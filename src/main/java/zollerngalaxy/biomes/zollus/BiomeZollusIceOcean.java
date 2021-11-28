/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.zollus;

import net.minecraft.init.Blocks;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityFrostGiant;

public class BiomeZollusIceOcean extends BiomeZollusBase {
	
	public BiomeZollusIceOcean(BiomeProperties props) {
		super("zollus_ocean", props);
		props.setRainDisabled();
		this.setBiomeHeight(25);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.setBlocks(Blocks.AIR);
		this.setTemp(-14.2F);
		this.enableSnow = true;
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 10, 1, 1));
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
}