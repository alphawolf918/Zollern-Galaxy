/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.eden;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeAsteroidCraters extends BiomeEdenBase {
	
	public BiomeAsteroidCraters(BiomeProperties props) {
		super("craters", props);
		props.setRainDisabled();
		props.setBaseHeight(0.1F);
		props.setHeightVariation(0.1F);
		props.setTemperature(6.5F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(6.5F);
		this.setBiomeHeight(42);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCraters = true;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x000000;
		this.topBlock = ZGBlocks.blockCrater.getDefaultState();
		this.fillerBlock = ZGBlocks.blockCrater.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff2ad8;
	}
}