/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.exodus;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeExoForest extends BiomeExodusBase {
	
	public BiomeExoForest(BiomeProperties props) {
		super("exoforest", props);
		this.setupBiome(props);
	}
	
	public BiomeExoForest(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(0.4F);
		props.setHeightVariation(0.5F);
		props.setTemperature(5.0F);
		this.biomeDecor.exodusTallGrassPerChunk = 15;
		this.biomeDecor.exodusTreesPerChunk = 20;
		this.biomeDecor.lavaLakesPerChunk = 1;
		this.biomeDecor.generateFalls = true;
		this.setTemp(5.2F);
		this.setBiomeHeight(34);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.grassFoliageColor = 0xff008b;
		this.waterColor = 0x8b008b;
		this.topBlock = ZGBlocks.exodusGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.exodusDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4c6e;
	}
}