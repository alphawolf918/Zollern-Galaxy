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
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.xantheon.WorldGenRadiolariaSpouts;

public class BiomeDecoratorXantheon extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.xantheonStone;
	
	private WorldGenerator chromeGen;
	private WorldGenerator ironGen;
	private WorldGenerator copperGen;
	private WorldGenerator coalGen;
	private WorldGenerator nickelGen;
	private WorldGenerator plutoniumGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator constructGen;
	
	public boolean generateLakes = true;
	public boolean generateSpouts = true;
	
	public int whiteLavaLakesPerChunk = 2;
	
	public BiomeDecoratorXantheon() {
		this.chromeGen = new WorldGenMinableZG(ZGBlocks.xantheonChrome, ZGBlocks.xantheonRock, EnumOreGenZG.DIRT.setBlockCount(45));
		this.ironGen = new WorldGenMinableZG(ZGBlocks.xantheonIronOre, STONE, EnumOreGenZG.IRON);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.xantheonCopperOre, STONE, EnumOreGenZG.COPPER);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.xantheonCoalOre, STONE, EnumOreGenZG.COAL);
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.xantheonNickelOre, STONE, EnumOreGenZG.NICKEL);
		this.plutoniumGen = new WorldGenMinableZG(ZGBlocks.xantheonPlutoniumOre, STONE, EnumOreGenZG.PLUTONIUM);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.xantheonFueltoniumOre, STONE, EnumOreGenZG.FUELTONIUM);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.xantheonAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.constructGen = new WorldGenMinableZG(ZGBlocks.xantheonConstructBlock, STONE, EnumOreGenZG.CONSTRUCTED);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.chromeGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.nickelGen, EnumOreGenZG.NICKEL, world, rand);
		this.generateOre(this.plutoniumGen, EnumOreGenZG.PLUTONIUM, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.constructGen, EnumOreGenZG.CONSTRUCTED, world, rand);
		
		int genY = 248;
		int y = genY;
		
		if (this.generateLakes && this.whiteLavaLakesPerChunk > 0) {
			for (int i = 0; i < this.whiteLavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(150) <= 10) {
					if (y <= 62) {
						(new WorldGenLakesZG(ZGFluids.blockWhiteLavaFluid, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Radiolaria Spouts
		if (this.generateSpouts) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (rand.nextInt(100) <= 5) {
				if (y >= 70 && y <= 90) {
					(new WorldGenRadiolariaSpouts()).generate(world, rand, this.chunkPos.add(x, y, z));
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