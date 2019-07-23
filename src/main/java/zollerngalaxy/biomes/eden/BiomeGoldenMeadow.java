package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class BiomeGoldenMeadow extends BiomeGenEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeGoldenMeadow(BiomeProperties props) {
		super("goldmeadow", props);
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(2.5F);
		props.setTemperature(4.0F);
		this.setTemp(4F);
		this.setBiomeHeight(52);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.edenTallGrassPerChunk = 5;
		this.biomeDecor.edenFlowersPerChunk = 2;
		this.grassFoilageColorMultiplier = 0x00008b;
		this.waterColor = 0x00008b;
		this.topBlock = ZGBlocks.edenGoldenGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00bbbb;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, LUSH, WET);
	}
}