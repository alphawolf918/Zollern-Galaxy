package zollerngalaxy.blocks;

import net.minecraft.block.Block;

public class ZGBlockGrassEden extends ZGBlockGrass {
	
	public ZGBlockGrassEden(String blockName) {
		super(blockName);
	}
	
	@Override
	public Block getDirtBlock() {
		return ZGBlocks.edenSoil;
	}
	
	@Override
	public Block getTallGrassBlock() {
		return ZGBlocks.edenTallGrass;
	}
	
}