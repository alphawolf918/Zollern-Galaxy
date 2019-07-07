package zollerngalaxy.recipes;

import zollerngalaxy.lib.helpers.ModHelperBase;

public class ZGRecipeRegistry {
	
	public static void init() {
		CraftingRecipes.init();
		SmeltingRecipes.init();
		if (ModHelperBase.useCofh) {
			PulverizerRecipes.init();
		}
	}
}