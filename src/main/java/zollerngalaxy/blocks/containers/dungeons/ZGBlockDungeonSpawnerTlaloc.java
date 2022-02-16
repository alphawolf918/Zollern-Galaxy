/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.containers.dungeons;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.tileentities.dungeons.TileEntityDungeonSpawnerTlaloc;

public class ZGBlockDungeonSpawnerTlaloc extends ZGBlockDungeonSpawner {
	
	public ZGBlockDungeonSpawnerTlaloc(String name) {
		super(name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityDungeonSpawnerTlaloc();
	}
}