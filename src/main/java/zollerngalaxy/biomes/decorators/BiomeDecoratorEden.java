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
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderEden;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.BiomeUtils;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;
import zollerngalaxy.worldgen.WorldGenZGMushroomTree;
import zollerngalaxy.worldgen.eden.WorldGenDropship;
import zollerngalaxy.worldgen.eden.WorldGenEdenFlowers;
import zollerngalaxy.worldgen.eden.WorldGenEdenPumpkins;
import zollerngalaxy.worldgen.eden.WorldGenEdenTower;
import zollerngalaxy.worldgen.eden.WorldGenEdenTrees;
import zollerngalaxy.worldgen.eden.WorldGenGiantBone;

public class BiomeDecoratorEden extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator coalGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator leadGen;
	private WorldGenerator nickelGen;
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
	private WorldGenerator heartiumGen;
	
	public int edenTallGrassPerChunk = 4;
	public int edenFlowersPerChunk = 2;
	public int edenPumpkinsPerChunk = 0;
	public int edenTreesPerChunk = 1;
	public int edenFallTreesPerChunk = 0;
	public int edenGoldTreesPerChunk = 0;
	public int edenLoveTreesPerChunk = 0;
	public int mushroomTreesPerChunk = 0;
	public int lavaLakesPerChunk = (this.enableExtremeMode) ? 2 : 1;
	public int waterLakesPerChunk = 4;
	public int dropshipsPerChunk = 1;
	
	private WorldGenerator pumpkinGen = new WorldGenEdenPumpkins();
	private WorldGenerator tallGrassGen = new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.edenTallGrass);
	private WorldGenerator waterLilyGen = new WorldGenWaterlily();
	private WorldGenerator treeGenEden = new WorldGenEdenTrees(false, ZGHelper.rngInt(5, 10), ZGBlocks.edenWoodLog.getDefaultState(),
			ZGBlocks.edenWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenerator towerGen = new WorldGenEdenTower();
	private WorldGenerator giantBoneGen = new WorldGenGiantBone();
	private WorldGenerator treeGenFall = new WorldGenEdenTrees(false, ZGHelper.rngInt(5, 7), ZGBlocks.edenParadiseWoodLog.getDefaultState(),
			ZGBlocks.edenParadiseWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenerator treeGenGold = new WorldGenEdenTrees(false, ZGHelper.rngInt(4, 8), ZGBlocks.edenGoldenWoodLog.getDefaultState(),
			ZGBlocks.edenGoldenWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenerator treeGenLove = new WorldGenEdenTrees(true, 5, ZGBlocks.edenLovetreeLog.getDefaultState(), ZGBlocks.edenLovetreeLeaves.getDefaultState(),
			this.generateVines);
	private WorldGenerator treeGenMushroom = new WorldGenZGMushroomTree(false, ZGHelper.rngInt(3, 6));
	private WorldGenerator dropshipGen = new WorldGenDropship();
	
	public boolean generateVines = false;
	public boolean generateLakes = true;
	public boolean generateCraters = false;
	public boolean generateWitchHuts = false;
	public boolean generateTowers = true;
	public boolean generateGiantBones = false;
	public boolean generateMansions = false;
	public boolean generateTrees = true;
	public boolean generateMushroomTrees = false;
	public boolean generatePumpkins = false;
	public boolean generateOutposts = true;
	public boolean generateDropships = true;
	
	public BiomeDecoratorEden() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.edenSoil, ZGBlocks.edenSurfaceRock, EnumOreGenZG.DIRT);
		this.gravelGen = new WorldGenMinableZG(ZGBlocks.edenGravel, ZGBlocks.edenStone, EnumOreGenZG.GRAVEL);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.edenCoalOre, ZGBlocks.edenStone, EnumOreGenZG.COAL);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.edenTinOre, ZGBlocks.edenStone, EnumOreGenZG.TIN);
		this.leadGen = new WorldGenMinableZG(ZGBlocks.edenLeadOre, ZGBlocks.edenStone, EnumOreGenZG.LEAD);
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.edenNickelOre, ZGBlocks.edenStone, EnumOreGenZG.NICKEL);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.edenCopperOre, ZGBlocks.edenStone, EnumOreGenZG.COPPER);
		this.silverGen = new WorldGenMinableZG(ZGBlocks.edenSilverOre, ZGBlocks.edenStone, EnumOreGenZG.SILVER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.edenIronOre, ZGBlocks.edenStone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.edenGoldOre, ZGBlocks.edenStone, EnumOreGenZG.GOLD);
		this.aluminumGen = new WorldGenMinableZG(ZGBlocks.edenAluminumOre, ZGBlocks.edenStone, EnumOreGenZG.ALUMINUM);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.edenRedstoneOre, ZGBlocks.edenStone, EnumOreGenZG.REDSTONE);
		this.lapisGen = new WorldGenMinableZG(ZGBlocks.edenLapisOre, ZGBlocks.edenStone, EnumOreGenZG.LAPIS);
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.edenDiamondOre, ZGBlocks.edenStone, EnumOreGenZG.DIAMOND);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.edenEmeraldOre, ZGBlocks.edenStone, EnumOreGenZG.EMERALD);
		this.meteoricIronGen = new WorldGenMinableZG(ZGBlocks.edenMeteoricIronOre, ZGBlocks.edenStone, EnumOreGenZG.METEORIC_IRON);
		this.deshGen = new WorldGenMinableZG(ZGBlocks.edenDeshOre, ZGBlocks.edenStone, EnumOreGenZG.DESH);
		this.viriGen = new WorldGenMinableZG(ZGBlocks.edenViriniumOre, ZGBlocks.edenStone, EnumOreGenZG.VIRINIUM);
		this.cobaltGen = new WorldGenMinableZG(ZGBlocks.edenCobaltOre, ZGBlocks.edenStone, EnumOreGenZG.COBALT);
		this.eveniumGen = new WorldGenMinableZG(ZGBlocks.edenEveniumOre, ZGBlocks.edenStone, EnumOreGenZG.EVENIUM);
		this.steelGen = new WorldGenMinableZG(ZGBlocks.edenSteelOre, ZGBlocks.edenSteelOre, EnumOreGenZG.STEEL);
		this.bronzeGen = new WorldGenMinableZG(ZGBlocks.edenBronzeOre, ZGBlocks.edenStone, EnumOreGenZG.BRONZE);
		this.invarGen = new WorldGenMinableZG(ZGBlocks.edenInvarOre, ZGBlocks.edenStone, EnumOreGenZG.INVAR);
		this.electrumGen = new WorldGenMinableZG(ZGBlocks.edenElectrumOre, ZGBlocks.edenStone, EnumOreGenZG.ELECTRUM);
		this.platinumGen = new WorldGenMinableZG(ZGBlocks.edenPlatinumOre, ZGBlocks.edenStone, EnumOreGenZG.PLATINUM);
		this.heartiumGen = new WorldGenMinableZG(ZGBlocks.edenHeartiumOre, ZGBlocks.edenStone, EnumOreGenZG.HEARTIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelGen, EnumOreGenZG.GRAVEL, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.leadGen, EnumOreGenZG.LEAD, world, rand);
		this.generateOre(this.nickelGen, EnumOreGenZG.NICKEL, world, rand);
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
		this.generateOre(this.heartiumGen, EnumOreGenZG.HEARTIUM, world, rand);
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = ZGBlocks.edenStone;
		
		if (biome instanceof BiomeSpace) {
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			genY = spaceBiome.getBiomeHeight();
		}
		
		// Lava Lakes
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt((this.enableExtremeMode) ? 75 : 100) <= 50) {
					(new WorldGenLakesZG(Blocks.LAVA, BLOCK_STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Dead Bushes
		if (this.deadBushPerChunk > 0) {
			// TODO
		}
		
		// Water Lakes
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				Block blockToUse = (BiomeUtils.isColdBiome(biome)) ? Blocks.ICE : Blocks.WATER;
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
			
			// Water Lilies
			if (this.waterlilyPerChunk > 0) {
				for (int i = 0; i < this.waterlilyPerChunk; ++i) {
					waterLilyGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Tall Grass
		if (this.edenTallGrassPerChunk > 0) {
			for (int i = 0; i < this.edenTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
			}
		}
		
		// Edenwood Trees
		if (this.generateTrees && this.edenTreesPerChunk > 0) {
			for (int i = 0; i < this.edenTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 50) {
					treeGenEden.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Paradise Trees
		if (this.generateTrees && this.edenFallTreesPerChunk > 0) {
			for (int i = 0; i < this.edenFallTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 85) {
					treeGenFall.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Goldenwood Trees
		if (this.generateTrees && this.edenGoldTreesPerChunk > 0) {
			for (int i = 0; i < this.edenGoldTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 80) {
					treeGenGold.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Lovetree Trees
		if (this.generateTrees && this.edenLoveTreesPerChunk > 0) {
			for (int i = 0; i < this.edenLoveTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 60) {
					treeGenLove.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Mushroom Trees
		if (this.generateTrees && this.mushroomTreesPerChunk > 0) {
			for (int i = 0; i < this.mushroomTreesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 65) {
					treeGenMushroom.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Pumpkins
		if (this.generatePumpkins && this.edenPumpkinsPerChunk > 0) {
			for (int i = 0; i < this.edenPumpkinsPerChunk; i++) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				if (y < 64) {
					y = ZGHelper.rngInt(64, 82);
				}
				
				if (rand.nextInt(100) <= 25) {
					pumpkinGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Flowers
		if (this.edenFlowersPerChunk > 0) {
			for (int i = 0; i <= this.edenFlowersPerChunk; ++i) {
				Block edenFlower = ZGBlocks.edenFlower;
				
				int r = rand.nextInt(30);
				
				if (r <= 5) {
					edenFlower = ZGBlocks.edenFlowerBlue;
				} else if (r <= 7) {
					edenFlower = ZGBlocks.edenFlowerCyan;
				} else if (r <= 10) {
					edenFlower = ZGBlocks.edenFlowerGreen;
				} else if (r <= 13) {
					edenFlower = ZGBlocks.edenFlowerOrange;
				} else if (r <= 15) {
					edenFlower = ZGBlocks.edenFlowerPurple;
				} else if (r <= 17) {
					edenFlower = ZGBlocks.edenFlowerRed;
				} else if (r <= 19) {
					edenFlower = ZGBlocks.edenFlowerYellow;
				} else if (r <= 21) {
					edenFlower = ZGBlocks.edenFlowerPink;
				} else if (r <= 23) {
					edenFlower = ZGBlocks.edenFlowerBlack;
				} else if (r <= 26) {
					edenFlower = ZGBlocks.edenFlowerWhite;
				}
				
				IBlockState flowerState = edenFlower.getDefaultState();
				ZGDecorateHelper.generatePlants(new WorldGenEdenFlowers(flowerState), world, rand, this.chunkPos);
			}
		}
		
		// Craters
		if (this.generateCraters) {
			ChunkProviderEden.INSTANCE.createCraters(x, z, chunkPrimer);
		}
		
		// Witch Huts
		if (this.generateWitchHuts) {
			// TODO
		}
		
		// Woodland Mansions
		if (this.generateMansions) {
			// TODO
		}
		
		// Crystal Towers
		if (this.generateTowers) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 63) {
				if (rand.nextInt(1000) <= 25) {
					y -= 10;
					towerGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Giant Bones
		if (this.generateGiantBones) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				if (rand.nextInt(700) <= 90) {
					giantBoneGen.generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		// Dropships
		if (this.generateDropships && this.dropshipsPerChunk > 0) {
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 50) {
				for (int i = 0; i < this.dropshipsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 1000 : 800) <= 15) {
						dropshipGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Outposts
		if (this.generateOutposts && this.outpostsPerChunk > 0) {
			if (biome instanceof BiomeSpace) {
				BiomeSpace spaceBiome = (BiomeSpace) biome;
				if (spaceBiome.getBiomeType() == EnumBiomeTypeZG.OCEAN) {
					return;
				}
			}
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (y >= 62) {
				IBlockState OUTPOST_STATE = ZGBlocks.blockOutpost.getDefaultState();
				WorldGenerator outpostGen = new WorldGenOutpost(OUTPOST_STATE, OUTPOST_STATE);
				for (int i = 0; i < this.outpostsPerChunk; i++) {
					if (rand.nextInt((this.enableExtremeMode) ? 200 : 100) <= ConfigManagerZG.outpostGenChance) {
						outpostGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
	}
}