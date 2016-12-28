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

package galaxymod.biomes.decorators.ore;

import galaxymod.biomes.eden.BiomeGenEdenBase;
import galaxymod.blocks.BlockList;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorEdenOre extends BiomeDecoratorOre {
	
	private World worldObj;
	private Random randomGenerator;
	
	private int chunkX;
	private int chunkZ;
	
	private WorldGenerator copperGen;
	private WorldGenerator tinGen;
	private WorldGenerator ironGen;
	private WorldGenerator meteoricIronGen;
	private WorldGenerator goldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator coalGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator lapisGen;
	private WorldGenerator deshGen;
	private WorldGenerator aluminumGen;
	private WorldGenerator viriniumGen;
	
	private WorldGenerator gravelGen;
	
	public BiomeDecoratorEdenOre() {
		this.ironGen = new WorldGenMinableMeta(BlockList.edenIronOre, 5, 0,
				false, BlockList.edenRock, 0);
		this.meteoricIronGen = new WorldGenMinableMeta(
				BlockList.edenMeteoricIronOre, 2, 0, false, BlockList.edenRock,
				0);
		this.copperGen = new WorldGenMinableMeta(BlockList.edenCopperOre, 8, 0,
				false, BlockList.edenRock, 0);
		this.tinGen = new WorldGenMinableMeta(BlockList.edenTinOre, 10, 0,
				false, BlockList.edenRock, 0);
		this.diamondGen = new WorldGenMinableMeta(BlockList.edenDiamondOre, 4,
				0, false, BlockList.edenRock, 0);
		this.emeraldGen = new WorldGenMinableMeta(BlockList.edenEmeraldOre, 4,
				0, false, BlockList.edenRock, 0);
		this.goldGen = new WorldGenMinableMeta(BlockList.edenGoldOre, 6, 0,
				false, BlockList.edenRock, 0);
		this.coalGen = new WorldGenMinableMeta(BlockList.edenCoalOre, 10, 0,
				false, BlockList.edenRock, 0);
		this.redstoneGen = new WorldGenMinableMeta(BlockList.edenRedstoneOre,
				6, 0, false, BlockList.edenRock, 0);
		this.lapisGen = new WorldGenMinableMeta(BlockList.edenLapisOre, 8, 0,
				false, BlockList.edenRock, 0);
		this.deshGen = new WorldGenMinableMeta(BlockList.edenDeshOre, 5, 0,
				false, BlockList.edenRock, 0);
		this.aluminumGen = new WorldGenMinableMeta(BlockList.edenAluminumOre,
				10, 0, false, BlockList.edenRock, 0);
		this.viriniumGen = new WorldGenMinableMeta(BlockList.edenViriOre, 5, 0,
				false, BlockList.edenRock, 0);
		this.gravelGen = new WorldGenMinableMeta(BlockList.edenGravel, 10, 0,
				false, BlockList.edenRock, 0);
	}
	
	@Override
	public void decorate(World worldObj, Random rand, int chunkX, int chunkZ) {
		if (this.worldObj != null) {
			throw new RuntimeException("Already decorating!!");
		} else {
			this.worldObj = worldObj;
			this.randomGenerator = rand;
			this.chunkX = chunkX;
			this.chunkZ = chunkZ;
			//
			BiomeGenBase currentBiome = worldObj.getBiomeGenForCoords(chunkX,
					chunkZ);
			if (currentBiome instanceof BiomeGenEdenBase) {
				this.genOre(10, this.ironGen, 4, 60);
				this.genOre(5, this.meteoricIronGen, 10, 20);
				this.genOre(7, this.goldGen, 4, 75);
				this.genOre(5, this.diamondGen, 10, 14);
				this.genOre(4, this.emeraldGen, 10, 12);
				this.genOre(5, this.copperGen, 4, 120);
				this.genOre(6, this.tinGen, 4, 120);
				this.genOre(8, this.coalGen, 2, 40);
				this.genOre(7, this.redstoneGen, 2, 25);
				this.genOre(7, this.lapisGen, 2, 25);
				this.genOre(5, this.deshGen, 4, 30);
				this.genOre(10, this.aluminumGen, 2, 72);
				this.genOre(6, this.viriniumGen, 4, 12);
				this.genOre(5, this.gravelGen, 4, 52);
			}
			//
			this.worldObj = null;
			this.randomGenerator = null;
		}
	}
	
	void genOre(int amountPerChunk, WorldGenerator worldGenerator, int minY,
			int maxY) {
		for (int var5 = 0; var5 < amountPerChunk; ++var5) {
			final int var6 = this.chunkX + this.randomGenerator.nextInt(16);
			final int var7 = this.randomGenerator.nextInt(maxY - minY) + minY;
			final int var8 = this.chunkZ + this.randomGenerator.nextInt(16);
			worldGenerator.generate(this.worldObj, this.randomGenerator, var6,
					var7, var8);
		}
	}
	
	@Override
	protected void setCurrentWorld(World world) {
		this.worldObj = world;
	}
	
	@Override
	protected World getCurrentWorld() {
		return this.worldObj;
	}
}
