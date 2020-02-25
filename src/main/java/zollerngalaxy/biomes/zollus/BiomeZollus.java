/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.zollus;

import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorZollus;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeZollus extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	
	public BiomeDecoratorZollus biomeDecor = this.getBiomeDecorator();
	
	public BiomeZollus(BiomeProperties props) {
		super("zollus", props);
		props.setRainDisabled();
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.enableSnow = true;
		this.clearAllSpawning();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostGiant.class, 15, 1, 1));
		this.topBlock = ZGBlocks.zolSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorZollus();
	}
	
	protected BiomeDecoratorZollus getBiomeDecorator() {
		return (BiomeDecoratorZollus) this.decorator;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}