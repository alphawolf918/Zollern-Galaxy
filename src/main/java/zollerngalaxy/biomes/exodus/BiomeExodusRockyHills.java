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

public class BiomeExodusRockyHills extends BiomeExodusBase {
	
	public BiomeExodusRockyHills(BiomeProperties props) {
		super("exodusrockyhills", props);
		this.setupBiome(props);
	}
	
	public BiomeExodusRockyHills(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.biomeDecor.tallGrassPerChunk = 0;
		this.biomeDecor.flowersPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 6;
		this.biomeDecor.generateFalls = true;
		this.enableSnow = false;
		this.setTemp(6F);
		this.setBiomeHeight(72);
		this.setBiomeType(EnumBiomeTypeZG.ROCKY);
		this.grassFoliageColor = 0xff008b;
		this.waterColor = 0x8b008b;
		this.topBlock = ZGBlocks.exodusRock.getDefaultState();
		this.fillerBlock = ZGBlocks.exodusStone.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4c6e;
	}
}