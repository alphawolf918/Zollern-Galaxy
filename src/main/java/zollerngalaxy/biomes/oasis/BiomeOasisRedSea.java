/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.oasis;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntitySquidlus;

public class BiomeOasisRedSea extends BiomeOasisBase {
	
	public BiomeOasisRedSea(BiomeProperties props) {
		super("oasisocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(7.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(9.0F);
		this.setBiomeHeight(5);
		this.setBlocks(ZGBlocks.oasisSand, ZGBlocks.oasisDirt);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 100, 1, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquidlus.class, 100, 1, 4));
		this.biomeDecor.oasisTallGrassPerChunk = 2;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = false;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.deadBushPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.enableSnow = false;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x8b0000;
		this.stoneBlock = ZGBlocks.oasisStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xffdd00;
	}
}