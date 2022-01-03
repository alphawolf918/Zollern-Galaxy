/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.base;

import java.util.Random;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedWitch;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerHandler;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import micdoodle8.mods.galacticraft.core.wrappers.PlayerGearData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.ai.EntityAILookAtTradePlayerZG;
import zollerngalaxy.mobs.entities.ai.EntityAITradePlayerZG;

public class EntityZGVillagerBase extends EntityAgeable implements IMerchant, INpc, IEntityBreathable {
	
	private int randomTickDivider;
	private boolean isMating;
	private boolean isPlaying;
	private Village villageObj;
	private EntityPlayer buyingPlayer;
	protected MerchantRecipeList buyingList;
	private int timeUntilReset;
	private boolean needsInitilization;
	private int wealth;
	private String lastBuyingPlayer;
	private boolean isLookingForHome;
	private InventoryBasic villagerInventory;
	protected static ItemStack mainPriceItem = new ItemStack(GCItems.itemBasicMoon, 1, 2);
	protected static ItemStack secondaryPriceItem = new ItemStack(GCItems.itemBasicMoon, 1, 2);
	
	public EntityZGVillagerBase(World worldIn) {
		super(worldIn);
		this.villagerInventory = new InventoryBasic("Items", false, 16);
		this.stepHeight = 3F;
		this.setSize(this.width * 1.5375F, this.height * 1.5375F);
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
		this.tasks.addTask(1, new EntityAITradePlayerZG(this));
		this.tasks.addTask(1, new EntityAILookAtTradePlayerZG(this));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(9, new EntityAIWander(this, 1.6D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 7.0F));
		this.setCanPickUpLoot(true);
	}
	
