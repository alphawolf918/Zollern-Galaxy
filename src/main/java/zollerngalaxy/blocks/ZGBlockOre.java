package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import zollerngalaxy.core.enums.EnumBlockTier;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockOre extends ZGBlockBase {
	
	protected EnumBlockTier oreTier = EnumBlockTier.ONE;
	protected Random rand = new Random();
	
	public ZGBlockOre(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setBlockType(EnumBlockType.ORE);
	}
	
	public EnumBlockTier getBlockTier() {
		return this.oreTier;
	}
	
	public Block setBlockTier(EnumBlockTier variantType) {
		this.oreTier = variantType;
		return this;
	}
}