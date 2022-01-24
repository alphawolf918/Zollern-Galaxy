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

public class BiomeKronosMagmaSlimelands extends BiomeKronosBase {
	
	public BiomeKronosMagmaSlimelands(BiomeProperties props) {
		super("kronos_magma_slimelands", props);
		props.setRainDisabled();
		this.setBiomeHeight(10);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(36.21F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(ZGBlocks.magmaSlimeBlock);
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
}