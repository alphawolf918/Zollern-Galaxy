/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityScorpion;

public class BiomeHarranDunes extends BiomeHarranBase {
	
	private final BiomeHarranDunes.Type type;
	
	private final IBlockState SAND_NORMAL = Blocks.SAND.getDefaultState();
	private final IBlockState SAND_RED = Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND);
	private final IBlockState SANDSTONE = Blocks.SANDSTONE.getDefaultState();
	private final IBlockState HARDENED_CLAY = Blocks.HARDENED_CLAY.getDefaultState();
	
	public BiomeHarranDunes(BiomeHarranDunes.Type typeIn, BiomeProperties props) {
		super((typeIn == Type.NORMAL) ? "harran_dunes" : "harran_red_desert", props);
		this.setupBiome(props);
		this.type = typeIn;
	}
	
	public BiomeHarranDunes(BiomeHarranDunes.Type typeIn, String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
		this.type = typeIn;
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.WARM);
		props.setBaseHeight(1.4F);
		props.setHeightVariation(1.5F);
		props.setTemperature(9.0F);
		this.setTemp((this.type == Type.NORMAL) ? 80F : 95F);
		this.setBiomeHeight((this.type == Type.NORMAL) ? 82 : 96);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 80, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMummy.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityScorpion.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityHusk.class, 80, 4, 4));
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCacti = true;
		this.biomeDecor.generateDeadBushes = true;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.generateMushroomTrees = false;
		this.biomeDecor.generateTallGrass = false;
		this.biomeDecor.generateFerns = false;
		this.biomeDecor.generateWaterLilies = false;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = (this.type == Type.NORMAL) ? 6 : 14;
		this.biomeDecor.deadBushesPerChunk = (this.type == Type.NORMAL) ? 8 : 16;
		this.biomeDecor.reedsPerChunk = 50;
		this.biomeDecor.cactiPerChunk = 10;
		this.grassFoliageColor = 0x345a83;
		this.waterColor = 0x00008b;
		this.topBlock = (this.type == Type.NORMAL) ? SAND_NORMAL : SAND_RED;
		this.fillerBlock = (this.type == Type.NORMAL) ? SANDSTONE : HARDENED_CLAY;
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.DESERT_WELL))
			if (rand.nextInt(1000) == 0) {
				int i = rand.nextInt(16) + 8;
				int j = rand.nextInt(16) + 8;
				BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
				(new WorldGenDesertWells()).generate(worldIn, rand, blockpos);
			}
		
		if (TerrainGen.decorate(worldIn, rand, new ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.FOSSIL))
			if (rand.nextInt(64) == 0) {
				(new WorldGenFossils()).generate(worldIn, rand, pos);
			}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xcc3a4b;
	}
	
	public static enum Type {
		NORMAL, RED
	};
}