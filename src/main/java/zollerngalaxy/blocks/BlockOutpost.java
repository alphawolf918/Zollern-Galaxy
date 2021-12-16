/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import zollerngalaxy.core.enums.EnumBlockType;

public class BlockOutpost extends ZGBlockBase {
	
	public BlockOutpost() {
		super("outpostblock", 2.8F);
		this.setBlockType(EnumBlockType.SPACE);
		this.setLightLevel(1.0F);
	}
	
}