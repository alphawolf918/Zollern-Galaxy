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

package galaxymod.tileentities.eden;

import galaxymod.mobs.entities.EntityGalaxyKnight;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class TileEntityDungeonSpawnerEden extends TileEntityDungeonSpawner {
	
	public TileEntityDungeonSpawnerEden() {
		super(EntityCrawlerBoss.class);
	}
	
	@Override
	public List<Class<? extends EntityLiving>> getDisabledCreatures() {
		final List<Class<? extends EntityLiving>> list = new ArrayList<Class<? extends EntityLiving>>();
		list.add(EntityEvolvedSkeleton.class);
		list.add(EntityEvolvedZombie.class);
		list.add(EntityEvolvedSpider.class);
		list.add(EntityEvolvedCreeper.class);
		list.add(EntityGalaxyKnight.class);
		return list;
	}
	
	@Override
	public void playSpawnSound(Entity entity) {
		this.worldObj.playSoundAtEntity(entity,
				"galacticraftcore:ambience.scaryscape", 9.0F, 1.4F);
	}
}