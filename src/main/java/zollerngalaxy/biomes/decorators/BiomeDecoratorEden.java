/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.decorators;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
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
import zollerngalaxy.worldgen.WorldGenBattleTower;
import zollerngalaxy.worldgen.WorldGenClayZG;
import zollerngalaxy.worldgen.WorldGenCrops;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenOutpost;
import zollerngalaxy.worldgen.WorldGenSandZG;
import zollerngalaxy.worldgen.WorldGenSmallCraterZG;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;
import zollerngalaxy.worldgen.WorldGenZGMushroomTree;
import zollerngalaxy.worldgen.eden.WorldGenDropship;
import zollerngalaxy.worldgen.eden.WorldGenEdenFlowers;
import zollerngalaxy.worldgen.eden.WorldGenEdenPumpkins;
import zollerngalaxy.worldgen.eden.WorldGenEdenTower;
import zollerngalaxy.worldgen.eden.WorldGenEdenTrees;
import zollerngalaxy.worldgen.eden.WorldGenGiantBone;

public class BiomeDecoratorEden extends BiomeDecoratorZG {
	
	private WorldGenerator dirtOreGen;
	private WorldGenerator gravelOreGen;
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
	
	public int tallGrassPerChunk = 4;
	public int flowersPerChunk = 2;
	public int edenPumpkinsPerChunk = 0;
	public int treesPerChunk = 1;
	public int mushroomTreesPerChunk = 0;
	public int lavaLakesPerChunk = (this.enableExtremeMode) ? 2 : 1;
	public int waterLakesPerChunk = 4;
	public int dropshipsPerChunk = 1;
	public int gravelPatchesPerChunk = 2;
	public int sandPatchesPerChunk = 3;
	public int clayPerChunk = 2;
	public int mushroomsPerChunk = 2;
	public int cropsPerChunk = 2;
	public int battleTowersPerChunk = 2;
	public int cratersPerChunk = 0;
	
	public float extraTreeChance = 0.5F;
	
	private WorldGenerator pumpkinGen = new WorldGenEdenPumpkins();
	private WorldGenerator tallGrassGen = new WorldGenTallGrassZG((ZGBlockTallGrass) ZGBlocks.edenTallGrass);
	private WorldGenerator waterLilyGen = new WorldGenWaterlily();
	private WorldGenerator treeGenEden = new WorldGenEdenTrees(false, ZGHelper.rngInt(5, 10), ZGBlocks.edenWoodLog.getDefaultState(), ZGBlocks.edenWoodLeaves.getDefaultState(), this.generateVines);
	private WorldGenerator towerGen = new WorldGenEdenTower();
	private WorldGenerator giantBoneGen = new WorldGenGiantBone();
	private WorldGenerator treeGenMushroom = new WorldGenZGMushroomTree(false, ZGHelper.rngInt(3, 6));
	private WorldGenerator dropshipGen = new WorldGenDropship();
	private WorldGenerator clayGen = new WorldGenClayZG(ZGBlocks.mudClayBlock, 8);
	private WorldGenerator gravelGen = new WorldGenSandZG(ZGBlocks.edenGravel, 6);
	private WorldGenerator sandGen = new WorldGenSandZG(ZGBlocks.edenBloodSand, 7);
	private WorldGenerator battleTowerGen = new WorldGenBattleTower(ZGBlocks.edenCobbleRock.getDefaultState(), ZGBlocks.blockShinestone.getDefaultState());
	private WorldGenerator craterGen = new WorldGenSmallCraterZG();
	private WorldGenerator cropGen;
	
	public boolean generateVines = false;
	public boolean generateLakes = true;
	public boolean generateWitchHuts = false;
	public boolean generateTowers = true;
	public boolean generateGiantBones = false;
	public boolean generateMansions = false;
	public boolean generateTrees = true;
	public boolean generateMushroomTrees = false;
	public boolean generatePumpkins = false;
	public boolean generateOutposts = true;
	public boolean generateDropships = true;
	public boolean generateFlowers = true;
	public boolean generateTallGrass = true;
	public boolean generateGravel = true;
	public boolean generateSand = true;
	public boolean generateClay = true;
	public boolean generateMushrooms = true;
	public boolean generateCrops = true;
	public boolean generateBattleTowers = true;
	public boolean generateCraters = false;
	
