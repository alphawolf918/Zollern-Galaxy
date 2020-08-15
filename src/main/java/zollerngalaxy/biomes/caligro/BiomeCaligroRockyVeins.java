/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.caligro;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCaligroRockyVeins extends BiomeCaligroBase {
	
	public BiomeCaligroRockyVeins(BiomeProperties props) {
		super("rockyveins", props);
		props.setBaseHeight(2.5F);
		props.setHeightVariation(2.2F);
		props.setTemperature(5.3F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(5.3F);
		this.setBiomeHeight(86);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = false;
		this.grassFoliageColor = 0x000;
		this.waterColor = 0x000;
		this.topBlock = ZGBlocks.caligroRock.getDefaultState();
		this.fillerBlock = ZGBlocks.caligroCobblestone.getDefaultState();
		this.stoneBlock = ZGBlocks.caligroStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x0c0;
	}
}