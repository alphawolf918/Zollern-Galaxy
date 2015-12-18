/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.zollus;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.biomes.decorators.BiomeDecoratorZollus;
import galaxymod.blocks.BlockList;
import galaxymod.core.NGCore;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;

public abstract class BiomeGenZollusBase extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public static int biomeHeightBaseModifier = 232;
	public BiomeDecoratorZollus biomeDecor = this.getBiomeDecorator();
	public static ArrayList<BiomeGenZollusBase> edenBiomes = new ArrayList();
	
	public BiomeGenZollusBase(int p_i1971_1_) {
		super(p_i1971_1_);
		this.setPlanetForBiome(NGCore.zollus);
		this.enableRain = true;
		this.enableSnow = true;
		this.setColor(BiomeList.biomeColor);
		this.setHeight(new Height(0.4F, 0.5F));
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.biomeDecor.zollusCrystalsPerChunk = 2;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.stoneBlock = BlockList.zolstone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public void setHeightBaseModifier(int bioHeight) {
		this.biomeHeightBaseModifier = bioHeight;
	}
	
	@Override
	public int getHeightBaseModifier() {
		return this.biomeHeightBaseModifier;
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
		int seaLevel = 35;
		
		for (int y = this.getHeightBaseModifier(); y >= 0; y--) {
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
									topBlock = Blocks.ice;
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
								fillerBlock = BlockList.zolarBlock;
								fillerMeta = 0;
								block[index] = BlockList.zolCobbleRock;
							} else {
								block[index] = fillerBlock;
								meta[index] = fillerMeta;
							}
						} else if (currentFillerDepth > 0) {
							currentFillerDepth--;
							block[index] = fillerBlock;
							meta[index] = fillerMeta;
							
							if (currentFillerDepth == 0
									&& fillerBlock == BlockList.zolarBlock) {
								currentFillerDepth = rand.nextInt(4)
										+ Math.max(0, y - (seaLevel - 1));
								fillerBlock = BlockList.zolCobbleRock;
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
	
	public static void setChunkHeightModifier(int heightMod) {
		chunkHeightModifier = heightMod;
	}
	
	public static int getChunkHeightModifier() {
		return chunkHeightModifier;
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