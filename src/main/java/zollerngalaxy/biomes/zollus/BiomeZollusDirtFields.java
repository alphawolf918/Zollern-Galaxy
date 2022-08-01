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

public class BiomeZollusDirtFields extends BiomeZollusBase {
	
	public BiomeZollusDirtFields(BiomeProperties props) {
		super("zollus_dirt_fields", props);
		props.setRainDisabled();
		this.setBiomeHeight(24);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-2.4F);
		this.enableSnow = true;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 10, 1, 1));
		this.topBlock = ZGBlocks.zolDirt.getDefaultState();
		this.fillerBlock = ZGBlocks.zolDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}