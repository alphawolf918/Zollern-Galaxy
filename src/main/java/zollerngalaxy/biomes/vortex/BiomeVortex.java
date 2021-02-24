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

public class BiomeVortex extends BiomeVortexBase {
	
	public BiomeVortex(BiomeProperties props) {
		super("vortex", props);
		props.setRainDisabled();
		props.setBaseHeight(1.6F);
		props.setHeightVariation(2.8F);
		props.setTemperature(15.0F);
		this.setTemp(10F);
		this.setBiomeHeight(92);
		this.setBiomeType(EnumBiomeTypeZG.STORMY);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.vortexSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.vortexVoltRock.getDefaultState();
		this.stoneBlock = ZGBlocks.vortexStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.001F;
	}
}