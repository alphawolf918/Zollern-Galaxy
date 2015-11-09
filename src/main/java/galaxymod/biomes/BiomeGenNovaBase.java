/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public abstract class BiomeGenNovaBase extends BiomeGenBase {

	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;

	public BiomeGenNovaBase(int p_i1971_1_) {
		super(p_i1971_1_);
		this.setColor(BiomeList.biomeColor);
		this.setHeight(height_HighPlateaus);
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
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