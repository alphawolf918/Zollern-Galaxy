/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.planets.satellites;

import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.celestial.ZGPlanet;

public class ZGSpaceStation extends Satellite {
	
	public ZGSpaceStation(String stationName, ZGPlanet parentBody) {
		super("space_station." + stationName);
		this.setParentBody(parentBody);
		this.setRelativeSize(0.2667F);
		this.setRelativeDistanceFromCenter(new ScalableDistance(5.5F, 5.5F));
		this.setRelativeOrbitTime(20.0F);
		this.setTierRequired(parentBody.getTierRequirement());
		this.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
		this.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
		this.setBiomeInfo(BiomeOrbit.space);
	}
	
}