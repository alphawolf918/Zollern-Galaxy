/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;
import galaxymod.mobs.entities.EntityMoolus;

import java.util.Random;

import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEden extends BiomeGenNovaBase {
	public BiomeEden(int par1) {
		super(par1);
		this.setBiomeName("Green Lands");
		this.theBiomeDecorator.generateLakes = true;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColorMultiplier = 0x009f9f;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMoolus.class,
				16, 2, 3));
		this.temperature = 6F;
		this.topBlock = BlockList.edenSurfaceRock;
		this.fillerBlock = BlockList.edenSoil;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}

	@Override
	public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_,
			int p_76728_4_) {
		super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
		for (int i = 0; i < 5; i++) {
			NGHelper.genEdenFlowers(p_76728_1_, p_76728_2_, p_76728_3_,
					p_76728_4_);
		}
	}
}