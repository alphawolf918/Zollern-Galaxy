/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.spawners;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.boss.EntityVexBotBoss;
import zollerngalaxy.tileentities.dungeons.TileEntityDungeonSpawnerTlaloc;

public class ZGBlockBossSpawnerTlaloc extends ZGBlockBossSpawner {
	
	public ZGBlockBossSpawnerTlaloc() {
		super("boss_spawner_t1", EntityVexBotBoss.class);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDungeonSpawnerTlaloc();
	}
	
}