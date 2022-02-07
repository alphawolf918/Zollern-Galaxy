/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial.starsystems;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.lib.ZGInfo;

public class ZGStar extends Star {
	
	public ZGStar(String starName) {
		super(starName);
		this.setupStar(starName, starName);
	}
	
	public ZGStar(String starName, String starBodyIcon) {
		super(starName);
		this.setupStar(starName, starBodyIcon);
	}
	
	protected void setupStar(String starName, String star_icon) {
		this.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/" + star_icon + ".png"));
		this.setTierRequired(-1);
		this.setPhaseShift(0.0F);
		this.setRelativeSize(1.0F);
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance, scaledDistance));
		return this;
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance1, float scaledDistance2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance1, scaledDistance2));
		return this;
	}
}