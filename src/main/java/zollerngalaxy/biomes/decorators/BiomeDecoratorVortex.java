/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenZGCrystals;

public class BiomeDecoratorVortex extends BiomeDecoratorZG {
	
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator copperGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator eveniumGen;
	
	public int stormCrystalsPerChunk = 2;
	public int chargiumLakesPerChunk = (this.enableExtremeMode) ? 2 : 1;
	
	public boolean generateStormCrystals = true;
	public boolean generateChargiumLakes = true;
	
	private WorldGenerator stormCrystalsGen = new WorldGenZGCrystals(ZGBlocks.blockCrystalsStorm.getDefaultState());
	private WorldGenerator chargiumLakeGen = new WorldGenLakesZG(ZGFluids.blockChargiumFluid, ZGBlocks.vortexStone);
	
	public BiomeDecoratorVortex() {
		this.ironGen = new WorldGenMinableZG(ZGBlocks.vortexIronOre, ZGBlocks.vortexStone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.vortexGoldOre, ZGBlocks.vortexStone, EnumOreGenZG.GOLD);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.vortexCopperOre, ZGBlocks.vortexStone, EnumOreGenZG.COPPER);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.vortexRedstoneOre, ZGBlocks.vortexStone, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.vortexDiamondOre, ZGBlocks.vortexStone, EnumOreGenZG.DIAMOND);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.vortexSuperChargedCoalOre, ZGBlocks.vortexStone, EnumOreGenZG.SUPER_CHARGED_COAL.setGenCount(15));
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.vortexFueltoniumOre, ZGBlocks.vortexStone, EnumOreGenZG.FUELTONIUM.setBlockCount(10));
		this.eveniumGen = new WorldGenMinableZG(ZGBlocks.vortexEveniumOre, ZGBlocks.vortexStone, EnumOreGenZG.EVENIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		int y = rand.nextInt(248) + 8;
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.eveniumGen, EnumOreGenZG.EVENIUM, world, rand);
		
		int genY = y;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Chargium Lakes
		if (this.generateChargiumLakes && this.chargiumLakesPerChunk > 0) {
			for (int i = 0; i < this.chargiumLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt((this.enableExtremeMode) ? 80 : 100) <= 10) {
					if (y <= 82) {
						this.chargiumLakeGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Storm Crystals
		if (this.generateStormCrystals && this.stormCrystalsPerChunk > 0) {
			if (ZGHelper.rngInt(1, 100) <= 65) {
				for (int i = 0; i < this.stormCrystalsPerChunk; ++i) {
					ZGDecorateHelper.generateCrystals(stormCrystalsGen, world, rand, this.chunkPos);
				}
			}
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				WorldGenerator outpostGen = new WorldGenOutpost(ZGBlocks.blockOutpost.getDefaultState(), ZGBlocks.blockOutpost.getDefaultState());
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt(100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}