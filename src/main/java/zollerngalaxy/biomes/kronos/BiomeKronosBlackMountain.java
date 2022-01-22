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

public class BiomeKronosBlackMountain extends BiomeKronosBase {
	
	public BiomeKronosBlackMountain(BiomeProperties props) {
		super("kronos_black_mountain", props);
		props.setRainDisabled();
		this.setBiomeHeight(124);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(80F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(Blocks.OBSIDIAN);
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
}