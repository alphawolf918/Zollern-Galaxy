/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.spawners;

import micdoodle8.mods.galacticraft.core.blocks.BlockBossSpawner;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.tileentities.TileEntityDungeonSpawnerZG;

public class ZGBlockBossSpawner extends BlockBossSpawner {
	
	protected Class<? extends EntityMob> bossMob;
	
	public ZGBlockBossSpawner(String blockName) {
		super(blockName);
	}
	
	public Block setBossSpawn(Class<? extends EntityMob> mobClass) {
		this.bossMob = mobClass;
		return this;
	}
	
	public Class<? extends EntityMob> getBossSpawn() {
		return this.bossMob;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDungeonSpawnerZG();
	}
	
}