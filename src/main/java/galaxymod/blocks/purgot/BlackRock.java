/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks.purgot;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.BlockNova;
import java.util.Random;
import net.minecraft.world.World;

public class BlackRock extends BlockNova {
	
	public BlackRock() {
		super("blackrock");
		this.setHardResist(2.0F, 0.4F);
		this.setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(100) == 0) {
			world.setBlock(x, y, z, BlockList.purgWhiteRock);
		}
	}
	
}