package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.proxy.IProxy;

public class ZGFluids {
	
	private static int totalFluids = 0;
	
	private static IProxy proxy = ZollernGalaxyCore.proxy;
	
	public static Fluid fluidChargium;
	public static ZGFluidBase blockChargiumFluid;
	
	public static Fluid fluidWhiteLava;
	public static ZGFluidBase blockWhiteLavaFluid;
	
	public static Fluid fluidFueltonium;
	public static ZGFluidBase blockFueltoniumFluid;
	
	public static void init() {
		ZGHelper.Log("Beginning Fluid Registry...");
		ZGFluids.registerFluids();
		ZGFluids.registerFluidBlocks();
		ZGFluids.addBuckets();
		ZGFluids.refreshReferences();
		ZGHelper.Log("Loaded a total of " + totalFluids + " new fluids!");
	}
	
	private static void registerFluids() {
		fluidChargium = new Fluid("chargium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"),
				new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"));
		fluidWhiteLava = new Fluid("whitelava", new ResourceLocation(ZGInfo.MOD_ID, "blocks/whitelava"),
				new ResourceLocation(ZGInfo.MOD_ID, "blocks/whitelava"));
		fluidFueltonium = new Fluid("fueltonium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/fueltonium"),
				new ResourceLocation(ZGInfo.MOD_ID, "blocks/fueltonium"));
		
		FluidRegistry.registerFluid(fluidChargium);
		FluidRegistry.registerFluid(fluidWhiteLava);
		FluidRegistry.registerFluid(fluidFueltonium);
		
		totalFluids += 3;
	}
	
	private static void registerFluidBlocks() {
		blockChargiumFluid = (ZGFluidBase) new ZGFluidBase("chargium", fluidChargium, Material.LAVA, MapColor.LIGHT_BLUE)
				.setQuantaPerBlock(6).setLightLevel(1.0F);
		blockWhiteLavaFluid = (ZGFluidBase) ((ZGFluidBase) new ZGFluidBase("whitelava", fluidWhiteLava, Material.LAVA,
				MapColor.WHITE_STAINED_HARDENED_CLAY).setQuantaPerBlock(3).setLightLevel(1.0F)).setTemperature(5000);
		blockFueltoniumFluid = (ZGFluidBase) ((ZGFluidBase) new ZGFluidBase("fueltonium", fluidFueltonium, Material.LAVA,
				MapColor.GREEN).setQuantaPerBlock(10).setLightLevel(1.0F)).setTemperature(10000);
		
		ForgeRegistries.BLOCKS.register(blockChargiumFluid);
		ForgeRegistries.BLOCKS.register(blockWhiteLavaFluid);
		ForgeRegistries.BLOCKS.register(blockFueltoniumFluid);
		
		proxy.addIModelRegister(blockChargiumFluid);
		proxy.addIModelRegister(blockWhiteLavaFluid);
		proxy.addIModelRegister(blockFueltoniumFluid);
	}
	
	public static void addBuckets() {
		FluidRegistry.addBucketForFluid(fluidChargium);
		FluidRegistry.addBucketForFluid(fluidWhiteLava);
		FluidRegistry.addBucketForFluid(fluidFueltonium);
	}
	
	public static void refreshReferences() {
		fluidChargium = FluidRegistry.getFluid("chargium");
		fluidWhiteLava = FluidRegistry.getFluid("whitelava");
		fluidFueltonium = FluidRegistry.getFluid("fueltonium");
	}
	
}