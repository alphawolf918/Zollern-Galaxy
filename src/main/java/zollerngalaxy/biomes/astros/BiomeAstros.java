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

public class BiomeAstros extends BiomeAstrosBase {
	
	public BiomeAstros(BiomeProperties props) {
		super("astros", props);
		props.setRainDisabled();
		this.setBiomeHeight(15);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(2.2F);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.astrosRock.getDefaultState();
		this.fillerBlock = ZGBlocks.astrosDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.astrosStone;
		this.setMoonForBiome(ZGPlanets.moonAstros);
	}
}