package zollerngalaxy.blocks;

import net.minecraft.block.Block;

public class ZGBlockGrassOasis extends ZGBlockGrass {
	
	public ZGBlockGrassOasis(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.oasisDirt;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return ZGBlocks.oasisTallGrass;
	}
	
}