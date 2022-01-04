/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.containers;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.tileentities.TileEntityDungeonSpawnerZG;

public class ZGBlockDungeonSpawner extends BlockBossSpawner {
	
	public ZGBlockDungeonSpawner(String name) {
		super(name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityDungeonSpawnerZG();
	}
}