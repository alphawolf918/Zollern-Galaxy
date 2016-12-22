/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.events;

import galaxymod.biomes.BiomeSpace;
import galaxymod.blocks.BlockList;
import galaxymod.core.PlanetNova;
import galaxymod.core.config.ConfigManagerZG;
import galaxymod.items.ItemList;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.utils.ZGDamageSource;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ZGEvents {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		EntityLivingBase theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityCrawlerBoss) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ItemList.edenDungeonKey, 1));
			worldObj.spawnEntityInWorld(item);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onLivingUpdate(LivingUpdateEvent event) {
		EntityLivingBase livingBase = event.entityLiving;
		if (livingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) livingBase;
			World world = player.worldObj;
			int playerX = (int) player.posX;
			int playerY = (int) player.posY;
			int playerZ = (int) player.posZ;
			Random rand = new Random();
			BiomeGenBase currentBiome = world.getBiomeGenForCoords(playerX,
					playerZ);
			if (currentBiome instanceof BiomeSpace) {
				BiomeSpace space = (BiomeSpace) currentBiome;
				PlanetNova planet = space.getPlanetForBiome();
				
				float toxLevel = planet.getToxicLevel();
				float radLevel = planet.getRadiationLevel();
				float planetTemp = space.getPlanetTemp();
				
				float toxDamage = (toxLevel * ZGDamageSource.baseToxDamage) / 1.5f;
				float radDamage = (radLevel * ZGDamageSource.baseRadDamage) / 2.2f;
				
				float hotTempDamage = 1.0f;
				hotTempDamage = (planetTemp * ZGDamageSource.baseHotDamage) / 1.4f;
				
				float coldTempDamage = 1.0f;
				coldTempDamage = Math.abs((planetTemp
						* (ZGDamageSource.baseColdDamage) * 2.0f) / 1.5f) - 4.6f;
				
				// Applies the survival mechanics.
				if (rand.nextInt(614) <= 392) {
					// Toxic Damage
					this.performSurvivalEffect(ItemList.blueprintTox,
							ZGDamageSource.deathToxic, toxDamage, player,
							planet.getIsToxicPlanet());
					
					// Radiation Damage
					this.performSurvivalEffect(ItemList.blueprintRad,
							ZGDamageSource.deathRadiation, radDamage, player,
							planet.getIsRadioactivePlanet());
				}
			}
		}
	}
	
	/**
	 * Perform the desired survival effect on the Player.
	 * 
	 * @param blueprintItem
	 * @param damageSource
	 * @param damageAmount
	 * @param player
	 * @param check
	 */
	private void performSurvivalEffect(Item blueprintItem,
			ZGDamageSource damageSource, float damageAmount,
			EntityPlayer player, boolean check) {
		InventoryPlayer matrix = player.inventory;
		if (check) {
			if (!matrix.hasItem(blueprintItem)) {
				player.attackEntityFrom(damageSource, damageAmount);
			} else {
				this.damageItemStack(blueprintItem, damageAmount, player);
			}
		}
	}
	
	private void damageItemStack(Item blueprintItem, float damageAmount,
			EntityPlayer player) {
		InventoryPlayer matrix = player.inventory;
		for (int i = 0; i < matrix.getSizeInventory(); i++) {
			if (matrix.getStackInSlot(i) != null) {
				ItemStack stackNew = matrix.getStackInSlot(i);
				if (stackNew != null && stackNew.getItem() == blueprintItem) {
					ItemStack k = new ItemStack(blueprintItem);
					k.setItemDamage(k.getItemDamage() + (int) damageAmount);
					matrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
		World worldObj = event.world;
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(event.chunkX * 16,
				event.chunkZ * 16);
		Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
				event.chunkZ);
		if (worldObj.provider.dimensionId == ConfigManagerZG.planetPurgotDimensionId) {
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == Blocks.water) {
									storage.func_150818_a(x, y, z,
											BlockList.purgDirt);
								}
							}
						}
					}
				}
				chunk.isModified = true;
			}
		}
	}
}