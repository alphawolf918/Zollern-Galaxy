/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.xathius;

import net.minecraft.block.Block;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGBlocks;

public class ZGBlockGrassXath extends ZGBlockGrass {
	
	public ZGBlockGrassXath(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.xathDirt;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return ZGBlocks.xathTallGrass;
	}
	
}