package zollerngalaxy.biomes.eden;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeEdenOcean extends BiomeGenEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x00ff00;
	
	public BiomeEdenOcean(BiomeProperties props) {
		super("edenocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(8.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(5.0F);
		this.setBiomeHeight(63);
		this.clearAllNonMonsterSpawning();
		this.biomeDecor.edenTallGrassPerChunk = 6;
		this.biomeDecor.edenFlowersPerChunk = 5;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateTowers = false;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.deadBushPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 6;
		this.enableSnow = false;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x00009f;
		this.topBlock = Blocks.AIR.getDefaultState();
		this.fillerBlock = Blocks.AIR.getDefaultState();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00002e;
	}
}