/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.infected;

import zollerngalaxy.blocks.ZGBlockDirt;

public class ZGInfectedDirt extends ZGBlockDirt implements IInfectedBlock {
	
	public ZGInfectedDirt(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	public ZGInfectedDirt(String blockName) {
		super(blockName);
	}
	
}