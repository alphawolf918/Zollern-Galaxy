package zollerngalaxy.biomes.eden;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;

public class BiomeAsteroidCraters extends BiomeGenEdenBase {
	
	public BiomeAsteroidCraters(BiomeProperties props) {
		super("craters", props);
		props.setRainDisabled();
		props.setBaseHeight(0.1F);
		props.setHeightVariation(0.1F);
		props.setTemperature(6.5F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.5F);
		this.setBiomeHeight(42);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCraters = true;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x000000;
		this.topBlock = ZGBlocks.blockCrater.getDefaultState();
		this.fillerBlock = ZGBlocks.blockCrater.getDefaultState();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff2ad8;
	}
}