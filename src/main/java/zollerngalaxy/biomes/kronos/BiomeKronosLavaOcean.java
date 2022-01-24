/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeKronosLavaOcean extends BiomeKronosBase {
	
	public BiomeKronosLavaOcean(BiomeProperties props) {
		super("kronos_ocean_lava", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(10.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(100F);
		this.setBiomeHeight(10);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.setBlocks(AIR.getBlock());
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
}