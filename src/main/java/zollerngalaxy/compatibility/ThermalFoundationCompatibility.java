package zollerngalaxy.compatibility;

import net.minecraft.block.Block;
import zollerngalaxy.lib.helpers.ZGHelper;
import cofh.thermalfoundation.init.TFFluids;

public class ThermalFoundationCompatibility {
	
	public static Block RED_SEA_BLOCK = TFFluids.blockFluidRedstone;
	
	public static void init() {
		ZGHelper.Log("Initialized IMC with Thermal Foundation.");
	}
	
}