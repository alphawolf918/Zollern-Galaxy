/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.xathius;

import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.worldgen.WorldGenTreeGiantZG;

public class BiomeXathiusGoliathForest extends BiomeXathiusBase {
	
	public static int grassFoilageColorMultiplier = 0x8b008b;
	public WorldGenAbstractTree goliathTreeGen = new WorldGenTreeGiantZG(true, 5, ZGBlocks.xathWoodLog.getDefaultState(), ZGBlocks.xathWoodLeaves.getDefaultState(), false);
	
	public BiomeXathiusGoliathForest(BiomeProperties props) {
		super("xathius_goliathforest", props);
		props.setBaseHeight(4.2F);
		props.setHeightVariation(2.4F);
		props.setTemperature(8.1F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(8.1F);
		this.setBiomeHeight(96);
		this.setBiomeType(EnumBiomeTypeZG.FOREST);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.generateTrees = true;
		this.biomeDecor.treesPerChunk = 40;
		this.grassFoilageColorMultiplier = 0x9fcc9f;
		this.waterColor = 0x8b2ca4;
		this.topBlock = ZGBlocks.xathGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.xathDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.xathStone;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return this.goliathTreeGen;
	}
}