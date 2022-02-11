/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.eden;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityEdenCow;
import zollerngalaxy.mobs.entities.EntityOinkus;

public class BiomeTerranValley extends BiomeEdenBase {
	
	public BiomeTerranValley(BiomeProperties props) {
		super("terranvalley", props);
		this.setupBiome(props);
	}
	
	public BiomeTerranValley(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.setTemp(4F);
		this.setBiomeHeight(10);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.tallGrassPerChunk = 40;
		this.biomeDecor.flowersPerChunk = 16;
		this.biomeDecor.treesPerChunk = 16;
		this.grassFoliageColor = 0x00008b;
		this.waterColor = 0x00008b;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityEdenCow.class, 100, 2, 3));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityOinkus.class, 100, 2, 3));
		this.topBlock = ZGBlocks.edenGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
}