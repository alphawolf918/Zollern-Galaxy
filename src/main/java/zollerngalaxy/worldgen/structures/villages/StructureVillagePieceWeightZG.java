/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.villages;

public class StructureVillagePieceWeightZG {
	
	public Class<? extends StructureComponentVillageZG> villagePieceClass;
	public final int villagePieceWeight;
	public int villagePiecesSpawned;
	public int villagePiecesLimit;
	
	public StructureVillagePieceWeightZG(Class<? extends StructureComponentVillageZG> par1Class, int par2, int par3) {
		this.villagePieceClass = par1Class;
		this.villagePieceWeight = par2;
		this.villagePiecesLimit = (int) (par3 / 1.5D);
	}
	
	public boolean canSpawnMoreVillagePiecesOfType(int par1) {
		return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
	}
	
	public boolean canSpawnMoreVillagePieces() {
		return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
	}
}