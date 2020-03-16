/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compatibility;

import zollerngalaxy.lib.helpers.ZGHelper;
import erogenousbeef.bigreactors.api.registry.ReactorInterior;
import erogenousbeef.bigreactors.api.registry.TurbineCoil;

public class ExtremeReactorsCompatibility {
	
	public static void init() {
		ZGHelper.Log("Initializing IMC with Extreme Reactors...");
		
		// Turbine Coils
		ExtremeReactorsCompatibility.registerTurbineBlock("blockCobalt", 2.5F, 1.0F, 2.4F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockEvenium", 2.6F, 1.02F, 2.5F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockVirinium", 2.7F, 1.04F, 2.6F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockSuperChargedCoal", 2.9F, 1.06F, 2.7F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockPlutonium", 3.2F, 1.06F, 3.4F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockZollernium", 3.5F, 1.07F, 3.5F);
		ExtremeReactorsCompatibility.registerTurbineBlock("blockChargium", 4.0F, 1.09F, 3.8F);
		
		// Reactor Fluids
		ExtremeReactorsCompatibility.registerReactorFluid("whitelava", 0.82F, 2.90F, 6.05F, 4.5F);
		ExtremeReactorsCompatibility.registerReactorFluid("fueltonium", 0.92F, 3.95F, 6.50F, 5.6F);
		ExtremeReactorsCompatibility.registerReactorFluid("chargium", 1.92F, 5.00F, 6.50F, 6.7F);
		
		ZGHelper.Log("Extreme Reactors IMC: Done!");
	}
	
	private static void registerTurbineBlock(String oreDictName, float efficiency, float bonus, float extractionRate) {
		TurbineCoil.registerBlock(oreDictName, efficiency, bonus, extractionRate);
		ZGHelper.Log("Extreme Reactors: Loaded '" + oreDictName + "' as a Turbine Coil.");
	}
	
	private static void registerReactorFluid(String fluidName, float absorption, float heatEfficiency, float moderation,
			float heatConductivity) {
		ReactorInterior.registerFluid(fluidName, absorption, heatEfficiency, moderation, heatConductivity);
		ZGHelper.Log("Extreme Reactors: Loaded '" + fluidName + "' as a Reactor Fluid.");
	}
}