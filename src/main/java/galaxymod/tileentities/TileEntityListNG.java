/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.tileentities;

import galaxymod.tileentities.eden.TileEntityDungeonSpawnerEden;
import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import galaxymod.utils.ZGHelper;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityListNG {
	
	static int totalTileEntities = 0;
	
	public static void init() {
		registerTile(TileEntityTreasureChestEden.class, "EdenTreasureChest");
		registerTile(TileEntityDungeonSpawnerEden.class, "EdenDungeonSpawner");
		
		ZGHelper.echo("Loaded a total of " + totalTileEntities
				+ " new tile entities.");
	}
	
	public static void registerTile(Class<? extends TileEntity> tile, String id) {
		GameRegistry.registerTileEntity(tile, id);
		totalTileEntities++;
	}
}