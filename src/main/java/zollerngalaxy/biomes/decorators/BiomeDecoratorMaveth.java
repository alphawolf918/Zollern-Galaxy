/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMaveth;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTunnel;

public class BiomeDecoratorMaveth extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.mavethStone;
	private static final Block ROCK = ZGBlocks.mavethRock;
	
	private WorldGenerator ironGen;
	private WorldGenerator electrumGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator vibraniumGen;
	
	public int tunnelsPerChunk = 5;
	
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	
	public BiomeDecoratorMaveth() {
		this.ironGen = new WorldGenMinableZG(ZGBlocks.mavethIronOre, STONE, EnumOreGenZG.IRON);
		this.electrumGen = new WorldGenMinableZG(ZGBlocks.mavethElectrumOre, STONE, EnumOreGenZG.ELECTRUM);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.mavethAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.mavethZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.vibraniumGen = new WorldGenMinableZG(ZGBlocks.mavethVibraniumOre, STONE, EnumOreGenZG.VIBRANIUM);
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
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.electrumGen, EnumOreGenZG.SHINIUM, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.vibraniumGen, EnumOreGenZG.VIBRANIUM, world, rand);
		
		// Tunnels
		if (this.generateTunnels && this.tunnelsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 35) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				for (int i = 0; i < this.tunnelsPerChunk; ++i) {
					if (y <= 60) {
						tunnelGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderMaveth.INSTANCE.createCraters(x, z, chunkPrimer);
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			if (biome instanceof BiomeSpace) {
				BiomeSpace spaceBiome = (BiomeSpace) biome;
				if (spaceBiome.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					return;
				}
			}
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				IBlockState OUTPOST_STATE = ZGBlocks.blockOutpost.getDefaultState();
				WorldGenerator outpostGen = new WorldGenOutpost(OUTPOST_STATE, OUTPOST_STATE);
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}