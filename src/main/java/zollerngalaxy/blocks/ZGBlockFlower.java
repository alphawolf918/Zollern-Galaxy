/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;

public class ZGBlockFlower extends ZGBlockBase {
	
	public ZGBlockFlower(String blockName) {
		super(blockName, 0.0F);
		this.setMaterial(Material.PLANTS);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
		this.setShouldJSONIgnore(true);
		this.setBlockType(EnumBlockType.FLOWER);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
		return null;
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
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		if (world.getBlockState(pos).getBlock().isReplaceable(world, pos) && this.canBlockStay(world, pos, this.getDefaultState())) {
			return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand);
		}
		return world.getBlockState(pos);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		this.checkAndDropBlock(world, pos, state);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		this.checkAndDropBlock(world, pos, state);
	}
	
	protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state) {
		if (!this.canBlockStay(world, pos, state)) {
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
		}
	}
	
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		return true;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return EnumHarvestLevelZG.WOOD.getHarvestLevel();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return "";
	}
}