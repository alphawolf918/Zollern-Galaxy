/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.candora;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeJollyWatermelonPlains extends BiomeCandoraBase {
	
	public BiomeJollyWatermelonPlains(BiomeProperties props) {
		super("jollywatermelon", props);
		props.setBaseHeight(1.5F);
		props.setHeightVariation(0.1F);
		props.setTemperature(5.4F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5.2F);
		this.setBiomeHeight(53);
		this.setBiomeType(EnumBiomeTypeZG.SWEET);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.chocolateLakesPerChunk = 0;
		this.grassFoliageColor = 0x9f9f00;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.candyCubeGreen.getDefaultState();
		this.fillerBlock = ZGBlocks.candyCubeRed.getDefaultState();
		this.stoneBlock = ZGBlocks.candyCubeGray;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff002e;
	}
}