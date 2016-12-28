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

import galaxymod.utils.ZGHelper;

public class CoreGalaxy {
	
	private String unlocalizedGalaxyName;
	
	public CoreGalaxy(String name) {
		this.setUnlocalizedGalaxyName(name);
	}
	
	public void setUnlocalizedGalaxyName(String galaxyName) {
		this.unlocalizedGalaxyName = galaxyName;
	}
	
	public String getUnlocalizedGalaxyName() {
		return this.unlocalizedGalaxyName;
	}
	
	public String getLocalizedGalaxyName() {
		return ZGHelper.capitalizeFirstLetter(unlocalizedGalaxyName);
	}
	
}