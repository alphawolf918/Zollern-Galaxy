/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranHills extends BiomeHarranBase {
	
	private final WorldGenerator silverfishSpawner = new WorldGenMinable(Blocks.MONSTER_EGG.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.STONE), 9);
	private final WorldGenTaiga2 spruceGenerator = new WorldGenTaiga2(false);
	
	public BiomeHarranHills(BiomeProperties props) {
		super("harran_hills", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranHills(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(2.6F);
		props.setHeightVariation(0.2F);
		props.setTemperature(5.6F);
		this.setTemp(34F);
		this.setBiomeHeight(128);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.spawnableCreatureList.add(new SpawnListEntry(EntityLlama.class, 5, 4, 6));
		this.enableSnow = true;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.grassPerChunk = 4;
		this.biomeDecor.flowersPerChunk = 8;
		this.biomeDecor.treesPerChunk = 1;
		this.grassFoliageColor = 0x008b00;
		this.waterColor = 0x8b008b;
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();// BiomeHills
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return rand.nextInt(3) > 0 ? this.spruceGenerator : super.getRandomTreeFeature(rand);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, rand, pos));
		WorldGenerator emeralds = new EmeraldGenerator();
		if (TerrainGen.generateOre(worldIn, rand, emeralds, pos, OreGenEvent.GenerateMinable.EventType.EMERALD))
			emeralds.generate(worldIn, rand, pos);
		
		for (int j1 = 0; j1 < 7; ++j1) {
			int k1 = rand.nextInt(16);
			int l1 = rand.nextInt(64);
			int i2 = rand.nextInt(16);
			if (TerrainGen.generateOre(worldIn, rand, silverfishSpawner, pos.add(j1, k1, l1), OreGenEvent.GenerateMinable.EventType.SILVERFISH))
				this.silverfishSpawner.generate(worldIn, rand, pos.add(k1, l1, i2));
		}
		
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, rand, pos));
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		
		if ((noiseVal < -1.0D || noiseVal > 2.0D)) {
			this.topBlock = Blocks.GRAVEL.getDefaultState();
			this.fillerBlock = Blocks.GRAVEL.getDefaultState();
		} else if (noiseVal > 1.0D) {
			this.topBlock = Blocks.STONE.getDefaultState();
			this.fillerBlock = Blocks.STONE.getDefaultState();
		}
		
		this.generateMetztliTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
	
	private static class EmeraldGenerator extends WorldGenerator {
		
		@Override
		public boolean generate(World worldIn, Random rand, BlockPos pos) {
			int count = 3 + rand.nextInt(6);
			for (int i = 0; i < count; i++) {
				int offset = ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-114332
				BlockPos blockpos = pos.add(rand.nextInt(16) + offset, rand.nextInt(28) + 4, rand.nextInt(16) + offset);
				
				IBlockState state = worldIn.getBlockState(blockpos);
				if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, BlockMatcher.forBlock(Blocks.STONE))) {
					worldIn.setBlockState(blockpos, Blocks.EMERALD_ORE.getDefaultState(), 16 | 2);
				}
			}
			return true;
		}
	}
}