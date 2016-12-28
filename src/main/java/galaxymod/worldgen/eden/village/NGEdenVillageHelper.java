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

package galaxymod.worldgen.eden.village;

import galaxymod.mobs.entities.EntityGrayAlien;
import net.minecraft.world.World;

public class NGEdenVillageHelper {
	
	public static void spawnAlien(World world, int i, int j, int k,
			int profession) {
		int spawnX = i;
		int spawnY = j;
		int spawnZ = k;
		
		if (world.isAirBlock(spawnX, spawnY, spawnZ)) {
			EntityGrayAlien alien = new EntityGrayAlien(world);
			alien.setLocationAndAngles(spawnX, spawnY, spawnZ, 0, 0);
			world.spawnEntityInWorld(alien);
		}
	}
	
	public static void spawnAlien(World world, int i, int j, int k) {
		spawnAlien(world, i, j, k, 0);
	}
}