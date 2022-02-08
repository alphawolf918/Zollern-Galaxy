/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class SizedPieceZG extends DirectionalPieceZG {
	
	protected int sizeX;
	protected int sizeY;
	protected int sizeZ;
	
	public SizedPieceZG() {
	}
	
	public SizedPieceZG(DungeonConfigurationZG configuration, int sizeX, int sizeY, int sizeZ, EnumFacing direction) {
		super(configuration, direction);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.sizeZ = sizeZ;
	}
	
	@Override
	protected void writeStructureToNBT(NBTTagCompound tagCompound) {
		super.writeStructureToNBT(tagCompound);
		
		tagCompound.setInteger("sizeX", this.sizeX);
		tagCompound.setInteger("sizeY", this.sizeY);
		tagCompound.setInteger("sizeZ", this.sizeZ);
	}
	
	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt, TemplateManager manager) {
		super.readStructureFromNBT(nbt, manager);
		
		this.sizeX = nbt.getInteger("sizeX");
		this.sizeY = nbt.getInteger("sizeY");
		this.sizeZ = nbt.getInteger("sizeZ");
	}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public int getSizeZ() {
		return sizeZ;
	}
}