/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZGCrystalBlock extends ZGBlockBase {
	
	protected static final AxisAlignedBB CRYSTAL_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9575D, 1.5D, 0.9575D);
	
	public ZGCrystalBlock(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.init();
	}
	
	public ZGCrystalBlock(String blockName) {
		super(blockName);
		this.setHardness(5.6F);
		this.setResistance(9.8F);
		this.init();
	}
	
	private void init() {
		this.setShouldJSONIgnore(true);
		this.setSound(SoundType.GLASS);
		this.setMaterial(Material.IRON);
		this.setLightLevel(1.0F);
		this.translucent = true;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CRYSTAL_AABB;
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
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
	
}