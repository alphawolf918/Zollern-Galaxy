/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.renderers;

import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import zollerngalaxy.lib.helpers.ClientZGRegisterHelper;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGItemRender {
	
	public static void init() {
		ZGItemRender.registerBlockRenderer();
		ZGItemRender.registerItemRenderer();
	}
	
	private static void registerBlockRenderer() {
		for (Entry<Block, String> map : CommonZGRegisterHelper.SINGLE_BLOCK_RENDER_LIST.entrySet()) {
			Block block = map.getKey();
			String name = map.getValue();
			
			ClientZGRegisterHelper.registerModelRender(block, name);
		}
	}
	
	private static void registerItemRenderer() {
		for (Entry<Item, String> map : CommonZGRegisterHelper.SINGLE_ITEM_RENDER_LIST.entrySet()) {
			Item item = map.getKey();
			String name = map.getValue();
			ClientZGRegisterHelper.registerModelRender(item, name);
		}
	}
	
}