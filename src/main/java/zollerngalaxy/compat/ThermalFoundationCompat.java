/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compat;

import cofh.thermalfoundation.init.TFFluids;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ThermalFoundationCompat {
	
	protected static boolean shouldUseRedstone = (ModHelperBase.useThermalFoundation && ConfigManagerZG.shouldOasisUseLiquidRedstone);
	
	public static void init() {
		ZGHelper.Log("Initialized IMC with Thermal Foundation.");
	}
	
	public static IBlockState getOasisWaterState() {
		return (shouldUseRedstone) ? TFFluids.blockFluidRedstone.getDefaultState() : Blocks.WATER.getDefaultState();
	}
	
}