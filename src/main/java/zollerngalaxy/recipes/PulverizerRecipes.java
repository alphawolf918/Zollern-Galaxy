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
		PulverizerRecipes.addRecipe(ZGBlocks.zolCopperOre, TFItems.itemMaterial.dustCopper, 64);
		PulverizerRecipes.addRecipe(ZGBlocks.kriffCopperOre, TFItems.itemMaterial.dustCopper, 64);
		PulverizerRecipes.addRecipe(ZGBlocks.purgCopperOre, TFItems.itemMaterial.dustCopper, 64);
		PulverizerRecipes.addRecipe(ZGBlocks.edenCopperOre, TFItems.itemMaterial.dustCopper, 64);
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonCopperOre, TFItems.itemMaterial.dustCopper, 64);
		
		// Tin
		PulverizerRecipes.addRecipe(ZGBlocks.zolTinOre, TFItems.itemMaterial.dustTin, 65);
		PulverizerRecipes.addRecipe(ZGBlocks.purgTinOre, TFItems.itemMaterial.dustTin, 65);
		PulverizerRecipes.addRecipe(ZGBlocks.edenTinOre, TFItems.itemMaterial.dustTin, 65);
		PulverizerRecipes.addRecipe(ZGBlocks.xathTinOre, TFItems.itemMaterial.dustTin, 65);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisTinOre, TFItems.itemMaterial.dustTin, 65);
		PulverizerRecipes.addRecipe(ZGBlocks.atheonTinOre, TFItems.itemMaterial.dustTin, 65);
		
		// Silver
		PulverizerRecipes.addRecipe(ZGBlocks.edenSilverOre, TFItems.itemMaterial.dustSilver, 66);
		
		// Lead
		PulverizerRecipes.addRecipe(ZGBlocks.purgLeadOre, TFItems.itemMaterial.dustLead, 67);
		PulverizerRecipes.addRecipe(ZGBlocks.edenLeadOre, TFItems.itemMaterial.dustLead, 67);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisLeadOre, TFItems.itemMaterial.dustLead, 67);
		
		// Iron
		PulverizerRecipes.addRecipe(ZGBlocks.zolIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.kriffIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.purgIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.edenIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.xathIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisIronOre, TFItems.itemMaterial.dustIron);
		PulverizerRecipes.addRecipe(ZGBlocks.perdIronOre, TFItems.itemMaterial.dustIron);
		
		// Gold
		PulverizerRecipes.addRecipe(ZGBlocks.zolGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.kriffGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.purgGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.edenGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.xathGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.oasisGoldOre, TFItems.itemMaterial.dustGold, 1);
		PulverizerRecipes.addRecipe(ZGBlocks.perdGoldOre, TFItems.itemMaterial.dustGold, 1);
		
		// Aluminum
		PulverizerRecipes.addRecipe(ZGBlocks.purgAluminumOre, TFItems.itemMaterial.dustAluminum, 68);
		PulverizerRecipes.addRecipe(ZGBlocks.edenAluminumOre, TFItems.itemMaterial.dustAluminum, 68);
		
		// Nickel
		PulverizerRecipes.addRecipe(ZGBlocks.edenNickelOre, TFItems.itemMaterial.dustNickel, 69);
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonNickelOre, TFItems.itemMaterial.dustNickel, 69);
		
		// Platinum
		PulverizerRecipes.addRecipe(ZGBlocks.edenPlatinumOre, TFItems.itemMaterial.dustPlatinum, 70);
		
		// Steel
		PulverizerRecipes.addRecipe(ZGBlocks.edenSteelOre, TFItems.itemMaterial.dustSteel, 96);
		
		// Electrum
		PulverizerRecipes.addRecipe(ZGBlocks.edenElectrumOre, TFItems.itemMaterial.dustElectrum, 97);
		
		// Invar
		PulverizerRecipes.addRecipe(ZGBlocks.edenInvarOre, TFItems.itemMaterial.dustInvar, 98);
		
		// Bronze
		PulverizerRecipes.addRecipe(ZGBlocks.edenBronzeOre, TFItems.itemMaterial.dustBronze, 99);
		
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
		PulverizerRecipes.addRecipe(ZGBlocks.perdZollerniumOre, ZGItems.dustZollernium);
		
		// Zinc
		PulverizerRecipes.addRecipe(ZGBlocks.atheonZincOre, ZGItems.dustZinc);
		
		// Fueltonium
		PulverizerRecipes.addRecipe(ZGBlocks.xantheonFueltoniumOre, ZGItems.dustFueltonium);
		
		ZGHelper.Log("Loaded a total of " + totalRecipes + " new Pulverizer recipes.");
	}
	
	public static void addRecipe(int energy, Block oreIn, Item itemOut, int metadata) {
		int numResult = (ConfigManagerZG.enableExtraPulverizerOutput) ? 4 : 2;
		ThermalExpansionHelper.addPulverizerRecipe(energy, new ItemStack(oreIn), new ItemStack(itemOut, numResult, metadata));
		totalRecipes++;
	}
	
	public static void addRecipe(int energy, Block oreIn, ItemStack itemStackOut, int metadata) {
		int numResult = (ConfigManagerZG.enableExtraPulverizerOutput) ? 4 : 2;
		ThermalExpansionHelper.addPulverizerRecipe(energy, new ItemStack(oreIn),
				new ItemStack(ItemHelper.getItemFromStack(itemStackOut), numResult, metadata));
		totalRecipes++;
	}
	
	public static void addRecipe(Block oreIn, ItemStack itemStackOut, int metadata) {
		PulverizerRecipes.addRecipe(5400, oreIn, itemStackOut, metadata);
	}
	
	public static void addRecipe(Block oreIn, ItemStack itemStackOut) {
		PulverizerRecipes.addRecipe(5400, oreIn, itemStackOut, 0);
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