/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.caligro;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenShadowSkull extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int i = position.getX();
		int j = position.getY();
		int k = position.getZ();
		
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		if (!world.isRemote) {
			for (int x = 0; x < rand.nextInt(4); x++) {
				EntityShadowSkeleton skelly = new EntityShadowSkeleton(world);
				ZGHelper.spawnEntity(skelly, world, ((i + 1) + x), j, k);
			}
		}
		
		setBlock(world, new BlockPos(i + 1, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 4, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 4, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 6, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 6, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 6, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 7, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 8, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 8, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 9, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 9, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 9, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 11, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 11, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 11, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 11, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 1, j + 11, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 2, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 2, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 2, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 7, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 7, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 8, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 11, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 12, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 12, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 12, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 12, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 2, j + 12, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 0, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 1, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 2, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 2, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 2, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 3, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 3, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 8, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 11, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 11, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 12, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 12, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 12, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 12, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 12, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 13, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 13, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 3, j + 13, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 0, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 1, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 2, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 2, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 2, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 3, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 3, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 3, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 4, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 5, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 6, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 7, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 7, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 7, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 8, k + 1), ZGBlocks.blockShadowBone);
		//
		BlockPos chestPos = new BlockPos(i + 4, j + 8, k + 4);
		ZGLootTables.generateChest(world, chestPos, rand, ZGLootTables.CHEST_SHADOW_SKULL);
		//
		setBlock(world, new BlockPos(i + 4, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 11, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 11, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 12, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 12, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 12, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 12, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 12, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 13, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 13, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 4, j + 13, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 2, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 2, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 2, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 7, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 7, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 8, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 11, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 11, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 12, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 12, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 12, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 12, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 5, j + 12, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 2, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 2, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 3, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 4, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 5, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 6, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 7, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 8, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 9, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 1), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 6), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 10, k + 7), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 11, k + 2), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 11, k + 3), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 11, k + 4), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 11, k + 5), ZGBlocks.blockShadowBone);
		setBlock(world, new BlockPos(i + 6, j + 11, k + 6), ZGBlocks.blockShadowBone);
		
		return true;
	}
}