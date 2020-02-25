/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.xathius;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeBluelands extends BiomeXathiusBase {
	
	public static int grassFoilageColorMultiplier = 0x8b008b;
	
	public BiomeBluelands(BiomeProperties props) {
		super("bluelands", props);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.1F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(4.1F);
		this.setBiomeHeight(92);
		this.setBiomeType(EnumBiomeTypeZG.NORMAL);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.grassFoilageColorMultiplier = 0x9fcc9f;
		this.waterColor = 0x8b2ca4;
		this.topBlock = ZGBlocks.xathRock.getDefaultState();
		this.fillerBlock = ZGBlocks.xathGravel.getDefaultState();
		this.stoneBlock = ZGBlocks.xathStone;
	}
}