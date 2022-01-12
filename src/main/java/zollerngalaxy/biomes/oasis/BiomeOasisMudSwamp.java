/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.oasis;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeOasisMudSwamp extends BiomeOasisBase {
	
	public BiomeOasisMudSwamp(BiomeProperties props) {
		super("oasis_mudswamp", props);
		props.setBaseHeight(1.4F);
		props.setHeightVariation(1.5F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.0F);
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.SWAMP);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.grassFoliageColor = 0x9fcc8b;
		this.waterColor = 0x0000ff;
		this.topBlock = ZGBlocks.mudClayBlock.getDefaultState();
		this.fillerBlock = ZGBlocks.mudClayBlock.getDefaultState();
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4c6fde;
	}
}