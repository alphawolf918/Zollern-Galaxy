/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranFruitForest extends BiomeHarranBase {
	
	private static final WorldGenAbstractTree CHERRY_TREE = ZGBlocks.cherryWoodGen;
	private static final WorldGenAbstractTree BANANA_TREE = ZGBlocks.bananaGen;
	private static final WorldGenAbstractTree GUAVA_TREE = ZGBlocks.guavaGen;
	private static final WorldGenAbstractTree PEACH_TREE = ZGBlocks.peachGen;
	private static final WorldGenAbstractTree GRAPEFRUIT_TREE = ZGBlocks.grapefruitGen;
	private static final WorldGenAbstractTree ORANGE_TREE = ZGBlocks.orangeGen;
	private static final WorldGenAbstractTree LEMON_TREE = ZGBlocks.lemonGen;
	private static final WorldGenAbstractTree LIME_TREE = ZGBlocks.limeGen;
	private static final WorldGenAbstractTree LIMON_TREE = ZGBlocks.limonGen;
	
	public BiomeHarranFruitForest(BiomeProperties props) {
		super("harran_fruit_forest", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranFruitForest(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(0.2F);
		props.setHeightVariation(0.1F);
		props.setTemperature(4.0F);
		props.setRainfall(10F);
		props.setWaterColor(0x0000ff);
		this.setTemp(15F);
		this.setBiomeHeight(24);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.setBlocks(ZGBlocks.harranGrass, ZGBlocks.harranSoil);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.generateTallGrass = true;
		this.biomeDecor.tallGrassPerChunk = 15;
		this.biomeDecor.waterLakesPerChunk = 8;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.grassPerChunk = 14;
		this.biomeDecor.flowersPerChunk = 2;
		this.biomeDecor.treesPerChunk = 55;
		this.grassFoliageColor = 0x00ff00;
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		switch (rand.nextInt(10)) {
			default:
			case 0:
				return BANANA_TREE;
			case 1:
				return CHERRY_TREE;
			case 2:
				return GUAVA_TREE;
			case 3:
				return PEACH_TREE;
			case 4:
				return GRAPEFRUIT_TREE;
			case 5:
				return ORANGE_TREE;
			case 6:
				return LEMON_TREE;
			case 7:
				return LIME_TREE;
			case 8:
				return LIMON_TREE;
		}
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return rand.nextInt(2) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
}