/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.biomes;

import galaxymod.biomes.eden.BiomeEden;
import galaxymod.biomes.eden.BiomeEdenBloodDesert;
import galaxymod.biomes.eden.BiomeEdenForest;
import galaxymod.biomes.eden.BiomeEdenGarden;
import galaxymod.biomes.eden.BiomeEdenMagmaLands;
import galaxymod.biomes.eden.BiomeEdenRockMountains;
import galaxymod.biomes.eden.BiomeEdenSnowyPlains;
import galaxymod.biomes.eden.BiomeEdenSwamp;
import galaxymod.biomes.eden.BiomeEdenTerranValley;
import galaxymod.biomes.kriffus.BiomeGenKriffonBase;
import galaxymod.biomes.purgot.BiomeGenPurgotBase;
import galaxymod.biomes.zollus.BiomeGenZollusBase;
import galaxymod.blocks.BlockList;
import galaxymod.core.config.ConfigManagerNova;
import galaxymod.utils.NovaHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeList {
	
	public static int biomeColor = 1404851;
	static int totalBiomes = 0;
	
	public static BiomeGenBase biomeZollus = ((BiomeGenZollusBase) new BiomeGenZollusBase(
			ConfigManagerNova.biomeZollusIcyLandsId).setTemp(1F).setBiomeName(
			"Ice Lands")).setBlocks(BlockList.zolarBlock, BlockList.zolDirt);
	
	public static BiomeGenBase biomeKriffus = ((BiomeGenKriffonBase) new BiomeGenKriffonBase(
			ConfigManagerNova.biomeKriffonFlamingPlainsId)
			.setBiomeName("Flaming Plains")).setTemp(10F).setBlocks(
			BlockList.kriffRock, BlockList.kriffDirt);
	
	public static BiomeGenBase biomeEden = new BiomeEden(
			ConfigManagerNova.biomeEdenGreenLandsId);
	public static BiomeGenBase biomeEdenRockMountains = new BiomeEdenRockMountains(
			ConfigManagerNova.biomeEdenRockMountainsId);
	public static BiomeGenBase biomeEdenTerranValley = new BiomeEdenTerranValley(
			ConfigManagerNova.biomeEdenTerranValleyId);
	public static BiomeGenBase biomeEdenBloodDesert = new BiomeEdenBloodDesert(
			ConfigManagerNova.biomeEdenBloodDesertId);
	public static BiomeGenBase biomeEdenGarden = new BiomeEdenGarden(
			ConfigManagerNova.biomeEdenGardenId);
	public static BiomeGenBase biomeEdenForest = new BiomeEdenForest(
			ConfigManagerNova.biomeEdenForestId);
	public static BiomeGenBase biomeEdenMagmaLands = new BiomeEdenMagmaLands(
			ConfigManagerNova.biomeEdenMagmaLandsId);
	public static BiomeGenBase biomeEdenSnowyPlains = new BiomeEdenSnowyPlains(
			ConfigManagerNova.biomeEdenSnowyPlainsId);
	public static BiomeGenBase biomeEdenSwamp = new BiomeEdenSwamp(
			ConfigManagerNova.biomeEdenSwamplandsId);
	
	public static BiomeGenBase biomePurgatory = ((BiomeSpace) new BiomeGenPurgotBase(
			ConfigManagerNova.biomePurgatoryId).setTemp(5F).setBiomeName(
			"Purgatory")).setBlocks(BlockList.purgRock, BlockList.purgDirt);
	
	public static void init() {
		
		// ZOLLUS
		addBiome(biomeZollus, BiomeType.COOL, 0);
		
		// KRIFFON
		addBiome(biomeKriffus, BiomeType.DESERT, 0);
		
		// EDEN
		addBiome(biomeEden, BiomeType.WARM, 0);
		addBiome(biomeEdenRockMountains, BiomeType.WARM, 0);
		addBiome(biomeEdenTerranValley, BiomeType.COOL, 0);
		addBiome(biomeEdenBloodDesert, BiomeType.DESERT, 0);
		addBiome(biomeEdenGarden, BiomeType.WARM, 0);
		addBiome(biomeEdenForest, BiomeType.WARM, 0);
		addBiome(biomeEdenMagmaLands, BiomeType.WARM, 0);
		addBiome(biomeEdenSnowyPlains, BiomeType.ICY, 0);
		addBiome(biomeEdenSwamp, BiomeType.WARM, 0);
		
		// PURGOT
		addBiome(biomePurgatory, BiomeType.COOL, 0);
		
		NovaHelper.echo("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	public static void addBiome(BiomeGenBase biome, BiomeType biomeType,
			int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		// BiomeManager.addSpawnBiome(biome);
		// BiomeManager.addVillageBiome(biome, true);
		// BiomeManager.addStrongholdBiome(biome);
		totalBiomes++;
	}
}