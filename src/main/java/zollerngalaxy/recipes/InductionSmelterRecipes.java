/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import cofh.api.util.ThermalExpansionHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import zollerngalaxy.items.ZGItems;
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
		
		// 1 Coal + 2 Enrichment Dust = 2 Super Charged Coal
		InductionSmelterRecipes.addRecipe(25000, new ItemStack(Items.COAL, 1), new ItemStack(ZGItems.dustEnrichment, 2), new ItemStack(ZGItems.superChargedCoal, 2));
		
		// 2 Amaranth Ingots + 1 Zinc Ingot = 2 Zollernium Ingots
		InductionSmelterRecipes.addRecipe(10000, new ItemStack(ZGItems.ingotAmaranth, 2), new ItemStack(ZGItems.ingotZinc, 1), new ItemStack(ZGItems.ingotZollernium, 1));
		
		// 2 Amaranth Dusts + 1 Zinc Dust = 1 Zollernium Dust
		InductionSmelterRecipes.addRecipe(5000, new ItemStack(ZGItems.dustAmaranth, 2), new ItemStack(ZGItems.dustZinc, 1), new ItemStack(ZGItems.dustZollernium, 1));
		
		// 1 Radite Ingot + 1 Zogite Ingot = 1 Zogradite Ingot
		InductionSmelterRecipes.addRecipe(15000, new ItemStack(ZGItems.ingotRadite, 1), new ItemStack(ZGItems.ingotZogite, 1), new ItemStack(ZGItems.ingotZogradite, 1));
		
		// 1 Radite Dust + 1 Zogite Dust = 1 Zogradite Dust
		InductionSmelterRecipes.addRecipe(8000, new ItemStack(ZGItems.dustRadite, 1), new ItemStack(ZGItems.dustZogite, 1), new ItemStack(ZGItems.dustZogradite, 1));
		
		ZGHelper.Log("Loaded " + totalRecipes + " new Induction Smelter recipes.");
	}
	
	public static void addRecipe(int energy, ItemStack input, ItemStack input2, ItemStack output) {
		ThermalExpansionHelper.addSmelterRecipe(energy, input, input2, output);
		totalRecipes++;
	}
}