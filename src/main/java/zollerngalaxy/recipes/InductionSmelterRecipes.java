/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import net.minecraft.item.ItemStack;
import zollerngalaxy.items.ZGItems;
import cofh.api.util.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	
	public static void init() {
		// 1 Shinium Dust + 2 Chargium Dust = 2 Chargium Ingots
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(ZGItems.dustShinium, 1), new ItemStack(ZGItems.dustChargium, 2),
				new ItemStack(ZGItems.ingotChargium, 2));
		
		// 2 Etrium Ingot + 4 Lost Diamond = 2 Zucrite Ingots
		ThermalExpansionHelper.addSmelterRecipe(8000, new ItemStack(ZGItems.ingotEtrium, 2), new ItemStack(ZGItems.dustChargium, 2),
				new ItemStack(ZGItems.ingotZucrite, 2));
		
		// 2 Ascendium + 4 1 Amaranth = 2 Ascendant Amaranth Ingots
		ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ZGItems.ascendium, 2), new ItemStack(ZGItems.ingotAmaranth, 1),
				new ItemStack(ZGItems.ingotAscendantAmaranth, 2));
	}
	
}