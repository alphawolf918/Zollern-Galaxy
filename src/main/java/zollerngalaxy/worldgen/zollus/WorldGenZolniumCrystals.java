package zollerngalaxy.worldgen.zollus;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.mobs.entities.EntityFrostGiant;

public class WorldGenZolniumCrystals extends WorldGenerator {
	
	private IBlockState flower;
	
	public WorldGenZolniumCrystals(IBlockState flower) {
		this.flower = flower;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < 128; ++i) {
			BlockPos pos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8)
					- rand.nextInt(8));
			
			if (world.isAirBlock(pos1) && (pos1.getY() < 255)
					&& ((ZolniumCrystals) this.flower.getBlock()).canBlockStay(world, pos1, this.flower)) {
				world.setBlockState(pos1, this.flower, 2);
			}
		}
		
		if (rand.nextInt(100) <= 25) {
			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();
			
			if (!world.isRemote) {
				EntityFrostGiant frostGiant = new EntityFrostGiant(world);
				frostGiant.setLocationAndAngles(x, y, z, 0, 0);
				world.spawnEntity(frostGiant);
			}
		}
		return true;
	}
}