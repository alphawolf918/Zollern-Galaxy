/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.exodus;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeBlackMesa extends BiomeExodusBase {
	
	public BiomeBlackMesa(BiomeProperties props) {
		super("exodusblackmesa", props);
		this.setupBiome(props);
	}
	
	public BiomeBlackMesa(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.WARM);
		props.setBaseHeight(2.6F);
		props.setHeightVariation(1.5F);
		props.setTemperature(6.0F);
		this.biomeDecor.tallGrassPerChunk = 0;
		this.biomeDecor.flowersPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 6;
		this.biomeDecor.generateFalls = false;
		this.enableSnow = false;
		this.setTemp(36F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.grassFoliageColor = 0x000000;
		this.waterColor = 0xeeeeee;
		this.topBlock = ZGBlocks.exodusSand.getDefaultState();
		this.fillerBlock = ZGBlocks.exodusStone.getDefaultState();
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FOSSIL)) {
			if (rand.nextInt(64) == 0) {
				(new WorldGenFossils()).generate(worldIn, rand, pos);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff2ba0;
	}
}