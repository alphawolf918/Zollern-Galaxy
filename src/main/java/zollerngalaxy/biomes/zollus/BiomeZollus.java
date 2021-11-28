/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.zollus;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityFrostGiant;

public class BiomeZollus extends BiomeZollusBase {
	
	public BiomeZollus(BiomeProperties props) {
		super("zollus", props);
		props.setRainDisabled();
		this.setBiomeHeight(45);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-10.2F);
		this.enableSnow = true;
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 10, 1, 1));
		this.topBlock = ZGBlocks.zolSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}