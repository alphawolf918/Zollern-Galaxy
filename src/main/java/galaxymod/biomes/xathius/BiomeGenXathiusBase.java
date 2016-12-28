/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.biomes.xathius;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.biomes.decorators.BiomeDecoratorXathius;
import galaxymod.blocks.BlockList;
import galaxymod.core.ZGPlanets;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeGenXathiusBase extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0xff0000;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorXathius biomeDecor = this.getBiomeDecorator();
	
	public BiomeGenXathiusBase(int p_i1971_1_) {
		super(p_i1971_1_);
		this.enableRain = true;
		this.enableSnow = true;
		this.setColor(BiomeList.biomeColor);
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = BlockList.xathRock;
		this.fillerBlock = BlockList.xathDirt;
		this.stoneBlock = BlockList.xathStone;
		this.setPlanetForBiome(ZGPlanets.planetXathius);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeGenXathiusBase setColor(int var1) {
		return (BiomeGenXathiusBase) super.setColor(var1);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorXathius();
	}
	
	protected BiomeDecoratorXathius getBiomeDecorator() {
		return (BiomeDecoratorXathius) this.theBiomeDecorator;
	}
	
	public void genXathiusBiomeTerrain(World world, Random rand, Block[] block,
			byte[] meta, int x, int z, double stoneNoise) {
		Block topBlock = this.topBlock;
		byte topMeta = 0;
		Block fillerBlock = this.fillerBlock;
		byte fillerMeta = 0;
		int currentFillerDepth = -1;
		int maxFillerDepth = (int) (stoneNoise / 3.0D + 3.0D + rand
				.nextDouble() * 0.25D);
		int maskX = x & 15;
		int maskZ = z & 15;
		int worldHeight = block.length / 256;
		int seaLevel = 32;
		
		for (int y = 255; y >= 0; y--) {
			int index = (maskZ * 16 + maskX) * worldHeight + y;
			
			if (y <= 0 + rand.nextInt(5)) {
				block[index] = Blocks.bedrock;
			} else {
				Block currentBlock = block[index];
				
				if (currentBlock != null
						&& currentBlock.getMaterial() != Material.air) {
					if (currentBlock == Blocks.stone) {
						if (this.stoneBlock != null) {
							block[index] = this.stoneBlock;
							meta[index] = this.stoneMeta;
						}
						if (currentFillerDepth == -1) {
							if (maxFillerDepth <= 0) {
								topBlock = null;
								topMeta = 0;
								fillerBlock = BlockList.xathRock;
								fillerMeta = 0;
							} else if (y >= seaLevel - 5 && y <= seaLevel) {
								topBlock = this.topBlock;
								topMeta = this.topMeta;
								fillerBlock = this.fillerBlock;
								fillerMeta = 0;
							}
							if (y < seaLevel - 1
									&& (topBlock == null || topBlock
											.getMaterial() == Material.air)) {
								if (this.getIsColdBiome()) {
									topBlock = Blocks.packed_ice;
									topMeta = 0;
								} else {
									topBlock = Blocks.water;
									topMeta = 0;
								}
							}
							
							currentFillerDepth = maxFillerDepth;
							
							if (y >= seaLevel - 2) {
								block[index] = topBlock;
								meta[index] = topMeta;
							} else if (y < seaLevel - 8 - maxFillerDepth) {
								topBlock = null;
								fillerBlock = BlockList.xathCobbleRock;
								fillerMeta = 0;
								block[index] = BlockList.xathStone;
							} else {
								block[index] = fillerBlock;
								meta[index] = fillerMeta;
							}
						} else if (currentFillerDepth > 0) {
							currentFillerDepth--;
							block[index] = fillerBlock;
							meta[index] = fillerMeta;
							
							if (currentFillerDepth == 0
									&& fillerBlock == BlockList.xathDirt) {
								currentFillerDepth = rand.nextInt(4)
										+ Math.max(0, y - (seaLevel - 1));
								fillerBlock = BlockList.xathStone;
								fillerMeta = 0;
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] block,
			byte[] meta, int x, int z, double stoneNoise) {
		this.genXathiusBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}