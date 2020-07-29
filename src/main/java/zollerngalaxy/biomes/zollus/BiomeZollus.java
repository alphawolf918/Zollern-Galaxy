/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.zollus;

import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeZollus extends BiomeZollusBase {
	
	public BiomeZollus(BiomeProperties props) {
		super("zollus", props);
		props.setRainDisabled();
		this.setBiomeHeight(45);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(-10.2F);
		this.enableSnow = true;
		this.clearAllSpawning();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 15, 1, 1));
		this.topBlock = ZGBlocks.zolSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}