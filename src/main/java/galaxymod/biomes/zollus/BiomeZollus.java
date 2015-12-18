package galaxymod.biomes.zollus;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.core.NGCore;

public class BiomeZollus extends BiomeGenZollusBase {
	public BiomeZollus(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Ice Lands");
		this.topBlock = BlockList.zolarBlock;
		this.fillerBlock = BlockList.zolarBlock;
		this.setPlanetForBiome(NGCore.zollus);
	}
}