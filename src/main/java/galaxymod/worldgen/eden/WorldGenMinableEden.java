package galaxymod.worldgen.eden;

import galaxymod.blocks.BlockList;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenMinableEden extends WorldGenMinable {
	
	public WorldGenMinableEden(Block par1, int par2) {
		super(par1, par2, BlockList.edenRock);
	}
	
	public WorldGenMinableEden(Block par1, int par2, int par3) {
		super(par1, par2);
	}
}