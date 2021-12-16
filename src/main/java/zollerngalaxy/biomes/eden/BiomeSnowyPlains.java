/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.eden;

import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeSnowyPlains extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	
	public BiomeSnowyPlains(BiomeProperties props) {
		super("snowyplains", props);
		props.setRainDisabled();
		props.setBaseHeight(0.4F);
		props.setHeightVariation(0.5F);
		props.setTemperature(1.0F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(-8.0F);
		this.setEnableSnow(true);
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPolarBear.class, 100, 2, 3));
		this.enableSnow = true;
		this.decorator.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.waterLakesPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 6;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.grassFoilageColorMultiplier = 0x00009f;
		this.waterColor = 0x00009f;
		this.topBlock = ZGBlocks.edenSnow.getDefaultState();
		this.fillerBlock = ZGBlocks.edenWinterRock.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00008b;
	}
}