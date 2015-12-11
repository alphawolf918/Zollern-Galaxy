package galaxymod.events;

import galaxymod.blocks.BlockList;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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