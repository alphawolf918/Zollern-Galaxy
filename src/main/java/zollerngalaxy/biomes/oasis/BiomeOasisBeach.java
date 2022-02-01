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

public class BiomeOasisBeach extends BiomeOasisBase {
	
	public BiomeOasisBeach(BiomeProperties props) {
		super("oasisbeach", props);
		props.setBaseHeight(0.2F);
		props.setHeightVariation(0.1F);
		props.setTemperature(6.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.0F);
		this.setBiomeHeight(5);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.setBlocks(ZGBlocks.oasisSand, ZGBlocks.mudClayBlock);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.generateCrops = false;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.cropsPerChunk = 0;
		this.biomeDecor.oilLakesPerChunk = 6;
		this.grassFoliageColor = 0x9f0000;
		this.waterColor = 0x8b2cff;
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x8b4fb6;
	}
}