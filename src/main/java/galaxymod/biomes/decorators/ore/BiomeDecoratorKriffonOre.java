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

import galaxymod.blocks.BlockList;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecoratorKriffonOre extends BiomeDecoratorOre {
	
	private World worldObj;
	private Random randomGenerator;
	
	private int chunkX;
	private int chunkZ;
	
	private WorldGenerator coalGen;
	private WorldGenerator copperGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator cobaltGen;
	
	public BiomeDecoratorKriffonOre() {
		this.coalGen = new WorldGenMinableMeta(BlockList.kriffCoalOre, 10, 0,
				false, BlockList.kriffStone, 0);
		this.copperGen = new WorldGenMinableMeta(BlockList.kriffCopperOre, 8,
				0, false, BlockList.kriffStone, 0);
		this.redstoneGen = new WorldGenMinableMeta(BlockList.kriffRedstoneOre,
				8, 0, false, BlockList.kriffStone, 0);
		this.ironGen = new WorldGenMinableMeta(BlockList.kriffIronOre, 5, 0,
				false, BlockList.kriffStone, 0);
		this.goldGen = new WorldGenMinableMeta(BlockList.kriffGoldOre, 5, 0,
				false, BlockList.kriffStone, 0);
		this.cobaltGen = new WorldGenMinableMeta(BlockList.kriffCobaltOre, 5,
				0, false, BlockList.kriffStone, 0);
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
			this.genOre(10, this.coalGen, 4, 70);
			this.genOre(6, this.copperGen, 4, 70);
			this.genOre(11, this.redstoneGen, 2, 50);
			this.genOre(8, this.ironGen, 4, 60);
			this.genOre(6, this.goldGen, 4, 50);
			this.genOre(8, this.cobaltGen, 2, 35);
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
