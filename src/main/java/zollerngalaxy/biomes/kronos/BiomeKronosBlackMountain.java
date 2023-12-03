/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeKronosBlackMountain extends BiomeKronosBase {
	
	public BiomeKronosBlackMountain(BiomeProperties props) {
		super("kronos_black_mountain", props);
		props.setRainDisabled();
		this.setBiomeHeight(124);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(89F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(Blocks.OBSIDIAN);
		this.enableSnow = false;
		this.stoneBlock = STONE.getBlock();
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, rand, pos));
		WorldGenerator azurites = new AzuriteGenerator();
		
		if (TerrainGen.generateOre(worldIn, rand, azurites, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
			azurites.generate(worldIn, rand, pos);
		}
		
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, rand, pos));
	}
	
	private static class AzuriteGenerator extends WorldGenerator {
		
		@Override
		public boolean generate(World worldIn, Random rand, BlockPos pos) {
			int count = 4 + rand.nextInt(6);
			for (int i = 0; i < count; i++) {
				int offset = ForgeModContainer.fixVanillaCascading ? 8 : 0; // MC-114332
				BlockPos blockpos = pos.add(rand.nextInt(16) + offset, rand.nextInt(28) + 4, rand.nextInt(16) + offset);
				
				IBlockState state = worldIn.getBlockState(blockpos);
				if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, BlockMatcher.forBlock(Blocks.OBSIDIAN))) {
					worldIn.setBlockState(blockpos, ZGBlocks.netherAzuriteOre.getDefaultState(), 16 | 2);
				}
			}
			return true;
		}
	}
}