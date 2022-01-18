package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenZGTree2 extends WorldGenAbstractTree {
	
	private IBlockState logState;
	private IBlockState leavesState;
	
	public WorldGenZGTree2(Block logBlockIn, Block leavesBlockIn) {
		super(false);
		this.logState = logBlockIn.getDefaultState();
		this.leavesState = leavesBlockIn.getDefaultState();
	}
	
	protected void setBlock(World world, BlockPos pos, IBlockState blockState) {
		world.setBlockState(pos, blockState, 2);
	}
	
	protected boolean isValidSpawn(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos.down());
		
		if (state == null) {
			return false;
		}
		
		Block blockBelow = state.getBlock();
		
		if (blockBelow == null) {
			return false;
		}
		
		if (blockBelow == Blocks.AIR || blockBelow == Blocks.WATER) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		this.setBlock(world, position.add(0, 4, 0), this.leavesState);
		this.setBlock(world, position.add(0, 4, 1), this.leavesState);
		this.setBlock(world, position.add(0, 4, 2), this.leavesState);
		this.setBlock(world, position.add(0, 4, 3), this.leavesState);
		this.setBlock(world, position.add(0, 4, 4), this.leavesState);
		this.setBlock(world, position.add(0, 4, 5), this.leavesState);
		this.setBlock(world, position.add(0, 4, 6), this.leavesState);
		this.setBlock(world, position.add(0, 4, 7), this.leavesState);
		this.setBlock(world, position.add(0, 4, 8), this.leavesState);
		this.setBlock(world, position.add(1, 4, 0), this.leavesState);
		this.setBlock(world, position.add(1, 4, 1), this.logState);
		this.setBlock(world, position.add(1, 4, 2), this.logState);
		this.setBlock(world, position.add(1, 4, 3), this.logState);
		this.setBlock(world, position.add(1, 4, 4), this.logState);
		this.setBlock(world, position.add(1, 4, 5), this.logState);
		this.setBlock(world, position.add(1, 4, 6), this.logState);
		this.setBlock(world, position.add(1, 4, 7), this.logState);
		this.setBlock(world, position.add(1, 4, 8), this.leavesState);
		this.setBlock(world, position.add(1, 5, 1), this.leavesState);
		this.setBlock(world, position.add(1, 5, 2), this.leavesState);
		this.setBlock(world, position.add(1, 5, 3), this.leavesState);
		this.setBlock(world, position.add(1, 5, 4), this.leavesState);
		this.setBlock(world, position.add(1, 5, 5), this.leavesState);
		this.setBlock(world, position.add(1, 5, 6), this.leavesState);
		this.setBlock(world, position.add(1, 5, 7), this.leavesState);
		this.setBlock(world, position.add(2, 4, 0), this.leavesState);
		this.setBlock(world, position.add(2, 4, 1), this.logState);
		this.setBlock(world, position.add(2, 4, 7), this.logState);
		this.setBlock(world, position.add(2, 4, 8), this.leavesState);
		this.setBlock(world, position.add(2, 5, 1), this.leavesState);
		this.setBlock(world, position.add(2, 5, 2), this.logState);
		this.setBlock(world, position.add(2, 5, 3), this.logState);
		this.setBlock(world, position.add(2, 5, 4), this.logState);
		this.setBlock(world, position.add(2, 5, 5), this.logState);
		this.setBlock(world, position.add(2, 5, 6), this.logState);
		this.setBlock(world, position.add(2, 5, 7), this.leavesState);
		this.setBlock(world, position.add(2, 6, 2), this.leavesState);
		this.setBlock(world, position.add(2, 6, 3), this.leavesState);
		this.setBlock(world, position.add(2, 6, 4), this.leavesState);
		this.setBlock(world, position.add(2, 6, 5), this.leavesState);
		this.setBlock(world, position.add(2, 6, 6), this.leavesState);
		this.setBlock(world, position.add(3, 4, 0), this.leavesState);
		this.setBlock(world, position.add(3, 4, 1), this.logState);
		this.setBlock(world, position.add(3, 4, 7), this.logState);
		this.setBlock(world, position.add(3, 4, 8), this.leavesState);
		this.setBlock(world, position.add(3, 5, 2), this.logState);
		this.setBlock(world, position.add(3, 5, 3), this.logState);
		this.setBlock(world, position.add(3, 5, 4), this.logState);
		this.setBlock(world, position.add(3, 5, 5), this.logState);
		this.setBlock(world, position.add(3, 5, 6), this.logState);
		this.setBlock(world, position.add(3, 5, 7), this.leavesState);
		this.setBlock(world, position.add(3, 6, 2), this.leavesState);
		this.setBlock(world, position.add(3, 6, 3), this.logState);
		this.setBlock(world, position.add(3, 6, 4), this.logState);
		this.setBlock(world, position.add(3, 6, 5), this.logState);
		this.setBlock(world, position.add(3, 6, 6), this.leavesState);
		this.setBlock(world, position.add(3, 7, 3), this.leavesState);
		this.setBlock(world, position.add(3, 7, 4), this.leavesState);
		this.setBlock(world, position.add(3, 7, 5), this.leavesState);
		this.setBlock(world, position.add(3, 8, 4), this.leavesState);
		this.setBlock(world, position.add(4, 0, 4), this.logState);
		this.setBlock(world, position.add(4, 1, 4), this.logState);
		this.setBlock(world, position.add(4, 2, 4), this.logState);
		this.setBlock(world, position.add(4, 3, 4), this.logState);
		this.setBlock(world, position.add(4, 4, 0), this.leavesState);
		this.setBlock(world, position.add(4, 4, 1), this.logState);
		this.setBlock(world, position.add(4, 4, 4), this.logState);
		this.setBlock(world, position.add(4, 4, 7), this.logState);
		this.setBlock(world, position.add(4, 4, 8), this.leavesState);
		this.setBlock(world, position.add(4, 5, 1), this.leavesState);
		this.setBlock(world, position.add(4, 5, 2), this.logState);
		this.setBlock(world, position.add(4, 5, 3), this.logState);
		this.setBlock(world, position.add(4, 5, 4), this.logState);
		this.setBlock(world, position.add(4, 5, 5), this.logState);
		this.setBlock(world, position.add(4, 5, 6), this.logState);
		this.setBlock(world, position.add(4, 5, 7), this.leavesState);
		this.setBlock(world, position.add(4, 6, 2), this.leavesState);
		this.setBlock(world, position.add(4, 6, 3), this.logState);
		this.setBlock(world, position.add(4, 6, 4), this.logState);
		this.setBlock(world, position.add(4, 6, 5), this.logState);
		this.setBlock(world, position.add(4, 6, 6), this.leavesState);
		this.setBlock(world, position.add(4, 7, 3), this.leavesState);
		this.setBlock(world, position.add(4, 7, 4), this.logState);
		this.setBlock(world, position.add(4, 7, 5), this.leavesState);
		this.setBlock(world, position.add(4, 8, 3), this.leavesState);
		this.setBlock(world, position.add(4, 8, 4), this.leavesState);
		this.setBlock(world, position.add(4, 8, 5), this.leavesState);
		this.setBlock(world, position.add(4, 9, 4), this.leavesState);
		this.setBlock(world, position.add(5, 4, 0), this.leavesState);
		this.setBlock(world, position.add(5, 4, 1), this.logState);
		this.setBlock(world, position.add(5, 4, 7), this.logState);
		this.setBlock(world, position.add(5, 4, 8), this.leavesState);
		this.setBlock(world, position.add(5, 5, 1), this.leavesState);
		this.setBlock(world, position.add(5, 5, 2), this.logState);
		this.setBlock(world, position.add(5, 5, 3), this.logState);
		this.setBlock(world, position.add(5, 5, 4), this.logState);
		this.setBlock(world, position.add(5, 5, 5), this.logState);
		this.setBlock(world, position.add(5, 5, 6), this.logState);
		this.setBlock(world, position.add(5, 5, 7), this.leavesState);
		this.setBlock(world, position.add(5, 6, 2), this.leavesState);
		this.setBlock(world, position.add(5, 6, 3), this.logState);
		this.setBlock(world, position.add(5, 6, 4), this.logState);
		this.setBlock(world, position.add(5, 6, 5), this.logState);
		this.setBlock(world, position.add(5, 6, 6), this.leavesState);
		this.setBlock(world, position.add(5, 7, 3), this.leavesState);
		this.setBlock(world, position.add(5, 7, 4), this.leavesState);
		this.setBlock(world, position.add(5, 8, 4), this.leavesState);
		this.setBlock(world, position.add(6, 4, 0), this.leavesState);
		this.setBlock(world, position.add(6, 4, 1), this.logState);
		this.setBlock(world, position.add(6, 4, 7), this.logState);
		this.setBlock(world, position.add(6, 4, 8), this.leavesState);
		this.setBlock(world, position.add(6, 5, 1), this.leavesState);
		this.setBlock(world, position.add(6, 5, 2), this.logState);
		this.setBlock(world, position.add(6, 5, 3), this.logState);
		this.setBlock(world, position.add(6, 5, 4), this.logState);
		this.setBlock(world, position.add(6, 5, 5), this.logState);
		this.setBlock(world, position.add(6, 5, 6), this.logState);
		this.setBlock(world, position.add(6, 5, 7), this.leavesState);
		this.setBlock(world, position.add(6, 6, 3), this.leavesState);
		this.setBlock(world, position.add(6, 6, 4), this.leavesState);
		this.setBlock(world, position.add(6, 6, 5), this.leavesState);
		this.setBlock(world, position.add(6, 6, 6), this.leavesState);
		this.setBlock(world, position.add(7, 4, 0), this.leavesState);
		this.setBlock(world, position.add(7, 4, 1), this.logState);
		this.setBlock(world, position.add(7, 4, 2), this.logState);
		this.setBlock(world, position.add(7, 4, 3), this.logState);
		this.setBlock(world, position.add(7, 4, 4), this.logState);
		this.setBlock(world, position.add(7, 4, 5), this.logState);
		this.setBlock(world, position.add(7, 4, 6), this.logState);
		this.setBlock(world, position.add(7, 4, 7), this.logState);
		this.setBlock(world, position.add(7, 4, 8), this.leavesState);
		this.setBlock(world, position.add(7, 5, 1), this.leavesState);
		this.setBlock(world, position.add(7, 5, 2), this.leavesState);
		this.setBlock(world, position.add(7, 5, 3), this.leavesState);
		this.setBlock(world, position.add(7, 5, 4), this.leavesState);
		this.setBlock(world, position.add(7, 5, 5), this.leavesState);
		this.setBlock(world, position.add(7, 5, 6), this.leavesState);
		this.setBlock(world, position.add(7, 5, 7), this.leavesState);
		this.setBlock(world, position.add(8, 4, 0), this.leavesState);
		this.setBlock(world, position.add(8, 4, 1), this.leavesState);
		this.setBlock(world, position.add(8, 4, 2), this.leavesState);
		this.setBlock(world, position.add(8, 4, 3), this.leavesState);
		this.setBlock(world, position.add(8, 4, 4), this.leavesState);
		this.setBlock(world, position.add(8, 4, 5), this.leavesState);
		this.setBlock(world, position.add(8, 4, 6), this.leavesState);
		this.setBlock(world, position.add(8, 4, 7), this.leavesState);
		this.setBlock(world, position.add(8, 4, 8), this.leavesState);
		
		return true;
	}
}