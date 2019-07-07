package zollerngalaxy.recipes;

import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import cofh.api.util.ThermalExpansionHelper;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

public class PulverizerRecipes {
	
	public static void init() {
		// Copper
		ThermalExpansionHelper.addPulverizerRecipe(
				5400,
				new ItemStack(ZGBlocks.zolCopperOre),
				new ItemStack(ItemHelper
						.getItemFromStack(TFItems.itemMaterial.dustCopper), 4,
						64));
		
		// Tin
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZGBlocks.zolTinOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustTin),
								4, 65));
		
		// Iron
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZGBlocks.zolIronOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustIron),
								4, 0));
		
		// Gold
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZGBlocks.zolGoldOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustGold),
								4, 1));
	}
}