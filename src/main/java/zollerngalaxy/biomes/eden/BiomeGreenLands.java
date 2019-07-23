package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class BiomeGreenLands extends BiomeGenEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeGreenLands(BiomeProperties props) {
		super("greenlands", props);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.8F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5F);
		this.setBiomeHeight(72);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.edenTallGrassPerChunk = 1;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x009f9f;
		this.topBlock = ZGBlocks.edenSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, LUSH, WET);
	}
}