/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.perdita;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class BiomeLostMountains extends BiomePerditaBase {
	
	private float temp = ZGHelper.rngInt(16, 28);
	
	public BiomeLostMountains(BiomeProperties props) {
		super("lostmountains", props);
		props.setBaseHeight(2.1F);
		props.setHeightVariation(1.2F);
		props.setTemperature(temp);
		this.setTemp(temp);
		this.setBiomeHeight(63);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.lostCactiPerChunk = 0;
		this.biomeDecor.lostDeadBushPerChunk = 0;
		this.grassFoliageColor = 0x9f00ff;
		this.waterColor = 0x1b2cff;
		this.topBlock = ZGBlocks.perdStone.getDefaultState();
		this.fillerBlock = ZGBlocks.perdCobble.getDefaultState();
		this.stoneBlock = ZGBlocks.perdStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4f2e;
	}
}