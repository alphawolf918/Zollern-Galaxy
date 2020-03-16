/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGSand extends ZGBlockFalling {
	
	public ZGSand(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setSoundType(SoundType.SAND);
		this.setBlockType(EnumBlockType.SAND);
	}
	
}