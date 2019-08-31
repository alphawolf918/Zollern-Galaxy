package zollerngalaxy.compatibility;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.entity.player.EntityPlayerMP;
import com.mjr.planetprogression.api.research.ResearchHooksMP;

// Thank you MJRLegends
public class PlanetProgressionCompatibility {
	
	/**
	 * Checks to see if the destination has been researched or not when using
	 * Planet Progressions.
	 * 
	 * @param player
	 * @param body
	 * @return Whether or not the Celestial Body has been researched yet or not.
	 */
	public static boolean hasResearched(EntityPlayerMP player, CelestialBody body) {
		return ResearchHooksMP.hasUnlockedCelestialBody(player, body);
	}
}