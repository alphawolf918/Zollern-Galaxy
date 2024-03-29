/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeKronos extends BiomeKronosBase {
	
	public BiomeKronos(BiomeProperties props) {
		super("kronos_main", props);
		props.setRainDisabled();
		this.setBiomeHeight(120);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(40F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(STONE.getBlock());
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
}