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