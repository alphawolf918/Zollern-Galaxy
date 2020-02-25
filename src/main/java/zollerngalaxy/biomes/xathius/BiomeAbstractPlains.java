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

public class BiomeAbstractPlains extends BiomeXathiusBase {
	
	public static int grassFoilageColorMultiplier = 0x8b008b;
	
	public BiomeAbstractPlains(BiomeProperties props) {
		super("abstractplains", props);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.4F);
		props.setTemperature(5.1F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5.1F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.NORMAL);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.grassFoilageColorMultiplier = 0x9fcc9f;
		this.waterColor = 0x8b2ca4;
		this.topBlock = ZGBlocks.xathGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.xathDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.xathStone;
	}
}