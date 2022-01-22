/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeKronosBlazingHills extends BiomeKronosBase {
	
	public BiomeKronosBlazingHills(BiomeProperties props) {
		super("kronos_blazing_hills", props);
		props.setRainDisabled();
		this.setBiomeHeight(90);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(135F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(ZGBlocks.blazeRock);
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
}