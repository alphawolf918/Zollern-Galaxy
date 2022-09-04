/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import cofh.api.util.ThermalExpansionHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import zollerngalaxy.blocks.fluids.ZGFluids;

public class FluidTransposerRecipes {
	
	public static void init() {
		// Molten Fueltonium
		ThermalExpansionHelper.addTransposerFill(3600, new ItemStack(Items.BUCKET, 1), FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidFueltonium, ZGFluids.fluidFueltonium.BUCKET_VOLUME)), new FluidStack(ZGFluids.fluidFueltonium, 2000), true);
		
		// Conductive Chargium
		ThermalExpansionHelper.addTransposerFill(4200, new ItemStack(Items.BUCKET, 1), FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidChargium, ZGFluids.fluidChargium.BUCKET_VOLUME)), new FluidStack(ZGFluids.fluidChargium, 1000), true);
		
		// Radiance
		ThermalExpansionHelper.addTransposerFill(8400, new ItemStack(Items.BUCKET, 1), FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidRadium, ZGFluids.fluidRadium.BUCKET_VOLUME)), new FluidStack(ZGFluids.fluidRadium, 4000), true);
		
		// Radite
		ThermalExpansionHelper.addTransposerFill(18400, new ItemStack(Items.BUCKET, 1), FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidRadite, ZGFluids.fluidRadium.BUCKET_VOLUME)), new FluidStack(ZGFluids.fluidRadite, 4000), true);
		
		// Kree Blood
		ThermalExpansionHelper.addTransposerFill(1500, new ItemStack(Items.BUCKET, 1), FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidKreeBlood, ZGFluids.fluidKreeBlood.BUCKET_VOLUME)), new FluidStack(ZGFluids.fluidKreeBlood, 4000), true);
	}
}