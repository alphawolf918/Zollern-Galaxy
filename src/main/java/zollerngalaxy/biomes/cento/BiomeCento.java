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

public class BiomeCento extends BiomeCentoBase {
	
	public BiomeCento(BiomeProperties props) {
		super("centotl", props);
		props.setRainDisabled();
		this.setBiomeHeight(5);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.setTemp(8.5F);
		this.enableSnow = false;
		this.topBlock = ZGBlocks.centoRock.getDefaultState();
		this.fillerBlock = ZGBlocks.centoDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.centoStone;
		this.setPlanetForBiome(ZGPlanets.planetCentotl);
	}
}