	protected ITradeList[] getTradeList() {
		ITradeList[] TRADE_LIST = new ITradeList[] { new ListVillagerItems(new ItemStack(ZGItems.alienStone, 1), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.axeAmaranth, 1), new PriceInfo(3, 4)), new ListVillagerItems(new ItemStack(ZGItems.darkEssence, 1), new PriceInfo(3, 4)),
				new ListVillagerItems(new ItemStack(ZGItems.sharkTooth, 1), new PriceInfo(3, 4)), new ListVillagerItems(new ItemStack(ZGItems.compressedVyrex, 1), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.azurite, 1), new PriceInfo(2, 4)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.rawBlubberFish, 1), new PriceInfo(1, 1), new ItemStack(ZGItems.edenFruit, 1)),
				new ListVillagerItems(new ItemStack(ZGItems.brownie, 1), new PriceInfo(3, 4)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.creamBall, 1), new PriceInfo(3, 5), new ItemStack(GCItems.schematic, 1, 1)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.compressedCobalt, 1), new PriceInfo(3, 5), new ItemStack(ZGBlocks.blockLore, 1)),
				new ItemAndSapphireToItem(new ItemStack(ZGBlocks.blockLore, 2), new PriceInfo(1, 1), new ItemStack(ZGItems.heartium, 1)),
				new ItemAndSapphireToItem(new ItemStack(ZGBlocks.blockPerdDiamond, 2), new PriceInfo(1, 1), new ItemStack(ZGBlocks.blockLore, 1)),
				new TradeGoodsForItems(new ItemStack(ZGBlocks.perdTreeSapling, 1), new PriceInfo(11, 39)),
				new TradeGoodsForItems(new ItemStack(ZGItems.superChargedCoal, ZGHelper.rngInt(2, 4)), new PriceInfo(11, 39)) };
		return TRADE_LIST;
	}
	
	@Override
	protected void onGrowingAdult() {
		super.onGrowingAdult();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}
	
	@Override
	protected void updateAITasks() {
		if (--this.randomTickDivider <= 0) {
			BlockPos blockpos = new BlockPos(this);
			this.world.getVillageCollection().addToVillagerPositionList(blockpos);
			this.randomTickDivider = 70 + this.rand.nextInt(50);
			this.villageObj = this.world.getVillageCollection().getNearestVillage(blockpos, 32);
			
			if (this.villageObj == null) {
				this.detachHome();
			} else {
				BlockPos blockpos1 = this.villageObj.getCenter();
				this.setHomePosAndDistance(blockpos1, (int) (this.villageObj.getVillageRadius() * 1.0F));
				
				if (this.isLookingForHome) {
					this.isLookingForHome = false;
					this.villageObj.setDefaultPlayerReputation(5);
				}
			}
		}
		
		if (!this.isTrading() && this.timeUntilReset > 0) {
			--this.timeUntilReset;
			
			if (this.timeUntilReset <= 0) {
				if (this.needsInitilization) {
					for (MerchantRecipe merchantrecipe : this.buyingList) {
						if (merchantrecipe.isRecipeDisabled()) {
							merchantrecipe.increaseMaxTradeUses(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
						}
					}
					
					this.populateBuyingList();
					this.needsInitilization = false;
					
					if (this.villageObj != null && this.lastBuyingPlayer != null) {
						this.world.setEntityState(this, (byte) 14);
						this.villageObj.modifyPlayerReputation(this.lastBuyingPlayer, 1);
					}
				}
				
				this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0));
			}
		}
		
		super.updateAITasks();
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.inventory.getCurrentItem();
		boolean flag = itemstack != null && itemstack.getItem() == Items.SPAWN_EGG;
		
		if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild() && !player.isSneaking()) {
			PlayerGearData gearData = GalacticraftCore.proxy.getGearData(player);
			
			if (!this.world.isRemote && (this.buyingList == null || this.buyingList.size() > 0)) {
				if (gearData != null && gearData.getFrequencyModule() != GCPlayerHandler.GEAR_NOT_PRESENT) {
					this.setCustomer(player);
					player.displayVillagerTradeGui(this);
				} else {
					if (player instanceof EntityPlayerMP) {
						EntityPlayerMP playerMP = (EntityPlayerMP) player;
						GCPlayerStats stats = GCPlayerStats.get(playerMP);
						if (stats.getChatCooldown() == 0) {
							player.sendMessage(new TextComponentString(GCCoreUtil.translate("gui.village.warning.no_freq_mod")));
							stats.setChatCooldown(20);
						}
					}
				}
			}
			
			player.addStat(StatList.TALKED_TO_VILLAGER);
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("Riches", this.wealth);
		
		if (this.buyingList != null) {
			tagCompound.setTag("Offers", this.buyingList.getRecipiesAsTags());
		}
		
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < this.villagerInventory.getSizeInventory(); ++i) {
			ItemStack itemstack = this.villagerInventory.getStackInSlot(i);
			
			if (!itemstack.isEmpty()) {
				nbttaglist.appendTag(itemstack.writeToNBT(new NBTTagCompound()));
			}
		}
		
		tagCompound.setTag("Inventory", nbttaglist);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		this.wealth = tagCompund.getInteger("Riches");
		
		if (tagCompund.hasKey("Offers", 10)) {
			NBTTagCompound nbttagcompound = tagCompund.getCompoundTag("Offers");
			this.buyingList = new MerchantRecipeList(nbttagcompound);
		}
		
		NBTTagList nbttaglist = tagCompund.getTagList("Inventory", 10);
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			ItemStack itemstack = new ItemStack(nbttaglist.getCompoundTagAt(i));
			
			if (!itemstack.isEmpty()) {
				this.villagerInventory.addItem(itemstack);
			}
		}
		
		this.setCanPickUpLoot(true);
	}
	
	@Override
	protected boolean canDespawn() {
		return false;
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 0.5F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		SoundEvent villagerSound = this.isTrading() ? SoundEvents.ENTITY_VILLAGER_TRADING : SoundEvents.ENTITY_VILLAGER_AMBIENT;
		boolean disableVillagerNoise = ConfigManagerZG.enableQuietVillagers;
		return (disableVillagerNoise) ? null : villagerSound;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_VILLAGER_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_VILLAGER_DEATH;
	}
	
	public boolean isMating() {
		return this.isMating;
	}
	
	public void setMating(boolean mating) {
		this.isMating = mating;
	}
	
	public void setPlaying(boolean playing) {
		this.isPlaying = playing;
	}
	
	public boolean isPlaying() {
		return this.isPlaying;
	}
	
	@Override
	public void setRevengeTarget(EntityLivingBase livingBase) {
		super.setRevengeTarget(livingBase);
		
		if (this.villageObj != null && livingBase != null) {
			this.villageObj.addOrRenewAgressor(livingBase);
			
			if (livingBase instanceof EntityPlayer) {
				int i = -1;
				
				if (this.isChild()) {
					i = -3;
				}
				
				this.villageObj.modifyPlayerReputation(livingBase.getName(), i);
				
				if (this.isEntityAlive()) {
					this.world.setEntityState(this, (byte) 13);
				}
			}
		}
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		if (this.villageObj != null) {
			Entity entity = cause.getTrueSource();
			
			if (entity != null) {
				if (entity instanceof EntityPlayer) {
					this.villageObj.modifyPlayerReputation(entity.getName(), -2);
				} else if (entity instanceof IMob) {
					this.villageObj.endMatingSeason();
				}
			} else {
				EntityPlayer entityplayer = this.world.getClosestPlayerToEntity(this, 16.0D);
				
				if (entityplayer != null) {
					this.villageObj.endMatingSeason();
				}
			}
		}
		
		super.onDeath(cause);
	}
	
	@Override
	public void setCustomer(EntityPlayer p_70932_1_) {
		this.buyingPlayer = p_70932_1_;
	}
	
	@Override
	public EntityPlayer getCustomer() {
		return this.buyingPlayer;
	}
	
	public boolean isTrading() {
		return this.buyingPlayer != null;
	}
	
	@Override
	public void useRecipe(MerchantRecipe recipe) {
		recipe.incrementToolUses();
		this.livingSoundTime = -this.getTalkInterval();
		this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
		int i = 3 + this.rand.nextInt(4);
		
		if (recipe.getToolUses() == 1 || this.rand.nextInt(5) == 0) {
			this.timeUntilReset = 40;
			this.needsInitilization = true;
			
			if (this.buyingPlayer != null) {
				this.lastBuyingPlayer = this.buyingPlayer.getName();
			} else {
				this.lastBuyingPlayer = null;
			}
			
			i += 5;
		}
		
		if (recipe.getItemToBuy() == this.getMainPriceItemStack()) {
			this.wealth += recipe.getItemToBuy().getCount();
		}
		
		if (recipe.getRewardsExp()) {
			this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY + 0.5D, this.posZ, i));
		}
	}
	
	@Override
	public void verifySellingItem(ItemStack stack) {
		if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
			this.livingSoundTime = -this.getTalkInterval();
			
			if (!stack.isEmpty()) {
				this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
			} else {
				this.playSound(SoundEvents.ENTITY_VILLAGER_NO, this.getSoundVolume(), this.getSoundPitch());
			}
		}
	}
	
	@Override
	public MerchantRecipeList getRecipes(EntityPlayer p_70934_1_) {
		if (this.buyingList == null) {
			this.populateBuyingList();
		}
		
		return this.buyingList;
	}
	
	private void populateBuyingList() {
		if (this.buyingList == null) {
			this.buyingList = new MerchantRecipeList();
		}
		
		for (EntityZGVillagerBase.ITradeList tradeList : this.getTradeList()) {
			tradeList.modifyMerchantRecipeList(this.buyingList, this.rand);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void setRecipes(MerchantRecipeList recipeList) {
	}
	
	@Override
	public float getEyeHeight() {
		float f = 1.62F;
		
		if (this.isChild()) {
			f = (float) (f - 0.81D);
		}
		
		return f;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 12) {
			this.spawnParticles(EnumParticleTypes.HEART);
		} else if (id == 13) {
			this.spawnParticles(EnumParticleTypes.VILLAGER_ANGRY);
		} else if (id == 14) {
			this.spawnParticles(EnumParticleTypes.VILLAGER_HAPPY);
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.world.spawnParticle(particleType, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 1.0D + this.rand.nextFloat() * this.height,
					this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, d0, d1, d2, new int[0]);
		}
	}
	
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		return livingdata;
	}
	
	@Override
	public EntityZGVillagerBase createChild(EntityAgeable ageable) {
		EntityZGVillagerBase entityvillager = new EntityZGVillagerBase(this.world);
		entityvillager.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData) null);
		return entityvillager;
	}
	
	@Override
	public World getWorld() {
		return this.world;
	}
	
	@Override
	public BlockPos getPos() {
		return new BlockPos(this);
	}
	
	@Override
	public boolean canBeLeashedTo(EntityPlayer player) {
		return false;
	}
	
	@Override
	public void onStruckByLightning(EntityLightningBolt lightningBolt) {
		if (!this.world.isRemote && !this.isDead) {
			EntityEvolvedWitch entitywitch = new EntityEvolvedWitch(this.world);
			entitywitch.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			entitywitch.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entitywitch)), (IEntityLivingData) null);
			entitywitch.setNoAI(this.isAIDisabled());
			
			if (this.hasCustomName()) {
				entitywitch.setCustomNameTag(this.getCustomNameTag());
				entitywitch.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
			}
			
			this.world.spawnEntity(entitywitch);
			this.setDead();
		}
	}
	
	protected void setPriceItem(ItemStack mainPriceItemIn) {
		EntityZGVillagerBase.mainPriceItem = mainPriceItemIn;
		EntityZGVillagerBase.secondaryPriceItem = mainPriceItemIn;
	}
	
	protected void setPriceItem(ItemStack mainPriceItemIn, ItemStack secondaryPriceItemIn) {
		EntityZGVillagerBase.mainPriceItem = mainPriceItemIn;
		EntityZGVillagerBase.secondaryPriceItem = secondaryPriceItemIn;
	}
	
	protected void setMainPriceItem(ItemStack mainPriceItemIn) {
		EntityZGVillagerBase.mainPriceItem = mainPriceItemIn;
	}
	
	protected void setSecondaryPriceItem(ItemStack secondaryPriceItemIn) {
		EntityZGVillagerBase.secondaryPriceItem = secondaryPriceItemIn;
	}
	
	protected ItemStack getMainPriceItemStack() {
		return this.mainPriceItem;
	}
	
	protected ItemStack getSecondaryItemStack() {
		return this.secondaryPriceItem;
	}
	
	protected ItemStack getPriceItemStack() {
		return this.mainPriceItem;
	}
	
	public InventoryBasic getVillagerInventory() {
		return this.villagerInventory;
	}
	
	@Override
	protected void updateEquipmentIfNeeded(EntityItem itemEntity) {
		ItemStack itemstack = itemEntity.getItem();
		Item item = itemstack.getItem();
		
		if (this.canVillagerPickupItem(item)) {
			ItemStack itemstack1 = this.villagerInventory.addItem(itemstack);
			
			if (itemstack1.isEmpty()) {
				itemEntity.setDead();
			} else {
				itemstack.setCount(itemstack1.getCount());
			}
		}
	}
	
	private boolean canVillagerPickupItem(Item itemIn) {
		return itemIn == Items.BREAD || itemIn == Items.POTATO || itemIn == Items.CARROT || itemIn == Items.WHEAT || itemIn == Items.WHEAT_SEEDS;
	}
	
	public boolean func_175553_cp() {
		return this.hasEnoughItems(1);
	}
	
	public boolean canAbondonItems() {
		return this.hasEnoughItems(2);
	}
	
	public boolean func_175557_cr() {
		return !this.hasEnoughItems(5);
	}
	
	private boolean hasEnoughItems(int multiplier) {
		for (int i = 0; i < this.villagerInventory.getSizeInventory(); ++i) {
			ItemStack itemstack = this.villagerInventory.getStackInSlot(i);
			
			if (!itemstack.isEmpty()) {
				if (itemstack.getItem() == Items.BREAD && itemstack.getCount() >= 3 * multiplier || itemstack.getItem() == Items.POTATO && itemstack.getCount() >= 12 * multiplier
						|| itemstack.getItem() == Items.CARROT && itemstack.getCount() >= 12 * multiplier) {
					return true;
				}
				
				if (itemstack.getItem() == Items.WHEAT && itemstack.getCount() >= 9 * multiplier) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
	@Override
	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
		if (super.replaceItemInInventory(inventorySlot, itemStackIn)) {
			return true;
		} else {
			int i = inventorySlot - 300;
			
			if (i >= 0 && i < this.villagerInventory.getSizeInventory()) {
				this.villagerInventory.setInventorySlotContents(i, itemStackIn);
				return true;
			} else {
				return false;
			}
		}
	}
	
	@Override
	public boolean isPushedByWater() {
		return true;
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return false;
	}
	
	public static class TradeGoodsForItems implements EntityZGVillagerBase.ITradeList {
		public ItemStack sellItem;
		public EntityZGVillagerBase.PriceInfo price;
		
		public TradeGoodsForItems(ItemStack itemStack, EntityZGVillagerBase.PriceInfo priceIn) {
			this.sellItem = itemStack;
			this.price = priceIn;
		}
		
		@Override
		public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
			int i = 1;
			
			if (this.price != null) {
				i = this.price.getPrice(random);
			}
			
			ItemStack tradeStack = this.sellItem.copy();
			tradeStack.setCount(i);
			
			recipeList.add(new MerchantRecipe(tradeStack, mainPriceItem));
		}
	}
	
	public interface ITradeList {
		void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random);
	}
	
	public static class ItemAndSapphireToItem implements EntityZGVillagerBase.ITradeList {
		public ItemStack field_179411_a;
		public EntityZGVillagerBase.PriceInfo field_179409_b;
		public ItemStack field_179410_c;
		
		public ItemAndSapphireToItem(Item p_i45813_1_, EntityZGVillagerBase.PriceInfo p_i45813_2_, Item p_i45813_3_) {
			this.field_179411_a = new ItemStack(p_i45813_1_);
			this.field_179409_b = p_i45813_2_;
			this.field_179410_c = new ItemStack(p_i45813_3_);
		}
		
		public ItemAndSapphireToItem(ItemStack p_i45813_1_, EntityZGVillagerBase.PriceInfo p_i45813_2_, ItemStack p_i45813_3_) {
			this.field_179411_a = p_i45813_1_;
			this.field_179409_b = p_i45813_2_;
			this.field_179410_c = p_i45813_3_;
		}
		
		@Override
		public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
			int i = 1;
			
			if (this.field_179409_b != null) {
				i = this.field_179409_b.getPrice(random);
			}
			
			recipeList.add(new MerchantRecipe(this.field_179411_a.copy(), mainPriceItem, this.field_179410_c.copy()));
		}
	}
	
	public static class ListVillagerItems implements EntityZGVillagerBase.ITradeList {
		public ItemStack itemToBuy;
		public EntityZGVillagerBase.PriceInfo priceInfo;
		
		public ListVillagerItems(ItemStack stack, EntityZGVillagerBase.PriceInfo priceInfo) {
			this.itemToBuy = stack;
			this.priceInfo = priceInfo;
		}
		
		@Override
		public void modifyMerchantRecipeList(MerchantRecipeList recipeList, Random random) {
			int i = 1;
			
			if (this.priceInfo != null) {
				i = this.priceInfo.getPrice(random);
			}
			
			ItemStack itemstack;
			ItemStack itemstack1;
			
			if (i < 0) {
				itemstack = mainPriceItem;
				itemstack1 = new ItemStack(this.itemToBuy.getItem(), -i, this.itemToBuy.getMetadata());
			} else {
				itemstack = secondaryPriceItem;
				itemstack1 = new ItemStack(this.itemToBuy.getItem(), 1, this.itemToBuy.getMetadata());
			}
			
			recipeList.add(new MerchantRecipe(itemstack, itemstack1));
		}
	}
	
	public static class PriceInfo extends Tuple<Integer, Integer> {
		
		protected static Random rand = new Random();
		
		public PriceInfo(int par1, int par2) {
			super(rand.nextInt(Integer.valueOf(par1)), rand.nextInt(Integer.valueOf(par2)));
		}
		
		public int getPrice(Random rand) {
			return this.getFirst().intValue() >= this.getSecond().intValue() ? this.getFirst().intValue()
					: this.getFirst().intValue() + rand.nextInt(this.getSecond().intValue() - this.getFirst().intValue() + 1);
		}
	}
}