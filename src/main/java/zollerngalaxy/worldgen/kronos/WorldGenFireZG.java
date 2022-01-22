package zollerngalaxy.worldgen.kronos;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlockBase;

public class WorldGenFireZG extends WorldGenerator {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			Block block = worldIn.getBlockState(blockpos.down()).getBlock();
			if ((worldIn.isAirBlock(blockpos) && (block == Blocks.NETHERRACK)) || (block instanceof ZGBlockBase && ((ZGBlockBase) block).getShouldAlwaysBurn())) {
				worldIn.setBlockState(blockpos, Blocks.FIRE.getDefaultState(), 2);
			}
		}
		
		return true;
	}
}