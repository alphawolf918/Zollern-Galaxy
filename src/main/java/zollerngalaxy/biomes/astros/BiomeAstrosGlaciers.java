/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.astros;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeAstrosGlaciers extends BiomeAstrosBase {
	
	public BiomeAstrosGlaciers(BiomeProperties props) {
		super("astros_glaciers", props);
		props.setRainDisabled();
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-2.4F);
		this.setBlocks(ZGBlocks.astrosIce);
		this.enableSnow = false;
		this.stoneBlock = ZGBlocks.astrosStone;
		this.setMoonForBiome(ZGPlanets.moonAstros);
	}
}