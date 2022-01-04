/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterUtilsZG {
	
	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) {
		GameRegistry.registerTileEntity(tileEntityClass, name);
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, ResourceLocation location) {
		GameRegistry.registerTileEntity(tileEntityClass, location);
	}
	
	public static void registerEventHandler(Object handler) {
		MinecraftForge.EVENT_BUS.register(handler);
	}
	
}
