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

public class BiomeAzuralPlains extends BiomeExodusBase {
	
	public BiomeAzuralPlains(BiomeProperties props) {
		super("azureplains", props);
		this.setupBiome(props);
	}
	
	public BiomeAzuralPlains(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.2F);
		props.setTemperature(4.0F);
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.tallGrassPerChunk = 14;
		this.biomeDecor.treesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.flowersPerChunk = 8;
		this.enableSnow = false;
		this.setTemp(4F);
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
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