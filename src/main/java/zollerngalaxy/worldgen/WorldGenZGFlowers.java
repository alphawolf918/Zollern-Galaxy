package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenZGFlowers extends WorldGenerator {
	
	private BlockBush flower;
	private IBlockState state;
	
	public WorldGenZGFlowers(BlockBush flowerIn) {
		this.flower = flowerIn;
		this.state = flowerIn.getDefaultState();
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 68; ++i) {
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4)
					- rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
			
			if (worldIn.isAirBlock(blockpos) && (blockpos.getY() < 255)
					&& this.flower.canBlockStay(worldIn, blockpos, this.state)) {
				worldIn.setBlockState(blockpos, this.state, 2);
			}
		}
		
		return true;
	}
}