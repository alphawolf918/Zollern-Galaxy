/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
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

public class BiomeDecoratorAltum extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.altumStone;
	
	private WorldGenerator amaranthGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator ironGen;
	private WorldGenerator diamondGen;
	private WorldGenerator zollerniumGen;
	private WorldGenerator goldGen;
	private WorldGenerator eveniumGen;
	private WorldGenerator rhodiumGen;
	private WorldGenerator coalGen;
	
	public BiomeDecoratorAltum() {
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.altumAmaranthOre, STONE, EnumOreGenZG.AMARANTH);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.altumRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.altumDiamondOre, STONE, EnumOreGenZG.DIAMOND);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.altumZollerniumOre, STONE, EnumOreGenZG.ZOLLERNIUM);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.altumIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.altumGoldOre, STONE, EnumOreGenZG.GOLD);
		this.eveniumGen = new WorldGenMinableZG(ZGBlocks.altumEveniumOre, STONE, EnumOreGenZG.EVENIUM);
		this.rhodiumGen = new WorldGenMinableZG(ZGBlocks.altumRhodiumOre, STONE, EnumOreGenZG.RHODIUM);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.altumRhodiumOre, STONE, EnumOreGenZG.COAL);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.eveniumGen, EnumOreGenZG.EVENIUM, world, rand);
		this.generateOre(this.rhodiumGen, EnumOreGenZG.RHODIUM, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		
		// TODO: World gen...
	}
}