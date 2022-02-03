/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.oasis;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeOasisMudSwamp extends BiomeOasisBase {
	
	protected static final IBlockState WATER_LILY = Blocks.WATERLILY.getDefaultState();
	
	public BiomeOasisMudSwamp(BiomeProperties props) {
		super("oasis_mudswamp", props);
		props.setBaseHeight(1.4F);
		props.setHeightVariation(1.5F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.0F);
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.SWAMP);
		this.enableSnow = false;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.waterLakesPerChunk = 6;
		this.biomeDecor.waterlilyPerChunk = 8;
		this.grassFoliageColor = 0x9fcc8b;
		this.waterColor = 0x0027dc;
		this.topBlock = ZGBlocks.mudClayBlock.getDefaultState();
		this.fillerBlock = ZGBlocks.mudClayBlock.getDefaultState();
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
		double d0 = GRASS_COLOR_NOISE.getValue(x * 0.25D, z * 0.25D);
		
		if (d0 > 0.0D) {
			int i = x & 15;
			int j = z & 15;
			
			for (int k = 128; k >= 0; --k) {
				if (chunkPrimerIn.getBlockState(j, k, i).getMaterial() != Material.AIR) {
					if (k <= (this.getBiomeHeight() - 3) && chunkPrimerIn.getBlockState(j, k, i).getBlock() != Blocks.WATER) {
						chunkPrimerIn.setBlockState(j, k, i, WATER);
						
						if (d0 <= 0.24D) {
							chunkPrimerIn.setBlockState(j, k + 1, i, WATER_LILY);
						}
					}
					
					break;
				}
			}
		}
		
		this.generateOasisTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FOSSIL)) {
			if (rand.nextInt(64) == 0) {
				(new WorldGenFossils()).generate(worldIn, rand, pos);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4c6fde;
	}
}