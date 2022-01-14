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
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranSwamp extends BiomeHarranBase {
	
	protected static final IBlockState WATER_LILY = Blocks.WATERLILY.getDefaultState();
	
	public BiomeHarranSwamp(BiomeProperties props) {
		super("harran_swamp", props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(6.5F);
		this.setTemp(46F);
		this.setBiomeHeight(45);
		this.setBiomeType(EnumBiomeTypeZG.SWAMP);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 25, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedWitch.class, 25, 1, 1));
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.generateVines = true;
		this.biomeDecor.treesPerChunk = 4;
		this.biomeDecor.waterLakesPerChunk = 24;
		this.biomeDecor.waterlilyPerChunk = 16;
		this.biomeDecor.deadBushPerChunk = 4;
		this.biomeDecor.tallGrassPerChunk = 4;
		this.biomeDecor.mushroomsPerChunk = 15;
		this.enableSnow = false;
		this.grassFoliageColor = 0x00aa00;
		this.waterColor = 0x004422;
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return SWAMP_FEATURE;
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
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FOSSIL))
			if (rand.nextInt(64) == 0) {
				(new WorldGenFossils()).generate(worldIn, rand, pos);
			}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		double d0 = GRASS_COLOR_NOISE.getValue(pos.getX() * 0.0225D, pos.getZ() * 0.0225D);
		return getModdedBiomeGrassColor(d0 < -0.1D ? 5011004 : 6975545);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getFoliageColorAtPos(BlockPos pos) {
		return getModdedBiomeFoliageColor(this.grassFoliageColor);
	}
}