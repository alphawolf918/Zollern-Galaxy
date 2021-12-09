/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZGBlockEgg extends ZGBlockBase {
	
	protected static final AxisAlignedBB EGG_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D);
	protected int ticksEggExisted = 0;
	
	public ZGBlockEgg(String blockName) {
		super(blockName, 6.0F);
		this.setResistance(10.0F);
		this.setMaterial(Material.DRAGON_EGG);
		this.setLightLevel(0.1F);
		this.setTickRandomly(true);
		this.setShouldJSONIgnore(true);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.checkFall(worldIn, pos);
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.checkFall(worldIn, fromPos);
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.hatchEgg(worldIn, pos);
		this.ticksEggExisted = 0;
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
	}
	
	public void hatchEgg(World worldIn, BlockPos pos) {
		// Override in child classes
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		this.checkFall(worldIn, pos);
		this.ticksEggExisted += 10;
		return true;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return EGG_AABB;
	}
	
	protected void checkFall(World worldIn, BlockPos pos) {
		if (worldIn.isAirBlock(pos.down()) && BlockFalling.canFallThrough(worldIn.getBlockState(pos.down())) && pos.getY() >= 0) {
			int i = 32;
			
			if (!BlockFalling.fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
				worldIn.spawnEntity(new EntityFallingBlock(worldIn, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, this.getDefaultState()));
			} else {
				worldIn.setBlockToAir(pos);
				BlockPos blockpos;
				
				for (blockpos = pos; worldIn.isAirBlock(blockpos) && BlockFalling.canFallThrough(worldIn.getBlockState(blockpos))
						&& blockpos.getY() > 0; blockpos = blockpos.down()) {
					;
				}
				
				if (blockpos.getY() > 0) {
					worldIn.setBlockState(blockpos, this.getDefaultState(), 2);
				}
			}
		}
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 5;
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