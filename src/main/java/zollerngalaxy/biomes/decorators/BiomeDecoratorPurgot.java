package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorPurgot extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator leadGen;
	private WorldGenerator aluminumGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator meteoricIronGen;
	
	public BiomeDecoratorPurgot() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.purgDirt, ZGBlocks.purgSurfaceRock,
				EnumOreGenZG.DIRT);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.purgTinOre, ZGBlocks.purgStone,
				EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.purgCopperOre, ZGBlocks.purgStone,
				EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.purgIronOre, ZGBlocks.purgStone,
				EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.purgGoldOre, ZGBlocks.purgStone,
				EnumOreGenZG.GOLD);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.purgLeadOre, ZGBlocks.purgStone,
				EnumOreGenZG.LEAD);
		this.aluminumGen = new WorldGenMinableZG(ZGBlocks.purgAluminumOre, ZGBlocks.purgStone,
				EnumOreGenZG.ALUMINUM);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.purgRedstoneOre, ZGBlocks.purgStone,
				EnumOreGenZG.REDSTONE);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.purgDiamondOre, ZGBlocks.purgStone,
				EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.purgEmeraldOre, ZGBlocks.purgStone,
				EnumOreGenZG.EMERALD);
		this.meteoricIronGen = new WorldGenMinableZG(ZGBlocks.purgMeteoricIronOre,
				ZGBlocks.purgStone, EnumOreGenZG.METEORIC_IRON);
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
		this.generateOre(this.aluminumGen, EnumOreGenZG.ALUMINUM, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.meteoricIronGen, EnumOreGenZG.METEORIC_IRON, world, rand);
	}
}