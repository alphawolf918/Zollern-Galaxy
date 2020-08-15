/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorCaligro extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator leadGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator shiniumGen;
	private WorldGenerator silverGen;
	private WorldGenerator nickelGen;
	private WorldGenerator topazGen;
	private WorldGenerator amberGen;
	private WorldGenerator opalGen;
	private WorldGenerator aquamarineGen;
	private WorldGenerator garnetGen;
	private WorldGenerator rubyGen;
	private WorldGenerator lapisGen;
	private WorldGenerator radiumGen;
	private WorldGenerator fueltoniumGen;
	private WorldGenerator superChargedCoalGen;
	private WorldGenerator zincGen;
	private WorldGenerator amaranthGen;
	private WorldGenerator zollerniumGen;
	
	// Corruption Layer
	private WorldGenerator corruptAscendiumGen;
	private WorldGenerator corruptEtriumGen;
	private WorldGenerator corruptChargiumGen;
	
	public BiomeDecoratorCaligro() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.caligroDirt, ZGBlocks.caligroSurfaceRock, EnumOreGenZG.DIRT);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.caligroTinOre, ZGBlocks.caligroStone, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.caligroCopperOre, ZGBlocks.caligroStone, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.caligroIronOre, ZGBlocks.caligroStone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.caligroGoldOre, ZGBlocks.caligroStone, EnumOreGenZG.GOLD);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.caligroLeadOre, ZGBlocks.caligroStone, EnumOreGenZG.LEAD);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.caligroRedstoneOre, ZGBlocks.caligroStone, EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.caligroDiamondOre, ZGBlocks.caligroStone, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.caligroEmeraldOre, ZGBlocks.caligroStone, EnumOreGenZG.EMERALD);
		this.shiniumGen = new WorldGenMinableZG(ZGBlocks.caligroShiniumOre, ZGBlocks.caligroStone, EnumOreGenZG.PLATINUM);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.caligroSilverOre, ZGBlocks.caligroStone, EnumOreGenZG.SILVER);
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.caligroNickelOre, ZGBlocks.caligroStone, EnumOreGenZG.NICKEL);
		this.topazGen = new WorldGenMinableZG(ZGBlocks.caligroTopazOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.amberGen = new WorldGenMinableZG(ZGBlocks.caligroAmberOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.opalGen = new WorldGenMinableZG(ZGBlocks.caligroOpalOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.aquamarineGen = new WorldGenMinableZG(ZGBlocks.caligroAquamarineOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.garnetGen = new WorldGenMinableZG(ZGBlocks.caligroGarnetOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.rubyGen = new WorldGenMinableZG(ZGBlocks.caligroRubyOre, ZGBlocks.caligroStone, EnumOreGenZG.POWER_GEM);
		this.lapisGen = new WorldGenMinableZG(ZGBlocks.caligroLapisOre, ZGBlocks.caligroStone, EnumOreGenZG.LAPIS);
		this.radiumGen = new WorldGenMinableZG(ZGBlocks.caligroRadiumOre, ZGBlocks.caligroStone, EnumOreGenZG.RADIUM);
		this.fueltoniumGen = new WorldGenMinableZG(ZGBlocks.caligroFueltoniumOre, ZGBlocks.caligroStone, EnumOreGenZG.FUELTONIUM);
		this.superChargedCoalGen = new WorldGenMinableZG(ZGBlocks.caligroSuperChargedCoalOre, ZGBlocks.caligroStone,
				EnumOreGenZG.SUPER_CHARGED_COAL);
		this.zincGen = new WorldGenMinableZG(ZGBlocks.caligroZincOre, ZGBlocks.caligroStone, EnumOreGenZG.ZINC);
		this.amaranthGen = new WorldGenMinableZG(ZGBlocks.caligroAmaranthOre, ZGBlocks.caligroStone, EnumOreGenZG.AMARANTH);
		this.zollerniumGen = new WorldGenMinableZG(ZGBlocks.caligroZollerniumOre, ZGBlocks.caligroStone, EnumOreGenZG.ZOLLERNIUM);
		this.corruptAscendiumGen = new WorldGenMinableZG(ZGBlocks.corruptAscendiumOre, ZGBlocks.corruptStone, EnumOreGenZG.POWER_GEM);
		this.corruptEtriumGen = new WorldGenMinableZG(ZGBlocks.corruptEtriumOre, ZGBlocks.corruptStone, EnumOreGenZG.POWER_GEM);
		this.corruptChargiumGen = new WorldGenMinableZG(ZGBlocks.corruptChargiumOre, ZGBlocks.corruptStone, EnumOreGenZG.ZOLLERNIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.shiniumGen, EnumOreGenZG.PLATINUM, world, rand);
		this.generateOre(this.silverGen, EnumOreGenZG.SILVER, world, rand);
		this.generateOre(this.nickelGen, EnumOreGenZG.NICKEL, world, rand);
		this.generateOre(this.topazGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.opalGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.aquamarineGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.garnetGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.rubyGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.lapisGen, EnumOreGenZG.LAPIS, world, rand);
		this.generateOre(this.radiumGen, EnumOreGenZG.RADIUM, world, rand);
		this.generateOre(this.fueltoniumGen, EnumOreGenZG.FUELTONIUM, world, rand);
		this.generateOre(this.superChargedCoalGen, EnumOreGenZG.SUPER_CHARGED_COAL, world, rand);
		this.generateOre(this.zincGen, EnumOreGenZG.ZINC, world, rand);
		this.generateOre(this.amaranthGen, EnumOreGenZG.AMARANTH, world, rand);
		this.generateOre(this.zollerniumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
		this.generateOre(this.corruptAscendiumGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.corruptEtriumGen, EnumOreGenZG.POWER_GEM, world, rand);
		this.generateOre(this.corruptChargiumGen, EnumOreGenZG.ZOLLERNIUM, world, rand);
	}
}