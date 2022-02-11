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

public class BiomeGreenLands extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeGreenLands(BiomeProperties props) {
		super("greenlands", props);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.8F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5F);
		this.setBiomeHeight(50);
		this.setBiomeType(EnumBiomeTypeZG.NORMAL);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 4;
		this.biomeDecor.tallGrassPerChunk = 0;
		this.biomeDecor.flowersPerChunk = 0;
		this.biomeDecor.treesPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x009f9f;
		this.topBlock = ZGBlocks.edenSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}
}