/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.mobs.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntityAlienSquid extends EntitySquid implements IEntityBreathable {
	
	public EntityAlienSquid(World par1World) {
		super(par1World);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}