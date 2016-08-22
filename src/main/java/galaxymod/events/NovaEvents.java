/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.events;

import galaxymod.biomes.BiomeSpace;
import galaxymod.blocks.BlockList;
import galaxymod.core.PlanetNova;
import galaxymod.core.config.ConfigManagerNova;
import galaxymod.items.ItemList;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.utils.NGDamageSource;
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

public class NovaEvents {
	
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
				
				float toxDamage = (toxLevel * NGDamageSource.baseToxDamage) / 1.5f;
				float radDamage = (radLevel * NGDamageSource.baseRadDamage) / 2.2f;
				
				float hotTempDamage = 1.0f;
				hotTempDamage = (planetTemp * NGDamageSource.baseHotDamage) / 1.1f;
				
				float coldTempDamage = 1.0f;
				coldTempDamage = Math.abs((planetTemp
						* (NGDamageSource.baseColdDamage) * 2.0f) / 1.5f);
				
				// Applies the survival mechanics.
				if (rand.nextInt(514) <= 392) {
					// Toxic Damage
					this.performSurvivalEffect(ItemList.blueprintTox,
							NGDamageSource.deathToxic, toxDamage, player,
							planet.getIsToxicPlanet());
					
					// Radiation Damage
					this.performSurvivalEffect(ItemList.blueprintRad,
							NGDamageSource.deathRadiation, radDamage, player,
							planet.getIsRadioactivePlanet());
					
					// Heat Damage
					// this.performSurvivalEffect(ItemList.blueprintScorch,
					// NGDamageSource.deathTempHot, hotTempDamage, player,
					// planet.getIsHotPlanet());
					
					// Cold Damage
					// this.performSurvivalEffect(ItemList.blueprintFreeze,
					// NGDamageSource.deathTempCold, coldTempDamage,
					// player, planet.getIsColdPlanet());
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
			NGDamageSource damageSource, float damageAmount,
			EntityPlayer player, boolean check) {
		InventoryPlayer matrix = player.inventory;
		if (check) {
			if (!matrix.hasItem(blueprintItem)) {
				player.attackEntityFrom(damageSource, damageAmount);
			} else {
				for (int i = 0; i < matrix.getSizeInventory(); i++) {
					if (matrix.getStackInSlot(i) != null) {
						ItemStack stackNew = matrix.getStackInSlot(i);
						if (stackNew != null
								&& stackNew.getItem() == blueprintItem) {
							ItemStack k = new ItemStack(blueprintItem);
							k.damageItem(k.getItemDamage()
									+ ((int) damageAmount), player);
							matrix.setInventorySlotContents(i, k);
						}
					}
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
		if (worldObj.provider.dimensionId == ConfigManagerNova.planetEdenDimensionId) {
			Block fromBlock = Blocks.stone;
			Block toBlock = BlockList.edenRock;
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == BlockList.edenSurfaceRock) {
									storage.func_150818_a(x, y, z,
											biome.topBlock);
								} else if (currentBlock == BlockList.edenSoil) {
									storage.func_150818_a(x, y, z,
											biome.fillerBlock);
								} else if (currentBlock == Blocks.stone) {
									storage.func_150818_a(x, y, z,
											BlockList.edenRock);
								} else if (currentBlock == Blocks.coal_ore) {
									storage.func_150818_a(x, y, z,
											BlockList.edenCoalOre);
								} else if (currentBlock == Blocks.dirt) {
									storage.func_150818_a(x, y, z,
											BlockList.edenSoil);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (worldObj.provider.dimensionId == ConfigManagerNova.planetZollusDimensionId) {
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == Blocks.water) {
									storage.func_150818_a(x, y, z,
											Blocks.packed_ice);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (worldObj.provider.dimensionId == ConfigManagerNova.planetKriffonDimensionId) {
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == Blocks.stone) {
									storage.func_150818_a(x, y, z,
											BlockList.kriffStone);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (worldObj.provider.dimensionId == ConfigManagerNova.planetPurgotDimensionId) {
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == Blocks.stone) {
									storage.func_150818_a(x, y, z,
											BlockList.purgStone);
								} else if (currentBlock == Blocks.water) {
									storage.func_150818_a(x, y, z,
											BlockList.purgDirt);
								} else if (currentBlock == BlockList.purgRock) {
									storage.func_150818_a(x, y, z,
											biome.topBlock);
								} else if (currentBlock == BlockList.purgDirt) {
									storage.func_150818_a(x, y, z,
											biome.fillerBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		} else if (worldObj.provider.dimensionId == ConfigManagerNova.planetXathiusDimensionId) {
			for (ExtendedBlockStorage storage : chunk.getBlockStorageArray()) {
				if (storage != null) {
					for (int x = 0; x < 16; ++x) {
						for (int y = 0; y < 16; ++y) {
							for (int z = 0; z < 16; ++z) {
								Block currentBlock = storage.getBlockByExtId(x,
										y, z);
								if (currentBlock == Blocks.stone) {
									storage.func_150818_a(x, y, z,
											BlockList.xathStone);
								} else if (currentBlock == BlockList.xathRock) {
									storage.func_150818_a(x, y, z,
											biome.topBlock);
								} else if (currentBlock == BlockList.xathDirt) {
									storage.func_150818_a(x, y, z,
											biome.fillerBlock);
								}
							}
						}
					}
				}
			}
			chunk.isModified = true;
		}
	}
}