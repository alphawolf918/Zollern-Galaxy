/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.chunkproviders;

import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.world.ChunkProviderBase;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.space.WorldGenSpaceStationZG;

public class ChunkProviderOrbitZG extends ChunkProviderBase {
	
	private final Random rand;
	private final World world;
	
	public ChunkProviderOrbitZG(World par1World, long par2, boolean par4) {
		this.rand = new Random(par2);
		this.world = par1World;
	}
	
	@Override
	public Chunk generateChunk(int par1, int par2) {
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
		
		final Chunk var4 = new Chunk(this.world, chunkprimer, par1, par2);
		
		final byte b = (byte) Biome.getIdForBiome(BiomeAdaptive.biomeDefault);
		final byte[] biomesArray = var4.getBiomeArray();
		for (int i = 0; i < biomesArray.length; ++i) {
			biomesArray[i] = b;
		}
		
		var4.generateSkylightMap();
		return var4;
	}
	
	@Override
	public void populate(int x, int z) {
		BlockFalling.fallInstantly = true;
		final int k = x * 16;
		final int l = z * 16;
		this.rand.setSeed(this.world.getSeed());
		final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(x * i1 + z * j1 ^ this.world.getSeed());
		if (k == 0 && l == 0) {
			BlockPos pos = new BlockPos(k, 64, l);
			this.world.setBlockState(pos, ZGBlocks.blockLore.getDefaultState(), 2);
			
			if (rand.nextInt(100) <= 50) {
				BlockPos pos2 = new BlockPos(k, pos.getY() + 1, l);
				this.world.setBlockState(pos2, ZGBlocks.blockLore.getDefaultState(), 2);
			}
			
			if (ConfigManagerZG.canExtraLoreSpawn) {
				if (rand.nextInt(100) <= 50) {
					BlockPos pos3 = new BlockPos(k + 1, pos.getY(), l);
					this.world.setBlockState(pos3, ZGBlocks.blockLore.getDefaultState(), 2);
				}
				
				if (rand.nextInt(100) <= 50) {
					BlockPos pos4 = new BlockPos(k, pos.getY(), l + 1);
					this.world.setBlockState(pos4, ZGBlocks.blockLore.getDefaultState(), 2);
				}
				
				if (rand.nextInt(100) <= 50) {
					BlockPos pos2 = new BlockPos(k, pos.getY() - 1, l);
					this.world.setBlockState(pos2, ZGBlocks.blockLore.getDefaultState(), 2);
				}
				
				if (rand.nextInt(100) <= 50) {
					BlockPos pos3 = new BlockPos(k - 1, pos.getY(), l);
					this.world.setBlockState(pos3, ZGBlocks.blockLore.getDefaultState(), 2);
				}
				
				if (rand.nextInt(100) <= 50) {
					BlockPos pos4 = new BlockPos(k, pos.getY(), l - 1);
					this.world.setBlockState(pos4, ZGBlocks.blockLore.getDefaultState(), 2);
				}
			}
			
			int posX = k - 10;
			int posY = 62;
			int posZ = l - 3;
			
			int increaseBy = ZGHelper.rngNumber(100, 200);
			
			int numSpaceStations = ConfigManagerZG.spaceStationGenAmount;
			
			BlockPos posGen1 = new BlockPos(posX, posY, posZ);
			BlockPos posGenX;
			
			if (numSpaceStations == 1) {
				new WorldGenSpaceStationZG().generate(this.world, this.rand, posGen1);
			} else {
				for (int i = 0; i < numSpaceStations; i++) {
					posGenX = new BlockPos(posGen1.getX() + increaseBy, posGen1.getY(), posGen1.getZ());
					new WorldGenSpaceStationZG().generate(this.world, this.rand, posGen1);
				}
			}
		}
		
		BlockFalling.fallInstantly = false;
	}
	
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return null;
	}
	
	@Override
	public void recreateStructures(Chunk p_180514_1_, int p_180514_2_, int p_180514_3_) {
	}
}