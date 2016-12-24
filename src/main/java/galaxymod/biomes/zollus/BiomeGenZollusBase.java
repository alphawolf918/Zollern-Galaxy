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

package galaxymod.biomes.zollus;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.biomes.decorators.BiomeDecoratorZollus;
import galaxymod.blocks.BlockList;
import galaxymod.core.ZGPlanets;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeGenZollusBase extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorZollus biomeDecor = this.getBiomeDecorator();
	
	public BiomeGenZollusBase(int p_i1971_1_) {
		super(p_i1971_1_);
		this.setPlanetForBiome(ZGPlanets.planetZollus);
		this.enableRain = false;
		this.enableSnow = true;
		this.setColor(BiomeList.biomeColor);
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.biomeDecor.zollusCrystalsPerChunk = 2;
		this.biomeDecor.zollusIceLakesPerChunk = 4;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = BlockList.zolarBlock;
		this.fillerBlock = BlockList.zolDirt;
		this.stoneBlock = BlockList.zolstone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeGenZollusBase setColor(int var1) {
		return (BiomeGenZollusBase) super.setColor(var1);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorZollus();
	}
	
	protected BiomeDecoratorZollus getBiomeDecorator() {
		return (BiomeDecoratorZollus) this.theBiomeDecorator;
	}
	
	public void genZollusBiomeTerrain(World world, Random rand, Block[] block,
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
								fillerBlock = BlockList.zolarBlock;
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
									topBlock = Blocks.ice;
									topMeta = 0;
								}
							}
							
							currentFillerDepth = maxFillerDepth;
							
							if (y >= seaLevel - 2) {
								block[index] = topBlock;
								meta[index] = topMeta;
							} else if (y < seaLevel - 8 - maxFillerDepth) {
								topBlock = null;
								fillerBlock = BlockList.zolCobbleRock;
								fillerMeta = 0;
								block[index] = BlockList.zolstone;
							} else {
								block[index] = fillerBlock;
								meta[index] = fillerMeta;
							}
						} else if (currentFillerDepth > 0) {
							currentFillerDepth--;
							block[index] = fillerBlock;
							meta[index] = fillerMeta;
							
							if (currentFillerDepth == 0
									&& fillerBlock == BlockList.zolDirt) {
								currentFillerDepth = rand.nextInt(4)
										+ Math.max(0, y - (seaLevel - 1));
								fillerBlock = BlockList.zolstone;
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
		this.genZollusBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
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