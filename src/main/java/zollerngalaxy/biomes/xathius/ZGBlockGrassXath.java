package zollerngalaxy.biomes.xathius;

import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGBlocks;
import net.minecraft.block.Block;

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