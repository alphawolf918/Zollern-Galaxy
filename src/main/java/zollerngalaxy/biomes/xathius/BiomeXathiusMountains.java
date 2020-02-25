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

public class BiomeXathiusMountains extends BiomeXathiusBase {
	
	public static int grassFoilageColorMultiplier = 0x8b008b;
	
	public BiomeXathiusMountains(BiomeProperties props) {
		super("xathiusocean", props);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(1.4F);
		props.setTemperature(7.1F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(7.1F);
		this.setBiomeHeight(92);
		this.setBiomeType(EnumBiomeTypeZG.ROCKY);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.topBlock = ZGBlocks.xathStone.getDefaultState();
		this.fillerBlock = ZGBlocks.xathStone.getDefaultState();
		this.stoneBlock = ZGBlocks.xathStone;
	}
}