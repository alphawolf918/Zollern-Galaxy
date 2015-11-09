/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.dimensions.providers.eden;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import galaxymod.biomes.BiomeList;
import galaxymod.biomes.decorators.BiomeDecoratorEden;
import galaxymod.blocks.BlockList;
import galaxymod.mobs.entities.EntityMoolus;
import galaxymod.worldgen.eden.MapGenCavernEden;
import galaxymod.worldgen.eden.MapGenCavesEden;
import galaxymod.worldgen.eden.WorldGenEdenDungeons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.ChunkProviderSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import com.google.common.collect.Lists;

public class ChunkProviderEden extends ChunkProviderSpace {

	private final BiomeDecoratorEden edenBiomeDecorator = new BiomeDecoratorEden();
	private final MapGenCavernEden caveGenerator = new MapGenCavernEden();
	private final MapGenCavesEden cavernGenerator = new MapGenCavesEden();
	private final WorldGenEdenDungeons dungeonGenerator = new WorldGenEdenDungeons();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	public Minecraft mc = Minecraft.getMinecraft();
	public EntityPlayer player = this.mc.thePlayer;
	public World worldObj;
	int i3;
	int j3;
	int k3;

	public ChunkProviderEden(World par1World, long seed,
			boolean mapFeaturesEnabled) {
		super(par1World, seed, mapFeaturesEnabled);
		this.worldObj = par1World;
	}

	@Override
	protected BiomeDecoratorSpace getBiomeGenerator() {
		return this.edenBiomeDecorator;
	}

	@Override
	protected BiomeGenBase[] getBiomesForGeneration() {
		return new BiomeGenBase[] { BiomeList.biomeEden,
				BiomeList.biomeEdenRockMountains,
				BiomeList.biomeEdenTerranValley, BiomeList.biomeEdenBloodDesert };
	}

	@Override
	protected BlockMetaPair getGrassBlock() {
		return new BlockMetaPair(BlockList.edenSurfaceRock, (byte) 5);
	}

	@Override
	protected BlockMetaPair getDirtBlock() {
		return new BlockMetaPair(BlockList.edenSoil, (byte) 6);
	}

	@Override
	protected BlockMetaPair getStoneBlock() {
		return new BlockMetaPair(BlockList.edenRock, (byte) 9);
	}

	@Override
	protected int getSeaLevel() {
		return 83;
	}

	@Override
	protected List<MapGenBaseMeta> getWorldGenerators() {
		List<MapGenBaseMeta> generators = Lists.newArrayList();
		generators.add(this.caveGenerator);
		generators.add(this.cavernGenerator);
		return generators;
	}

	@Override
	protected SpawnListEntry[] getMonsters() {
		List<SpawnListEntry> monsters = new ArrayList<SpawnListEntry>();
		monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 2, 1, 2));
		monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 2, 1, 2));
		monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 2, 1, 2));
		monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2, 1, 2));
		return monsters.toArray(new SpawnListEntry[monsters.size()]);
	}

	@Override
	protected SpawnListEntry[] getCreatures() {
		List<SpawnListEntry> creatures = new ArrayList<SpawnListEntry>();
		creatures.add(new SpawnListEntry(EntityMoolus.class, 1, 2, 2));
		return creatures.toArray(new SpawnListEntry[creatures.size()]);
	}

	@Override
	public double getHeightModifier() {
		return 12;
	}

	@Override
	public double getSmallFeatureHeightModifier() {
		return 26;
	}

	@Override
	public double getMountainHeightModifier() {
		return 85;
	}

	@Override
	public double getValleyHeightModifier() {
		return 50;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType type, int x, int y, int z) {
		BiomeGenBase currentBiome = worldObj.getBiomeGenForCoords(x, z);
		if (type == EnumCreatureType.monster) {
			List monsters = new ArrayList();
			monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 4, 2, 2));
			monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 4, 2, 2));
			monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 4, 2,
					3));
			monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 4, 2, 2));
			return monsters;
		} else if (type == EnumCreatureType.creature) {
			List creatures = new ArrayList();
			creatures.add(new SpawnListEntry(EntityMoolus.class, 2, 2, 2));
			return creatures;
		} else {
			return null;
		}
	}

	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockFalling.fallInstantly = true;
		final int var4 = par2 * 16;
		final int var5 = par3 * 16;
		BiomeGenBase currentBiome = this.worldObj.getBiomeGenForCoords(
				var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		final long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		final long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(par2 * var7 + par3 * var9 ^ this.worldObj.getSeed());
		boolean flag = false;
		int k = var4;
		int l = var5;
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));

		this.mineshaftGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		this.dungeonGenerator.generate(worldObj, rand, var5, k, l);
		this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj,
				this.rand, par2, par3);
		int k1;
		int l1;
		int i2;

		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3,
				flag, ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, currentBiome,
					k + 8, l + 8, 16, 16, this.rand);
		}

		if (this.rand.nextInt(4) == 0
				&& TerrainGen.populate(par1IChunkProvider, worldObj, rand,
						par2, par3, flag, LAKE)) {
			k1 = var4 + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(256);
			i2 = var5 + this.rand.nextInt(16) + 8;
			new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand,
					k1, l1, i2);
		}

		boolean doGen;

		BiomeGenBase biomegenbase = currentBiome;
		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		k += 8;
		l += 8;

		doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2,
				par3, flag, ICE);
		for (k1 = 0; doGen && k1 < 16; ++k1) {
			for (l1 = 0; l1 < 16; ++l1) {
				i2 = this.worldObj.getPrecipitationHeight(k + k1, l + l1);

				if (this.worldObj.isBlockFreezable(k1 + k, i2 - 1, l1 + l)) {
					this.worldObj.setBlock(k1 + k, i2 - 1, l1 + l, Blocks.ice,
							0, 2);
				}
			}
		}
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(
				par1IChunkProvider, worldObj, rand, par2, par3, flag));
		this.decoratePlanet(this.worldObj, this.rand, var4, var5);
		BlockFalling.fallInstantly = false;
	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate progress) {
		return true;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public int getCraterProbability() {
		return 2200;
	}

	@Override
	public void decoratePlanet(World par1World, Random par2Random, int par3,
			int par4) {
		this.edenBiomeDecorator.decorate(par1World, par2Random, par3, par4);
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int x, int z) {
		this.mineshaftGenerator.func_151539_a(this, this.worldObj, x, z,
				(Block[]) null);
		this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, x, z,
				(Block[]) null);
	}

	@Override
	public void onChunkProvide(int cX, int cZ, Block[] blocks, byte[] metadata) {
	}

	@Override
	public void onPopulate(IChunkProvider provider, int cX, int cZ) {

	}
}