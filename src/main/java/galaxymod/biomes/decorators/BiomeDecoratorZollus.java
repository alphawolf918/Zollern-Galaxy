/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.decorators;

import galaxymod.blocks.BlockList;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorZollus extends BiomeDecorator {
	
	public int zollusCrystalsPerChunk = 1;
	public int zollusIceLakesPerChunk = 5;
	
	@Override
	public void decorateChunk(World world, Random rand, BiomeGenBase biome,
			int x, int z) {
		if (this.currentWorld != null) {
			throw new RuntimeException("Already decorating!!");
		} else {
			this.currentWorld = world;
			this.randomGenerator = rand;
			this.chunk_X = x;
			this.chunk_Z = z;
			this.genDecorations(biome);
			this.currentWorld = null;
			this.randomGenerator = null;
		}
	}
	
	@Override
	protected void genDecorations(BiomeGenBase biome) {
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(
				this.currentWorld, this.randomGenerator, this.chunk_X,
				this.chunk_Z));
		int x;
		int y;
		int z;
		int i;
		
		for (i = 0; this.getGen(EventType.FLOWERS)
				&& i < this.zollusCrystalsPerChunk; ++i) {
			if (this.randomGenerator.nextInt(6) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenFlowers(BlockList.zolniumCrystals).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
		}
		
		for (i = 0; this.getGen(EventType.LAKE)
				&& i < this.zollusIceLakesPerChunk; ++i) {
			if (this.randomGenerator.nextInt(2) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenLakes(Blocks.packed_ice).generate(currentWorld,
						randomGenerator, x, y, z);
			}
		}
		
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(
				this.currentWorld, this.randomGenerator, this.chunk_X,
				this.chunk_Z));
	}
	
	private boolean getGen(EventType event) {
		return TerrainGen.decorate(this.currentWorld, this.randomGenerator,
				this.chunk_X, this.chunk_Z, event);
	}
}