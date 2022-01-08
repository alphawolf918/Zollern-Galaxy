/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.events;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.google.common.collect.Maps;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.planets.venus.client.FakeLightningBoltRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGSand;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCaligro;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderVortex;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityGalaxyDragon;
import zollerngalaxy.mobs.entities.EntityGalaxyKnight;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.EntityVexBot;
import zollerngalaxy.mobs.entities.base.EntityMutantZombie;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ArmorUtils;
import zollerngalaxy.util.CachedEnumZG;
import zollerngalaxy.util.VillageUtils;
import zollerngalaxy.util.ZGDamageSrc;
import zollerngalaxy.util.ZGUtils;
import zollerngalaxy.util.ZombieUtils;

public class ZGEvents {
	
	private ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	private IProxy proxy = this.core.proxy;
	
	private Map<BlockPos, Integer> lightning = Maps.newHashMap();
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onBlockBrokenEvent(BreakEvent event) {
		World world = event.getWorld();
		if (!world.isRemote) {
			BlockPos pos = event.getPos();
			IBlockState state = world.getBlockState(pos);
			if (state.getBlock() == Blocks.DRAGON_EGG) {
				EntityGalaxyDragon galaxyDragon = new EntityGalaxyDragon(world);
				ZGHelper.spawnEntity(galaxyDragon, world, pos);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onWindBlowingEvent(WindBlowingEvent event) {
		if (ConfigManagerZG.enableWindBlowEvent) {
			final Minecraft minecraft = ZGUtils.getClient();
			final EntityPlayerSP player = minecraft.player;
			
			World world = event.getWorld();
			WorldProvider provider = world.provider;
			
			if (ZGHelper.rngInt(1, 150) == 0 && provider instanceof WorldProviderVortex) {
				double freq = player.getRNG().nextDouble() * Math.PI * 2.0F;
				double dist = 60.0F;
				double dX = dist * Math.cos(freq);
				double dZ = dist * Math.sin(freq);
				double posX = player.posX + dX;
				double posY = 70;
				double posZ = player.posZ + dZ;
				float pitch = 5.0F + player.getRNG().nextFloat() * 0.2F;
				event.updateDirectionBasedOnChance();
				minecraft.world.playSound(player, posX, posY, posZ, ZGSoundEvents.WEATHER_WIND, SoundCategory.WEATHER, 1000.0F, pitch);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		InventoryPlayer playerInventory = player.inventory;
		World world = player.world;
		WorldProvider provider = world.provider;
		
		boolean isCreativeMode = player.capabilities.isCreativeMode;
		boolean isRadianceActive = player.isPotionActive(ZGPotions.radiance);
		boolean isAntiCorruptActive = player.isPotionActive(ZGPotions.antiCorruption);
		
		Iterator<Map.Entry<BlockPos, Integer>> it = lightning.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<BlockPos, Integer> entry = it.next();
			int val = entry.getValue();
			if (val - 1 <= 0) {
				it.remove();
			} else {
				entry.setValue(val - 1);
			}
		}
		
		if (player.getRNG().nextInt(550) == 0 && provider instanceof WorldProviderVortex) {
			double freq = player.getRNG().nextDouble() * Math.PI * 2.0F;
			double dist = 60.0F;
			double dX = dist * Math.cos(freq);
			double dZ = dist * Math.sin(freq);
			double posX = player.posX + dX;
			double posY = 70;
			double posZ = player.posZ + dZ;
			float volume = 1000.0F;
			float pitch = 5.0F + player.getRNG().nextFloat() * 0.2F;
			lightning.put(new BlockPos(posX, posY, posZ), 20);
			SoundEvent thunder = SoundEvents.ENTITY_LIGHTNING_THUNDER;
			SoundCategory category = SoundCategory.WEATHER;
			world.playSound(player, posX, posY, posZ, thunder, category, volume, pitch);
		} else if (provider instanceof WorldProviderCaligro) {
			// Radiance Protection
			Item radium = ZGItems.radium;
			ItemStack radiumStack = new ItemStack(radium);
			boolean hasRadium = playerInventory.hasItemStack(radiumStack);
			
			// Radiance Check
			if (hasRadium && !isCreativeMode && !isRadianceActive) {
				PotionEffect radianceEffect = new PotionEffect(ZGPotions.radiance, ZGPotions.radianceTime, 1);
				player.addPotionEffect(radianceEffect);
				if (playerInventory.hasItemStack(radiumStack)) {
					int invSlot = playerInventory.getSlotFor(radiumStack);
					playerInventory.decrStackSize(invSlot, 1);
				}
				this.proxy.sendChatMessage(player, TextFormatting.GOLD + ZGUtils.translate("tooltips.radiance"));
			}
		}
		
		// Check what hand the Player is using, and check to see if it isn't
		// null. Then, grab the item they're holding, and check to see if
		// that's not equal to null. If it is the Bedrock Breaker, check the
		// Player's inventory to see if they have any Ascendant Amaranth
		// Ingots. If they do, then copy the original held item, set its
		// damage to 0, and put it in the slot that the old one occupied.
		// This also will decrease the stack size of the ingots. If none
		// remain, then it will not be repaired.
		EnumHand currentHand = player.getActiveHand();
		if (currentHand != null) {
			ItemStack heldItem = player.getHeldItem(currentHand);
			if (heldItem != null) {
				Item currentItem = heldItem.getItem();
				if (currentItem == ZGItems.BEDROCK_BREAKER) {
					int toolDamage = heldItem.getItemDamage();
					if (toolDamage >= heldItem.getMaxDamage()) {
						ItemStack repairItemStack = new ItemStack(ZGItems.ingotAscendantAmaranth);
						if (playerInventory.hasItemStack(repairItemStack)) {
							ItemStack repairedItem = heldItem.copy();
							repairedItem.setItemDamage(0);
							int invSlot = playerInventory.getSlotFor(heldItem);
							playerInventory.setInventorySlotContents(invSlot, repairedItem);
							playerInventory.decrStackSize(playerInventory.getSlotFor(repairItemStack), 1);
						}
					}
				}
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void renderLightning(ClientProxyCore.EventSpecialRender event) {
		Iterator<Map.Entry<BlockPos, Integer>> it = lightning.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<BlockPos, Integer> entry = it.next();
			BlockPos entryKey = entry.getKey();
			long seed = entry.getValue() / 10 + entryKey.getX() + entryKey.getZ();
			double x = entryKey.getX() - ClientProxyCore.playerPosX;
			double y = entryKey.getY() - ClientProxyCore.playerPosY;
			double z = entryKey.getZ() - ClientProxyCore.playerPosZ;
			FakeLightningBoltRenderer.renderBolt(seed, x, y, z);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onPlayerDeath(LivingDeathEvent event) {
		Entity entity = event.getEntityLiving();
		World world = entity.world;
		WorldProvider provider = world.provider;
		if (!world.isRemote && provider instanceof WorldProviderMetztli) {
			if (entity instanceof EntityPlayer) {
				DamageSource damageSource = event.getSource();
				Entity damageSourceEntity = damageSource.getImmediateSource();
				EntityPlayer player = (EntityPlayer) entity;
				if (damageSourceEntity instanceof EntityZombie) {
					ZombieUtils.convertToZombie(player, world, EntityZombie.class, "Zombie");
				} else if (damageSourceEntity instanceof EntityMutantZombie) {
					String strMutantName = ((EntityMutantZombie) damageSourceEntity).getMutantName();
					strMutantName = (strMutantName == "" || strMutantName == null) ? "Mutant" : strMutantName;
					Class<? extends EntityMutantZombie> mutantZombieClass = (Class<? extends EntityMutantZombie>) damageSourceEntity.getClass();
					ZombieUtils.convertToZombie(player, world, mutantZombieClass, strMutantName);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		Random rand = new Random();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			InventoryPlayer playerInventory = player.inventory;
			BlockPos playerLocation = new BlockPos(player.posX, (player.posY - 1), player.posZ);
			World world = player.world;
			IBlockState blockState = world.getBlockState(playerLocation);
			Block block = blockState.getBlock();
			
			boolean isCreativeMode = player.capabilities.isCreativeMode;
			boolean isRadianceActive = player.isPotionActive(ZGPotions.radiance);
			boolean isAntiCorruptActive = player.isPotionActive(ZGPotions.antiCorruption);
			
			if (world.provider instanceof WorldProviderVortex) {
				if (ZGHelper.rngInt(1, 700) <= 15 && ConfigManagerZG.enableWindBlowEvent) {
					MinecraftForge.EVENT_BUS.post(new WindBlowingEvent(world, player));
				}
			} else if (world.provider instanceof WorldProviderCaligro) {
				// Shadow Damage
				if (!isCreativeMode && !isRadianceActive) {
					player.attackEntityFrom(ZGDamageSrc.deathShadows, ZGDamageSrc.deathShadows.getDamageBase());
				}
			}
			
			// Perform Radiance potion effect
			if (isRadianceActive) {
				ZGPotions.radiance.performEffect(player, 1);
			}
			
			// Infection
			// Spread to all Players within the radius by using the potion effect.
			// You can find the potion effect's "performEffect" function in the
			// ClientProxy class, under doPotionEffects.
			if (player.isPotionActive(ZGPotions.infected)) {
				ZGPotions.infected.performEffect(player, 1);
				Class<? extends Entity> playerClass = EntityPlayer.class;
				AxisAlignedBB boundingBox = player.getEntityBoundingBox();
				AxisAlignedBB expandedBox = boundingBox.expand(5.0D, 2.0D, 5.0D);
				List<? extends Entity> playerList = world.<Entity> getEntitiesWithinAABB(playerClass, expandedBox);
				Object[] playerArray = playerList.toArray();
				for (Object o : playerArray) {
					EntityPlayer currentPlayer = (EntityPlayer) o;
					if (!currentPlayer.isPotionActive(ZGPotions.infected)) {
						PotionEffect infectEffect = new PotionEffect(ZGPotions.infected, ZGPotions.infectionTime, 1);
						currentPlayer.addPotionEffect(infectEffect);
					}
				}
			}
			
			// Handle Armor Checks
			ArmorUtils.performArmorCheck(player);
		}
		
		// Handle Alien Mutations
		ZombieUtils.HandleMutations(entity, rand);
		
		// Allow Alien Villagers to mutate into Zombies, but only on Metztli.
		ZombieUtils.doMutation(entity, rand);
	}
	
	// Modifies names for Patrons, Contributors and my friends.
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onNameFormatEvent(NameFormat event) {
		if (!ConfigManagerZG.changeContributorNames) {
			return;
		}
		
		String username = event.getUsername();
		username = username.toLowerCase();
		if (username.equals("alphawolf918")) {
			event.setDisplayname(TextFormatting.GOLD + "Zollern Wolf" + TextFormatting.WHITE);
		} else if (username.equals("nascarmpfan")) {
			event.setDisplayname(TextFormatting.RED + "Specter Fettel" + TextFormatting.WHITE);
		} else if (username.equals("applepiec00kie")) {
			event.setDisplayname(TextFormatting.LIGHT_PURPLE + "Queen Apple" + TextFormatting.WHITE);
		} else if (username.equals("lazy_logic")) {
			event.setDisplayname(TextFormatting.AQUA + "Logic" + TextFormatting.WHITE);
		} else if (username.equals("master_zane")) {
			event.setDisplayname(TextFormatting.GOLD + "Master Zane" + TextFormatting.WHITE);
		} else if (username.equals("chronoxshift") || username.equals("chrono_miles_")) {
			event.setDisplayname(TextFormatting.AQUA + "ChronoxShift" + TextFormatting.WHITE);
		} else if (username.equals("actural_guy")) {
			event.setDisplayname(TextFormatting.GOLD + "ExistingEevee" + TextFormatting.WHITE);
		} else if (username.equals("autumnstarfire")) {
			event.setDisplayname(TextFormatting.LIGHT_PURPLE + "AutumnStarFire" + TextFormatting.WHITE);
		} else if (username.equals("snorlaxdacat")) {
			event.setDisplayname(TextFormatting.GREEN + "SnorlaxDaCat" + TextFormatting.WHITE);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEntityDamaged(LivingHurtEvent event) {
		EntityLivingBase ent = event.getEntityLiving();
		DamageSource src = event.getSource();
		if (ent instanceof EntityGrayAlien && ConfigManagerZG.spawnGalaxyKnight) {
			EntityGrayAlien alien = (EntityGrayAlien) ent;
			if (src.getTrueSource() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) src.getTrueSource();
				BlockPos worldPos = alien.getPosition();
				World world = alien.getEntityWorld();
				EntityGalaxyKnight spaceKnight = new EntityGalaxyKnight(world);
				spaceKnight.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
				spaceKnight.setAttackTarget(player);
				world.spawnEntity(spaceKnight);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLootTableLoadEvent(LootTableLoadEvent event) {
		ResourceLocation lootName = event.getName();
		if (lootName == LootTableList.GAMEPLAY_FISHING_FISH) {
			LootTableManager lootMgr = event.getLootTableManager();
			LootTable lootTbl = event.getTable();
			LootCondition[] conditions = new LootCondition[] {};
			RandomValueRange rng = new RandomValueRange(1.0F);
			RandomValueRange rngBonus = new RandomValueRange(0.0F);
			LootEntry entryZGFish = new LootEntryTable(ZGLootTables.GAMEPLAY_FISHING, 20, 10, conditions, "zgfishingentry");
			LootEntry[] entries = new LootEntry[] { entryZGFish };
			LootPool pool = new LootPool(entries, conditions, rng, rngBonus, "zgfishingpool");
			lootTbl.addPool(pool);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onJoinWorldEvent(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		WorldProvider provider = world.provider;
		if (!world.isRemote) {
			Entity ent = event.getEntity();
			if (ent instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) ent;
				if (this.core.isInTestMode() || this.core.isInDevMode()) {
					String txtFormat = TextFormatting.BOLD + " " + TextFormatting.RED;
					String msg = txtFormat
							+ "WARNING: This is NOT a valid version of Zollern Galaxy! Please uninstall the mod and install the correct version, or it will not operate correctly. Please also contact the mod author immediately!";
					this.proxy.sendChatMessage(player, msg);
				}
			}
			
			// Turn sand blocks to glass when struck by lightning
			if (ent instanceof EntityLightningBolt) {
				EntityLightningBolt bolt = (EntityLightningBolt) ent;
				BlockPos boltPos = bolt.getPosition();
				IBlockState posState = world.getBlockState(boltPos);
				Block stateBlock = posState.getBlock();
				if (stateBlock instanceof BlockSand || stateBlock instanceof ZGSand) {
					world.setBlockState(boltPos, Blocks.GLASS.getDefaultState());
				}
			}
		}
		
		// Convert Alien Villagers to planet-specific Villagers
		VillageUtils.ConvertVillagers(event);
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		// Moolus (Alien Cow)
		if (theEntity instanceof EntityMoolus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBeef, worldObj, theEntity);
			}
		}
		
		// Oinkus (Alien Pig)
		if (theEntity instanceof EntityOinkus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBacon, worldObj, theEntity);
			}
		}
		
		// Gray Alien
		if (theEntity instanceof EntityGrayAlien) {
			for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
				ZGHelper.dropItem(ZGItems.alienStone, worldObj, theEntity);
			}
		}
		
		// Mega Creeper
		if (theEntity instanceof EntityMegaCreeper) {
			for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
				ZGHelper.dropItem(ZGItems.superChargedCoal, worldObj, theEntity);
			}
		}
		
		// Mummy
		if (theEntity instanceof EntityMummy) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(Items.PAPER, worldObj, theEntity);
				}
			}
			
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.perdGlowdust, worldObj, theEntity);
				}
			}
		}
		
		// Scorpion
		if (theEntity instanceof EntityScorpion) {
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.dustEmerald, worldObj, theEntity);
				}
			}
		}
		
		// Shadow Skeleton
		if (theEntity instanceof EntityShadowSkeleton) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
					ZGHelper.dropItem(ZGItems.shadowBone, worldObj, theEntity);
				}
			}
		}
		
		// Blubber Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawBlubberFish, worldObj, theEntity);
		}
		
		// Gypsy Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawGypsyFish, worldObj, theEntity);
		}
		
		// Blade Fish
		if (theEntity instanceof EntityBladeFish) {
			ZGHelper.dropItem(ZGItems.rawBladeFish, worldObj, theEntity);
		}
		
		// Shark
		if (theEntity instanceof EntityShark) {
			// Shagreen (Shark Leather)
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.shagreen, worldObj, theEntity);
				}
			}
			
			// Shark Tooth
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(ZGItems.sharkTooth, worldObj, theEntity);
				}
			}
		}
		
		// Shade Entities
		if (theEntity instanceof IShadeEntity) {
			if (((IShadeEntity) theEntity).shouldDropEssence()) {
				if (ZGHelper.getRNGChance(5, 10)) {
					for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
						ZGHelper.dropItem(ZGItems.darkEssence, worldObj, theEntity);
					}
				}
			}
		}
		
		// Xenomorph
		// TODO
		
		// Vexbot
		if (theEntity instanceof EntityVexBot) {
			// Raw Virinium
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.dustVirinium, worldObj, theEntity);
				}
			}
			
			// Rhodium Ingot
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.ingotRhodium, worldObj, theEntity);
				}
			}
			
			// Zinc Ingot
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.ingotZinc, worldObj, theEntity);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onUseHoe(UseHoeEvent event) {
		if (event.getResult() != Result.DEFAULT || event.isCanceled()) {
			return;
		}
		
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		
		if (world.isAirBlock(pos.up())) {
			if (block instanceof ZGBlockGrass || block instanceof ZGBlockDirt) {
				this.setFarmland(event, world, pos, Blocks.FARMLAND);
			}
		}
	}
	
	/**
	 * Set the block at the passed position to farmland.
	 * 
	 * @param event
	 * @param world
	 * @param pos
	 * @param farmland
	 */
	private void setFarmland(UseHoeEvent event, World world, BlockPos pos, Block farmland) {
		world.setBlockState(pos, farmland.getDefaultState());
		event.setResult(Result.ALLOW);
		SoundEvent stepSound = SoundType.GROUND.getStepSound();
		SoundCategory soundCategory = SoundCategory.BLOCKS;
		float soundVolume = (SoundType.GROUND.getVolume() + 1.0F) / 2.0F;
		float soundPitch = SoundType.GROUND.getPitch() * 0.8F;
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), stepSound, soundCategory, soundVolume, soundPitch);
		
		for (EnumHand hand : CachedEnumZG.valuesHandCached()) {
			event.getEntityPlayer().swingArm(hand);
		}
	}
}