package galaxymod.worldgen.eden.village;

import galaxymod.lib.NovaHelper;
import galaxymod.mobs.entities.EntityGrayAlien;
import java.util.Random;
import net.minecraft.world.World;

public class NGEdenVillageHelper {
	
	public static void spawnAlien(World world, int i, int j, int k,
			int profession) {
		int tries = 0;
		int spawnX = i;
		int spawnY = j;
		int spawnZ = k;
		// int g;
		if (world.isAirBlock(spawnX, spawnY, spawnZ)) {
			EntityGrayAlien alien = new EntityGrayAlien(world);
			alien.setLocationAndAngles(spawnX, spawnY, spawnZ, 0, 0);
			alien.setHomeArea(spawnX, spawnY, spawnZ, (new Random()).nextInt(5));
			world.spawnEntityInWorld(alien);
			NovaHelper.echo("Alien spawned");
		} else {
			NovaHelper.echo("Block was not free at coords. Could not spawn alien.");
		}
	}
}