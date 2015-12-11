/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.dimensions.providers.kriffus;

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

public class ChunkProviderKriffus extends ChunkProviderSpace {
	
	public ArrayList<MapGenBaseMeta> mapGenList = new ArrayList<MapGenBaseMeta>();
	
	public ChunkProviderKriffus(World par1World, long seed,
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
				10, 2, 2);
		SpawnListEntry creeper = new SpawnListEntry(EntityEvolvedCreeper.class,
				10, 2, 2);
		SpawnListEntry zombie = new SpawnListEntry(EntityEvolvedZombie.class,
				10, 2, 2);
		return new SpawnListEntry[] { skele, creeper, zombie };
	}
	
	@Override
	protected SpawnListEntry[] getCreatures() {
		SpawnListEntry villager = new SpawnListEntry(EntityAlienVillager.class,
				1, 1, 1);
		return new SpawnListEntry[] {};
	}
	
	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(BlockList.kriffRock, (byte) 0);
	}
	
	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(BlockList.kriffRock, (byte) 0);
	}
	
	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(BlockList.kriffStone, (byte) 0);
	}
	
	@Override
	public double getHeightModifier() {
		return 15;
	}
	
	@Override
	public double getSmallFeatureHeightModifier() {
		return 4;
	}
	
	@Override
	public double getMountainHeightModifier() {
		return 8;
	}
	
	@Override
	public double getValleyHeightModifier() {
		return 6;
	}
	
	@Override
	public int getCraterProbability() {
		return 84;
	}
	
	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
		
	}
	
	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {
		
	}
	
	@Override
	public boolean chunkExists(int x, int y) {
		return false;
	}
}