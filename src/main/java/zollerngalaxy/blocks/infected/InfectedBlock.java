/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.infected;

import zollerngalaxy.blocks.ZGBlockBase;

public class InfectedBlock extends ZGBlockBase implements IInfectedBlock {
	
	public InfectedBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	public InfectedBlock(String blockName) {
		super(blockName, 8.6F);
	}
}