/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compat.tconstruct;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.TinkerRegistry;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class TCSmelteryManager {
	
	private static int totalCasts = 0;
	
	public static void init() {
		registerCastingRecipe(ZGItems.ingotRadium, Items.GOLD_INGOT, ZGFluids.fluidRadium, 1000);
		
		ZGHelper.Log("Loaded a total of " + totalCasts + " table casts.");
		ZGHelper.Log("Loaded Tinker's Construct Smeltery Manager.");
	}
	
	private static void registerCastingRecipe(Item output, Item cast, Fluid fluid, int amount) {
		TinkerRegistry.registerTableCasting(new ItemStack(output), new ItemStack(cast), fluid, amount);
		totalCasts++;
	}
}