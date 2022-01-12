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

public class BiomeOasisPlains extends BiomeOasisBase {
	
	public BiomeOasisPlains(BiomeProperties props) {
		super("oasisplains", props);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.0F);
		props.setTemperature(6.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.0F);
		this.setBiomeHeight(53);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.cropsPerChunk = 4;
		this.grassFoliageColor = 0x9f0000;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.oasisGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.oasisDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4f2e;
	}
}