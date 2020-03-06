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
public class ModelBlubberFish extends ModelBase {
	
	private final ModelRenderer body;
	private final ModelRenderer other;
	
	public ModelBlubberFish() {
		textureWidth = 64;
		textureHeight = 64;
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -5.0F, -4.0F, 8, 5, 8, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 13, -7.0F, -1.0F, 0.0F, 14, 0, 3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 14, 14, 0.0F, -8.0F, -4.0F, 0, 3, 7, 0.0F, false));
		
		other = new ModelRenderer(this);
		other.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(other, 0.0F, 3.1416F, 0.0F);
		other.cubeList.add(new ModelBox(other, 0, 9, 0.0F, -6.0F, -11.0F, 0, 7, 7, 0.0F, false));
		other.cubeList.add(new ModelBox(other, 0, 23, -3.0F, -4.0F, 4.0F, 6, 4, 2, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		other.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}