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

public class BiomeEdenwoodForest extends BiomeEdenBase {
	
	public BiomeEdenwoodForest(BiomeProperties props) {
		super("edenwoodforest", props);
		props.setBaseHeight(1.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(5.5F);
		this.setTemp(5.4F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.FOREST);
		this.decorator.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.generateVines = false;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 8;
		this.biomeDecor.edenTreesPerChunk = 90;
		this.biomeDecor.waterLakesPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 14;
		this.enableSnow = true;
		this.grassFoliageColor = 0x00ff00;
		this.waterColor = 0x0000ff;
		this.topBlock = ZGBlocks.edenGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004a4b;
	}
	
}