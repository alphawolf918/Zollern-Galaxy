/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.genlayers.metztli;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.util.CachedEnumZG;

public class GenLayerMetztliBiomes extends GenLayerMetztli {
	
	@SuppressWarnings("unchecked")
	private List<BiomeEntry>[] biomes = new ArrayList[CachedEnumZG.valuesBiomeCached().length];
	private ArrayList<BiomeEntry>[] biomesList = this.setupBiomes();
	
	public GenLayerMetztliBiomes(long seed) {
		super(seed);
		
		for (BiomeType type : CachedEnumZG.valuesBiomeCached()) {
			ImmutableList<BiomeEntry> biomesToAdd = this.getBiomes(type);
			int idx = type.ordinal();
			
			if (this.biomes[idx] == null) {
				this.biomes[idx] = new ArrayList<>();
			}
			if (biomesToAdd != null) {
				this.biomes[idx].addAll(biomesToAdd);
			}
		}
	}
	
	private ArrayList<BiomeEntry>[] setupBiomes() {
		@SuppressWarnings("unchecked")
		ArrayList<BiomeEntry>[] currentBiomes = new ArrayList[CachedEnumZG.valuesBiomeCached().length];
		List<BiomeEntry> list = new ArrayList<>();
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_PLAINS, 100));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_DUNES, 90));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_RED_DESERT, 85));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_SWAMP, 80));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_MARSH, 75));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_CLAY_MESA, 70));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_HILLS, 65));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_FOREST, 55));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_OCEAN, 50));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_SHROOMS, 40));
		list.add(new BiomeEntry(ZGBiomes.METZTLI_HARRAN_TUNDRA, 30));
		
		currentBiomes[BiomeType.WARM.ordinal()] = new ArrayList<>(list);
		return currentBiomes;
	}
	
	private ImmutableList<BiomeEntry> getBiomes(BiomeType type) {
		int idx = type.ordinal();
		List<BiomeEntry> list = idx >= this.biomesList.length ? null : this.biomesList[idx];
		return list != null ? ImmutableList.copyOf(list) : null;
	}
	
	@Override
	public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
		int[] dest = IntCache.getIntCache(areaWidth * areaHeight);
		
		for (int dz = 0; dz < areaHeight; dz++) {
			for (int dx = 0; dx < areaWidth; dx++) {
				this.initChunkSeed(dx + areaX, dz + areaY);
				dest[dx + dz * areaWidth] = Biome.getIdForBiome(this.getWeightedBiomeEntry(BiomeType.WARM).biome);
			}
		}
		return dest;
	}
	
	protected BiomeEntry getWeightedBiomeEntry(BiomeType type) {
		List<BiomeEntry> biomeList = this.biomes[type.ordinal()];
		int totalWeight = WeightedRandom.getTotalWeight(biomeList);
		int weight = BiomeManager.isTypeListModded(type) ? this.nextInt(totalWeight) : this.nextInt(totalWeight / 10) * 10;
		return WeightedRandom.getRandomItem(biomeList, weight);
	}
}