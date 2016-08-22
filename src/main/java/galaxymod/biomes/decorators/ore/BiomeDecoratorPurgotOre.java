/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.biomes.decorators.ore;

import galaxymod.blocks.BlockList;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class BiomeDecoratorPurgotOre extends BiomeDecoratorNova {
	
	private World worldObj;
	private Random randomGenerator;
	
	private int chunkX;
	private int chunkZ;
	
	private WorldGenerator copperGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator eveniumGen;
	private WorldGenerator cobaltGen;
	
	public BiomeDecoratorPurgotOre() {
		this.copperGen = new WorldGenMinableMeta(BlockList.purgCopperOre, 8, 0,
				false, BlockList.purgStone, 0);
		this.ironGen = new WorldGenMinableMeta(BlockList.purgIronOre, 6, 0,
				false, BlockList.purgStone, 0);
		this.goldGen = new WorldGenMinableMeta(BlockList.purgGoldOre, 6, 0,
				false, BlockList.purgStone, 0);
		this.diamondGen = new WorldGenMinableMeta(BlockList.purgDiamondOre, 2,
				0, false, BlockList.purgStone, 0);
		this.emeraldGen = new WorldGenMinableMeta(BlockList.purgEmeraldOre, 2,
				0, false, BlockList.purgStone, 0);
		this.eveniumGen = new WorldGenMinableMeta(BlockList.purgEveOre, 3, 0,
				false, BlockList.purgStone, 0);
		this.cobaltGen = new WorldGenMinableMeta(BlockList.purgCobaltOre, 3, 0,
				false, BlockList.purgStone, 0);
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
			this.generatePurgot();
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
	
	void generatePurgot() {
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Pre(
				this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
		this.genOre(6, this.copperGen, 4, 70);
		this.genOre(10, this.ironGen, 4, 60);
		this.genOre(8, this.goldGen, 4, 50);
		this.genOre(6, this.diamondGen, 2, 14);
		this.genOre(4, this.emeraldGen, 2, 10);
		this.genOre(5, this.eveniumGen, 2, 14);
		this.genOre(5, this.cobaltGen, 2, 14);
		MinecraftForge.EVENT_BUS.post(new GCCoreEventPopulate.Post(
				this.worldObj, this.randomGenerator, this.chunkX, this.chunkZ));
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