/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.exodus;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.exodus.WorldGenExoTrees;

public class BiomeExoForest extends BiomeExodusBase {
	
	protected static final IBlockState LOG_STATE = ZGBlocks.exoWoodLogs.getDefaultState();
	protected static final IBlockState LEAVES_STATE = ZGBlocks.exoWoodLeaves.getDefaultState();
	protected static final WorldGenExoTrees EXO_TREES = new WorldGenExoTrees(false, ZGHelper.rngInt(5, 10), LOG_STATE, LEAVES_STATE, false);
	
	public BiomeExoForest(BiomeProperties props) {
		super("exoforest", props);
		this.setupBiome(props);
	}
	
	public BiomeExoForest(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(0.4F);
		props.setHeightVariation(0.5F);
		props.setTemperature(5.0F);
		this.biomeDecor.tallGrassPerChunk = 15;
		this.biomeDecor.lavaLakesPerChunk = 1;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.treesPerChunk = 6;
		this.biomeDecor.flowersPerChunk = 10;
		this.enableSnow = false;
		this.setTemp(5.2F);
		this.setBiomeHeight(24);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.grassFoliageColor = 0xff008b;
		this.waterColor = 0x8b008b;
		this.topBlock = ZGBlocks.exodusGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.exodusDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return EXO_TREES;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff4c6e;
	}
}