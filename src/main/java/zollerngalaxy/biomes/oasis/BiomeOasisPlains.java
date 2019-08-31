package zollerngalaxy.biomes.oasis;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeOasisPlains extends BiomeOasisBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeOasisPlains(BiomeProperties props) {
		super("oasisplains", props);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.8F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x009f9f;
		this.topBlock = ZGBlocks.oasisGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.oasisDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}
}