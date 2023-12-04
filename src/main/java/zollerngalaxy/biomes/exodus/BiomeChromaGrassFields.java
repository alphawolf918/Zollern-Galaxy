/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.exodus;

import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class BiomeChromaGrassFields extends BiomeExodusBase {
	
	public BiomeChromaGrassFields(BiomeProperties props) {
		super("chroma_grass_fields", props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.2F);
		props.setTemperature(4.6F);
		this.biomeDecor.generateFalls = false;
		this.biomeDecor.tallGrassPerChunk = 16;
		this.biomeDecor.treesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 4;
		this.biomeDecor.flowersPerChunk = 4;
		this.enableSnow = false;
		this.setTemp(4.6F);
		this.setBiomeHeight(42);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		int rng = ZGHelper.rngInt(1, 100);
		this.grassFoliageColor = (rng > 50) ? 0x00008b : 0xff00ff;
		this.waterColor = 0x00008b;
		this.topBlock = this.getChromaVariant(); // Still only getting the one color...
		this.fillerBlock = ZGBlocks.chromaSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	private IBlockState getChromaVariant() {
		IBlockState chromaState = ZGBlocks.chromaGrassGreen.getDefaultState();
		int rng = ZGHelper.rngInt(1, 100);
		if (rng > 40 && rng < 90) {
			chromaState = ZGBlocks.chromaGrassBlue.getDefaultState();
		} else if (rng >= 90) {
			chromaState = ZGBlocks.chromaGrassPink.getDefaultState();
		} else if (rng < 40) {
			chromaState = ZGBlocks.chromaGrassYellow.getDefaultState();
		} else if (rng == 100) {
			chromaState = ZGBlocks.chromaGrassRed.getDefaultState();
		}
		return chromaState;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x0099ff;
	}
}