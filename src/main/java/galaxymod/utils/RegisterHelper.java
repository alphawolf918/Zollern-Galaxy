/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {
	
	static int id = 0;
	
	public static void registerBlock(Block block) {
		if (Loader.isModLoaded("GalacticraftCore")) {
			try {
				Class<?> tClass = Class
						.forName("micdoodle8.mods.galacticraft.core.items.ItemBlockGC");
				GameRegistry.registerBlock(block, (Class) tClass, block
						.getUnlocalizedName().substring(5));
			} catch (ClassNotFoundException e) {
				GameRegistry.registerBlock(block, ItemBlock.class, block
						.getUnlocalizedName().substring(5));
			}
		} else {
			GameRegistry.registerBlock(block, ItemBlock.class, block
					.getUnlocalizedName().substring(5));
		}
	}
	
	public static void registerBlock(Block block,
			Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName()
				.substring(5));
	}
	
	public static void registerBlock(Block block,
			Class<? extends ItemBlock> itemBlock, Object... objectFromItemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName()
				.substring(5), objectFromItemBlock);
	}
	
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
	}
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluidContainer(Fluid fluid,
			ItemStack filledContainer, ItemStack emptyContainer) {
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(
				new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME),
				filledContainer, emptyContainer));
	}
	
	public static void setFireBurn(Block block, int encouragement,
			int flammibility) {
		Blocks.fire.setFireInfo(block, encouragement, flammibility);
	}
	
	public static void registerEntity(Class<? extends Entity> var0,
			String var1, int color1, int color2) {
		EntityRegistry.registerGlobalEntityID(var0, var1,
				EntityRegistry.findGlobalUniqueEntityId(), color1, color2);
	}
	
	public static void registerNonMobEntity(Class<? extends Entity> var0,
			String var1, Object mod, boolean sendVel) {
		EntityRegistry
				.registerModEntity(var0, var1, id++, mod, 256, 1, sendVel);
	}
}