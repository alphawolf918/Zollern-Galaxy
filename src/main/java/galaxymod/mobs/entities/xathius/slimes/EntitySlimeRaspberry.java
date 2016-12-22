/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.mobs.entities.xathius.slimes;

import net.minecraft.world.World;

public class EntitySlimeRaspberry extends EntitySlimeBase {
	
	public EntitySlimeRaspberry(World world) {
		super(world, SlimeType.RASPBERRY);
		this.setSlimeName("Raspberry");
	}
	
}