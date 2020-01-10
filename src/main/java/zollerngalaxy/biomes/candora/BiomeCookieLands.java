package zollerngalaxy.biomes.candora;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCookieLands extends BiomeCandoraBase {
	
	public BiomeCookieLands(BiomeProperties props) {
		super("cookielands", props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.0F);
		props.setTemperature(7.4F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(7.4F);
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.SWEET);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.chocolateLakesPerChunk = 0;
		this.grassFoliageColor = 0x3c9b59;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.blockCookie.getDefaultState();
		this.fillerBlock = ZGBlocks.candyCubeBrown.getDefaultState();
		this.stoneBlock = ZGBlocks.candyCubeGray;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xd36c2e;
	}
}