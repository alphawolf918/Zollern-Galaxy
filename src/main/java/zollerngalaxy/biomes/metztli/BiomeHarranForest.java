/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.worldgen.WorldGenZGTree;

public class BiomeHarranForest extends BiomeHarranBase {
	
	protected static final IBlockState CHERRY_LOG = ZGBlocks.cherryWoodLog.getDefaultState();
	protected static final IBlockState CHERRY_LEAVES = ZGBlocks.cherryWoodLeaves.getDefaultState();
	
	protected static final WorldGenBirchTree SUPER_BIRCH_TREE = new WorldGenBirchTree(false, true);
	protected static final WorldGenBirchTree BIRCH_TREE = new WorldGenBirchTree(false, false);
	protected static final WorldGenCanopyTree ROOF_TREE = new WorldGenCanopyTree(false);
	protected static final WorldGenAbstractTree CHERRY_TREE = new WorldGenZGTree(false, 4, CHERRY_LOG, CHERRY_LEAVES, false);
	
	private final BiomeHarranForest.Type type;
	
	public BiomeHarranForest(BiomeHarranForest.Type typeIn, BiomeProperties props) {
		super("harran_forest1", props);
		this.setupBiome(props, typeIn);
		this.type = typeIn;
	}
	
	public BiomeHarranForest(String singleName, BiomeHarranForest.Type typeIn, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props, typeIn);
		this.type = typeIn;
	}
	
	private void setupBiome(BiomeProperties props, BiomeHarranForest.Type typeIn) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.6F);
		props.setTemperature(5.6F);
		this.setTemp(24F);
		this.setBiomeHeight(28);
		this.setBiomeType(EnumBiomeTypeZG.FOREST);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.grassPerChunk = 8;
		this.biomeDecor.tallGrassPerChunk = 6;
		this.biomeDecor.flowersPerChunk = 4;
		this.biomeDecor.treesPerChunk = 10;
		if (this.type == Type.CHERRY) {
			this.grassFoliageColor = 0xf741cb;
		} else {
			this.grassFoliageColor = 0x00cc00;
		}
		this.waterColor = 0x0000ff;
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.stoneBlock = Blocks.STONE;
		
		if (this.type == BiomeHarranForest.Type.FLOWER) {
			this.biomeDecor.treesPerChunk = 6;
			this.biomeDecor.flowersPerChunk = 100;
			this.biomeDecor.grassPerChunk = 1;
			this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
		}
		
		if (this.type == BiomeHarranForest.Type.NORMAL) {
			this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 5, 4, 4));
		}
		
		if (this.type == BiomeHarranForest.Type.ROOFED) {
			this.biomeDecor.treesPerChunk = -999;
		}
		
		if (this.type == BiomeHarranForest.Type.FLOWER) {
			this.flowers.clear();
			for (BlockFlower.EnumFlowerType type : BlockFlower.EnumFlowerType.values()) {
				if (type.getBlockType() == BlockFlower.EnumFlowerColor.YELLOW)
					continue;
				if (type == BlockFlower.EnumFlowerType.BLUE_ORCHID)
					type = BlockFlower.EnumFlowerType.POPPY;
				addFlower(Blocks.RED_FLOWER.getDefaultState().withProperty(Blocks.RED_FLOWER.getTypeProperty(), type), 10);
			}
		}
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		if (this.type == BiomeHarranForest.Type.ROOFED && rand.nextInt(3) > 0) {
			return ROOF_TREE;
		} else if (this.type != BiomeHarranForest.Type.BIRCH && rand.nextInt(5) != 0) {
			return rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE;
		} else if (this.type == BiomeHarranForest.Type.CHERRY && rand.nextInt(3) == 0) {
			return CHERRY_TREE;
		} else {
			return BIRCH_TREE;
		}
	}
	
	@Override
	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		if (this.type == BiomeHarranForest.Type.FLOWER) {
			double d0 = MathHelper.clamp((1.0D + GRASS_COLOR_NOISE.getValue(pos.getX() / 48.0D, pos.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
			BlockFlower.EnumFlowerType blockflower$enumflowertype = BlockFlower.EnumFlowerType.values()[(int) (d0 * BlockFlower.EnumFlowerType.values().length)];
			return blockflower$enumflowertype == BlockFlower.EnumFlowerType.BLUE_ORCHID ? BlockFlower.EnumFlowerType.POPPY : blockflower$enumflowertype;
		} else {
			return super.pickRandomFlower(rand, pos);
		}
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		if (this.type == BiomeHarranForest.Type.ROOFED) {
			this.addMushrooms(worldIn, rand, pos);
		}
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FLOWERS)) {
			int i = rand.nextInt(5) - 3;
			
			if (this.type == BiomeHarranForest.Type.FLOWER) {
				i += 2;
			}
			
			this.addDoublePlants(worldIn, rand, pos, i);
		}
		super.decorate(worldIn, rand, pos);
	}
	
	public void addMushrooms(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				int k = i * 4 + 1 + 8 + rand.nextInt(3);
				int l = j * 4 + 1 + 8 + rand.nextInt(3);
				BlockPos blockpos = world.getHeight(pos.add(k, 0, l));
				
				if (rand.nextInt(20) == 0 && TerrainGen.decorate(world, rand, new ChunkPos(pos), blockpos, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
					WorldGenBigMushroom worldgenbigmushroom = new WorldGenBigMushroom();
					worldgenbigmushroom.generate(world, rand, blockpos);
				} else if (TerrainGen.decorate(world, rand, new ChunkPos(pos), blockpos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
					WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(rand);
					worldgenabstracttree.setDecorationDefaults();
					
					if (worldgenabstracttree.generate(world, rand, blockpos)) {
						worldgenabstracttree.generateSaplings(world, rand, blockpos);
					}
				}
			}
		}
	}
	
	public void addDoublePlants(World world, Random rand, BlockPos pos, int iter) {
		for (int i = 0; i < iter; ++i) {
			int j = rand.nextInt(3);
			
			if (j == 0) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.SYRINGA);
			} else if (j == 1) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.ROSE);
			} else if (j == 2) {
				DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.PAEONIA);
			}
			
			for (int k = 0; k < 5; ++k) {
				int l = rand.nextInt(16) + 8;
				int i1 = rand.nextInt(16) + 8;
				int j1 = rand.nextInt(world.getHeight(pos.add(l, 0, i1)).getY() + 32);
				
				if (DOUBLE_PLANT_GENERATOR.generate(world, rand, new BlockPos(pos.getX() + l, j1, pos.getZ() + i1))) {
					break;
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00a94b;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		int i = super.getGrassColorAtPos(pos);
		return this.type == BiomeHarranForest.Type.ROOFED ? (i & 16711422) + 2634762 >> 1 : i;
	}
	
	public static enum Type {
		NORMAL, FLOWER, BIRCH, ROOFED, CHERRY;
	}
}