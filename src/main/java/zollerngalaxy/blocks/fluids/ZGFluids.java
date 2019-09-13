package zollerngalaxy.blocks.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGFluids {
	
	private static int totalFluids = 0;
	
	public static Fluid fluidChargium;
	public static ChargiumLiquidBlock blockChargiumFluid;
	
	public static void init() {
		ZGHelper.Log("Beginning Fluid Registry...");
		
		ZGFluids.registerFluids();
		ZGFluids.registerFluidBlocks();
		ZGFluids.addBuckets();
		ZGFluids.refreshReferences();
		
		blockChargiumFluid.init();
		
		ZGHelper.Log("Loaded a total of " + totalFluids + "new fluids.");
	}
	
	private static void registerFluids() {
		fluidChargium = new Fluid("chargium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"),
				new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"));
		totalFluids++;
	}
	
	private static void registerFluidBlocks() {
		blockChargiumFluid = new ChargiumLiquidBlock(fluidChargium);
		
		ZollernGalaxyCore.proxy.addIModelRegister(blockChargiumFluid);
	}
	
	public static void addBuckets() {
		FluidRegistry.addBucketForFluid(fluidChargium);
	}
	
	public static void refreshReferences() {
		fluidChargium = FluidRegistry.getFluid("chargium");
	}
	
}