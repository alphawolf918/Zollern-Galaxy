/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial.spacestations;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.core.world.gen.BiomeOrbit;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.celestial.ZGPlanet;

public class ZGSpaceStation extends Satellite {
	
	public ZGSpaceStation(String stationName, ZGPlanet parentBody) {
		super("spacestation." + stationName);
		this.setParentBody(parentBody);
		this.setTierRequired(parentBody.getTierRequirement());
		this.setupSpaceStation();
	}
	
	protected void setupSpaceStation() {
		this.setRelativeSize(0.2667F);
		this.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(9F, 9F));
		this.setRelativeOrbitTime(20.0F);
		this.setBodyIcon(new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/space_station.png"));
		this.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
		this.setBiomeInfo(BiomeOrbit.space);
	}
	
	public ZGSpaceStation setParentPlanet(ZGPlanet planet) {
		this.setParentBody(planet);
		return this;
	}
}