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
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;

public class BiomeFlowerGarden extends BiomeEdenBase {
	
	public BiomeFlowerGarden(BiomeProperties props) {
		super("flowergarden", props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(4.0F);
		this.setBiomeHeight(42);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 4;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.edenTallGrassPerChunk = 24;
		this.biomeDecor.edenFlowersPerChunk = 48;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.grassFoliageColor = 0x00228b;
		this.waterColor = 0x00228b;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMoolus.class, 100, 4, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityOinkus.class, 100, 4, 6));
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