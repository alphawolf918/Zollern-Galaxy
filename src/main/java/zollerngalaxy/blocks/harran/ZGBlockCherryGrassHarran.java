/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.harran;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGBlocks;

public class ZGBlockCherryGrassHarran extends ZGBlockGrass {
	
	public ZGBlockCherryGrassHarran(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.harranSoil;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return Blocks.TALLGRASS;
	}
	
}