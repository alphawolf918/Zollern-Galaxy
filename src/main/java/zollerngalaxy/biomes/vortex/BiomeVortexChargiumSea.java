/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.vortex;

import net.minecraft.init.Blocks;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeVortexChargiumSea extends BiomeVortexBase {
	
	public BiomeVortexChargiumSea(BiomeProperties props) {
		super("vortex_chargium_sea", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(16.0F);
		this.setTemp(18F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.setBlocks(Blocks.AIR);
		this.stoneBlock = ZGBlocks.vortexStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.001F;
	}
}