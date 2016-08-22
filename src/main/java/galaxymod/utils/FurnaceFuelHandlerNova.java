/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.utils;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.Pair;
import cpw.mods.fml.common.IFuelHandler;

public class FurnaceFuelHandlerNova implements IFuelHandler {
	
	private static HashMap<Pair<Item, Integer>, Integer> fuelList = new HashMap<Pair<Item, Integer>, Integer>();
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == ItemList.prometheanCrystal) {
			return 102400;
		} else if (fuel.getItem() == Item
				.getItemFromBlock(BlockList.edenWoodSapling)) {
			return 500;
		} else {
			return 0;
		}
	}
	
	public static void setFuelValues() {
		
	}
	
	private static void addFuel(Item item, int metadata, int value) {
		fuelList.put(Pair.of(item, metadata), value);
	}
	
	private static void addFuel(Block block, int value) {
		addFuel(Item.getItemFromBlock(block), 0, value);
	}
	
	private static int getFuelValue(ItemStack stack) {
		if (stack == null || stack.getItem() == null) {
			return 0;
		}
		
		Pair<Item, Integer> pair = Pair.of(stack.getItem(),
				stack.getItemDamage());
		
		if (fuelList.containsKey(pair)) {
			return fuelList.get(pair);
		} else {
			pair = Pair.of(stack.getItem(), 0);
			
			if (fuelList.containsKey(pair)) {
				return fuelList.get(pair);
			}
		}
		return 0;
	}
}