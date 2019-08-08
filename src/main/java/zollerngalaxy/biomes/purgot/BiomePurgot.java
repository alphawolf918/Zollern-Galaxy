package zollerngalaxy.biomes.purgot;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomePurgot extends BiomePurgotBase {
	
	public BiomePurgot(BiomeProperties props) {
		super("purgot", props);
		props.setRainDisabled();
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.8F);
		props.setTemperature(5.0F);
		this.setTemp(5F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.DARK);
		this.enableSnow = true;
		this.topBlock = ZGBlocks.purgSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.purgDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.purgStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
}