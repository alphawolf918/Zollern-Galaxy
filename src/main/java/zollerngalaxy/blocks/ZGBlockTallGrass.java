package zollerngalaxy.blocks;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.json.JSONRegistryHelper;

public class ZGBlockTallGrass extends ZGBlockFlower implements IGrowable, IShearable {
	
	protected static final AxisAlignedBB TALL_GRASS_AABB = new AxisAlignedBB(0.09999999403953552D,
			0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D,
			0.8999999761581421D);
	
	protected ZGBlockTallGrass(String blockName) {
		super(blockName);
		this.setMaterial(Material.VINE);
		JSONRegistryHelper.registerFlowerBlock(blockName);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return TALL_GRASS_AABB;
	}
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		Block soil = worldIn.getBlockState(pos.down()).getBlock();
		if (soil instanceof ZGBlockGrass || soil instanceof ZGBlockDirt) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		return 1 + random.nextInt(fortune * 2 + 1);
	}
	
	/**
	 * Spawns the block's drops in the world. By the time this is called the
	 * Block has possibly been set to air via Block.removedByPlayer
	 */
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(this));
			spawnAsEntity(worldIn, pos, new ItemStack(this, 1));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this, 1, state.getBlock().getMetaFromState(state));
	}
	
	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		
	}
	
	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}
	
	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	/**
	 * Get the OffsetType for this Block. Determines if the model is rendered
	 * slightly offset.
	 */
	@Override
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XYZ;
	}
	
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos,
			int fortune) {
		return NonNullList.withSize(1, new ItemStack(this, 1));
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune) {
		if (RANDOM.nextInt(4) != 0)
			return;
		ItemStack seed = net.minecraftforge.common.ForgeHooks.getGrassSeed(RANDOM, fortune);
		if (!seed.isEmpty()) {
			drops.add(seed);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return null;
	}
}