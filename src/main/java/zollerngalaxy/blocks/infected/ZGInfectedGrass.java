/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.infected;

import net.minecraft.block.Block;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGBlocks;

public class ZGInfectedGrass extends ZGBlockGrass implements IInfectedBlock {
	
	public ZGInfectedGrass(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	public ZGInfectedGrass(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.mavethInfectedSoil;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return ZGBlocks.mavethInfectedTallGrass;
	}
}