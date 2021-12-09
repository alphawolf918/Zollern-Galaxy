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
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderCentotl;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTunnel;
import zollerngalaxy.worldgen.centotl.WorldGenFacehuggerEgg;

public class BiomeDecoratorCentotl extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.centoStone;
	private static final Block ROCK = ZGBlocks.centoRock;
	
	private WorldGenerator dirtGen;
	private WorldGenerator constructGen1;
	private WorldGenerator constructGen2;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator shiniumGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator zollerniumGen;
	
	public int tunnelsPerChunk = 5;
	public int eggsPerChunk = 5;
	
	public boolean generateCraters = true;
	public boolean generateTunnels = true;
	public boolean generateEggs = true;
	
	private WorldGenerator tunnelGen = new WorldGenTunnel();
	private WorldGenerator eggGen = new WorldGenFacehuggerEgg();
	
	public BiomeDecoratorCentotl() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.centoDirt, ROCK, EnumOreGenZG.DIRT);
		this.constructGen1 = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, ROCK, EnumOreGenZG.CONSTRUCTED);
		this.constructGen2 = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, ROCK, EnumOreGenZG.CONSTRUCTED);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.centoIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.centoGoldOre, STONE, EnumOreGenZG.GOLD);
		this.shiniumGen = new WorldGenMinableZG(ZGBlocks.centoShiniumOre, STONE, EnumOreGenZG.SHINIUM);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.centoFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.centoZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
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
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.shiniumGen, EnumOreGenZG.SHINIUM, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.constructGen1, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.constructGen2, EnumOreGenZG.CONSTRUCTED, world, rand);
		
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
		
		// Facehugger Eggs
		if (this.generateEggs && this.eggsPerChunk > 0) {
			for (int i = 0; i < this.eggsPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y <= 10) {
					y += ZGHelper.rngInt(0, 75);
				}
				if (rand.nextInt(100) <= 25) {
					this.eggGen.generate(world, rand, this.chunkPos.add(x, y, z));
					this.eggGen.generate(world, rand, this.chunkPos.add(x + 3, y, z));
					this.eggGen.generate(world, rand, this.chunkPos.add(x - 3, y, z));
					this.eggGen.generate(world, rand, this.chunkPos.add(x, y, z + 3));
					this.eggGen.generate(world, rand, this.chunkPos.add(x - 3, y, z + 3));
					this.eggGen.generate(world, rand, this.chunkPos.add(x + 3, y, z - 3));
				}
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderCentotl.INSTANCE.createCraters(x, z, chunkPrimer);
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