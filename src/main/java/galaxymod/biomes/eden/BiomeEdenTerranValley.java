package galaxymod.biomes.eden;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;
import galaxymod.mobs.entities.EntityMoolus;

import java.util.Random;

import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenTerranValley extends BiomeGenEdenBase {
	public BiomeEdenTerranValley(int par1) {
		super(par1);
		this.setBiomeName("Terran Valley");
		this.setChunkHeightModifier(4);
		this.setHeight(new Height(0.9F, 1.2F));
		this.theBiomeDecorator.generateLakes = true;
		this.getBiomeDecorator().edenTallGrassPerChunk = 4;
		this.getBiomeDecorator().edenFlowersPerChunk = 6;
		this.grassFoilageColorMultiplier = 0x0000bf;
		this.waterColorMultiplier = 0x00008b;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMoolus.class,
				2, 2, 2));
		this.temperature = 6F;
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
			NGHelper.genEdenFlowers(p_76728_1_, p_76728_2_, p_76728_3_,
					p_76728_4_);
		}
	}
}