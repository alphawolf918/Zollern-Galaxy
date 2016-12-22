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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenGarden extends BiomeGenEdenBase {
	
	public BiomeEdenGarden(int p_i1985_1_) {
		super(p_i1985_1_);
		this.setBiomeName("Garden of Eden");
		this.setColor(BiomeList.biomeColor);
		this.temperature = 5F;
		this.grassFoilageColorMultiplier = 0x009f8d;
		this.biomeDecor.waterlilyPerChunk = 2;
		this.biomeDecor.edenFlowersPerChunk = 400;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = BlockList.edenGrass;
		this.fillerBlock = BlockList.edenSoil;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x002ef4;
	}
}