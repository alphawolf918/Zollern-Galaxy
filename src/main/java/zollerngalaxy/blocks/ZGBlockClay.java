/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBlockClay extends ZGBlockBase {
	
	protected int minDropped = (this.enableExtremeMode) ? 4 : 2;
	protected int maxDropped = (this.enableExtremeMode) ? 8 : 4;
	protected Item clayBall;
	
	public ZGBlockClay(String blockName, float hardResist, Item itemIn) {
		super(blockName, hardResist);
		this.setMaterial(Material.CLAY);
		this.setSoundType(SoundType.GROUND);
		this.setBlockType(EnumBlockType.CLAY);
		this.clayBall = itemIn;
		this.setHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.WOOD.getHarvestLevel());
	}
	
	public ZGBlockClay(String blockName, Item itemIn) {
		this(blockName, 0.6F, itemIn);
	}
	
	public Block setClayDropped(Item clayBallIn) {
		this.clayBall = clayBallIn;
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.clayBall;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt((this.enableExtremeMode) ? 4 : 2, (this.enableExtremeMode) ? 8 : 4);
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(this.clayBall, 1));
		}
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int randInt = rand.nextInt(4);
		return (randInt > 0) ? randInt : 2;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 0;
			}
			
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
}