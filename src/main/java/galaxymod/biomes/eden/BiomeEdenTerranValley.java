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
import galaxymod.utils.NovaHelper;
import java.util.Random;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenTerranValley extends BiomeGenEdenBase {
	public BiomeEdenTerranValley(int par1) {
		super(par1);
		this.setBiomeName("Terran Valley");
		this.setHeightBaseModifier(196);
		this.setChunkHeightModifier(4);
		this.theBiomeDecorator.generateLakes = true;
		this.biomeDecor.edenTallGrassPerChunk = 4;
		this.biomeDecor.edenFlowersPerChunk = 6;
		this.grassFoilageColorMultiplier = 0x00008b;
		this.waterColorMultiplier = 0x00008b;
		this.temperature = 4F;
		this.topBlock = BlockList.edenGrass;
		this.fillerBlock = BlockList.edenSoil;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
	
	@Override
	public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_,
			int p_76728_4_) {
		super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
		for (int i = 0; i < 5; i++) {
			NovaHelper.genEdenFlowers(p_76728_1_, p_76728_2_, p_76728_3_,
					p_76728_4_);
		}
	}
}