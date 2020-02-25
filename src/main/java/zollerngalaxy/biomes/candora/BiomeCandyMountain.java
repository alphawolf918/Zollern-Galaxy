/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.candora;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCandyMountain extends BiomeCandoraBase {
	
	public BiomeCandyMountain(BiomeProperties props) {
		super("candymountain", props);
		props.setBaseHeight(3.5F);
		props.setHeightVariation(1.2F);
		props.setTemperature(5.2F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5.2F);
		this.setBiomeHeight(83);
		this.setBiomeType(EnumBiomeTypeZG.SWEET);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.biomeDecor.chocolateLakesPerChunk = 2;
		this.grassFoliageColor = 0x9f9f00;
		this.waterColor = 0x8b2cff;
		this.topBlock = ZGBlocks.candyCubeRed.getDefaultState();
		this.fillerBlock = ZGBlocks.candyCubeWhite.getDefaultState();
		this.stoneBlock = ZGBlocks.candyCubeGray;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff002e;
	}
}