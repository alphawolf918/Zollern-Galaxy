package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorEden extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator coalGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator leadGen;
	private WorldGenerator nickleGen;
	private WorldGenerator copperGen;
	private WorldGenerator silverGen;
	private WorldGenerator aluminumGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator lapisGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator meteoricIronGen;
	private WorldGenerator deshGen;
	private WorldGenerator viriGen;
	private WorldGenerator cobaltGen;
	private WorldGenerator eveniumGen;
	private WorldGenerator steelGen;
	private WorldGenerator bronzeGen;
	private WorldGenerator invarGen;
	private WorldGenerator electrumGen;
	private WorldGenerator platinumGen;
	
	public int edenTallGrassPerChunk = 4;
	public int edenFlowersPerChunk = 4;
	
	public BiomeDecoratorEden() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.edenDirt, ZGBlocks.edenSurfaceRock,
				EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.edenGravel, ZGBlocks.edenStone,
				EnumOreGenZG.GRAVEL);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.edenCoalOre, ZGBlocks.edenStone,
				EnumOreGenZG.COAL);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.edenTinOre, ZGBlocks.edenStone,
				EnumOreGenZG.TIN);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.edenLeadOre, ZGBlocks.edenStone,
				EnumOreGenZG.LEAD);
		this.nickleGen = new WorldGenMinableZG(ZGBlocks.edenNickleOre, ZGBlocks.edenStone,
				EnumOreGenZG.NICKLE);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.edenCopperOre, ZGBlocks.edenStone,
				EnumOreGenZG.COPPER);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.edenSilverOre, ZGBlocks.edenStone,
				EnumOreGenZG.SILVER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.edenIronOre, ZGBlocks.edenStone,
				EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.edenGoldOre, ZGBlocks.edenStone,
				EnumOreGenZG.GOLD);
		this.aluminumGen = new WorldGenMinableZG(ZGBlocks.edenAluminumOre, ZGBlocks.edenStone,
				EnumOreGenZG.ALUMINUM);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.edenRedstoneOre, ZGBlocks.edenStone,
				EnumOreGenZG.REDSTONE);
		this.lapisGen = new WorldGenMinableZG(ZGBlocks.edenLapisOre, ZGBlocks.edenStone,
				EnumOreGenZG.LAPIS);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.edenDiamondOre, ZGBlocks.edenStone,
				EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.edenEmeraldOre, ZGBlocks.edenStone,
				EnumOreGenZG.EMERALD);
		this.meteoricIronGen = new WorldGenMinableZG(ZGBlocks.edenMeteoricIronOre,
				ZGBlocks.edenStone, EnumOreGenZG.METEORIC_IRON);
		this.deshGen = new WorldGenMinableZG(ZGBlocks.edenDeshOre, ZGBlocks.edenStone,
				EnumOreGenZG.DESH);
		this.viriGen = new WorldGenMinableZG(ZGBlocks.edenViriniumOre, ZGBlocks.edenStone,
				EnumOreGenZG.VIRINIUM);
		this.cobaltGen = new WorldGenMinableZG(ZGBlocks.edenCobaltOre, ZGBlocks.edenStone,
				EnumOreGenZG.COBALT);
		this.eveniumGen = new WorldGenMinableZG(ZGBlocks.edenEveniumOre, ZGBlocks.edenStone,
				EnumOreGenZG.EVENIUM);
		this.steelGen = new WorldGenMinableZG(ZGBlocks.edenSteelOre, ZGBlocks.edenSteelOre,
				EnumOreGenZG.STEEL);
		this.bronzeGen = new WorldGenMinableZG(ZGBlocks.edenBronzeOre, ZGBlocks.edenStone,
				EnumOreGenZG.BRONZE);
		this.invarGen = new WorldGenMinableZG(ZGBlocks.edenInvarOre, ZGBlocks.edenStone,
				EnumOreGenZG.INVAR);
		this.electrumGen = new WorldGenMinableZG(ZGBlocks.edenElectrumOre, ZGBlocks.edenStone,
				EnumOreGenZG.ELECTRUM);
		this.platinumGen = new WorldGenMinableZG(ZGBlocks.edenElectrumOre, ZGBlocks.edenStone,
				EnumOreGenZG.ELECTRUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.nickleGen, EnumOreGenZG.NICKLE, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.silverGen, EnumOreGenZG.SILVER, world, rand);
		this.generateOre(this.aluminumGen, EnumOreGenZG.ALUMINUM, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.lapisGen, EnumOreGenZG.LAPIS, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.meteoricIronGen, EnumOreGenZG.METEORIC_IRON, world, rand);
		this.generateOre(this.deshGen, EnumOreGenZG.DESH, world, rand);
		this.generateOre(this.viriGen, EnumOreGenZG.VIRINIUM, world, rand);
		this.generateOre(this.cobaltGen, EnumOreGenZG.COBALT, world, rand);
		this.generateOre(this.eveniumGen, EnumOreGenZG.EVENIUM, world, rand);
		this.generateOre(this.steelGen, EnumOreGenZG.STEEL, world, rand);
		this.generateOre(this.bronzeGen, EnumOreGenZG.BRONZE, world, rand);
		this.generateOre(this.invarGen, EnumOreGenZG.INVAR, world, rand);
		this.generateOre(this.electrumGen, EnumOreGenZG.ELECTRUM, world, rand);
		this.generateOre(this.platinumGen, EnumOreGenZG.PLATINUM, world, rand);
	}
}