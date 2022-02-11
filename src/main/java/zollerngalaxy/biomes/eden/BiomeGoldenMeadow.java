/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.eden;

import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.eden.WorldGenEdenTrees;

public class BiomeGoldenMeadow extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	private WorldGenAbstractTree edenTreeGen = new WorldGenEdenTrees(false, ZGHelper.rngInt(4, 8), ZGBlocks.edenGoldenWoodLog.getDefaultState(), ZGBlocks.edenGoldenWoodLeaves.getDefaultState(), this.generateVines);
	
	public BiomeGoldenMeadow(BiomeProperties props) {
		super("goldmeadow", props);
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(2.5F);
		props.setTemperature(4.0F);
		this.setTemp(4.7F);
		this.setBiomeHeight(20);
		this.setBiomeType(EnumBiomeTypeZG.PLAINS);
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.treesPerChunk = 30;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.tallGrassPerChunk = 45;
		this.biomeDecor.flowersPerChunk = 6;
		this.grassFoilageColorMultiplier = 0x00008b;
		this.waterColor = 0x00008b;
		this.topBlock = ZGBlocks.edenGoldenGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return this.edenTreeGen;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00bbbb;
	}
}