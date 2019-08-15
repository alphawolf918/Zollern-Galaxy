package zollerngalaxy.compatibility;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Optional;
import zollerngalaxy.lib.helpers.ModHelperBase;
import com.mjr.planetprogression.api.research.ResearchHooksMP;

public class PlanetProgressionCompatibility {
	
	@Optional.Method(modid = "planetprogression")
	public static boolean hasUnlockedCelestialBody(EntityPlayerMP player, CelestialBody cBody) {
		if (ModHelperBase.usePlanetProgression) {
			ResearchHooksMP resHooks = new ResearchHooksMP();
			return resHooks.hasUnlockedCelestialBody(player, cBody);
		}
		return false;
	}
}