package galaxymod.events;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class NGEvents {
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void onLivingSpawnEvent(LivingSpawnEvent event) {
		EntityLiving entity = (EntityLiving) event.entityLiving;
		World world = event.world;
		if (entity.getClass() == EntityVillager.class) {
			float posX = event.x;
			float posY = event.y;
			float posZ = event.z;
			entity.setDead();
			EntityAlienVillager alien = new EntityAlienVillager(world);
			alien.setLocationAndAngles(posX, posY, posZ, entity.rotationYaw,
					entity.rotationPitch);
			world.spawnEntityInWorld(alien);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		EntityLivingBase theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityCrawlerBoss) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ItemList.edenDungeonKey, 2));
			worldObj.spawnEntityInWorld(item);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onItemCraftedEvent(ItemCraftedEvent event) {
		EntityPlayer player = event.player;
		ItemStack crafting = event.crafting;
		// TODO
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onItemSmeltedEvent(ItemSmeltedEvent event) {
		EntityPlayer player = event.player;
		ItemStack smelting = event.smelting;
		// TODO
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onChunkPreLoadEvent(PopulateChunkEvent.Pre event) {
		World worldObj = event.world;
		BiomeGenBase biome = worldObj.getBiomeGenForCoords(event.chunkX * 16,
				event.chunkZ * 16);
		if (worldObj.provider.dimensionId == -32) {
			Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX,
					event.chunkZ);
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
								}
								// if (currentBlock == Blocks.water
								// &&
								// biome.equals(BiomeList.biomeEdenSnowyPlains))
								// {
								// storage.func_150818_a(x, y, z, Blocks.ice);
								// } else if (currentBlock == Blocks.water
								// &&
								// biome.equals(BiomeList.biomeEdenMagmaLands))
								// {
								// storage.func_150818_a(x, y, z, Blocks.lava);
								// }
							}
						}
					}
				}
			}
			chunk.isModified = true;
		}
	}
}