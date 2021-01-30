/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.xantheon;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeXantheon extends BiomeXantheonBase {
	
	public BiomeXantheon(BiomeProperties props) {
		super("xantheon", props);
		props.setRainDisabled();
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.8F);
		props.setTemperature(5.0F);
		this.setTemp(5F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.xantheonRock.getDefaultState();
		this.fillerBlock = ZGBlocks.xantheonChrome.getDefaultState();
		this.stoneBlock = ZGBlocks.xantheonStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}