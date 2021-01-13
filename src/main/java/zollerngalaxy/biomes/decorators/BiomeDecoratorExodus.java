/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;

public class BiomeDecoratorExodus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravGen;
	//
	//
	
	public BiomeDecoratorExodus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.exodusDirt, ZGBlocks.exodusGrass, EnumOreGenZG.DIRT);
		this.gravGen = new WorldGenMinableZG(ZGBlocks.exodusGravel, ZGBlocks.exodusGrass, EnumOreGenZG.GRAVEL);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		int genY = 248;
		int y = genY;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravGen, EnumOreGenZG.GRAVEL, world, rand);
		
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				WorldGenerator outpostGen = new WorldGenOutpost(ZGBlocks.blockOutpost.getDefaultState(),
						ZGBlocks.blockOutpost.getDefaultState());
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}