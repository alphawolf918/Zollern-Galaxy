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

public class BiomeRedlands extends BiomeOasisBase {
	
	public BiomeRedlands(BiomeProperties props) {
		super("redlands", props);
		props.setBaseHeight(1.5F);
		props.setHeightVariation(1.0F);
		props.setTemperature(4.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(4.0F);
		this.setBiomeHeight(15);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.grassFoliageColor = 0x9fcc8b;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.oasisRock.getDefaultState();
		this.fillerBlock = ZGBlocks.oasisGravel.getDefaultState();
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4f2e;
	}
}