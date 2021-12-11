/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compatibility;

import net.minecraft.block.Block;
import zollerngalaxy.lib.helpers.ZGHelper;
import cofh.thermalfoundation.init.TFFluids;

public class ThermalFoundationCompat {
	
	public static Block RED_SEA_BLOCK = TFFluids.blockFluidRedstone;
	
	public static void init() {
		ZGHelper.Log("Initialized IMC with Thermal Foundation.");
	}
	
}