package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ZGBlockFalling extends ZGBlockBase {
	
	public static boolean fallInstantly;
	
	public ZGBlockFalling(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn,
			BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			this.checkFallable(worldIn, pos);
		}
	}
	
	private void checkFallable(World worldIn, BlockPos pos) {
		if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down())))
				&& pos.getY() >= 0) {
			int i = 32;
			
			if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-32, -32, -32), pos.add(32, 32, 32))) {
				if (!worldIn.isRemote) {
					EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn,
							pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D,
							worldIn.getBlockState(pos));
					this.onStartFalling(entityfallingblock);
					worldIn.spawnEntity(entityfallingblock);
				}
			} else {
				IBlockState state = worldIn.getBlockState(pos);
				worldIn.setBlockToAir(pos);
				BlockPos blockpos;
				
				for (blockpos = pos.down(); (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn
						.getBlockState(blockpos))) && blockpos.getY() > 0; blockpos = blockpos
						.down()) {
					;
				}
				
				if (blockpos.getY() > 0) {
					worldIn.setBlockState(blockpos.up(), state); // Forge: Fix
																	// loss of
																	// state
																	// information
																	// during
																	// world
																	// gen.
				}
			}
		}
	}
	
	protected void onStartFalling(EntityFallingBlock fallingEntity) {
	}
	
	/**
	 * How many world ticks before ticking
	 */
	@Override
	public int tickRate(World worldIn) {
		return 2;
	}
	
	public static boolean canFallThrough(IBlockState state) {
		Block block = state.getBlock();
		Material material = state.getMaterial();
		return block == Blocks.FIRE || material == Material.AIR || material == Material.WATER
				|| material == Material.LAVA;
	}
	
	public void onEndFalling(World worldIn, BlockPos pos) {
	}
	
	public void onBroken(World p_190974_1_, BlockPos p_190974_2_) {
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(16) == 0) {
			BlockPos blockpos = pos.down();
			
			if (canFallThrough(worldIn.getBlockState(blockpos))) {
				double d0 = pos.getX() + rand.nextFloat();
				double d1 = pos.getY() - 0.05D;
				double d2 = pos.getZ() + rand.nextFloat();
				worldIn.spawnParticle(EnumParticleTypes.FALLING_DUST, d0, d1, d2, 0.0D, 0.0D, 0.0D,
						new int[] { Block.getStateId(stateIn) });
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getDustColor(IBlockState p_189876_1_) {
		return -16777216;
	}
	
}