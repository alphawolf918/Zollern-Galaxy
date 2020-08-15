/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.corrupted;

import zollerngalaxy.blocks.ZGBlockBase;

public class ZGCorruptBlock extends ZGBlockBase implements ICorruptBlock {
	
	public ZGCorruptBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	public ZGCorruptBlock(String blockName) {
		this(blockName, 5.6F);
	}
	
}