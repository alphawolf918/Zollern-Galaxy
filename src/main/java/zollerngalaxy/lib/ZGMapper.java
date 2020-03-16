/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.ItemStack;

public class ZGMapper extends StateMapperBase implements ItemMeshDefinition {
	
	public final ModelResourceLocation location;
	
	public ZGMapper(String modName, String fileName, String modelName) {
		this.location = new ModelResourceLocation(modName + ":" + fileName, modelName);
	}
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		return location;
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		return location;
	}
	
}