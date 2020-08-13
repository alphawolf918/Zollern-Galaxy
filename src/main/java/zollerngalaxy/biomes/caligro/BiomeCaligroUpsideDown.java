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

public class BiomeCaligroUpsideDown extends BiomeCaligroBase {
	
	public BiomeCaligroUpsideDown(BiomeProperties props) {
		super("upsidedown", props);
		props.setBaseHeight(3.5F);
		props.setHeightVariation(1.2F);
		props.setTemperature(2.0F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(2.0F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.grassFoliageColor = 0x000;
		this.waterColor = 0x000;
		this.topBlock = ZGBlocks.caligroSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.caligroDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.caligroStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x0d0;
	}
}