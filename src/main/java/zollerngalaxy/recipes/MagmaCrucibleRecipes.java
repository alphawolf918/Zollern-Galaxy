/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import cofh.api.util.ThermalExpansionHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.items.ZGItems;

public class MagmaCrucibleRecipes {
	
	public static void init() {
		// Molten Fueltonium Ingot
		addCrucibleRecipe(3600, new ItemStack(ZGItems.ingotFueltonium, 1), ZGFluids.fluidFueltonium, 1000);
		
		// Molten Fueltonium Block
		addCrucibleRecipe(7200, new ItemStack(ZGBlocks.blockFueltonium, 1), ZGFluids.fluidFueltonium, 9000);
		
		// Chargium Ingot
		addCrucibleRecipe(5000, new ItemStack(ZGItems.superChargedCoal, 1), ZGFluids.fluidChargium, 500);
		
		// Chargium Block
		addCrucibleRecipe(10000, new ItemStack(ZGBlocks.blockSuperChargedCoal, 1), ZGFluids.fluidChargium, 4500);
		
		// Radium Gem
		addCrucibleRecipe(8000, new ItemStack(ZGItems.radium, 1), ZGFluids.fluidRadium, 800);
		
		// Radium Block
		addCrucibleRecipe(16000, new ItemStack(ZGBlocks.blockRadium, 1), ZGFluids.fluidRadium, 7200);
	}
	
	private static void addCrucibleRecipe(int energy, ItemStack itemStack, Fluid fluid, int fluidAmount) {
		ThermalExpansionHelper.addCrucibleRecipe(energy, itemStack, new FluidStack(fluid, fluidAmount));
	}
	
}