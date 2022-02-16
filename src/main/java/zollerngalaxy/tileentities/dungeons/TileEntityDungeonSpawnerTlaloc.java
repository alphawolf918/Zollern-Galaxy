/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.tileentities.dungeons;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.core.client.sounds.GCSounds;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.SoundCategory;
import zollerngalaxy.mobs.entities.boss.EntityVexBotBoss;

public class TileEntityDungeonSpawnerTlaloc extends TileEntityDungeonSpawnerZG<EntityVexBotBoss> {
	
	public TileEntityDungeonSpawnerTlaloc() {
		super(EntityVexBotBoss.class);
	}
	
	@Override
	public List<Class<? extends EntityLiving>> getDisabledCreatures() {
		List<Class<? extends EntityLiving>> list = new ArrayList<Class<? extends EntityLiving>>();
		list.add(EntityEvolvedSkeleton.class);
		list.add(EntityEvolvedCreeper.class);
		list.add(EntityEvolvedZombie.class);
		list.add(EntityEvolvedSpider.class);
		return list;
	}
	
	@Override
	public void playSpawnSound(Entity entity) {
		this.world.playSound(null, entity.posX, entity.posY, entity.posZ, GCSounds.scaryScape, SoundCategory.AMBIENT, 9.0F, 1.4F);
	}
}