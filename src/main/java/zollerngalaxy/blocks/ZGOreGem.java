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
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGOreGem extends ZGBlockOre {
	
	protected int minDropped = (this.enableExtremeMode) ? 4 : 2;
	protected int maxDropped = (this.enableExtremeMode) ? 8 : 4;
	protected Item itemToDrop = ZGItems.sapphire;
	
	protected int droppedMetadata = 0;
	protected boolean itemHasMetadata = false;
	
	public ZGOreGem(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist);
		this.itemToDrop = gemItem;
		this.setDroppedItemHasMetadata(this.itemHasMetadata);
	}
	
	public Block setDropMeta(int droppedMeta, boolean hasMeta) {
		this.itemHasMetadata = hasMeta;
		if (this.itemHasMetadata) {
			this.droppedMetadata = droppedMeta;
		}
		return this;
	}
	
	public Block setDroppedItemHasMetadata(boolean hasMetadata) {
		this.itemHasMetadata = hasMetadata;
		return this;
	}
	
	public boolean getDroppedItemHasMetadata() {
		return this.itemHasMetadata;
	}
	
	public Block setDroppedMetadata(int md) {
		this.droppedMetadata = md;
		return this;
	}
	
	public int getDroppedMetadata() {
		return this.droppedMetadata;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.itemToDrop;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt(this.getMinDropped(), this.getMaxDropped());
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(itemToDrop, 1, this.droppedMetadata));
		}
	}
	
	public Block setMinMaxDropped(int minD, int maxD) {
		this.setMinDropped(minD);
		this.setMaxDropped(maxD);
		return this;
	}
	
	public Block setMaxDropped(int md) {
		this.maxDropped = md;
		return this;
	}
	
	public Block setMinDropped(int md) {
		this.minDropped = md;
		return this;
	}
	
	public int getMinDropped() {
		return this.minDropped;
	}
	
	public int getMaxDropped() {
		return this.maxDropped;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int numDropped = 1;
		int extMod = (this.enableExtremeMode) ? 1 : 0;
		switch (this.getBlockTier()) {
			default:
				numDropped = ZGHelper.rngInt(1, 1);
				break;
			case ONE:
				numDropped = ZGHelper.rngInt(minDropped + extMod, maxDropped + extMod);
				break;
			case TWO:
				numDropped = ZGHelper.rngInt(maxDropped + extMod, maxDropped + 2 + extMod);
				break;
			case THREE:
				numDropped = ZGHelper.rngInt(maxDropped + 2 + extMod, maxDropped + 3 + extMod);
				break;
			case FOUR:
				numDropped = ZGHelper.rngInt(maxDropped + 4 + extMod, maxDropped + 5 + extMod);
				break;
		}
		return numDropped;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 1;
			}
			
			return this.quantityDropped(random) * i;
		} else {
			return this.quantityDropped(random);
		}
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		int extMod = (this.enableExtremeMode) ? 2 : 0;
		Random rand = (world instanceof World) ? ((World) world).rand : new Random();
		return MathHelper.getInt(rand, 3 + extMod, 7 + extMod);
	}
	
}