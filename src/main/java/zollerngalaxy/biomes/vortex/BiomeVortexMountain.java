/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.vortex;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeVortexMountain extends BiomeVortexBase {
	
	public BiomeVortexMountain(BiomeProperties props) {
		super("vortex_mountain", props);
		props.setRainDisabled();
		props.setBaseHeight(2.4F);
		props.setHeightVariation(0.2F);
		props.setTemperature(16.0F);
		this.setTemp(15F);
		this.setBiomeHeight(103);
		this.setBiomeType(EnumBiomeTypeZG.ROCKY);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.vortexStone.getDefaultState();
		this.fillerBlock = ZGBlocks.vortexCobblestone.getDefaultState();
		this.stoneBlock = ZGBlocks.vortexStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.001F;
	}
}