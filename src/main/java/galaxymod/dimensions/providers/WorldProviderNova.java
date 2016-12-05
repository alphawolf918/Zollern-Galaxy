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

package galaxymod.dimensions.providers;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import net.minecraft.world.World;

public abstract class WorldProviderNova extends WorldProviderSpace implements
		IExitHeight, ISolarLevel {
	
	protected String planetName = this.getCelestialBody().getLocalizedName()
			.toLowerCase();
	
	@Override
	public String getSaveFolder() {
		return "planets/" + this.planetName;
	}
	
	public World getWorldObj() {
		return this.worldObj;
	}
	
	@Override
	public boolean shouldForceRespawn() {
		return true;
	}
	
	@Override
	public String getDimensionName() {
		return "Planet " + this.planetName;
	}
	
	@Override
	public float getSolarSize() {
		return 1.0F;
	}
	
}