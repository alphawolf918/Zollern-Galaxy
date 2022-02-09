/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.spawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import micdoodle8.mods.galacticraft.core.entities.EntityBossBase;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.tileentities.TileEntityDungeonSpawnerZG;

public class ZGBlockBossSpawner extends BlockBossSpawner {
	
	protected Class<? extends EntityBossBase> bossMob;
	
	public ZGBlockBossSpawner(String blockName, Class<? extends EntityBossBase> bossMobIn) {
		super(blockName);
		this.bossMob = bossMobIn;
	}
	
	public Block setBossSpawn(Class<? extends EntityBossBase> mobClass) {
		this.bossMob = mobClass;
		return this;
	}
	
	public Class<? extends EntityBossBase> getBossSpawn() {
		return this.bossMob;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDungeonSpawnerZG(this.bossMob);
	}
}