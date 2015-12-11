package galaxymod.biomes.zollus;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.blocks.BlockList;
import galaxymod.core.NGCore;

public class BiomeZollus extends BiomeSpace {
	public BiomeZollus(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Ice Lands");
		this.topBlock = BlockList.solarBlock;
		this.fillerBlock = BlockList.solarBlock;
		this.setPlanetForBiome(NGCore.zollus);
	}
}