/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedWitch;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranClayMesa extends BiomeHarranBase {
	
	public BiomeHarranClayMesa(BiomeProperties props) {
		super("harran_clay_mesa", props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.4F);
		props.setTemperature(6.0F);
		this.setTemp(65.42F);
		this.setBiomeHeight(25);
		this.setBiomeType(EnumBiomeTypeZG.SWAMP);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 25, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 25, 1, 1));
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.generateVines = true;
		this.biomeDecor.treesPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 16;
		this.biomeDecor.waterlilyPerChunk = 16;
		this.biomeDecor.tallGrassPerChunk = 0;
		this.biomeDecor.mushroomsPerChunk = 15;
		this.biomeDecor.mushroomTreesPerChunk = 5;
		this.enableSnow = false;
		this.grassFoliageColor = 0x00ff00;
		this.waterColor = 0x4e8bdc;
		this.topBlock = Blocks.CLAY.getDefaultState();
		this.fillerBlock = Blocks.HARDENED_CLAY.getDefaultState();
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		double d0 = GRASS_COLOR_NOISE.getValue(x * 0.25D, z * 0.25D);
		
		if (d0 > 0.0D) {
			int i = x & 15;
			int j = z & 15;
			
			for (int k = 255; k >= 0; --k) {
				if (chunkPrimerIn.getBlockState(j, k, i).getMaterial() != Material.AIR) {
					if (k <= (this.getBiomeHeight() - 3) && chunkPrimerIn.getBlockState(j, k, i).getBlock() != Blocks.WATER) {
						chunkPrimerIn.setBlockState(j, k, i, WATER);
						
						if (d0 <= 0.24D) {
							chunkPrimerIn.setBlockState(j, k + 1, i, Blocks.WATERLILY.getDefaultState());
						}
					}
					
					break;
				}
			}
		}
		
		this.generateMetztliTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
}