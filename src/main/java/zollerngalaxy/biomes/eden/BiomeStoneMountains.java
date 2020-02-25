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

public class BiomeStoneMountains extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeStoneMountains(BiomeProperties props) {
		super("stonemountains", props);
		props.setRainDisabled();
		props.setBaseHeight(4.0F);
		props.setHeightVariation(0.6F);
		props.setTemperature(7.2F);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(7.2F);
		this.setBiomeHeight(120);
		this.setBiomeType(EnumBiomeTypeZG.ROCKY);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 1;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x0000ff;
		this.topBlock = ZGBlocks.edenStone.getDefaultState();
		this.fillerBlock = ZGBlocks.edenCobbleRock.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2ad8;
	}
}