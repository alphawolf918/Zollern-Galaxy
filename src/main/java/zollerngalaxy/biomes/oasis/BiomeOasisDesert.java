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

public class BiomeOasisDesert extends BiomeOasisBase {
	
	public BiomeOasisDesert(BiomeProperties props) {
		super("oasis_desert", props);
		props.setBaseHeight(2.2F);
		props.setHeightVariation(1.6F);
		props.setTemperature(9.5F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(56.0F);
		this.setBiomeHeight(56);
		this.setBiomeType(EnumBiomeTypeZG.BEACH);
		this.setBlocks(ZGBlocks.oasisSand, ZGBlocks.oasisRock);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.generateCrops = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.cropsPerChunk = 2;
		this.biomeDecor.oilLakesPerChunk = 10;
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