package zollerngalaxy.recipes;

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
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenCopperOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 4, 64));
		
		// Tin
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolTinOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 4, 65));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgTinOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 4, 65));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenTinOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 4, 65));
		
		// Silver
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenSilverOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustSilver), 4, 66));
		
		// Lead
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgLeadOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 4, 67));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenLeadOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 4, 67));
		
		// Iron
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenIronOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron), 4, 0));
		
		// Gold
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.zolGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenGoldOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 4, 1));
		
		// Aluminum
		ThermalExpansionHelper
				.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgAluminumOre), new ItemStack(
						ItemHelper.getItemFromStack(TFItems.itemMaterial.dustAluminum), 4, 68));
		ThermalExpansionHelper
				.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenAluminumOre), new ItemStack(
						ItemHelper.getItemFromStack(TFItems.itemMaterial.dustAluminum), 4, 68));
		
		// Steel
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenSteelOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustSteel), 4, 96));
		
		// Bronze
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenBronzeOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustBronze), 4, 99));
		
		// Invar
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenInvarOre),
				new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.dustInvar), 4, 98));
		
		// Electrum
		ThermalExpansionHelper
				.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenElectrumOre), new ItemStack(
						ItemHelper.getItemFromStack(TFItems.itemMaterial.dustElectrum), 4, 97));
		
		// Platinum
		ThermalExpansionHelper
				.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenPlatinumOre), new ItemStack(
						ItemHelper.getItemFromStack(TFItems.itemMaterial.dustPlatinum), 4, 70));
		
		// Cobalt
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.kriffCobaltOre),
				new ItemStack(ZGItems.dustCobalt, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgCobaltOre),
				new ItemStack(ZGItems.dustCobalt, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenCobaltOre),
				new ItemStack(ZGItems.dustCobalt, 4));
		
		// Evenium
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.purgEveniumOre),
				new ItemStack(ZGItems.dustEve, 4));
		ThermalExpansionHelper.addPulverizerRecipe(5400, new ItemStack(ZGBlocks.edenEveniumOre),
				new ItemStack(ZGItems.dustEve, 4));
	}
}