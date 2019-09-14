package zollerngalaxy.recipes;

import net.minecraft.item.ItemStack;
import zollerngalaxy.items.ZGItems;
import cofh.api.util.ThermalExpansionHelper;

public class InductionSmelterRecipes {
	
	public static void init() {
		// 1 Shinium Dust + 2 Chargium Dust = 2 Chargium Ingots
		ThermalExpansionHelper.addSmelterRecipe(5000, new ItemStack(ZGItems.dustShinium, 1), new ItemStack(
				ZGItems.dustChargium, 2), new ItemStack(ZGItems.ingotChargium, 2));
	}
	
}