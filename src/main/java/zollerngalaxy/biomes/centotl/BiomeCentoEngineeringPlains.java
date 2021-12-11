/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.centotl;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCentoEngineeringPlains extends BiomeCentoBase {
	
	public BiomeCentoEngineeringPlains(BiomeProperties props) {
		super("centotl_engineering_plains", props);
		props.setRainDisabled();
		this.setBiomeHeight(55);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.setTemp(4.5F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.centoDirt.getDefaultState();
		this.fillerBlock = ZGBlocks.centoGravel.getDefaultState();
		this.stoneBlock = ZGBlocks.centoStone;
		this.setPlanetForBiome(ZGPlanets.planetCentotl);
	}
}