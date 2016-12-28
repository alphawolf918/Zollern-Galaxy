/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.core.galaxies;

public class GalaxyList {
	
	public static CoreGalaxy milkyWay = new CoreGalaxy("milkyWay");
	public static CoreGalaxy zollern = new CoreGalaxy("zollern");
	
	public static String getGalaxy(CoreGalaxy g) {
		return g.getUnlocalizedGalaxyName();
	}
}