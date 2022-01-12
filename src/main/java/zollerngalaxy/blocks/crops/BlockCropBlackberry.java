/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.crops;

import net.minecraft.item.Item;
import zollerngalaxy.items.ZGItems;

public class BlockCropBlackberry extends ZGBlockCropBase {
	
	public BlockCropBlackberry() {
		super("blackberry");
	}
	
	@Override
	protected Item getSeed() {
		return ZGItems.blackberry;
	}
	
	@Override
	protected Item getCrop() {
		return ZGItems.blackberry;
	}
}