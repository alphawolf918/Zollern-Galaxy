/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.biomes.perdita;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class BiomeLostOasis extends BiomePerditaBase {
	
	private float temp = ZGHelper.rngInt(16, 26);
	
	public BiomeLostOasis(BiomeProperties props) {
		super("lostoasis", props);
		props.setBaseHeight(0.1F);
		props.setHeightVariation(0.1F);
		props.setTemperature(temp);
		this.setTemp(temp);
		this.setBiomeHeight(23);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = false;
		this.biomeDecor.lostTallGrassPerChunk = 16;
		this.biomeDecor.lostPalmWoodTreesPerChunk = 4;
		this.biomeDecor.lostLakesPerChunk = 7;
		this.biomeDecor.lostReedsPerChunk = 5;
		this.biomeDecor.lostCactiPerChunk = 0;
		this.biomeDecor.lostDeadBushPerChunk = 0;
		this.biomeDecor.lostFueltoniumLakesPerChunk = 0;
		this.grassFoliageColor = 0x9f00ff;
		this.waterColor = 0x1b2cff;
		this.topBlock = ZGBlocks.perdGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.perdDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.perdStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4f2e;
	}
}