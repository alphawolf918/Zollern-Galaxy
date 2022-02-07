/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.machines;

import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.items.IShiftDescription;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.creativetabs.ZGTabs;

public abstract class ZGBlockMachineBase extends BlockContainer implements ITileEntityProvider, ISingleZGBlockRender, ISortableBlock, IShiftDescription {
	
	protected static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
	protected String blockName;
	
	public ZGBlockMachineBase(String blockNameIn, float hardResist) {
		super(Material.ROCK);
		this.blockName = blockNameIn;
		this.setBlockName(blockNameIn);
		this.setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setTickRandomly(true);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3).getOpposite();
		state = state.withProperty(FACING, enumfacing);
		BlockPos blockpos1 = pos.north();
		BlockPos blockpos2 = pos.south();
		BlockPos blockpos3 = pos.west();
		BlockPos blockpos4 = pos.east();
		boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
		boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
		boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
		boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();
		
		if (!flag && !flag1 && !flag2 && !flag3) {
			worldIn.setBlockState(pos, state, 3);
		} else if (enumfacing.getAxis() == EnumFacing.Axis.X && (flag || flag1)) {
			if (flag) {
				worldIn.setBlockState(blockpos1, state, 3);
			} else {
				worldIn.setBlockState(blockpos2, state, 3);
			}
			
			worldIn.setBlockState(pos, state, 3);
		} else if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3)) {
			if (flag2) {
				worldIn.setBlockState(blockpos3, state, 3);
			} else {
				worldIn.setBlockState(blockpos4, state, 3);
			}
			
			worldIn.setBlockState(pos, state, 3);
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getHorizontal(meta);
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = state.getValue(FACING);
		
		int facingbits = facing.getHorizontalIndex();
		return facingbits;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public abstract String getShiftDescription(int meta);
	
	@Override
	public boolean showDescription(int meta) {
		return true;
	}
	
	public void setBlockName(String blockNameIn) {
		this.setUnlocalizedName(blockName);
		this.blockName = blockNameIn;
	}
	
	@Override
	public String getName() {
		return this.blockName.toLowerCase();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZGTabs.zgBlocksTab;
	}
	
	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.MACHINE;
	}
	
	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);
	
}