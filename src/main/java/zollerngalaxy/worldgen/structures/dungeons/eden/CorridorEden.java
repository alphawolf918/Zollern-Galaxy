/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons.eden;

import java.lang.reflect.Constructor;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockUnlitTorch;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class CorridorEden extends SizedPieceEden {
	
	public CorridorEden() {
	}
	
	public CorridorEden(DungeonConfigurationEden configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing direction) {
		super(configuration, sizeX, sizeY, sizeZ, direction);
		this.setCoordBaseMode(EnumFacing.SOUTH);
		this.boundingBox = new StructureBoundingBox(blockPosX, configuration.getYPosition(), blockPosZ, blockPosX + sizeX, configuration.getYPosition() + sizeY, blockPosZ + sizeZ);
	}
	
	@Override
	public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
		for (int i = 0; i < this.boundingBox.getXSize(); i++) {
			for (int j = 0; j < this.boundingBox.getYSize(); j++) {
				for (int k = 0; k < this.boundingBox.getZSize(); k++) {
					if ((this.getDirection().getAxis() == EnumFacing.Axis.Z && (i == 0 || i == this.boundingBox.getXSize() - 1)) || j == 0 || j == this.boundingBox.getYSize() - 1 || (this.getDirection().getAxis() == EnumFacing.Axis.X && (k == 0 || k == this.boundingBox.getZSize() - 1))) {
						this.setBlockState(worldIn, this.configuration.getBrickBlock(), i, j, k, this.boundingBox);
					} else {
						if (j == this.boundingBox.getYSize() - 2) {
							if (this.getDirection().getAxis() == EnumFacing.Axis.Z && (k + 1) % 4 == 0 && (i == 1 || i == this.boundingBox.getXSize() - 2)) {
								this.setBlockState(worldIn, GCBlocks.unlitTorch.getDefaultState().withProperty(BlockUnlitTorch.FACING, i == 1 ? EnumFacing.WEST.getOpposite() : EnumFacing.EAST.getOpposite()), i, j, k, this.boundingBox);
								continue;
							} else if (this.getDirection().getAxis() == EnumFacing.Axis.X && (i + 1) % 4 == 0 && (k == 1 || k == this.boundingBox.getZSize() - 2)) {
								this.setBlockState(worldIn, GCBlocks.unlitTorch.getDefaultState().withProperty(BlockUnlitTorch.FACING, k == 1 ? EnumFacing.NORTH.getOpposite() : EnumFacing.SOUTH.getOpposite()), i, j, k, this.boundingBox);
								continue;
							}
						}
						
						this.setBlockState(worldIn, Blocks.AIR.getDefaultState(), i, j, k, this.boundingBox);
					}
				}
			}
		}
		
		return true;
	}
	
	private <T extends SizedPieceEden> T getRoom(Class<?> clazz, DungeonStartEden startPiece, Random rand) {
		try {
			Constructor<?> c0 = clazz.getConstructor(DungeonConfigurationEden.class, Random.class, Integer.TYPE, Integer.TYPE, EnumFacing.class);
			T dummy = (T) c0.newInstance(this.configuration, rand, 0, 0, this.getDirection().getOpposite());
			StructureBoundingBox extension = getExtension(this.getDirection(), getDirection().getAxis() == EnumFacing.Axis.X ? dummy.getSizeX() : dummy.getSizeZ(), getDirection().getAxis() == EnumFacing.Axis.X ? dummy.getSizeZ() : dummy.getSizeX());
			if (startPiece.checkIntersection(extension)) {
				return null;
			}
			int sizeX = extension.maxX - extension.minX;
			int sizeZ = extension.maxZ - extension.minZ;
			int sizeY = dummy.sizeY;
			int blockX = extension.minX;
			int blockZ = extension.minZ;
			Constructor<?> c1 = clazz.getConstructor(DungeonConfigurationEden.class, Random.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, EnumFacing.class);
			return (T) c1.newInstance(this.configuration, rand, blockX, blockZ, sizeX, sizeY, sizeZ, this.getDirection().getOpposite());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public PieceEden getNextPiece(DungeonStartEden startPiece, Random rand) {
		int pieceCount = startPiece.attachedComponents.size();
		if (pieceCount > 10 && startPiece.attachedComponents.get(pieceCount - 2) instanceof RoomBossEden) {
			try {
				return getRoom(this.configuration.getTreasureRoom(), startPiece, rand);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			int bossRoomChance = Math.max((int) (20.0 / (pieceCount - 10)), 1);
			boolean bossRoom = pieceCount > 25 || (pieceCount > 10 && rand.nextInt(bossRoomChance) == 0);
			if (bossRoom) {
				try {
					return getRoom(this.configuration.getBossRoom(), startPiece, rand);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			} else {
				StructureBoundingBox extension = getExtension(this.getDirection(), rand.nextInt(4) + 6, rand.nextInt(4) + 6);
				
				if (startPiece.checkIntersection(extension)) {
					return null;
				}
				
				int sizeX = extension.maxX - extension.minX;
				int sizeZ = extension.maxZ - extension.minZ;
				int sizeY = configuration.getRoomHeight();
				int blockX = extension.minX;
				int blockZ = extension.minZ;
				
				if (Math.abs(startPiece.getBoundingBox().maxZ - boundingBox.minZ) > 200) {
					return null;
				}
				
				if (Math.abs(startPiece.getBoundingBox().maxX - boundingBox.minX) > 200) {
					return null;
				}
				
				switch (rand.nextInt(3)) {
					case 0:
						return new RoomSpawnerEden(this.configuration, rand, blockX, blockZ, sizeX, sizeY, sizeZ, this.getDirection().getOpposite());
					case 1:
						return new RoomChestEden(this.configuration, rand, blockX, blockZ, sizeX, sizeY, sizeZ, this.getDirection().getOpposite());
					default:
					case 2:
						return new RoomEmptyEden(this.configuration, rand, blockX, blockZ, sizeX, sizeY, sizeZ, this.getDirection().getOpposite());
				}
			}
		}
		return null;
	}
}