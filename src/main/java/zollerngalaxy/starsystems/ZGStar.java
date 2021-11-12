/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.starsystems;

import micdoodle8.mods.galacticraft.api.galaxies.Star;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.lib.ZGInfo;

public class ZGStar extends Star {
	
	public ZGStar(String starName) {
		super(starName);
		this.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/" + starName + ".png"));
		this.setTierRequired(-1);
		this.setPhaseShift(0.0F);
		this.setRelativeSize(1.0F);
	}
}