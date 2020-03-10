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

public class BiomeRockyIsles extends BiomeAltumBase {
	
	public BiomeRockyIsles(BiomeProperties props) {
		super("rockyisles", props);
		props.setRainDisabled();
		this.setBiomeHeight(12);
		this.setBiomeType(EnumBiomeTypeZG.ISLAND);
		this.setTemp(84.23F);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.altumRock.getDefaultState();
		this.fillerBlock = ZGBlocks.altumDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.altumStone;
		this.setPlanetForBiome(ZGPlanets.planetAltum);
	}
}