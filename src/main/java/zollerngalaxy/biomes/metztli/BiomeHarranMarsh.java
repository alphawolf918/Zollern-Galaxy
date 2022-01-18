/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDirt.DirtType;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranMarsh extends BiomeHarranBase {
	
	private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
	private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY,
			Boolean.valueOf(false));
	private static final IBlockState OAK_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY,
			Boolean.valueOf(false));
	
	public BiomeHarranMarsh(BiomeProperties props) {
		super("harran_marsh", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranMarsh(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.WARM);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(8.0F);
		props.setRainfall(0.9F);
		this.setTemp(65F);
		this.setBiomeHeight(65);
		this.setBiomeType(EnumBiomeTypeZG.MARSH);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 80, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityParrot.class, 40, 1, 2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityOcelot.class, 40, 1, 2));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCacti = false;
		this.biomeDecor.generateDeadBushes = true;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.generateJungleTrees = true;
		this.biomeDecor.generateMushroomTrees = false;
		this.biomeDecor.generateTallGrass = true;
		this.biomeDecor.generateWaterLilies = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.waterLakesPerChunk = 24;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.jungleTreesPerChunk = 55;
		this.biomeDecor.tallGrassPerChunk = 15;
		this.biomeDecor.fernsPerChunk = 15;
		this.grassFoliageColor = 0x00ff00;
		this.waterColor = 0x008b5c;
		this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.PODZOL);
		this.fillerBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT);
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		if (rand.nextInt(10) == 0) {
			return BIG_TREE_FEATURE;
		} else if (rand.nextInt(2) == 0) {
			return new WorldGenShrub(JUNGLE_LOG, OAK_LEAF);
		} else {
			return rand.nextInt(2) == 0 ? new WorldGenMegaJungle(false, 10, 20, JUNGLE_LOG, JUNGLE_LEAF) : new WorldGenTrees(false, 4 + rand.nextInt(7), JUNGLE_LOG, JUNGLE_LEAF, true);
		}
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return rand.nextInt(2) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		int i = rand.nextInt(16) + 8;
		int j = rand.nextInt(16) + 8;
		int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
		if (height < 1) {
			height = 1;
		}
		int k = rand.nextInt(height);
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), pos.add(i, k, j), DecorateBiomeEvent.Decorate.EventType.PUMPKIN)) {
			(new WorldGenMelon()).generate(worldIn, rand, pos.add(i, k, j));
		}
		WorldGenVines worldgenvines = new WorldGenVines();
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS)) {
			for (int j1 = 0; j1 < 50; ++j1) {
				k = rand.nextInt(16) + 8;
				int l = 128;
				int i1 = rand.nextInt(16) + 8;
				worldgenvines.generate(worldIn, rand, pos.add(k, 128, i1));
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		double d0 = GRASS_COLOR_NOISE.getValue(x * 0.25D, z * 0.25D);
		
		if (d0 > 0.0D) {
			int i = x & 15;
			int j = z & 15;
			
			for (int k = 128; k >= 0; --k) {
				if (chunkPrimerIn.getBlockState(j, k, i).getMaterial() != Material.AIR) {
					if (k <= (this.getBiomeHeight() - 3) && chunkPrimerIn.getBlockState(j, k, i).getBlock() != Blocks.WATER) {
						chunkPrimerIn.setBlockState(j, k, i, Blocks.WATER.getDefaultState());
						
						if (d0 <= 0.24D) {
							chunkPrimerIn.setBlockState(j, k + 1, i, Blocks.WATERLILY.getDefaultState());
						}
					}
					
					break;
				}
			}
		}
		
		this.generateMetztliTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xcc3a4b;
	}
	//
	// @Override
	// @SideOnly(Side.CLIENT)
	// public int getGrassColorAtPos(BlockPos pos) {
	// double d0 = GRASS_COLOR_NOISE.getValue(pos.getX() * 0.0225D, pos.getZ() * 0.0225D);
	// return getModdedBiomeGrassColor(d0 < -0.1D ? 5011004 : 6975545);
	// }
	//
	// @Override
	// @SideOnly(Side.CLIENT)
	// public int getFoliageColorAtPos(BlockPos pos) {
	// return getModdedBiomeFoliageColor(this.grassFoliageColor);
	// }
}