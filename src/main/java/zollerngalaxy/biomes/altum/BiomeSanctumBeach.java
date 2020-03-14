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

public class BiomeSanctumBeach extends BiomeAltumBase {
	
	public BiomeSanctumBeach(BiomeProperties props) {
		super("sanctumbeach", props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(1.2F);
		this.setBiomeHeight(25);
		this.setBiomeType(EnumBiomeTypeZG.BEACH);
		this.setTemp(76.18F);
		this.biomeDecor.waterLakesPerChunk = 6;
		this.topBlock = ZGBlocks.altumSand.getDefaultState();
		this.fillerBlock = ZGBlocks.altumCobble.getDefaultState();
		this.stoneBlock = ZGBlocks.altumStone;
		this.setPlanetForBiome(ZGPlanets.planetAltum);
	}
}