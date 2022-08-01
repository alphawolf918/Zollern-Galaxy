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

public class BiomeZollusIcyRockies extends BiomeZollusBase {
	
	public BiomeZollusIcyRockies(BiomeProperties props) {
		super("zollus_icyrockies", props);
		props.setRainDisabled();
		this.setBiomeHeight(65);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-5.2F);
		this.enableSnow = true;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 10, 1, 1));
		this.topBlock = ZGBlocks.zolCobbleRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolCobbleRock.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}