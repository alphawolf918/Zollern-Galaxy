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

public class BiomeZollusRoyalTundra extends BiomeZollusBase {
	
	public BiomeZollusRoyalTundra(BiomeProperties props) {
		super("zollus_royaltundra", props);
		props.setRainDisabled();
		this.setBiomeHeight(75);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-6.4F);
		this.enableSnow = true;
		this.biomeDecor.generateIceSpikes = false;
		this.biomeDecor.generateCrystals = false;
		this.topBlock = ZGBlocks.zolRoyalRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolStone.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}