/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.cento;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCentoConstructs extends BiomeCentoBase {
	
	public BiomeCentoConstructs(BiomeProperties props) {
		super("centotl_constructs", props);
		props.setRainDisabled();
		this.setBiomeHeight(75);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.setTemp(2.8F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.xantheonConstructBlock.getDefaultState();
		this.fillerBlock = ZGBlocks.blockCrater.getDefaultState();
		this.stoneBlock = ZGBlocks.centoStone;
		this.setPlanetForBiome(ZGPlanets.planetCentotl);
	}
}