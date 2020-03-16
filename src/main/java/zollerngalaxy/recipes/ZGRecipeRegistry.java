/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import zollerngalaxy.lib.helpers.ModHelperBase;

public class ZGRecipeRegistry {
	
	public static void init() {
		CraftingRecipes.init();
		FurnaceRecipes.init();
		CompressorRecipesZG.init();
		if (ModHelperBase.useCofh && ModHelperBase.useThermalFoundation) {
			PulverizerRecipes.init();
			InductionSmelterRecipes.init();
			MagmaCrucibleRecipes.init();
			FluidTransposerRecipes.init();
		}
	}
}