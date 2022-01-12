/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.recipes;

import java.util.Arrays;
import java.util.List;
import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.item.ItemStack;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;

public final class CircuitFabricatorRecipesZG {
	
	// Total Recipes
	private static int totalRecipes = 0;
	
	// Outputs
	private static ItemStack dustEnrichment = new ItemStack(ZGItems.dustEnrichment, 9);
	
	// Inputs
	private static ItemStack silicon = new ItemStack(GCItems.basicItem, 1, 2);
	private static ItemStack garnetFire = new ItemStack(ZGItems.garnetFire, 2);
	private static ItemStack dustPlutonium = new ItemStack(ZGItems.ingotPlutonium, 9);
	private static ItemStack ingotRhodium = new ItemStack(ZGItems.ingotRhodium, 4);
	
	public static void init() {
		// Enrichment Dust
		CircuitFabricatorRecipesZG.addCircuitFabrication(dustEnrichment, Arrays.asList(garnetFire, silicon, silicon, dustPlutonium, ingotRhodium));
		
		//
		// TODO
		//
		ZGHelper.Log("Loaded " + totalRecipes + " new Circuit Fabricator recipes.");
	}
	
	private static void addCircuitFabrication(ItemStack itemStackOut, List<Object> list) {
		ZGRecipeHelper.addCircuitFabricatorRecipe(itemStackOut, list);
		totalRecipes++;
	}
}