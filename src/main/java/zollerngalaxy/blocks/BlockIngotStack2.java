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
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.fluids.ZGFluidBase;

public class BlockIngotStack2 extends ZGBlockBase {
	
	protected static final AxisAlignedBB INGOT_STACK_AABB = new AxisAlignedBB(0.0525D, 0.0D, 0.0525D, 0.8575D, 0.6D, 0.8575D);
	protected Item droppedItem = null;
	
	private final BlockIngotStack2 instance;
	
	public BlockIngotStack2(String blockName, Item ingotIn) {
		super("ingotstack_" + blockName);
		this.instance = this;
		this.droppedItem = ingotIn;
		this.setHardResist(6.0F, 10.0F);
		this.setMaterial(Material.IRON);
		// if (ZollernGalaxyCore.instance().isInDevMode()) {
		// JSONFactory.registerIngotStack("ingotstack_" + blockName);
		// }
	}
	
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		Block block = world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock();
		if (block != Blocks.AIR && block != this.instance && !(block instanceof ZGFluidBase)) {
			return true;
		}
		return false;
	}
	
	public Item getDroppedItem() {
		return this.droppedItem;
	}
	
	public Block setDroppedItem(Item droppedItemIn) {
		this.droppedItem = droppedItemIn;
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.droppedItem;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = 7;
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(this.droppedItem, 1, 0));
		}
	}
	
	@Override
	public int quantityDropped(Random rand) {
		return 7;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return INGOT_STACK_AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return true;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}