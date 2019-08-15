package zollerngalaxy.compatibility;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.entity.player.EntityPlayerMP;
import com.mjr.planetprogression.api.research.ResearchHooksMP;

public class PlanetProgressionCompatibility {
	
	public static boolean hasUnlockedCelestialBody(EntityPlayerMP player, CelestialBody body) {
		return ResearchHooksMP.hasUnlockedCelestialBody(player, body);
	}
}