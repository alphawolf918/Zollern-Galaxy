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

public class BiomeAstros extends BiomeAstrosBase {
	
	public BiomeAstros(BiomeProperties props) {
		super("astros", props);
		props.setRainDisabled();
		this.setBiomeHeight(35);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.setTemp(2.2F);
		this.enableSnow = true;
		this.clearAllSpawning();
		if (ConfigManagerZG.enableAlienVillagerSpawn) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		}
		this.topBlock = ZGBlocks.astrosRock.getDefaultState();
		this.fillerBlock = ZGBlocks.astrosDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.astrosStone;
		this.setMoonForBiome(ZGPlanets.moonAstros);
	}
}