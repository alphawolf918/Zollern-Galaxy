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

public class MaterialKreeBlood extends MaterialLiquid {
	
	public MaterialKreeBlood() {
		super(MapColor.BLUE_STAINED_HARDENED_CLAY);
	}
	
	@Override
	public boolean blocksMovement() {
		return true;
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