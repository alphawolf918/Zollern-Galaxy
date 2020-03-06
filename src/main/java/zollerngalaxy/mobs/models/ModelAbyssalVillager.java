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
public class ModelAbyssalVillager extends ModelBase {
	
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	
	public ModelAbyssalVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 32, 10, 0.0F, -15.0F, -2.0F, 0, 5, 6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 18, -8.0F, -13.0F, 1.0F, 16, 12, 0, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 28, 28, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 38, 40, 0.0F, 0.0F, 2.0F, 0, 9, 4, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 32, 0, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 28, 42, -1.0F, -1.0F, 2.0F, 0, 8, 2, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 28, 42, 1.0F, -1.0F, 2.0F, 0, 8, 2, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 30, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 21, 0, -2.2F, 12.0F, -4.0F, 4, 0, 3, 0.0F, false));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 16, 30, -2.1F, 0.0F, -1.0F, 4, 12, 2, 0.0F, true));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 32, 41, 0.0F, 1.0F, 1.0F, 0, 12, 3, 0.0F, false));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 32, 41, 0.2F, 1.0F, 1.0F, 0, 12, 3, 0.0F, false));
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 30, -2.0F, 0.0F, -1.0F, 4, 12, 2, 0.0F, false));
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 21, 3, -2.0F, 12.0F, -4.0F, 4, 0, 3, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		Body.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		RightLeg.render(f5);
		LeftLeg.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}