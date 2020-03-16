/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGTabs {
	
	public static CreativeTabs zgItemsTab;
	public static CreativeTabs zgBlocksTab;
	
	public static void init() {
		zgBlocksTab = ZGHelper.createCreativeTabs("ZollernGalaxyBlocks", new ItemStack(ZGBlocks.edenGrass));
		zgItemsTab = ZGHelper.createCreativeTabs("ZollernGalaxyItems", new ItemStack(ZGItems.alienStone));
	}
}