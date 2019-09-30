package zollerngalaxy.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import cofh.api.util.ThermalExpansionHelper;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

public class PulverizerRecipes {
	
	private static int totalRecipes = 0;
	
	public static void init() {
		ZGHelper.Log("Beginning Pulverizer recipe registration...");
		
		// Copper
		PulverizerRecipes.addRecipe(ZGBlocks.zolCopperOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 64);
		PulverizerRecipes.addRecipe(ZGBlocks.kriffCopperOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper),
				64);
		PulverizerRecipes
				.addRecipe(ZGBlocks.purgCopperOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 64);
		PulverizerRecipes
				.addRecipe(ZGBlocks.edenCopperOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 64);
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonCopperOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustCopper), 64);
		
		// Tin
		PulverizerRecipes.addRecipe(ZGBlocks.zolTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		PulverizerRecipes.addRecipe(ZGBlocks.purgTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		PulverizerRecipes.addRecipe(ZGBlocks.edenTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		PulverizerRecipes.addRecipe(ZGBlocks.xathTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		PulverizerRecipes.addRecipe(ZGBlocks.atheonTinOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustTin), 65);
		
		// Silver
		PulverizerRecipes
				.addRecipe(ZGBlocks.edenSilverOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustSilver), 66);
		
		// Lead
		PulverizerRecipes.addRecipe(ZGBlocks.purgLeadOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 67);
		PulverizerRecipes.addRecipe(ZGBlocks.edenLeadOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 67);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisLeadOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustLead), 67);
		
		// Iron
		PulverizerRecipes.addRecipe(ZGBlocks.zolIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		PulverizerRecipes.addRecipe(ZGBlocks.kriffIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		PulverizerRecipes.addRecipe(ZGBlocks.purgIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		PulverizerRecipes.addRecipe(ZGBlocks.edenIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		PulverizerRecipes.addRecipe(ZGBlocks.xathIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		PulverizerRecipes.addRecipe(ZGBlocks.oasisIronOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustIron));
		
		// Gold
		PulverizerRecipes.addRecipe(ZGBlocks.zolGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		PulverizerRecipes.addRecipe(ZGBlocks.kriffGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		PulverizerRecipes.addRecipe(ZGBlocks.purgGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		PulverizerRecipes.addRecipe(ZGBlocks.edenGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		PulverizerRecipes.addRecipe(ZGBlocks.xathGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisGoldOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustGold), 1);
		
		// Aluminum
		PulverizerRecipes.addRecipe(ZGBlocks.purgAluminumOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustAluminum), 68);
		PulverizerRecipes.addRecipe(ZGBlocks.edenAluminumOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustAluminum), 68);
		
		// Nickel
		PulverizerRecipes
				.addRecipe(ZGBlocks.edenNickelOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustNickel), 69);
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonNickelOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustNickel), 69);
		
		// Platinum
		PulverizerRecipes.addRecipe(ZGBlocks.edenPlatinumOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustPlatinum), 70);
		
		// Steel
		PulverizerRecipes.addRecipe(ZGBlocks.edenSteelOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustSteel), 96);
		
		// Electrum
		PulverizerRecipes.addRecipe(ZGBlocks.edenElectrumOre,
				ItemHelper.getItemFromStack(TFItems.itemMaterial.dustElectrum), 97);
		
		// Invar
		PulverizerRecipes.addRecipe(ZGBlocks.edenInvarOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustInvar), 98);
		
		// Bronze
		PulverizerRecipes
				.addRecipe(ZGBlocks.edenBronzeOre, ItemHelper.getItemFromStack(TFItems.itemMaterial.dustBronze), 99);
		
		// Cobalt
		PulverizerRecipes.addRecipe(ZGBlocks.kriffCobaltOre, ZGItems.dustCobalt);
		PulverizerRecipes.addRecipe(ZGBlocks.purgCobaltOre, ZGItems.dustCobalt);
		PulverizerRecipes.addRecipe(ZGBlocks.edenCobaltOre, ZGItems.dustCobalt);
		
		// Evenium
		PulverizerRecipes.addRecipe(ZGBlocks.purgEveniumOre, ZGItems.dustEvenium);
		PulverizerRecipes.addRecipe(ZGBlocks.edenEveniumOre, ZGItems.dustEvenium);
		
		// Amaranth
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonAmaranthOre, ZGItems.dustAmaranth);
		PulverizerRecipes.addRecipe(ZGBlocks.atheonAmaranthOre, ZGItems.dustAmaranth);
		
		// Zollernium
		PulverizerRecipes.addRecipe(ZGBlocks.atheonZollerniumOre, ZGItems.dustZollernium);
		
		// Zinc
		PulverizerRecipes.addRecipe(ZGBlocks.atheonZincOre, ZGItems.dustZinc);
		
		// Fueltonium
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonFueltoniumOre, ZGItems.dustFueltonium);
		
		ZGHelper.Log("Loaded a total of " + totalRecipes + " new Pulverizer recipes.");
	}
	
	public static void addRecipe(int energy, Block oreIn, Item itemOut, int metadata) {
		int numResult = (ConfigManagerZG.enableExtraPulverizerOutput) ? 4 : 2;
		ThermalExpansionHelper
				.addPulverizerRecipe(energy, new ItemStack(oreIn), new ItemStack(itemOut, numResult, metadata));
		totalRecipes++;
	}
	
	public static void addRecipe(int energy, Block oreIn, Item itemOut) {
		PulverizerRecipes.addRecipe(energy, oreIn, itemOut, 0);
	}
	
	public static void addRecipe(Block oreIn, Item itemOut) {
		PulverizerRecipes.addRecipe(5400, oreIn, itemOut);
	}
	
	public static void addRecipe(Block oreIn, Item itemOut, int metadata) {
		PulverizerRecipes.addRecipe(5400, oreIn, itemOut, 0);
	}
}