/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class ZGChromaGrass extends ZGBlockGrass {
	
	public ZGChromaGrass(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.chromaSoil;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return Blocks.TALLGRASS;
	}
	
}