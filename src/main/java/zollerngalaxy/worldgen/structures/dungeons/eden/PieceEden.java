/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons.eden;

import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class PieceEden extends StructureComponent {
	
	protected DungeonConfigurationEden configuration;
	protected static DungeonConfigurationEden DUNGEON_CFG;
	
	public PieceEden() {
	}
	
	public PieceEden(DungeonConfigurationEden configuration) {
		this.configuration = configuration;
		DUNGEON_CFG = configuration;
	}
	
	@Override
	protected void writeStructureToNBT(NBTTagCompound tagCompound) {
		this.configuration.writeToNBT(tagCompound);
	}
	
	@Override
	protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager manager) {
		if (this.configuration == null) {
			this.configuration = new DungeonConfigurationEden();
			this.configuration.readFromNBT(tagCompound);
		}
	}
	
	protected StructureBoundingBox getExtension(EnumFacing direction, int length, int width) {
		int blockX, blockZ, sizeX, sizeZ;
		switch (direction) {
			case NORTH:
				sizeX = width;
				sizeZ = length;
				blockX = this.boundingBox.minX + (this.boundingBox.maxX - this.boundingBox.minX) / 2 - sizeX / 2;
				blockZ = this.boundingBox.minZ - sizeZ;
				break;
			case EAST:
				sizeX = length;
				sizeZ = width;
				blockX = this.boundingBox.maxX;
				blockZ = this.boundingBox.minZ + (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 - sizeZ / 2;
				break;
			case SOUTH:
				sizeX = width;
				sizeZ = length;
				blockX = this.boundingBox.minX + (this.boundingBox.maxX - this.boundingBox.minX) / 2 - sizeX / 2;
				blockZ = this.boundingBox.maxZ;
				break;
			case WEST:
			default:
				sizeX = length;
				sizeZ = width;
				blockX = this.boundingBox.minX - sizeX;
				blockZ = this.boundingBox.minZ + (this.boundingBox.maxZ - this.boundingBox.minZ) / 2 - sizeZ / 2;
				break;
		}
		return new StructureBoundingBox(blockX, this.configuration.getYPosition(), blockZ, blockX + sizeX, this.configuration.getYPosition() + this.configuration.getHallwayHeight(), blockZ + sizeZ);
	}
	
	public PieceEden getNextPiece(DungeonStartEden startPiece, Random rand) {
		return null;
	}
}