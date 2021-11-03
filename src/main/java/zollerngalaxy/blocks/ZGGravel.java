/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGGravel extends ZGBlockFalling {
	
	public ZGGravel(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setSoundType(SoundType.GROUND);
		this.setBlockType(EnumBlockType.GRAVEL);
	}
	
	public ZGGravel(String blockName) {
		this(blockName, 2.2F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (fortune > 3) {
			fortune = 3;
		}
		
		return rand.nextInt(10 - fortune * 3) == 0 ? Items.FLINT : super.getItemDropped(state, rand, fortune);
	}
}