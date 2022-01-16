/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compat;

import erogenousbeef.bigreactors.api.registry.Reactants;
import erogenousbeef.bigreactors.api.registry.ReactorInterior;
import erogenousbeef.bigreactors.api.registry.TurbineCoil;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.item.ItemStack;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.recipes.InductionSmelterRecipes;

public class ExtremeReactorsCompat {
	
	public static final int fueltoniumReactantAmount = 2000;
	public static final int plutoniumReactantAmount = 4000;
	
	protected static final int FUEL = 0;
	protected static final int WASTE = 1;
	
	protected static final int fueltoniumColor = 0x00ff00;
	protected static final int plutoniumColor = 0xffd700;
	
	public static void init() {
		ZGHelper.Log("Initializing IMC with Extreme Reactors...");
		
		// Turbine Coils
		ExtremeReactorsCompat.registerTurbineBlock("blockCobalt", 2.5F, 1.0F, 2.4F);
		ExtremeReactorsCompat.registerTurbineBlock("blockEvenium", 2.6F, 1.02F, 2.5F);
		ExtremeReactorsCompat.registerTurbineBlock("blockVirinium", 2.7F, 1.04F, 2.6F);
		ExtremeReactorsCompat.registerTurbineBlock("blockSuperChargedCoal", 2.9F, 1.06F, 2.7F);
		ExtremeReactorsCompat.registerTurbineBlock("blockPlutonium", 3.2F, 1.06F, 3.4F);
		ExtremeReactorsCompat.registerTurbineBlock("blockZollernium", 3.5F, 1.07F, 3.5F);
		ExtremeReactorsCompat.registerTurbineBlock("blockChargium", 4.0F, 1.09F, 3.8F);
		
		// Reactor Fluids
		ExtremeReactorsCompat.registerReactorFluid("whitelava", 0.82F, 2.90F, 6.05F, 4.5F);
		ExtremeReactorsCompat.registerReactorFluid("fueltonium", 0.92F, 3.95F, 6.50F, 5.6F);
		ExtremeReactorsCompat.registerReactorFluid("chargium", 1.92F, 5.00F, 6.50F, 6.7F);
		
		// Reactor Solids
		ExtremeReactorsCompat.registerReactorSolid("ingotFueltonium", "fueltonium", fueltoniumReactantAmount, FUEL, fueltoniumColor);
		ExtremeReactorsCompat.registerReactorSolid("ingotPlutonium", "plutonium", plutoniumReactantAmount, FUEL, plutoniumColor);
		
		// Extreme Reactors + Thermal Foundation
		if (ModHelperBase.useThermalFoundation) {
			// Blutonium
			if (ModHelperBase.useExtremeReactors && ConfigManagerZG.enableExtremeReactorsCompat) {
				// 8 Cyanite + 2 Enrichment Dust = 2 Blutonium Ingots
				InductionSmelterRecipes.addRecipe(20000, new ItemStack(BrItems.ingotCyanite, 9), new ItemStack(ZGItems.dustEnrichment, 2), new ItemStack(BrItems.ingotBlutonium, 2));
			}
		}
		
		ZGHelper.Log("Extreme Reactors IMC: Done!");
	}
	
	private static void registerTurbineBlock(String oreDictName, float efficiency, float bonus, float extractionRate) {
		TurbineCoil.registerBlock(oreDictName, efficiency, bonus, extractionRate);
		ZGHelper.Log("Extreme Reactors: Loaded '" + oreDictName + "' as a Turbine Coil.");
	}
	
	private static void registerReactorFluid(String fluidName, float absorption, float heatEfficiency, float moderation, float heatConductivity) {
		ReactorInterior.registerFluid(fluidName, absorption, heatEfficiency, moderation, heatConductivity);
		ZGHelper.Log("Extreme Reactors: Loaded '" + fluidName + "' as a Reactor Fluid.");
	}
	
	private static void registerReactorSolid(String oreDictName, String reactantName, int qty, int type, int clr) {
		Reactants.registerReactant(reactantName, type, clr);
		ZGHelper.Log("Extreme Reactors: Registered '" + reactantName + "' (" + oreDictName + ") as a Reactant.");
		Reactants.registerSolid(oreDictName, reactantName, qty);
		ZGHelper.Log("Extreme Reactors: Loaded '" + reactantName + "' (" + oreDictName + ") as a Reactor solid.");
	}
}