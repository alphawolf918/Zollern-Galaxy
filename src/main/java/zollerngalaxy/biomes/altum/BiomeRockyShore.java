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
import zollerngalaxy.planets.ZGPlanets;

public class BiomeRockyShore extends BiomeAltumBase {
	
	public BiomeRockyShore(BiomeProperties props) {
		super("rockyshore", props);
		props.setBaseHeight(2.8F);
		props.setHeightVariation(2.0F);
		this.setBiomeHeight(62);
		this.setBiomeType(EnumBiomeTypeZG.ISLAND);
		this.setTemp(74.14F);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.altumStone.getDefaultState();
		this.fillerBlock = ZGBlocks.altumCobble.getDefaultState();
		this.stoneBlock = ZGBlocks.altumStone;
		this.setPlanetForBiome(ZGPlanets.planetAltum);
	}
}