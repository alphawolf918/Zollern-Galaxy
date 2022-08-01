/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.zollus;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeZollusSnowPlains extends BiomeZollusBase {
	
	public BiomeZollusSnowPlains(BiomeProperties props) {
		super("zollus_snowplains", props);
		props.setRainDisabled();
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-18.8F);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.zolSnow.getDefaultState();
		this.fillerBlock = ZGBlocks.zolSnow.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}