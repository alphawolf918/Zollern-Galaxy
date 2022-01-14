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

public class BlockCropCucumber extends ZGBlockCropBase {
	
	public BlockCropCucumber() {
		super("cucumber");
	}
	
	@Override
	protected Item getSeed() {
		return ZGItems.cucumber;
	}
	
	@Override
	protected Item getCrop() {
		return ZGItems.cucumber;
	}
}