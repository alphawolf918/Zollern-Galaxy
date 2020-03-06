/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Made by DabbingEevee
 */
public class ModelBladeFish extends ModelBase {
	
	private final ModelRenderer fishbody;
	private final ModelRenderer finsandstuff;
	
	public ModelBladeFish() {
		textureWidth = 32;
		textureHeight = 32;
		
		fishbody = new ModelRenderer(this);
		fishbody.setRotationPoint(0.0F, 24.0F, 0.0F);
		fishbody.cubeList.add(new ModelBox(fishbody, 0, 0, -1.0F, -4.0F, -1.0F, 2, 4, 8, 0.0F, false));
		fishbody.cubeList.add(new ModelBox(fishbody, 0, 5, 0.0F, -3.0F, -8.0F, 0, 2, 7, 0.0F, false));
		
		finsandstuff = new ModelRenderer(this);
		finsandstuff.setRotationPoint(0.0F, 24.0F, 0.0F);
		finsandstuff.cubeList.add(new ModelBox(finsandstuff, 0, 11, 0.0F, -4.0F, 7.0F, 0, 4, 3, 0.0F, false));
		finsandstuff.cubeList.add(new ModelBox(finsandstuff, 12, 12, -3.0F, -1.0F, 0.0F, 6, 1, 2, 0.0F, false));
		finsandstuff.cubeList.add(new ModelBox(finsandstuff, 0, 0, 0.0F, -6.0F, 0.0F, 0, 2, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		fishbody.render(f5);
		finsandstuff.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}