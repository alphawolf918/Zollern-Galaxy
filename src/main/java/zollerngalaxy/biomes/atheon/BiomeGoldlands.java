/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.atheon;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeGoldlands extends BiomeAtheonBase {
	
	public BiomeGoldlands(BiomeProperties props) {
		super("goldlands", props);
		props.setBaseHeight(2.5F);
		props.setHeightVariation(1.2F);
		props.setTemperature(10.0F);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(10.0F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.WEIRD);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.grassFoliageColor = 0xffffff;
		this.waterColor = 0xffffff;
		this.topBlock = ZGBlocks.atheonRock.getDefaultState();
		this.fillerBlock = ZGBlocks.atheonLuxrock.getDefaultState();
		this.stoneBlock = ZGBlocks.atheonStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4f2e;
	}
}