	public BiomeDecoratorEden() {
		this.dirtOreGen = new WorldGenMinableZG(ZGBlocks.edenSoil, ZGBlocks.edenSurfaceRock, EnumOreGenZG.DIRT);
		this.gravelOreGen = new WorldGenMinableZG(ZGBlocks.edenGravel, ZGBlocks.edenStone, EnumOreGenZG.GRAVEL);
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
		ChunkPos forgeChunkPos = new ChunkPos(this.chunkPos);
		
		this.generateOre(this.dirtOreGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.gravelOreGen, EnumOreGenZG.GRAVEL, world, rand);
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
		if (this.generateTallGrass && this.tallGrassPerChunk > 0) {
			for (int i = 0; i < this.tallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(this.tallGrassGen, world, rand, this.chunkPos);
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
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS)) {
			if (this.generateFlowers && this.flowersPerChunk > 0) {
				for (int l2 = 0; l2 < this.flowersPerChunk; ++l2) {
					int i7 = rand.nextInt(16) + 8;
					int l10 = rand.nextInt(16) + 8;
					int j14 = world.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;
					
					if (j14 > 0) {
						int k17 = rand.nextInt(j14);
						BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);
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
						
						if (edenFlower.getDefaultState().getMaterial() != Material.AIR) {
							IBlockState flowerState = edenFlower.getDefaultState();
							(new WorldGenEdenFlowers(flowerState)).generate(world, rand, blockpos1);
						}
					}
				}
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
			if (y >= 24) {
				if (rand.nextInt(100) <= 15) {
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
					if (rand.nextInt((this.enableExtremeMode) ? 1000 : 600) <= 15) {
						dropshipGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Oil Lakes
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CUSTOM)) {
			if (this.generateOil && this.oilPerChunk > 0 && this.enableOilGen) {
				for (int i = 0; i < this.oilPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					(new WorldGenLakesZG(GCBlocks.crudeOil, ZGBlocks.edenStone)).generate(world, rand, this.chunkPos.add(x, y, z));
					EventHandlerGC.generateOil(world, rand, x, z, false);
				}
			}
		}
		
		// Clay
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.CLAY)) {
			if (this.generateClay && this.clayPerChunk > 0) {
				for (int i1 = 0; i1 < this.clayPerChunk; ++i1) {
					int l1 = rand.nextInt(16) + 8;
					int i6 = rand.nextInt(16) + 8;
					this.clayGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(l1, 0, i6)));
				}
			}
		}
		
		// Gravel
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2)) {
			if (this.generateGravel && this.gravelPatchesPerChunk > 0) {
				for (int j1 = 0; j1 < this.gravelPatchesPerChunk; ++j1) {
					int i2 = rand.nextInt(16) + 8;
					int j6 = rand.nextInt(16) + 8;
					this.gravelGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(i2, 0, j6)));
				}
			}
		}
		
		// Sand
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SAND)) {
			if (this.generateSand && this.sandPatchesPerChunk > 0) {
				for (int i = 0; i < this.sandPatchesPerChunk; ++i) {
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					this.sandGen.generate(world, rand, world.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
				}
			}
		}
		
		int k1 = this.treesPerChunk;
		
		if (rand.nextFloat() < this.extraTreeChance) {
			++k1;
		}
		
		// Random Tree Feature
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.TREE)) {
			if (rand.nextInt(4) == 0) {
				for (int j2 = 0; j2 < y; ++j2) {
					int k6 = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					WorldGenAbstractTree worldgenabstracttree = biome.getRandomTreeFeature(rand);
					worldgenabstracttree.setDecorationDefaults();
					BlockPos blockpos = world.getHeight(this.chunkPos.add(k6, 0, l));
					
					if (worldgenabstracttree.generate(world, rand, blockpos)) {
						worldgenabstracttree.generateSaplings(world, rand, blockpos);
					}
				}
			}
		}
		
		// Crops
		if (this.generateCrops && this.cropsPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 100) <= 45) {
				for (int i = 0; i < this.cropsPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 62) {
						this.cropGen = new WorldGenCrops(ZGHelper.getRandomCrop(rand).getDefaultState());
						this.cropGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Mushrooms (Small)
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.SHROOM)) {
			if (this.generateMushrooms && this.mushroomsPerChunk > 0) {
				for (int l3 = 0; l3 < this.mushroomsPerChunk; ++l3) {
					if (rand.nextInt(4) == 0) {
						int i8 = rand.nextInt(16) + 8;
						int l11 = rand.nextInt(16) + 8;
						BlockPos blockpos2 = world.getHeight(this.chunkPos.add(i8, 0, l11));
						this.mushroomBrownGen.generate(world, rand, blockpos2);
					}
					
					if (rand.nextInt(8) == 0) {
						int j8 = rand.nextInt(16) + 8;
						int i12 = rand.nextInt(16) + 8;
						int j15 = world.getHeight(this.chunkPos.add(j8, 0, i12)).getY() * 2;
						
						if (j15 > 0) {
							int k18 = rand.nextInt(j15);
							BlockPos blockpos5 = this.chunkPos.add(j8, k18, i12);
							this.mushroomRedGen.generate(world, rand, blockpos5);
						}
					}
				}
				
				if (rand.nextInt(4) == 0) {
					int i4 = rand.nextInt(16) + 8;
					int k8 = rand.nextInt(16) + 8;
					int j12 = world.getHeight(this.chunkPos.add(i4, 0, k8)).getY() * 2;
					
					if (j12 > 0) {
						int k15 = rand.nextInt(j12);
						this.mushroomBrownGen.generate(world, rand, this.chunkPos.add(i4, k15, k8));
					}
				}
				
				if (rand.nextInt(8) == 0) {
					int j4 = rand.nextInt(16) + 8;
					int l8 = rand.nextInt(16) + 8;
					int k12 = world.getHeight(this.chunkPos.add(j4, 0, l8)).getY() * 2;
					
					if (k12 > 0) {
						int l15 = rand.nextInt(k12);
						this.mushroomRedGen.generate(world, rand, this.chunkPos.add(j4, l15, l8));
					}
				}
			}
		}
		
		// Mushroom Trees
		if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM)) {
			if (this.generateMushroomTrees && this.mushroomTreesPerChunk > 0) {
				for (int i = 0; i < this.mushroomTreesPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y < 64) {
						y = ZGHelper.rngInt(64, 82);
					}
					
					if (rand.nextInt(100) <= 45) {
						this.treeGenMushroom.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Falls
		if (this.generateFalls) {
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_WATER)) {
				for (int k5 = 0; k5 < 50; ++k5) {
					int i10 = rand.nextInt(16) + 8;
					int l13 = rand.nextInt(16) + 8;
					int i17 = rand.nextInt(120) + 8;
					
					if (i17 > 0) {
						int k19 = rand.nextInt(i17);
						BlockPos blockpos6 = this.chunkPos.add(i10, k19, l13);
						(new WorldGenLiquids(Blocks.FLOWING_WATER)).generate(world, rand, blockpos6);
					}
				}
			}
			
			if (TerrainGen.decorate(world, rand, forgeChunkPos, DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA)) {
				for (int l5 = 0; l5 < 20; ++l5) {
					int j10 = rand.nextInt(16) + 8;
					int i14 = rand.nextInt(16) + 8;
					int j17 = rand.nextInt(rand.nextInt(rand.nextInt(112) + 8) + 8);
					BlockPos blockpos3 = this.chunkPos.add(j10, j17, i14);
					(new WorldGenLiquids(Blocks.FLOWING_LAVA)).generate(world, rand, blockpos3);
				}
			}
		}
		
		// Battle Towers
		if (this.generateBattleTowers && this.battleTowersPerChunk > 0 && !BiomeUtils.isOceanBiome(biome)) {
			if (ZGHelper.rngInt(1, 250) <= 35) {
				for (int i = 0; i < this.battleTowersPerChunk; ++i) {
					y = rand.nextInt(rand.nextInt(genY) + 8);
					if (y >= 60 && y < 80) {
						this.battleTowerGen.generate(world, rand, this.chunkPos.add(x, y, z));
					}
				}
			}
		}
		
		// Craters (Small)
		int craterSpawnChance = ConfigManagerZG.craterSpawnChance;
		if (this.generateCraters && this.cratersPerChunk > 0 && craterSpawnChance > 0) {
			ChunkProviderEden.INSTANCE.createCraters(x, z, chunkPrimer);
			y = rand.nextInt(rand.nextInt(genY) + 8);
			if (ZGHelper.rngInt(1, 100) <= craterSpawnChance) {
				for (int i = 0; i < this.cratersPerChunk; ++i) {
					if (y <= 70) {
						this.craterGen.generate(world, rand, this.chunkPos.add(x, y, z));
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