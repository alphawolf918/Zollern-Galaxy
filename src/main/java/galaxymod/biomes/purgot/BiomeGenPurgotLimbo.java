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

package galaxymod.biomes.purgot;

import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenPurgotLimbo extends BiomeGenPurgotBase {
	
	public BiomeGenPurgotLimbo(int par1) {
		super(par1);
		this.setBiomeName("Limbo");
		this.setTemp(1F);
		this.grassFoilageColorMultiplier = 0xbfbfbf;
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 0x000000;
		this.topBlock = BlockList.purgWhiteRock;
		this.fillerBlock = BlockList.purgRock;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f4f4f;
	}
	
}