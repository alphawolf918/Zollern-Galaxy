/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.astros;

import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeAstrosRockies extends BiomeAstrosBase {
	
	public BiomeAstrosRockies(BiomeProperties props) {
		super("astros_rockies", props);
		props.setRainDisabled();
		this.setBiomeHeight(40);
		this.setBiomeType(EnumBiomeTypeZG.ROCKY);
		this.setTemp(5.2F);
		this.enableSnow = false;
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		}
		this.topBlock = ZGBlocks.astrosStone.getDefaultState();
		this.fillerBlock = ZGBlocks.astrosCobblestone.getDefaultState();
		this.stoneBlock = ZGBlocks.astrosStone;
		this.setMoonForBiome(ZGPlanets.moonAstros);
	}
}