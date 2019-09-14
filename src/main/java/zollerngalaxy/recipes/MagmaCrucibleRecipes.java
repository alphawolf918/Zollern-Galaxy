package zollerngalaxy.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.items.ZGItems;
import cofh.api.util.ThermalExpansionHelper;

public class MagmaCrucibleRecipes {
	
	public static void init() {
		// Molten Fueltonium
		// Ingot
		ThermalExpansionHelper.addCrucibleRecipe(3600, new ItemStack(ZGItems.ingotFueltonium, 1), new FluidStack(
				ZGFluids.fluidFueltonium, 1000));
		
		// Molten Fueltonium
		// Block
		ThermalExpansionHelper.addCrucibleRecipe(7200, new ItemStack(ZGBlocks.blockFueltonium, 1), new FluidStack(
				ZGFluids.fluidFueltonium, 9000));
		
		// Chargium
		// Ingot
		ThermalExpansionHelper.addCrucibleRecipe(5000, new ItemStack(ZGItems.superChargedCoal, 1), new FluidStack(
				ZGFluids.fluidChargium, 500));
		
		// Chargium
		// Block
		ThermalExpansionHelper.addCrucibleRecipe(10000, new ItemStack(ZGBlocks.blockSuperChargedCoal, 1), new FluidStack(
				ZGFluids.fluidChargium, 4500));
	}
	
}