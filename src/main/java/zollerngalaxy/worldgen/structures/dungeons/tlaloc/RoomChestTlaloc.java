/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons.tlaloc;

import java.util.Random;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import zollerngalaxy.blocks.containers.ZGBlockTreasureChest;
import zollerngalaxy.core.ZGLootTables;

public class RoomChestTlaloc extends RoomEmptyTlaloc {
	
	public RoomChestTlaloc() {
	}
	
	public RoomChestTlaloc(DungeonConfigurationTlaloc configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
	}
	
	@Override
	public boolean addComponentParts(World worldIn, Random rand, StructureBoundingBox boundingBox) {
		if (super.addComponentParts(worldIn, rand, boundingBox)) {
			int chestX = this.sizeX / 2;
			int chestY = 1;
			int chestZ = this.sizeZ / 2;
			this.setBlockState(worldIn, Blocks.CHEST.getDefaultState().withProperty(ZGBlockTreasureChest.FACING, this.getDirection().getOpposite()), chestX, chestY, chestZ, boundingBox);
			
			BlockPos blockpos = new BlockPos(this.getXWithOffset(chestX, chestZ), this.getYWithOffset(chestY), this.getZWithOffset(chestX, chestZ));
			TileEntityChest chest = (TileEntityChest) worldIn.getTileEntity(blockpos);
			
			if (chest != null) {
				ResourceLocation chesttype = ZGLootTables.CHEST_DUNGEON_TIER10_DEFAULT;
				if (worldIn.provider instanceof IGalacticraftWorldProvider) {
					chesttype = ((IGalacticraftWorldProvider) worldIn.provider).getDungeonChestType();
				}
				chest.setLootTable(chesttype, rand.nextLong());
			}
			
			return true;
		}
		
		return false;
	}
}