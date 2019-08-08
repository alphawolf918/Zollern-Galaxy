package zollerngalaxy.biomes.purgot;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeLimbo extends BiomePurgotBase {
	
	public static int grassFoilageColorMultiplier = 0x000000;
	
	public BiomeLimbo(BiomeProperties props) {
		super("limbo", props);
		props.setRainDisabled();
		props.setBaseHeight(2.0F);
		props.setHeightVariation(0.6F);
		props.setTemperature(2.0F);
		this.setTemp(2F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.enableSnow = true;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.topBlock = ZGBlocks.purgBlackRock.getDefaultState();
		this.fillerBlock = ZGBlocks.purgWhiteRock.getDefaultState();
		this.stoneBlock = ZGBlocks.purgStone;
	}
}