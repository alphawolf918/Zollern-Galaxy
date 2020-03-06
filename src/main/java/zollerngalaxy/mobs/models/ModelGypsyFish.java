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
 * Made by @author DabbingEevee
 */
public class ModelGypsyFish extends ModelBase {
	
	private final ModelRenderer backFinRight;
	private final ModelRenderer backFinLeft;
	private final ModelRenderer frontFinLeft;
	private final ModelRenderer frontFinRight;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	
	public ModelGypsyFish() {
		textureWidth = 64;
		textureHeight = 64;
		
		backFinRight = new ModelRenderer(this);
		backFinRight.setRotationPoint(-8.0F, 23.5F, 3.0F);
		setRotationAngle(backFinRight, 0.0F, 0.0F, -0.5236F);
		backFinRight.cubeList.add(new ModelBox(backFinRight, 33, 12, 2.0F, -0.5F, 0.0F, 5, 1, 7, 0.0F, false));
		backFinRight.cubeList.add(new ModelBox(backFinRight, 20, 28, 1.0F, -0.5F, 2.0F, 3, 2, 10, 0.0F, false));
		
		backFinLeft = new ModelRenderer(this);
		backFinLeft.setRotationPoint(8.0F, 23.5F, 3.0F);
		setRotationAngle(backFinLeft, 0.0F, 0.0F, 0.5236F);
		backFinLeft.cubeList.add(new ModelBox(backFinLeft, 0, 34, -7.0F, -0.5F, 0.0F, 5, 1, 7, 0.0F, false));
		backFinLeft.cubeList.add(new ModelBox(backFinLeft, 20, 28, -4.0F, -0.5F, 2.0F, 3, 2, 10, 0.0F, false));
		
		frontFinLeft = new ModelRenderer(this);
		frontFinLeft.setRotationPoint(5.0F, 23.5F, -8.0F);
		frontFinLeft.cubeList.add(new ModelBox(frontFinLeft, 28, 40, -2.0F, -0.5F, 0.0F, 3, 1, 5, 0.0F, false));
		frontFinLeft.cubeList.add(new ModelBox(frontFinLeft, 38, 38, 1.0F, -0.5F, 2.0F, 1, 2, 8, 0.0F, false));
		
		frontFinRight = new ModelRenderer(this);
		frontFinRight.setRotationPoint(5.0F, 23.5F, -8.0F);
		frontFinRight.cubeList.add(new ModelBox(frontFinRight, 0, 13, -11.0F, -0.5F, 0.0F, 3, 1, 5, 0.0F, false));
		frontFinRight.cubeList.add(new ModelBox(frontFinRight, 36, 28, -12.0F, -0.5F, 2.0F, 1, 2, 8, 0.0F, false));
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -7.0F, -10.0F, 6, 7, 21, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 13, 0.0F, -13.0F, 1.0F, 0, 6, 15, 0.0F, false));
		
		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 24.0F, 0.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 36, 0.0F, -8.0F, 23.0F, 0, 9, 6, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 0, 0, -2.0F, -7.0F, 11.0F, 4, 7, 6, 0.0F, false));
		tail.cubeList.add(new ModelBox(tail, 18, 40, -1.0F, -7.0F, 17.0F, 2, 7, 6, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		backFinRight.render(f5);
		backFinLeft.render(f5);
		frontFinLeft.render(f5);
		frontFinRight.render(f5);
		body.render(f5);
		tail.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}