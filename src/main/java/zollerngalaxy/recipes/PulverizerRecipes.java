package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import cofh.api.util.ThermalExpansionHelper;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

public class PulverizerRecipes {
	
	public static void init() {
		// Copper
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolCopperOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 4, 64));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffCopperOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 4, 64));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgCopperOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 4, 64));
		
		// Tin
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolTinOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 4, 65));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgTinOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 4, 65));
		
		// Lead
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgLeadOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 4, 67));
		
		// Iron
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		
		// Gold
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		
		// Aluminum
		ThermalExpansionHelper
				.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgAluminumOre), new ItemStack(
						ItemHelper.getItemFromStack(TFItems.itemMaterial.dustAluminum), 4, 68));
		
		// Cobalt
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffCobaltOre),
				new ItemStack(ZGItems.dustCobalt, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgCobaltOre),
				new ItemStack(ZGItems.dustCobalt, 4));
		
		// Evenium
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgEveniumOre),
				new ItemStack(ZGItems.dustEve, 4));
		
		// Meteoric Iron
		ThermalExpansionHelper.addPulverizerRecipe(5400,
				new ItemStack(ZGBlocks.purgMeteoricIronOre), new ItemStack(GCItems.meteoricIronRaw,
						4));
	}
}