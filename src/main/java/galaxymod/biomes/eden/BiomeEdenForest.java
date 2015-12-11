/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenForest extends BiomeEdenTerranValley {
	
	public static int grassFoilageColorMultiplier = 0x00ff4a;
	
	public BiomeEdenForest(int p_i1971_1_) {
		super(p_i1971_1_);
		this.setBiomeName("Edenwood Forest");
		this.setColor(BiomeList.biomeColor);
		this.enableRain = true;
		this.enableSnow = true;
		this.temperature = 5F;
		this.biomeDecor.edenWoodTreesPerChunk = 1600;
		this.biomeDecor.edenTallGrassPerChunk = 1;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = BlockList.edenGrass;
		this.fillerBlock = BlockList.edenSoil;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004a4b;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}