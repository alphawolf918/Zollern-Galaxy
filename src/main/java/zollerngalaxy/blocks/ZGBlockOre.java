/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
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