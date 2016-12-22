/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
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
import galaxymod.biomes.oasis.BiomeGenOasisBase;
import galaxymod.biomes.purgot.BiomeGenPurgotBase;
import galaxymod.biomes.purgot.BiomeGenPurgotLimbo;
import galaxymod.biomes.xathius.BiomeGenXathiusAbstractPlains;
import galaxymod.biomes.xathius.BiomeGenXathiusBase;
import galaxymod.biomes.zollus.BiomeGenZollusBase;
import galaxymod.blocks.BlockList;
import galaxymod.core.config.ConfigManagerZG;
import galaxymod.utils.ZGHelper;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeList {
	
	public static int biomeColor = 1404851;
	static int totalBiomes = 0;
	
	public static BiomeSpace biomeZollus = ((BiomeGenZollusBase) new BiomeGenZollusBase(
			ConfigManagerZG.biomeZollusIcyLandsId).setTemp(1F).setBiomeName(
			"Ice Lands")).setBlocks(BlockList.zolarBlock, BlockList.zolDirt);
	
	public static BiomeSpace biomeKriffus = ((BiomeGenKriffonBase) new BiomeGenKriffonBase(
			ConfigManagerZG.biomeKriffonFlamingPlainsId)
			.setBiomeName("Scorched Valley")).setTemp(10F).setBlocks(
			BlockList.kriffRock, BlockList.kriffDirt);
	
	public static BiomeSpace biomeXathius = ((BiomeGenXathiusBase) new BiomeGenXathiusBase(
			ConfigManagerZG.biomeXathiusId).setBiomeName("Happy Hills"))
			.setTemp(5F).setBlocks(BlockList.xathRock, BlockList.xathDirt);
	public static BiomeSpace biomeXathiusAbstractPlains = new BiomeGenXathiusAbstractPlains(
			ConfigManagerZG.biomeXathiusAbstractPlainsId);
	
	public static BiomeSpace biomeOasis = ((BiomeSpace) new BiomeGenOasisBase(
			ConfigManagerZG.biomeOasisId).setTemp(5f).setBiomeName("Oasis"))
			.setBlocks(BlockList.oasisGrass, BlockList.oasisDirt);
	
	public static BiomeSpace biomeEden = new BiomeEden(
			ConfigManagerZG.biomeEdenGreenLandsId);
	public static BiomeSpace biomeEdenRockMountains = new BiomeEdenRockMountains(
			ConfigManagerZG.biomeEdenRockMountainsId);
	public static BiomeSpace biomeEdenTerranValley = new BiomeEdenTerranValley(
			ConfigManagerZG.biomeEdenTerranValleyId);
	public static BiomeSpace biomeEdenBloodDesert = new BiomeEdenBloodDesert(
			ConfigManagerZG.biomeEdenBloodDesertId);
	public static BiomeSpace biomeEdenGarden = new BiomeEdenGarden(
			ConfigManagerZG.biomeEdenGardenId);
	public static BiomeSpace biomeEdenForest = new BiomeEdenForest(
			ConfigManagerZG.biomeEdenForestId);
	public static BiomeSpace biomeEdenMagmaLands = new BiomeEdenMagmaLands(
			ConfigManagerZG.biomeEdenMagmaLandsId);
	public static BiomeSpace biomeEdenSnowyPlains = new BiomeEdenSnowyPlains(
			ConfigManagerZG.biomeEdenSnowyPlainsId);
	public static BiomeSpace biomeEdenSwamp = new BiomeEdenSwamp(
			ConfigManagerZG.biomeEdenSwamplandsId);
	
	public static BiomeSpace biomePurgatory = ((BiomeGenPurgotBase) new BiomeGenPurgotBase(
			ConfigManagerZG.biomePurgatoryId).setTemp(4F).setBiomeName(
			"Purgatory")).setBlocks(BlockList.purgRock, BlockList.purgDirt);
	public static BiomeSpace biomePurgotLimbo = new BiomeGenPurgotLimbo(
			ConfigManagerZG.biomePurgotLimboId);
	
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
		addBiome(biomePurgotLimbo, BiomeType.ICY, 0);
		
		// Xathius
		addBiome(biomeXathius, BiomeType.WARM, 0);
		addBiome(biomeXathiusAbstractPlains, BiomeType.WARM, 0);
		
		// Oasis
		addBiome(biomeOasis, BiomeType.WARM, 0);
		
		ZGHelper.echo("Loaded a total of " + totalBiomes + " new biomes.");
	}
	
	public static void addBiome(BiomeSpace biome, BiomeType biomeType,
			int biomeWeight) {
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		totalBiomes++;
	}
}