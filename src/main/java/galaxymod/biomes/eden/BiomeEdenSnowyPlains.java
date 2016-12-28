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

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;

public class BiomeEdenSnowyPlains extends BiomeGenEdenBase {
	
	public BiomeEdenSnowyPlains(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Snowy Plains");
		this.setEnableSnow();
		this.temperature = 1F;
		this.theBiomeDecorator.generateLakes = true;
		this.biomeDecor.edenGravPerChunk = 4;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 4;
		this.biomeDecor.edenLakesPerChunk = 4;
		this.biomeDecor.edenSandPerChunk = 1;
		this.biomeDecor.edenWoodTreesPerChunk = 5;
		this.topBlock = BlockList.edenWinterRock;
		this.fillerBlock = BlockList.edenSoil;
	}
}