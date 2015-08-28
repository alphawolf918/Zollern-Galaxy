package galaxymod.dimensions.chunkmanagers;

import galaxymod.biomes.BiomeList;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class WorldChunkManagerEden extends WorldChunkManagerSpace {

	@Override
	public BiomeGenBase getBiome(){
		return BiomeList.biomeEden;
	}
}