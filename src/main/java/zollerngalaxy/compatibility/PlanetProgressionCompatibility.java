/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.compatibility;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.entity.player.EntityPlayerMP;
import zollerngalaxy.lib.helpers.ZGHelper;
import com.mjr.planetprogression.api.research.ResearchHooksMP;

/**
 * Thank you MJRLegends
 */
public class PlanetProgressionCompatibility {
	
	public static void init() {
		ZGHelper.Log("Initialized IMC with Planet Progressions.");
	}
	
	/**
	 * Checks to see if the destination has been researched or not when using
	 * Planet Progressions.
	 * 
	 * @param EntityPlayer
	 * @param CelestialBody
	 * @return Whether or not the Celestial Body has been researched yet or not
	 *         (boolean).
	 */
	public static boolean hasResearched(EntityPlayerMP player, CelestialBody body) {
		return ResearchHooksMP.hasUnlockedCelestialBody(player, body);
	}
}