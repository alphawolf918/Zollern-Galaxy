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

public class BiomeEdenGoldenMeadow extends BiomeGenEdenBase {
	
	public BiomeEdenGoldenMeadow(int p_i1985_1_) {
		super(p_i1985_1_);
		this.setBiomeName("Golden Meadow");
		this.setColor(BiomeList.biomeColor);
		this.temperature = 4F;
		this.grassFoilageColorMultiplier = 0xffff00;
		this.biomeDecor.waterlilyPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 2;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenWoodTreesPerChunk = 1;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = BlockList.edenGoldenGrass;
		this.fillerBlock = BlockList.edenSoil;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00bbbb;
	}
}