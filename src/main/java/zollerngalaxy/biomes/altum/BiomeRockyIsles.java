/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.altum;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeRockyIsles extends BiomeAltumBase {
	
	public BiomeRockyIsles(BiomeProperties props) {
		super("rockyisles", props);
		props.setBaseHeight(1.8F);
		props.setHeightVariation(2.0F);
		this.setBiomeHeight(42);
		this.setBiomeType(EnumBiomeTypeZG.ISLAND);
		this.setTemp(84.23F);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.altumRock.getDefaultState();
		this.fillerBlock = ZGBlocks.altumDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.altumStone;
	}
}