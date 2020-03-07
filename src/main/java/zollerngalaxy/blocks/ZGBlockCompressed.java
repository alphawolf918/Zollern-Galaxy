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

public class ZGBlockCompressed extends ZGBlockMetal {
	
	public ZGBlockCompressed(String strTexture) {
		super(strTexture);
		this.setHardResist(3.2F);
		this.setSoundType(SoundType.STONE);
		this.setBlockType(EnumBlockType.COMPRESSED);
	}
	
}