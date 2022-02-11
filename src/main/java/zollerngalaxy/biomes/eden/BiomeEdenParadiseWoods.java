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

public class BiomeEdenParadiseWoods extends BiomeEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	private WorldGenAbstractTree treeGenFall = new WorldGenEdenTrees(false, ZGHelper.rngInt(5, 7), ZGBlocks.edenParadiseWoodLog.getDefaultState(), ZGBlocks.edenParadiseWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenAbstractTree treeGenGold = new WorldGenEdenTrees(false, ZGHelper.rngInt(4, 8), ZGBlocks.edenGoldenWoodLog.getDefaultState(), ZGBlocks.edenGoldenWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenAbstractTree treeGenLove = new WorldGenEdenTrees(true, 5, ZGBlocks.edenLovetreeLog.getDefaultState(), ZGBlocks.edenLovetreeLeaves.getDefaultState(), this.generateVines);
	
	public BiomeEdenParadiseWoods(BiomeProperties props) {
		super("paradisewoods", props);
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.6F);
		props.setHeightVariation(2.5F);
		props.setTemperature(1.0F);
		this.setTemp(4F);
		this.setBiomeHeight(30);
		this.setBiomeType(EnumBiomeTypeZG.FOREST);
		this.enableSnow = false;
		this.biomeDecor.generatePumpkins = true;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateVines = false;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.tallGrassPerChunk = 16;
		this.biomeDecor.flowersPerChunk = 4;
		this.biomeDecor.treesPerChunk = 60;
		this.biomeDecor.edenPumpkinsPerChunk = 8;
		this.grassFoilageColorMultiplier = 0x8b0000;
		this.waterColor = 0x00008b;
		this.topBlock = ZGBlocks.edenFallGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		int randInt = rand.nextInt(4);
		switch (randInt) {
			default:
			case 0:
				return treeGenFall;
			case 1:
				return treeGenGold;
			case 2:
				return treeGenLove;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff8b00;
	}
}