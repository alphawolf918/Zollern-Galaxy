/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenIcePath;
import net.minecraft.world.gen.feature.WorldGenIceSpike;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeHarranTundra extends BiomeMetztliBase {
	
	public static enum Type {
		NORMAL, MEGA, MEGA_SPRUCE;
	}
	
	private final boolean superIcy = true;
	private final WorldGenIceSpike iceSpike = new WorldGenIceSpike();
	private final WorldGenIcePath icePatch = new WorldGenIcePath(4);
	private static final WorldGenTaiga1 PINE_GENERATOR = new WorldGenTaiga1();
	private static final WorldGenTaiga2 SPRUCE_GENERATOR = new WorldGenTaiga2(false);
	private static final WorldGenMegaPineTree MEGA_PINE_GENERATOR = new WorldGenMegaPineTree(false, false);
	private static final WorldGenMegaPineTree MEGA_SPRUCE_GENERATOR = new WorldGenMegaPineTree(false, true);
	private static final WorldGenBlockBlob FOREST_ROCK_GENERATOR = new WorldGenBlockBlob(Blocks.MOSSY_COBBLESTONE, 0);
	private final BiomeHarranTundra.Type type;
	
	public BiomeHarranTundra(BiomeProperties props, BiomeHarranTundra.Type typeIn) {
		super("harran_tundra", props);
		this.type = typeIn;
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.COLD);
		props.setBaseHeight(0.4F);
		props.setHeightVariation(0.5F);
		props.setTemperature(-0.5F);
		props.setSnowEnabled();
		this.setEnableSnow(true);
		this.setTemp(-0.5F);
		this.setBiomeHeight(32);
		this.setBiomeType(EnumBiomeTypeZG.ICY);
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 8, 4, 4));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 10, 2, 3));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPolarBear.class, 1, 1, 2));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityStray.class, 80, 4, 4));
		this.enableSnow = true;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateTrees = true;
		this.biomeDecor.generateMushroomTrees = false;
		this.biomeDecor.generateTallGrass = true;
		this.biomeDecor.generateWaterLilies = false;
		this.biomeDecor.generateDeadBushes = true;
		this.biomeDecor.deadBushesPerChunk = 1;
		this.biomeDecor.waterLakesPerChunk = 0;
		this.biomeDecor.lavaLakesPerChunk = 2;
		this.biomeDecor.treesPerChunk = 10;
		this.grassFoliageColor = 0x340922;
		this.waterColor = 0x00008b;
		this.topBlock = Blocks.SNOW.getDefaultState();
		this.fillerBlock = DIRT;
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		if (this.superIcy && TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ICE)) {
			for (int i = 0; i < 3; ++i) {
				int j = rand.nextInt(16) + 8;
				int k = rand.nextInt(16) + 8;
				this.iceSpike.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}
			
			for (int l = 0; l < 2; ++l) {
				int i1 = rand.nextInt(16) + 8;
				int j1 = rand.nextInt(16) + 8;
				this.icePatch.generate(worldIn, rand, worldIn.getHeight(pos.add(i1, 0, j1)));
			}
		}
		
		if ((this.type == BiomeHarranTundra.Type.MEGA || this.type == BiomeHarranTundra.Type.MEGA_SPRUCE)
				&& TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK)) {
			int i = rand.nextInt(3);
			
			for (int j = 0; j < i; ++j) {
				int k = rand.nextInt(16) + 8;
				int l = rand.nextInt(16) + 8;
				BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
				FOREST_ROCK_GENERATOR.generate(worldIn, rand, blockpos);
			}
		}
		
		DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FLOWERS))
			for (int i1 = 0; i1 < 7; ++i1) {
				int j1 = rand.nextInt(16) + 8;
				int k1 = rand.nextInt(16) + 8;
				int l1 = rand.nextInt(worldIn.getHeight(pos.add(j1, 0, k1)).getY() + 32);
				DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j1, l1, k1));
			}
		
		super.decorate(worldIn, rand, pos);
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		if ((this.type == BiomeHarranTundra.Type.MEGA || this.type == BiomeHarranTundra.Type.MEGA_SPRUCE) && rand.nextInt(3) == 0) {
			return this.type != BiomeHarranTundra.Type.MEGA_SPRUCE && rand.nextInt(13) != 0 ? MEGA_PINE_GENERATOR : MEGA_SPRUCE_GENERATOR;
		} else {
			return rand.nextInt(3) == 0 ? PINE_GENERATOR : SPRUCE_GENERATOR;
		}
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return rand.nextInt(5) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.07F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x0089ff;
	}
}