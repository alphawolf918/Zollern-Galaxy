/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.villages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class StructureComponentVillageStartPieceZG extends StructureComponentVillageWellZG {
	
	public BiomeProvider biomeProvider;
	public int terrainType;
	public StructureVillagePieceWeightZG structVillagePieceWeight;
	public List<StructureVillagePieceWeightZG> structureVillageWeightedPieceList;
	public ArrayList<Object> field_74932_i = new ArrayList<Object>();
	public ArrayList<Object> field_74930_j = new ArrayList<Object>();
	
	public StructureComponentVillageStartPieceZG() {
	}
	
	public StructureComponentVillageStartPieceZG(BiomeProvider biomeProvider, int par2, Random par3Random, int par4, int par5,
			ArrayList<StructureVillagePieceWeightZG> par6ArrayList, int par7) {
		super(null, 0, par3Random, par4, par5);
		this.biomeProvider = biomeProvider;
		this.structureVillageWeightedPieceList = par6ArrayList;
		this.terrainType = par7;
		this.startPiece = this;
	}
	
	@Override
	protected void writeStructureToNBT(NBTTagCompound nbt) {
		super.writeStructureToNBT(nbt);
		
		nbt.setInteger("TerrainType", this.terrainType);
	}
	
	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt, TemplateManager manager) {
		super.readStructureFromNBT(nbt, manager);
		
		this.terrainType = nbt.getInteger("TerrainType");
	}
	
	public BiomeProvider getBiomeProvider() {
		return this.biomeProvider;
	}
}
