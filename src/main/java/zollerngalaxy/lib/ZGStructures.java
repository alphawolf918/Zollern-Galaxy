/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.lib;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import zollerngalaxy.worldgen.ZGWoodlandMansion;
import zollerngalaxy.worldgen.structures.villages.MapGenVillageHarran;
import zollerngalaxy.worldgen.structures.villages.StructureVillageStartZG;

public class ZGStructures {
	
	public static void init() {
		MapGenStructureIO.registerStructure(ZGWoodlandMansion.Start.class, "HarranMansion");
		MapGenStructureIO.registerStructure(StructureVillageStartZG.class, "ZGVillage");
		MapGenStructureIO.registerStructure(MapGenVillageHarran.Start.class, "HarranVillage");
	}
}