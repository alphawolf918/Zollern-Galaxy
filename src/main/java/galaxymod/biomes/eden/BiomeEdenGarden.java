/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.eden;

import galaxymod.blocks.BlockList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenGarden extends BiomeGenEdenBase {
	
	public BiomeEdenGarden(int p_i1985_1_) {
		super(p_i1985_1_);
		this.setBiomeName("Garden of Eden");
		this.setColor(112);
		this.setHeight(new Height(0.5F, 0.5F));
		this.rootHeight = 0F;
		this.heightVariation = 0F;
		this.grassFoilageColorMultiplier = 0x009f8d;
		this.spawnableCreatureList.clear();
		this.getBiomeDecorator().waterlilyPerChunk = 2;
		this.topBlock = Blocks.grass;
		this.fillerBlock = BlockList.edenSoil;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x002ef4;
	}
	
	@Override
	public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_,
			Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_,
			int p_150573_6_, double p_150573_7_) {
		super.genTerrainBlocks(p_150573_1_, p_150573_2_, p_150573_3_,
				p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
	}
}