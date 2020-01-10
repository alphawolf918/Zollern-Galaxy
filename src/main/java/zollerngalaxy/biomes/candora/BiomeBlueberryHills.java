package zollerngalaxy.biomes.candora;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeBlueberryHills extends BiomeCandoraBase {
	
	public BiomeBlueberryHills(BiomeProperties props) {
		super("blueberryhills", props);
		props.setBaseHeight(2.5F);
		props.setHeightVariation(1.1F);
		props.setTemperature(4.4F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(4.4F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.SWEET);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.chocolateLakesPerChunk = 0;
		this.grassFoliageColor = 0x0099ff;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.candyCubeBlue.getDefaultState();
		this.fillerBlock = ZGBlocks.candyCubeCyan.getDefaultState();
		this.stoneBlock = ZGBlocks.candyCubeGray;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00002e;
	}
}