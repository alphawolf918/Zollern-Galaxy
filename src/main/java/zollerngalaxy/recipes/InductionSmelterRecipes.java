/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import cofh.api.util.ThermalExpansionHelper;
import erogenousbeef.bigreactors.init.BrItems;
import net.minecraft.item.ItemStack;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHelper;

public final class InductionSmelterRecipes {
	
	private static int totalRecipes = 0;
	
	public static void init() {
		// 1 Shinium Dust + 2 Chargium Dust = 2 Chargium Ingots
		InductionSmelterRecipes.addRecipe(5000, new ItemStack(ZGItems.dustShinium, 1), new ItemStack(ZGItems.dustChargium, 2), new ItemStack(ZGItems.ingotChargium, 2));
		
		// 2 Etrium Ingot + 4 Lost Diamond = 2 Zucrite Ingots
		InductionSmelterRecipes.addRecipe(8000, new ItemStack(ZGItems.ingotEtrium, 2), new ItemStack(ZGItems.dustChargium, 2), new ItemStack(ZGItems.ingotZucrite, 2));
		
		// 2 Ascendium + 4 1 Amaranth = 2 Ascendant Amaranth Ingots
		InductionSmelterRecipes.addRecipe(10000, new ItemStack(ZGItems.ascendium, 2), new ItemStack(ZGItems.ingotAmaranth, 1), new ItemStack(ZGItems.ingotAscendantAmaranth, 2));
		
		// Blutonium
		if (ModHelperBase.useExtremeReactors && ConfigManagerZG.enableExtremeReactorsCompat) {
			// 8 Cyanite + 2 Enrichment Dust = 2 Blutonium Ingots
			InductionSmelterRecipes.addRecipe(20000, new ItemStack(BrItems.ingotCyanite, 9), new ItemStack(ZGItems.dustEnrichment, 2), new ItemStack(BrItems.ingotBlutonium, 2));
		}
		
		ZGHelper.Log("Loaded " + totalRecipes + " new Induction Smelter recipes.");
	}
	
	private static void addRecipe(int energy, ItemStack input, ItemStack input2, ItemStack output) {
		ThermalExpansionHelper.addSmelterRecipe(energy, input, input2, output);
		totalRecipes++;
	}
}