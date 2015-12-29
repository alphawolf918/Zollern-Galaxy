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

import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenGarden extends BiomeGenEdenBase {
	
	public BiomeEdenGarden(int p_i1985_1_) {
		super(p_i1985_1_);
		this.setBiomeName("Garden of Eden");
		this.setColor(112);
		this.setHeightBaseModifier(200);
		this.setHeight(new Height(0.2F, 0.2F));
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