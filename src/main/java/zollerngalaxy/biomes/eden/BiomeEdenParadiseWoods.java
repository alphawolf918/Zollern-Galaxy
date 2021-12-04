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

public class BiomeEdenParadiseWoods extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeEdenParadiseWoods(BiomeProperties props) {
		super("paradisewoods", props);
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(2.5F);
		props.setTemperature(1.0F);
		this.setTemp(4F);
		this.setBiomeHeight(62);
		this.setBiomeType(EnumBiomeTypeZG.FOREST);
		this.enableSnow = false;
		this.biomeDecor.generatePumpkins = true;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateVines = false;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.edenTallGrassPerChunk = 8;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.biomeDecor.edenFallTreesPerChunk = 10;
		this.biomeDecor.edenGoldTreesPerChunk = 6;
		this.biomeDecor.edenLoveTreesPerChunk = 4;
		this.biomeDecor.edenPumpkinsPerChunk = 2;
		this.grassFoilageColorMultiplier = 0x8b0000;
		this.waterColor = 0x00008b;
		this.topBlock = ZGBlocks.edenFallGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff8b00;
	}
}