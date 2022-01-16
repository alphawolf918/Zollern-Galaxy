/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranPlains extends BiomeHarranBase {
	
	public BiomeHarranPlains(BiomeProperties props) {
		super("harran", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranPlains(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(0.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(4.0F);
		this.setTemp(24F);
		this.setBiomeHeight(32);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.grassPerChunk = 14;
		this.biomeDecor.flowersPerChunk = 8;
		this.biomeDecor.treesPerChunk = 2;
		this.grassFoliageColor = 0x00008b;
		this.waterColor = 0x8b008b;
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
}