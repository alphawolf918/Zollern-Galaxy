/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorPerdita extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.perdStone;
	
	private WorldGenerator creepstoneGen;
	private WorldGenerator creepdirtGen;
	
	public BiomeDecoratorPerdita() {
		this.creepstoneGen = new WorldGenMinableZG(ZGBlocks.perdCreepStone, STONE, EnumOreGenZG.SPECIAL_STONE);
		this.creepdirtGen = new WorldGenMinableZG(ZGBlocks.perdCreepDirt, STONE, EnumOreGenZG.DIRT.setMaxHeight(32));
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.creepstoneGen, EnumOreGenZG.SPECIAL_STONE, world, rand);
		
		int genY = 248;
		int y = genY;
	}
}