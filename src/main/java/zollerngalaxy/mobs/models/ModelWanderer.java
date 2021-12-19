/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBiped;

public class ModelWanderer extends ModelBiped {
	
	public ModelWanderer() {
		this(0.0F);
	}
	
	public ModelWanderer(float modelSize) {
		this(modelSize, 0.0F, 64, 32);
	}
	
	public ModelWanderer(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn) {
		super(modelSize, p_i1149_2_, textureWidthIn, textureHeightIn);
	}
}