package zollerngalaxy.lib.helpers.integration;

import erogenousbeef.bigreactors.api.registry.TurbineCoil;

public class ZGTurbineBlocks {
	
	public static void init() {
		TurbineCoil.registerBlock("blockCobalt", 2.5f, 1.0f, 2.4f);
		TurbineCoil.registerBlock("blockEvenium", 2.9f, 1.02f, 2.9f);
		TurbineCoil.registerBlock("blockVirinium", 3.2f, 1.04f, 3.0f);
	}
	
}