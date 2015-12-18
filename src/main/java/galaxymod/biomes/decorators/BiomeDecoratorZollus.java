/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorZollus extends BiomeDecorator {
	
	public int zollusCrystalsPerChunk = 1;
	
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
		
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(
				this.currentWorld, this.randomGenerator, this.chunk_X,
				this.chunk_Z));
	}
	
	private boolean getGen(EventType event) {
		return TerrainGen.decorate(this.currentWorld, this.randomGenerator,
				this.chunk_X, this.chunk_Z, event);
	}
}