/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.worldgen.eden;

import galaxymod.blocks.BlockList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenEdenFlowers extends WorldGenerator {
	private Block flower;
	private int flowerMeta;
	
	public WorldGenEdenFlowers(Block block, int flowerType) {
		Block flowerBlock;
		switch (flowerType) {
			default:
			case 0:
				flowerBlock = BlockList.edenFlower;
			break;
			case 1:
				flowerBlock = BlockList.edenFlowerBlue;
			break;
			case 2:
				flowerBlock = BlockList.edenFlowerCyan;
			break;
			case 3:
				flowerBlock = BlockList.edenFlowerOrange;
			break;
			case 4:
				flowerBlock = BlockList.edenFlowerPurple;
			break;
			case 5:
				flowerBlock = BlockList.edenFlowerRed;
			break;
			case 6:
				flowerBlock = BlockList.edenFlowerYellow;
			break;
			case 7:
				flowerBlock = BlockList.edenFlowerGreen;
			break;
		}
		this.flower = flowerBlock;
		this.flowerMeta = 0;
	}
	
	@Override
	public boolean generate(World world, Random rand, int par3, int par4,
			int par5) {
		for (int i = 0; i < 64; ++i) {
			int i1 = par3 + rand.nextInt(8) - rand.nextInt(8);
			int j1 = par4 + rand.nextInt(4) - rand.nextInt(4);
			int k1 = par5 + rand.nextInt(8) - rand.nextInt(8);
			
			if (world.isAirBlock(i1, j1, k1)
					&& (!world.provider.hasNoSky || j1 < 127)
					&& (world.getFullBlockLightValue(i1, j1, k1) >= 8 || world
							.canBlockSeeTheSky(i1, j1, k1))
					&& this.flower.canPlaceBlockOnSide(world, i1, j1, k1, 1)) {
				world.setBlock(i1, j1, k1, this.flower, this.flowerMeta, 2);
			}
		}
		return true;
	}
}