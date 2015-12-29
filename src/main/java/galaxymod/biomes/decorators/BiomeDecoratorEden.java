/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.biomes.decorators;

import galaxymod.biomes.eden.BiomeGenEdenBase;
import galaxymod.blocks.BlockList;
import galaxymod.worldgen.WorldGenTreeNG;
import galaxymod.worldgen.eden.WorldGenEdenFlowers;
import galaxymod.worldgen.eden.WorldGenEdenLakes;
import galaxymod.worldgen.eden.WorldGenEdenSand;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorEden extends BiomeDecorator {
	
	public int edenTallGrassPerChunk = 0;
	public int edenFlowersPerChunk = 4;
	public int edenWoodTreesPerChunk = 1;
	public int edenDeadBushPerChunk = 0;
	public int edenSandPerChunk = 4;
	public int edenGravPerChunk = 2;
	public int edenLakesPerChunk = 1;
	public int edenWaterLillyPerChunk = 0;
	
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
		
		// Eden's Blood Sand
		for (i = 0; this.getGen(EventType.SAND) && i < this.edenSandPerChunk; i++) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenEdenSand(BlockList.edenBloodSand, 0, 6).generate(
					this.currentWorld, this.randomGenerator, x, y, z);
		}
		
		// Eden's Gravel
		for (i = 0; this.getGen(EventType.SAND) && i < this.edenGravPerChunk; i++) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenEdenSand(BlockList.edenGravel, 0, 8).generate(
					this.currentWorld, this.randomGenerator, x, y, z);
		}
		
		// Water Lillies
		for (i = 0; this.getGen(EventType.LILYPAD)
				&& i < this.edenWaterLillyPerChunk; i++) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenWaterlily().generate(currentWorld, randomGenerator, x,
					y, z);
		}
		
		// Lava & Water (Lakes)
		for (i = 0; this.getGen(EventType.LAKE) && i < this.edenLakesPerChunk; i++) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			BiomeGenEdenBase currentBiome = (BiomeGenEdenBase) this.currentWorld
					.getBiomeGenForCoords(x, z);
			if (currentBiome.theBiomeDecorator.generateLakes != false) {
				Block lakeBlock = (currentBiome.getIsHotBiome()) ? Blocks.lava
						: Blocks.water;
				if (!currentBiome.getIsHotBiome()) {
					lakeBlock = (lakeBlock == Blocks.water && currentBiome
							.getIsColdBiome()) ? Blocks.ice : Blocks.water;
				}
				new WorldGenEdenLakes(lakeBlock).generate(currentWorld,
						randomGenerator, x, y, z);
			}
		}
		
		// Tall Grass
		for (i = 0; this.getGen(EventType.GRASS)
				&& i < this.edenTallGrassPerChunk; ++i) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenTallGrass(BlockList.edenTallGrass, 0).generate(
					this.currentWorld, this.randomGenerator, x, y, z);
		}
		
		// Dead Bush
		for (i = 0; this.getGen(EventType.DEAD_BUSH)
				&& i < this.edenDeadBushPerChunk; ++i) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenDeadBush(Blocks.deadbush).generate(currentWorld,
					randomGenerator, x, y, z);
		}
		
		// Trees
		for (i = 0; this.getGen(EventType.TREE)
				&& i < this.edenWoodTreesPerChunk; i++) {
			x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			y = this.randomGenerator.nextInt(256);
			z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenTreeNG(BlockList.edenWoodLog, BlockList.edenWoodLeaves,
					0, 0, false, 6, 4, true).generate(currentWorld,
					randomGenerator, x, y, z);
		}
		
		// Eden Flowers
		for (i = 0; this.getGen(EventType.FLOWERS)
				&& i < this.edenFlowersPerChunk; ++i) {
			if (this.randomGenerator.nextInt(4) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 0).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(4) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 1).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(4) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 2).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(8) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 3).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(8) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 4).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(8) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 5).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(8) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 6).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
			}
			
			if (this.randomGenerator.nextInt(8) == 0) {
				x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(256);
				z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenEdenFlowers(BlockList.edenFlower, 7).generate(
						this.currentWorld, this.randomGenerator, x, y, z);
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