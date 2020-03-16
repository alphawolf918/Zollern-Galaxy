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
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGPlanetStone extends ZGBlockBase {
	
	private Block droppedBlock;
	
	public ZGPlanetStone(String blockName, float hardResist, Block blockDropped) {
		super(blockName, hardResist);
		this.droppedBlock = blockDropped;
		this.setBlockType(EnumBlockType.STONE);
	}
	
	public ZGPlanetStone(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.droppedBlock = this;
	}
	
	public ZGPlanetStone(String blockName) {
		this(blockName, 2.6F);
	}
	
	public ZGPlanetStone(String blockName, Block blockDropped) {
		this(blockName, 2.6F, blockDropped);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return Item.getItemFromBlock(this.droppedBlock);
	}
	
}