/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.materials;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class MaterialSpaceMilk extends MaterialLiquid {
	
	public MaterialSpaceMilk() {
		super(MapColor.PINK_STAINED_HARDENED_CLAY);
	}
	
	@Override
	public boolean blocksLight() {
		return true;
	}
	
	@Override
	public boolean isOpaque() {
		return true;
	}
	
	public boolean isTranslucent() {
		return !this.isOpaque();
	}
	
}