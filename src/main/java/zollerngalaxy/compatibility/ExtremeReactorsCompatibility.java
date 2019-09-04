package zollerngalaxy.compatibility;

import zollerngalaxy.lib.helpers.ZGHelper;
import erogenousbeef.bigreactors.api.registry.TurbineCoil;

public class ExtremeReactorsCompatibility {
	
	public static void init() {
		ZGHelper.Log("Initializing IMC with Extreme Reactors...");
		ExtremeReactorsCompatibility.registerTurbineBlock("blockCobalt", 2.5F, 1.0F, 2.4F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockEvenium", 2.6F, 1.02F, 2.5F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockVirinium", 2.7F, 1.04F, 2.6F);
		ZGHelper.Log("Extreme Reactors IMC: Done!");
	}
	
	private static void registerTurbineBlock(String oreDictName, float efficiency, float bonus, float extractionRate) {
		TurbineCoil.registerBlock(oreDictName, efficiency, bonus, extractionRate);
		ZGHelper.Log("Extreme Reactors: Loaded '" + oreDictName + "' as a Turbine Coil.");
	}
	
}