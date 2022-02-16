/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons.tlaloc;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class DungeonConfigurationTlaloc extends DungeonConfiguration {
	
	private IBlockState brickBlock;
	private int yPosition;
	private int hallwayLengthMin;
	private int hallwayLengthMax;
	private int hallwayHeight;
	private int roomHeight;
	private Class<?> bossRoom;
	private Class<?> treasureRoom;
	protected ResourceLocation lootTable;
	protected ResourceLocation dungeonLoot;
	private IBlockState chestState;
	private IBlockState spawnerState;
	private IBlockState fluidState;
	private ResourceLocation mobs;
	
	public DungeonConfigurationTlaloc() {
	}
	
	public DungeonConfigurationTlaloc(IBlockState brickBlock, int yPosition, int hallwayLengthMin, int hallwayLengthMax, int hallwayHeight, int roomHeight, Class<?> bossRoom, Class<?> treasureRoom) {
		this.brickBlock = brickBlock;
		this.yPosition = yPosition;
		this.hallwayLengthMin = hallwayLengthMin;
		this.hallwayLengthMax = hallwayLengthMax;
		this.hallwayHeight = hallwayHeight;
		this.roomHeight = roomHeight;
		this.bossRoom = bossRoom;
		this.treasureRoom = treasureRoom;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
		tagCompound.setString("brickBlock", Block.REGISTRY.getNameForObject(this.brickBlock.getBlock()).toString());
		tagCompound.setInteger("brickBlockMeta", this.brickBlock.getBlock().getMetaFromState(this.brickBlock));
		tagCompound.setInteger("yPosition", this.yPosition);
		tagCompound.setInteger("hallwayLengthMin", this.hallwayLengthMin);
		tagCompound.setInteger("hallwayLengthMax", this.hallwayLengthMax);
		tagCompound.setInteger("hallwayHeight", this.hallwayHeight);
		tagCompound.setInteger("roomHeight", this.roomHeight);
		tagCompound.setString("bossRoom", this.bossRoom.getName());
		tagCompound.setString("treasureRoom", this.treasureRoom.getName());
		return tagCompound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		try {
			this.brickBlock = Block.getBlockFromName(tagCompound.getString("brickBlock")).getStateFromMeta(tagCompound.getInteger("brickBlockMeta"));
			this.yPosition = tagCompound.getInteger("yPosition");
			this.hallwayLengthMin = tagCompound.getInteger("hallwayLengthMin");
			this.hallwayLengthMax = tagCompound.getInteger("hallwayLengthMax");
			this.hallwayHeight = tagCompound.getInteger("hallwayHeight");
			this.roomHeight = tagCompound.getInteger("roomHeight");
			this.bossRoom = Class.forName(tagCompound.getString("bossRoom"));
			this.treasureRoom = Class.forName(tagCompound.getString("treasureRoom"));
		} catch (Exception e) {
			System.err.println("Failed to read dungeon configuration from NBT");
			e.printStackTrace();
		}
	}
	
	@Override
	public IBlockState getBrickBlock() {
		return brickBlock;
	}
	
	@Override
	public int getYPosition() {
		return yPosition;
	}
	
	@Override
	public int getHallwayLengthMin() {
		return hallwayLengthMin;
	}
	
	@Override
	public int getHallwayLengthMax() {
		return hallwayLengthMax;
	}
	
	@Override
	public int getHallwayHeight() {
		return hallwayHeight;
	}
	
	@Override
	public int getRoomHeight() {
		return roomHeight;
	}
	
	@Override
	public Class<?> getBossRoom() {
		return bossRoom;
	}
	
	@Override
	public Class<?> getTreasureRoom() {
		return treasureRoom;
	}
	
	public DungeonConfigurationTlaloc getConfiguration() {
		return this;
	}
}