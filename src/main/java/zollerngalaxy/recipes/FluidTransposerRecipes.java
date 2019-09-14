package zollerngalaxy.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import zollerngalaxy.blocks.fluids.ZGFluids;
import cofh.api.util.ThermalExpansionHelper;

public class FluidTransposerRecipes {
	
	public static void init() {
		// Molten Fueltonium
		ThermalExpansionHelper.addTransposerFill(3600, new ItemStack(Items.BUCKET, 1),
				FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidFueltonium, ZGFluids.fluidFueltonium.BUCKET_VOLUME)),
				new FluidStack(ZGFluids.fluidFueltonium, 2000), true);
		
		// Conductive Chargium
		ThermalExpansionHelper.addTransposerFill(4200, new ItemStack(Items.BUCKET, 1),
				FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidChargium, ZGFluids.fluidChargium.BUCKET_VOLUME)),
				new FluidStack(ZGFluids.fluidChargium, 1000), true);
	}
	
}