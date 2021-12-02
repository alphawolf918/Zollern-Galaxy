/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.villages;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.core.util.GCLog;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import zollerngalaxy.blocks.ZGBlocks;

public class MapGenVillageZG extends MapGenStructure {
	
	public static List<Biome> villageSpawnBiomes = Arrays.asList(new Biome[] { BiomeAdaptive.biomeDefault });
	private final int terrainType;
	private static boolean initialized;
	private String worldName;
	private IBlockState VILLAGE_BLOCK;
	private static MapGenVillageZG INSTANCE;
	
	static {
		try {
			MapGenVillageZG.initiateStructures();
		} catch (Throwable e) {
			
		}
	}
	
	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageZG.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartZG.class, "ZGVillage");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageFieldZG.class, "ZGField1");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageField2ZG.class, "ZGField2");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageHouseZG.class, "ZGHouse");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageRoadPieceZG.class, "ZGRoadPiece");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillagePathGenZG.class, "ZGPath");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageTorchZG.class, "ZGTorch");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageStartPieceZG.class, "ZGWell");
			MapGenStructureIO.registerStructureComponent(StructureComponentVillageWoodHutZG.class, "ZGWoodHut");
		}
		
		MapGenVillageZG.initialized = true;
	}
	
	public MapGenVillageZG(String worldNameIn, IBlockState houseBlockIn) {
		this.terrainType = 0;
		this.worldName = worldNameIn;
		this.VILLAGE_BLOCK = houseBlockIn;
		INSTANCE = this;
	}
	
	public MapGenVillageZG(String worldNameIn, Block houseBlockIn) {
		this(worldNameIn, houseBlockIn.getDefaultState());
	}
	
	public MapGenVillageZG(String worldNameIn) {
		this(worldNameIn, ZGBlocks.blockShinestoneCrystalBricks.getDefaultState());
	}
	
	@Override
	protected boolean canSpawnStructureAtCoords(int i, int j) {
		final byte numChunks = 32;
		final byte offsetChunks = 8;
		final int oldi = i;
		final int oldj = j;
		
		if (i < 0) {
			i -= numChunks - 1;
		}
		
		if (j < 0) {
			j -= numChunks - 1;
		}
		
		int randX = i / numChunks;
		int randZ = j / numChunks;
		final Random var7 = this.world.setRandomSeed(i, j, 10387312);
		randX *= numChunks;
		randZ *= numChunks;
		randX += var7.nextInt(numChunks - offsetChunks);
		randZ += var7.nextInt(numChunks - offsetChunks);
		
		return oldi == randX && oldj == randZ;
	}
	
	@Override
	public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean p_180706_3_) {
		this.world = worldIn;
		return findNearestStructurePosBySpacing(worldIn, this, pos, 32, 8, 10387312, false, 100, p_180706_3_);
	}
	
	@Override
	protected StructureStart getStructureStart(int par1, int par2) {
		GCLog.debug("Generating " + this.worldName + " Village at x" + par1 * 16 + " z" + par2 * 16);
		return new StructureVillageStartZG(this.world, this.rand, par1, par2, this.terrainType);
	}
	
	@Override
	public String getStructureName() {
		return "ZGVillage";
	}
	
	public IBlockState getHouseBlock() {
		return this.VILLAGE_BLOCK;
	}
	
	public static MapGenVillageZG instance() {
		return INSTANCE;
	}
}
