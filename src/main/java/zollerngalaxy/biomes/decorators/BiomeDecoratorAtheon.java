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
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;

public class BiomeDecoratorAtheon extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.atheonStone;
	
	private WorldGenerator amaranthGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator tinGen;
	private WorldGenerator diamondGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator zincGen;
	private WorldGenerator constructGen;
	private WorldGenerator goldenConstructGen;
	
	public boolean generateLakes = true;
	
	public int whiteLavaLakesPerChunk = (this.enableExtremeMode) ? 2 : 1;
	
	public BiomeDecoratorAtheon() {
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.atheonAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.atheonRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.atheonTinOre, STONE, EnumOreGenZG.TIN);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.atheonDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.atheonZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.atheonZincOre, STONE, EnumOreGenZG.ZINC);
		this.constructGen = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, STONE, EnumOreGenZG.CONSTRUCTED);
		this.goldenConstructGen = new WorldGenMinableZG(ZGBlocks.atheonConstructBlock, STONE, EnumOreGenZG.CONSTRUCTED.setBlockCount(20));
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.zincGen, EnumOreGenZG.ZINC, world, rand);
		this.generateOre(this.constructGen, EnumOreGenZG.CONSTRUCTED, world, rand);
		this.generateOre(this.goldenConstructGen, EnumOreGenZG.CONSTRUCTED, world, rand);
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		int genY = 248;
		int y = genY;
		
		// Radiolaria Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
			if (this.generateLakes && this.whiteLavaLakesPerChunk > 0) {
				for (int i = 0; i < this.whiteLavaLakesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					
					if (rand.nextInt((this.enableExtremeMode) ? 70 : 130) <= 10) {
						if (y <= 72) {
							(new WorldGenLakesZG(ZGFluids.blockWhiteLavaFluid, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
						}
					}
				}
			}
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