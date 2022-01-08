/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.tlaloc;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityVexBotGold;

public class BiomeTlalocGoldenConstructs extends BiomeTlalocBase {
	
	public BiomeTlalocGoldenConstructs(BiomeProperties props) {
		super("tlaloc_golden_constructs", props);
		props.setRainDisabled();
		props.setTemperature(9.5F);
		this.setBiomeHeight(95);
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.setBlocks(ZGBlocks.atheonConstructBlock);
		this.setTemp(9.5F);
		this.biomeDecor.ufosPerChunk = 1;
		this.enableSnow = false;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityVexBotGold.class, 100, 1, 2));
		this.stoneBlock = ZGBlocks.tlalocStone;
		this.setPlanetForBiome(ZGPlanets.planetTlaloc);
	}
}