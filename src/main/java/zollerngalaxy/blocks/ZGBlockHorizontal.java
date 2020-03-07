/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public abstract class ZGBlockHorizontal extends ZGBlockBase {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	protected ZGBlockHorizontal(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
}