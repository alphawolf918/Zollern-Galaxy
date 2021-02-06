/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.crystals;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.blocks.fluids.ZGFluidBase;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGCrystalBlock extends ZGBlockBase {
	
	protected static final AxisAlignedBB CRYSTAL_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9575D, 1.5D, 0.9575D);
	
	protected int minDropped = (this.enableExtremeMode) ? 4 : 2;
	protected int maxDropped = (this.enableExtremeMode) ? 8 : 4;
	protected Item droppedItem = null;
	
	private final ZGCrystalBlock instance;
	
	public ZGCrystalBlock(String blockName, float hardResist, Item droppedItemIn) {
		super(blockName, hardResist);
		this.instance = this;
		this.droppedItem = droppedItemIn;
		this.init();
	}
	
	public ZGCrystalBlock(String blockName, Item droppedItemIn) {
		super(blockName);
		this.setHardness(5.6F);
		this.setResistance(9.8F);
		this.instance = this;
		this.droppedItem = droppedItemIn;
		this.init();
	}
	
	private void init() {
		this.setShouldJSONIgnore(true);
		this.setSound(SoundType.GLASS);
		this.setMaterial(Material.IRON);
		this.setHarvestLevel(EnumHarvestToolZG.OMNITOOL.getHarvestTool(), EnumHarvestLevelZG.OMNI.getHarvestLevel());
		this.setLightLevel(1.0F);
		this.translucent = true;
	}
	
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		Block block = world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock();
		if (block != Blocks.AIR && block != this.instance && !(block instanceof ZGFluidBase)) {
			return true;
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.droppedItem;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt(this.getMinDropped(), this.getMaxDropped());
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(this.droppedItem, 1, 0));
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
		numDropped = ZGHelper.rngInt(1, 1 + extMod);
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