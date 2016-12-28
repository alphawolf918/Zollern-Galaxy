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

package galaxymod.biomes.eden;

import galaxymod.blocks.BlockList;

public class BiomeEdenSwamp extends BiomeGenEdenBase {
	
	public BiomeEdenSwamp(int par1) {
		super(par1);
		this.setBiomeName("Swamplands");
		this.waterColorMultiplier = 0x004422;
		this.grassFoilageColorMultiplier = 0x00aa00;
		this.temperature = 6.5F;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 4;
		this.biomeDecor.edenWoodTreesPerChunk = 25;
		this.biomeDecor.edenSandPerChunk = 2;
		this.biomeDecor.edenLakesPerChunk = 6;
		this.biomeDecor.edenWaterLillyPerChunk = 800;
		this.biomeDecor.edenGravPerChunk = 2;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.theBiomeDecorator.mushroomsPerChunk = 20;
		this.topBlock = BlockList.edenGrass;
		this.fillerBlock = BlockList.edenSoil;
	}
}