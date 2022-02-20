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
import net.minecraft.util.math.MathHelper;

public class ModelSentinelHound extends ModelBase {
	
	private final ModelRenderer sentinelHound;
	private final ModelRenderer Head;
	private final ModelRenderer head;
	private final ModelRenderer Snout;
	private final ModelRenderer Neck;
	private final ModelRenderer neck4;
	private final ModelRenderer neck3;
	private final ModelRenderer neck2;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Leg1;
	private final ModelRenderer leg3;
	private final ModelRenderer leg2;
	private final ModelRenderer Leg2;
	private final ModelRenderer leg6;
	private final ModelRenderer leg5;
	private final ModelRenderer Leg3;
	private final ModelRenderer leg9;
	private final ModelRenderer leg8;
	private final ModelRenderer Leg4;
	private final ModelRenderer leg12;
	private final ModelRenderer leg11;
	private final ModelRenderer Tail;
	private final ModelRenderer tail3;
	private final ModelRenderer tail2;
	
	public ModelSentinelHound() {
		textureWidth = 64;
		textureHeight = 64;
		
		sentinelHound = new ModelRenderer(this);
		sentinelHound.setRotationPoint(0.0F, 22.0F, -2.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinelHound.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 10, -2.0F, -23.0F, -14.0F, 5, 2, 1, 0.0F, false));
		
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 1.0F);
		Head.addChild(head);
		setRotationAngle(head, -0.0436F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 15, -3.0F, -23.0F, -15.0F, 7, 5, 10, 0.0F, false));
		
		Snout = new ModelRenderer(this);
		Snout.setRotationPoint(0.0F, 0.0F, 1.0F);
		Head.addChild(Snout);
		setRotationAngle(Snout, -0.0436F, 0.0F, 0.0F);
		Snout.cubeList.add(new ModelBox(Snout, 0, 0, -2.0F, -20.0F, -18.0F, 5, 2, 13, 0.0F, false));
		
		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(1.0F, 0.0F, 0.0F);
		Head.addChild(Neck);
		
		neck4 = new ModelRenderer(this);
		neck4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck4);
		setRotationAngle(neck4, 0.2182F, 0.0F, 0.0F);
		neck4.cubeList.add(new ModelBox(neck4, 0, 30, -2.0F, -20.0F, -4.0F, 3, 5, 5, 0.0F, false));
		neck4.cubeList.add(new ModelBox(neck4, 11, 35, -2.0F, -12.0F, -2.0F, 3, 5, 5, 0.0F, false));
		
		neck3 = new ModelRenderer(this);
		neck3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck3);
		setRotationAngle(neck3, 0.4363F, 0.0F, 0.0F);
		neck3.cubeList.add(new ModelBox(neck3, 27, 35, -2.0F, -18.0F, 0.0F, 3, 4, 5, 0.0F, false));
		
		neck2 = new ModelRenderer(this);
		neck2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck2);
		setRotationAngle(neck2, 0.3491F, 0.0F, 0.0F);
		neck2.cubeList.add(new ModelBox(neck2, 38, 39, -2.0F, -15.0F, -1.0F, 3, 4, 5, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 23, 0, -3.0F, -8.0F, -4.0F, 7, 5, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 26, 22, -2.0F, -8.0F, 4.0F, 5, 5, 8, 0.0F, false));
		sentinelHound.addChild(Body);
		
		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinelHound.addChild(Legs);
		
		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Leg1);
		Leg1.cubeList.add(new ModelBox(Leg1, 49, 48, -5.0F, -7.0F, -3.0F, 2, 6, 2, 0.0F, false));
		
		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(leg3);
		setRotationAngle(leg3, 1.789F, 0.0F, 0.0436F);
		leg3.cubeList.add(new ModelBox(leg3, 25, 44, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(leg2);
		setRotationAngle(leg2, 1.8326F, 0.0F, 0.0436F);
		leg2.cubeList.add(new ModelBox(leg2, 41, 48, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(9.0F, 0.0F, 0.0F);
		Legs.addChild(Leg2);
		Leg2.cubeList.add(new ModelBox(Leg2, 49, 35, -5.0F, -7.0F, -3.0F, 2, 6, 2, 0.0F, false));
		
		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(leg6);
		setRotationAngle(leg6, 1.789F, 0.0F, 0.0436F);
		leg6.cubeList.add(new ModelBox(leg6, 44, 19, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(leg5);
		setRotationAngle(leg5, 1.8326F, 0.0F, 0.0436F);
		leg5.cubeList.add(new ModelBox(leg5, 33, 48, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(9.0F, 0.0F, 9.0F);
		Legs.addChild(Leg3);
		Leg3.cubeList.add(new ModelBox(Leg3, 45, 0, -5.0F, -7.0F, -2.0F, 2, 6, 2, 0.0F, false));
		
		leg9 = new ModelRenderer(this);
		leg9.setRotationPoint(0.0F, 0.0F, 1.0F);
		Leg3.addChild(leg9);
		setRotationAngle(leg9, 1.789F, 0.0F, 0.0436F);
		leg9.cubeList.add(new ModelBox(leg9, 0, 15, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(0.0F, 0.0F, 1.0F);
		Leg3.addChild(leg8);
		setRotationAngle(leg8, 1.8326F, 0.0F, 0.0436F);
		leg8.cubeList.add(new ModelBox(leg8, 0, 46, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(9.0F, 0.0F, 9.0F);
		Legs.addChild(Leg4);
		Leg4.cubeList.add(new ModelBox(Leg4, 23, 0, -14.0F, -7.0F, -2.0F, 2, 6, 2, 0.0F, false));
		
		leg12 = new ModelRenderer(this);
		leg12.setRotationPoint(-9.0F, 0.0F, 1.0F);
		Leg4.addChild(leg12);
		setRotationAngle(leg12, 1.789F, 0.0F, 0.0436F);
		leg12.cubeList.add(new ModelBox(leg12, 0, 0, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg11 = new ModelRenderer(this);
		leg11.setRotationPoint(-9.0F, 0.0F, 1.0F);
		Leg4.addChild(leg11);
		setRotationAngle(leg11, 1.8326F, 0.0F, 0.0436F);
		leg11.cubeList.add(new ModelBox(leg11, 14, 45, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -1.0F, 0.0F);
		sentinelHound.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 0, 40, -1.0F, -5.0F, 10.0F, 3, 1, 5, 0.0F, false));
		
		tail3 = new ModelRenderer(this);
		tail3.setRotationPoint(0.0F, -4.0F, 21.0F);
		Tail.addChild(tail3);
		setRotationAngle(tail3, 0.4796F, 0.0201F, -0.0387F);
		tail3.cubeList.add(new ModelBox(tail3, 24, 15, -1.0F, -3.0F, -3.0F, 3, 1, 6, 0.0F, false));
		
		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(tail2);
		setRotationAngle(tail2, 0.1309F, 0.0F, 0.0F);
		tail2.cubeList.add(new ModelBox(tail2, 36, 13, -1.0F, -3.0F, 14.0F, 3, 1, 5, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		sentinelHound.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.Leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.Leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
}