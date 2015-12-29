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

package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;

public class BiomeEdenSnowyPlains extends BiomeGenEdenBase {
	public BiomeEdenSnowyPlains(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Snowy Plains");
		this.setEnableSnow();
		this.setHeightBaseModifier(196);
		this.setChunkHeightModifier(5);
		this.setHeight(new Height(0.1F, 0.2F));
		this.temperature = 1F;
		this.theBiomeDecorator.generateLakes = true;
		this.biomeDecor.edenGravPerChunk = 4;
		this.biomeDecor.edenFlowersPerChunk = 3;
		this.biomeDecor.edenTallGrassPerChunk = 2;
		this.biomeDecor.edenLakesPerChunk = 2;
		this.biomeDecor.edenSandPerChunk = 1;
		this.biomeDecor.edenWoodTreesPerChunk = 5;
		this.topBlock = BlockList.edenWinterRock;
		this.fillerBlock = BlockList.edenSoil;
	}
}