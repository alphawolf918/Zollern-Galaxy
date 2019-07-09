package zollerngalaxy.recipes;

import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.items.ZGItems;
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
		ThermalExpansionHelper.addPulverizerRecipe(
				5400,
				new ItemStack(ZGBlocks.kriffCopperOre),
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
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZGBlocks.kriffIronOre),
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
		ThermalExpansionHelper
				.addPulverizerRecipe(
						5400,
						new ItemStack(ZGBlocks.kriffGoldOre),
						new ItemStack(
								ItemHelper
										.getItemFromStack(TFItems.itemMaterial.dustGold),
								4, 1));
		
		// Cobalt
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(
				ZGBlocks.kriffCobaltOre), new ItemStack(ZGItems.dustCobalt, 4,
				1));
	}
}