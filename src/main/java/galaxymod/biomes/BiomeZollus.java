package galaxymod.biomes;

import galaxymod.blocks.BlockList;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeZollus extends BiomeGenBase {
	public BiomeZollus(int par1){
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.topBlock = BlockList.solarBlock;
		this.fillerBlock = BlockList.solarBlock;
	}
}