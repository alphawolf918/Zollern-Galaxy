/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.kriffus;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.blocks.BlockList;
import galaxymod.core.NGCore;

public class BiomeKriffus extends BiomeSpace {
	
	public BiomeKriffus(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Flaming Plains");
		this.topBlock = BlockList.kriffRock;
		this.fillerBlock = BlockList.kriffRock;
		this.temperature = 11F;
		this.setPlanetForBiome(NGCore.kriffus);
	}
}