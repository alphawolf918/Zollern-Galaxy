/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollerngalaxy.blocks.materials.MaterialSpaceMilk;
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
	
	public static Fluid fluidChocolate;
	public static ZGFluidBase blockChocolateFluid;
	
	public static Fluid fluidRadium;
	public static ZGFluidBase blockRadiumFluid;
	
	public static Fluid fluidSpaceMilk;
	public static ZGFluidBase blockSpaceMilk;
	
	public static void init() {
		ZGHelper.Log("Beginning Fluid Registry...");
		ZGFluids.registerFluids();
		ZGFluids.registerFluidBlocks();
		ZGFluids.addBuckets();
		ZGFluids.refreshReferences();
		ZGHelper.Log("Loaded a total of " + totalFluids + " new fluids.");
	}
	
	private static void registerFluids() {
		fluidChargium = new Fluid("chargium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/chargiumfluid"));
		fluidWhiteLava = new Fluid("whitelava", new ResourceLocation(ZGInfo.MOD_ID, "blocks/whitelava"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/whitelava"));
		fluidFueltonium = new Fluid("fueltonium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/fueltonium"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/fueltonium"));
		fluidChocolate = new Fluid("chocolatemelted", new ResourceLocation(ZGInfo.MOD_ID, "blocks/chocolatemelted"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/chocolatemelted"));
		fluidRadium = new Fluid("radium", new ResourceLocation(ZGInfo.MOD_ID, "blocks/radiumfluid"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/radiumfluid"));
		fluidSpaceMilk = new Fluid("spacemilk", new ResourceLocation(ZGInfo.MOD_ID, "blocks/spacemilk"), new ResourceLocation(ZGInfo.MOD_ID, "blocks/spacemilk"));
		
		registerFluid(fluidChargium);
		registerFluid(fluidWhiteLava);
		registerFluid(fluidFueltonium);
		registerFluid(fluidChocolate);
		registerFluid(fluidRadium);
		registerFluid(fluidSpaceMilk);
	}
	
	private static void registerFluidBlocks() {
		blockChargiumFluid = (ZGFluidBase) new ZGFluidBase("chargium", fluidChargium, Material.LAVA, MapColor.LIGHT_BLUE).setQuantaPerBlock(3).setLightLevel(1.0F);
		blockWhiteLavaFluid = (ZGFluidBase) ((ZGFluidBase) new ZGFluidBase("whitelava", fluidWhiteLava, Material.LAVA, MapColor.WHITE_STAINED_HARDENED_CLAY).setQuantaPerBlock(6).setLightLevel(1.0F))
				.setTemperature(5000);
		blockFueltoniumFluid = (ZGFluidBase) ((ZGFluidBase) new ZGFluidBase("fueltonium", fluidFueltonium, Material.LAVA, MapColor.GREEN).setQuantaPerBlock(10).setLightLevel(1.0F))
				.setTemperature(10000);
		blockChocolateFluid = (ZGFluidBase) new ZGFluidBase("chocolatemelted", fluidChocolate, Material.WATER, MapColor.BROWN).setQuantaPerBlock(9).setLightLevel(0.5F);
		blockRadiumFluid = (ZGFluidBase) new ZGFluidBase("radium", fluidRadium, Material.WATER, MapColor.YELLOW).setQuantaPerBlock(6).setLightLevel(1.0F);
		blockSpaceMilk = (ZGFluidBase) new ZGFluidBase("spaceMilk", fluidSpaceMilk, new MaterialSpaceMilk(), MapColor.PINK).setQuantaPerBlock(8).setLightLevel(0.6F);
		
		ForgeRegistries.BLOCKS.register(blockChargiumFluid);
		ForgeRegistries.BLOCKS.register(blockWhiteLavaFluid);
		ForgeRegistries.BLOCKS.register(blockFueltoniumFluid);
		ForgeRegistries.BLOCKS.register(blockChocolateFluid);
		ForgeRegistries.BLOCKS.register(blockRadiumFluid);
		ForgeRegistries.BLOCKS.register(blockSpaceMilk);
		
		proxy.addIModelRegister(blockChargiumFluid);
		proxy.addIModelRegister(blockWhiteLavaFluid);
		proxy.addIModelRegister(blockFueltoniumFluid);
		proxy.addIModelRegister(blockChocolateFluid);
		proxy.addIModelRegister(blockRadiumFluid);
		proxy.addIModelRegister(blockSpaceMilk);
	}
	
	public static void addBuckets() {
		FluidRegistry.addBucketForFluid(fluidChargium);
		FluidRegistry.addBucketForFluid(fluidWhiteLava);
		FluidRegistry.addBucketForFluid(fluidFueltonium);
		FluidRegistry.addBucketForFluid(fluidChocolate);
		FluidRegistry.addBucketForFluid(fluidRadium);
		FluidRegistry.addBucketForFluid(fluidSpaceMilk);
	}
	
	public static void refreshReferences() {
		fluidChargium = FluidRegistry.getFluid("chargium");
		fluidWhiteLava = FluidRegistry.getFluid("whitelava");
		fluidFueltonium = FluidRegistry.getFluid("fueltonium");
		fluidChocolate = FluidRegistry.getFluid("chocolatemelted");
		fluidRadium = FluidRegistry.getFluid("radium");
		fluidSpaceMilk = FluidRegistry.getFluid("spacemilk");
	}
	
	protected static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		totalFluids++;
	}
}