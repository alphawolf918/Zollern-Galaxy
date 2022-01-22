/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import net.minecraft.init.Blocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeKronosSoulDesert extends BiomeKronosBase {
	
	public BiomeKronosSoulDesert(BiomeProperties props) {
		super("kronos_desert_soul", props);
		props.setRainDisabled();
		this.setBiomeHeight(60);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(60F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(Blocks.SOUL_SAND);
		this.enableSnow = false;
		this.biomeDecor.generateNetherWarts = true;
		this.biomeDecor.netherWartsPerChunk = 8;
		this.stoneBlock = STONE.getBlock();
	}
}