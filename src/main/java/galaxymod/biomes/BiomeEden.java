package galaxymod.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeEden extends BiomeGenBase {
	public BiomeEden(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setHeight(height_MidHills);
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.flowersPerChunk = 2;
		this.theBiomeDecorator.treesPerChunk = 1;
		this.waterColorMultiplier = 0x00008b;
		this.temperature = 4F;
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
	}
}