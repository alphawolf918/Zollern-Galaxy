/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranShroomlands extends BiomeHarranBase {
	
	public BiomeHarranShroomlands(BiomeProperties props) {
		super("harran_shrooms", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranShroomlands(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(-0.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(6.0F);
		this.setTemp(6.0F);
		this.setBiomeHeight(42);
		this.setBiomeType(EnumBiomeTypeZG.MUSHROOM);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.generateVines = true;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 5;
		this.biomeDecor.tallGrassPerChunk = 4;
		this.biomeDecor.flowersPerChunk = 0;
		this.biomeDecor.treesPerChunk = 0;
		this.biomeDecor.mushroomsPerChunk = 14;
		this.biomeDecor.bigMushroomsPerChunk = 16;
		this.biomeDecor.deadBushesPerChunk = 4;
		this.grassFoliageColor = 0x00008b;
		this.waterColor = 0xff008b;
		this.topBlock = Blocks.MYCELIUM.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xd51b3c;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		double d0 = GRASS_COLOR_NOISE.getValue(pos.getX() * 0.0225D, pos.getZ() * 0.0225D);
		return getModdedBiomeGrassColor(d0 < -0.1D ? 5011004 : 6975545);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getFoliageColorAtPos(BlockPos pos) {
		return getModdedBiomeFoliageColor(this.grassFoliageColor);
	}
}