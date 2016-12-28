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

public class BiomeEdenBloodDesert extends BiomeGenEdenBase {
	
	public BiomeEdenBloodDesert(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Blood Desert");
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.biomeDecor.edenDeadBushPerChunk = 2;
		this.waterColorMultiplier = 0x00009f;
		this.temperature = 8F;
		this.topBlock = BlockList.edenBloodSand;
		this.fillerBlock = BlockList.edenBloodStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}