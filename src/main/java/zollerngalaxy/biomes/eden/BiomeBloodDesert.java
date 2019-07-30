package zollerngalaxy.biomes.eden;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;

public class BiomeBloodDesert extends BiomeGenEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeBloodDesert(BiomeProperties props) {
		super("blooddesert", props);
		props.setRainDisabled();
		props.setBaseHeight(3.2F);
		props.setHeightVariation(0.4F);
		props.setTemperature(8.0F);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(8.0F);
		this.setBiomeHeight(102);
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.decorator.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.deadBushPerChunk = 4;
		this.biomeDecor.waterLakesPerChunk = 3;
		this.enableSnow = false;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x00009f;
		this.topBlock = ZGBlocks.edenBloodSand.getDefaultState();
		this.fillerBlock = ZGBlocks.edenBloodStone.getDefaultState();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}
}