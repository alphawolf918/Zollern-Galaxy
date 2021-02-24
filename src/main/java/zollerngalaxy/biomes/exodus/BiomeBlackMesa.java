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

public class BiomeBlackMesa extends BiomeExodusBase {
	
	public BiomeBlackMesa(BiomeProperties props) {
		super("exodusblackmesa", props);
		this.setupBiome(props);
	}
	
	public BiomeBlackMesa(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.WARM);
		props.setBaseHeight(2.4F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.biomeDecor.exodusTallGrassPerChunk = 0;
		this.biomeDecor.astersPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 12;
		this.setTemp(10F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.enableSnow = false;
		this.decorator.generateFalls = false;
		this.grassFoliageColor = 0x000000;
		this.waterColor = 0xeeeeee;
		this.topBlock = ZGBlocks.exodusSand.getDefaultState();
		this.fillerBlock = ZGBlocks.exodusStone.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff2ba0;
	}
}