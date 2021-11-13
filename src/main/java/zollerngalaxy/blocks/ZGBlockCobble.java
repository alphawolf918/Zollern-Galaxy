/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockCobble extends ZGBlockBase {
	
	public ZGBlockCobble(String blockName) {
		super(blockName);
		this.setBlockType(EnumBlockType.COBBLESTONE);
	}
	
	public ZGBlockCobble(String blockName, float hardResist) {
		this(blockName);
		this.setHardness(hardResist);
	}
	
}