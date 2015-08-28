package galaxymod.dimensions.providers.zollus;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.decorators.BiomeDecoratorNova;
import galaxymod.blocks.BlockList;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.world.gen.MapGenCavesMoon;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderZollus extends ChunkProviderSpace {

	public ArrayList<MapGenBaseMeta> mapGenList = new ArrayList<MapGenBaseMeta>();

	public ChunkProviderZollus(World par1World, long seed,
			boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return new BiomeDecoratorNova();
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { BiomeList.biomeZollus };
	}

	@Override
	protected int getSeaLevel() {
		return 56;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		mapGenList.add(new MapGenCavesMoon());
		return mapGenList;
	}

	@Override
	protected SpawnListEntry[] getMonsters() {
		SpawnListEntry skele = new SpawnListEntry(EntityEvolvedSkeleton.class,
				100, 4, 4);
		SpawnListEntry creeper = new SpawnListEntry(EntityEvolvedCreeper.class,
				100, 4, 4);
		SpawnListEntry zombie = new SpawnListEntry(EntityEvolvedZombie.class,
				100, 4, 4);
		return new SpawnListEntry[] { skele, creeper, zombie };
	}

	@Override
	protected SpawnListEntry[] getCreatures() {
		SpawnListEntry villager = new SpawnListEntry(EntityAlienVillager.class,
				10, 2, 2);
		return new SpawnListEntry[] { villager };
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(BlockList.solarBlock, (byte) 0);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(BlockList.solarBlock, (byte) 0);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(BlockList.zolstone, (byte) 0);
	}

	@Override
	public double getHeightModifier() {
		return 10;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 0;
	}

	@Override
	public double getMountainHeightModifier() {
		return 0;
	}

	@Override
	public double getValleyHeightModifier() {
		return 0;
	}

	@Override
	public int getCraterProbability() {
		return 64;
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {

	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		
	}
   
    @Override
    public boolean chunkExists(int x, int y){
        return false;
    }
}