/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.maveth;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeMaveth extends BiomeMavethBase {
	
	public BiomeMaveth(BiomeProperties props) {
		super("zg_maveth", props);
		props.setRainDisabled();
		this.setBiomeHeight(86);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.setTemp(-2.8F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.mavethSand.getDefaultState();
		this.fillerBlock = ZGBlocks.mavethRock.getDefaultState();
		this.stoneBlock = ZGBlocks.mavethStone;
	}
}