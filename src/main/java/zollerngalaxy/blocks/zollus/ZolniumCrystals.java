/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.zollus;

import static net.minecraft.block.SoundType.METAL;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGBlockIce;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZolniumCrystals extends ZGBlockFlower {
	
	protected int minDropped = 1;
	protected int maxDropped = 3;
	protected Item itemToDrop;
	
	public ZolniumCrystals() {
		super("zolcrystals");
		this.setMaterial(Material.IRON);
		this.setHardResist(2.6F);
		this.setSoundType(METAL);
		this.setHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
		this.setItemDropped(ZGItems.zolCrystal);
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		Block block = world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock();
		if (block == Blocks.PACKED_ICE || block instanceof ZGBlockIce) {
			return true;
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.itemToDrop;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt(this.getMinDropped(), this.getMaxDropped());
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(itemToDrop, 1, 0));
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
	
	public Block setItemDropped(Item item) {
		this.itemToDrop = item;
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
		numDropped = ZGHelper.rngInt(minDropped, maxDropped);
		return numDropped;
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
	
	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		return MathHelper.getInt(rand, 6, 14);
	}
	
}