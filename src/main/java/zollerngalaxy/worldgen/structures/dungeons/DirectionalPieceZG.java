/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons;

import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class DirectionalPieceZG extends PieceZG {
	
	private EnumFacing direction;
	
	public DirectionalPieceZG() {
	}
	
	public DirectionalPieceZG(DungeonConfigurationZG configuration, EnumFacing direction) {
		super(configuration);
		this.direction = direction;
	}
	
	public EnumFacing getDirection() {
		return direction;
	}
	
	public void setDirection(EnumFacing direction) {
		this.direction = direction;
	}
	
	@Override
	protected void writeStructureToNBT(NBTTagCompound tagCompound) {
		super.writeStructureToNBT(tagCompound);
		
		tagCompound.setInteger("direction", this.direction.ordinal());
	}
	
	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt, TemplateManager manager) {
		super.readStructureFromNBT(nbt, manager);
		
		if (nbt.hasKey("direction")) {
			this.direction = EnumFacing.getFront(nbt.getInteger("direction"));
		} else {
			this.direction = EnumFacing.NORTH;
		}
	}
	
	public PieceZG getCorridor(Random rand, DungeonStartZG startPiece, int maxAttempts, boolean small) {
		EnumFacing randomDir;
		int blockX;
		int blockZ;
		int sizeX;
		int sizeZ;
		boolean valid;
		int attempts = maxAttempts;
		int randDir = rand.nextInt(3);
		do {
			randomDir = EnumFacing.getHorizontal((getDirection().getOpposite().getHorizontalIndex() + 1 + randDir) % 4);
			StructureBoundingBox extension = getExtension(randomDir, this.configuration.getHallwayLengthMin() + rand.nextInt(this.configuration.getHallwayLengthMax() - this.configuration.getHallwayLengthMin()), 3);
			blockX = extension.minX;
			blockZ = extension.minZ;
			sizeX = extension.maxX - extension.minX;
			sizeZ = extension.maxZ - extension.minZ;
			valid = !startPiece.checkIntersection(extension);
			attempts--;
			randDir++;
		} while (!valid && attempts > 0);
		
		if (!valid) {
			return null;
		}
		
		return new CorridorZG(this.configuration, rand, blockX, blockZ, sizeX, small ? 3 : this.configuration.getHallwayHeight(), sizeZ, randomDir);
	}
}
