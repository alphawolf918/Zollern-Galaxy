/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.candora;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeChocolateOcean extends BiomeCandoraBase {
	
	public BiomeChocolateOcean(BiomeProperties props) {
		super("candoraocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(7.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(7.0F);
		this.setBiomeHeight(72);
		this.setBlocks(Blocks.AIR);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.deadBushPerChunk = 0;
		this.biomeDecor.chocolateLakesPerChunk = 6;
		this.enableSnow = false;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0xff0000;
		this.stoneBlock = ZGBlocks.candyCubeGray;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xffdd00;
	}
}