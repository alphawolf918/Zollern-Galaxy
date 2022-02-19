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

public class ModelSentinelHound extends ModelBase {
	
	private final ModelRenderer sentinelHound;
	private final ModelRenderer Head;
	private final ModelRenderer head_r1;
	private final ModelRenderer Snout;
	private final ModelRenderer Neck;
	private final ModelRenderer neck4_r1;
	private final ModelRenderer neck3_r1;
	private final ModelRenderer neck2_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Leg1;
	private final ModelRenderer leg3_r1;
	private final ModelRenderer leg2_r1;
	private final ModelRenderer Leg2;
	private final ModelRenderer leg6_r1;
	private final ModelRenderer leg5_r1;
	private final ModelRenderer Leg3;
	private final ModelRenderer leg9_r1;
	private final ModelRenderer leg8_r1;
	private final ModelRenderer Leg4;
	private final ModelRenderer leg12_r1;
	private final ModelRenderer leg11_r1;
	private final ModelRenderer Tail;
	private final ModelRenderer tail3_r1;
	private final ModelRenderer tail2_r1;
	
	public ModelSentinelHound() {
		textureWidth = 64;
		textureHeight = 64;
		
		sentinelHound = new ModelRenderer(this);
		sentinelHound.setRotationPoint(0.0F, 22.0F, -2.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinelHound.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 10, -2.0F, -23.0F, -14.0F, 5, 2, 1, 0.0F, false));
		
		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		Head.addChild(head_r1);
		setRotationAngle(head_r1, -0.0436F, 0.0F, 0.0F);
		head_r1.cubeList.add(new ModelBox(head_r1, 0, 15, -3.0F, -23.0F, -15.0F, 7, 5, 10, 0.0F, false));
		
		Snout = new ModelRenderer(this);
		Snout.setRotationPoint(0.0F, 0.0F, 1.0F);
		Head.addChild(Snout);
		setRotationAngle(Snout, -0.0436F, 0.0F, 0.0F);
		Snout.cubeList.add(new ModelBox(Snout, 0, 0, -2.0F, -20.0F, -18.0F, 5, 2, 13, 0.0F, false));
		
		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(1.0F, 0.0F, 0.0F);
		Head.addChild(Neck);
		
		neck4_r1 = new ModelRenderer(this);
		neck4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck4_r1);
		setRotationAngle(neck4_r1, 0.2182F, 0.0F, 0.0F);
		neck4_r1.cubeList.add(new ModelBox(neck4_r1, 0, 30, -2.0F, -20.0F, -4.0F, 3, 5, 5, 0.0F, false));
		neck4_r1.cubeList.add(new ModelBox(neck4_r1, 11, 35, -2.0F, -12.0F, -2.0F, 3, 5, 5, 0.0F, false));
		
		neck3_r1 = new ModelRenderer(this);
		neck3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck3_r1);
		setRotationAngle(neck3_r1, 0.4363F, 0.0F, 0.0F);
		neck3_r1.cubeList.add(new ModelBox(neck3_r1, 27, 35, -2.0F, -18.0F, 0.0F, 3, 4, 5, 0.0F, false));
		
		neck2_r1 = new ModelRenderer(this);
		neck2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(neck2_r1);
		setRotationAngle(neck2_r1, 0.3491F, 0.0F, 0.0F);
		neck2_r1.cubeList.add(new ModelBox(neck2_r1, 38, 39, -2.0F, -15.0F, -1.0F, 3, 4, 5, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinelHound.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 23, 0, -3.0F, -8.0F, -4.0F, 7, 5, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 26, 22, -2.0F, -8.0F, 4.0F, 5, 5, 8, 0.0F, false));
		
		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinelHound.addChild(Legs);
		
		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(Leg1);
		Leg1.cubeList.add(new ModelBox(Leg1, 49, 48, -5.0F, -7.0F, -3.0F, 2, 6, 2, 0.0F, false));
		
		leg3_r1 = new ModelRenderer(this);
		leg3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(leg3_r1);
		setRotationAngle(leg3_r1, 1.789F, 0.0F, 0.0436F);
		leg3_r1.cubeList.add(new ModelBox(leg3_r1, 25, 44, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg2_r1 = new ModelRenderer(this);
		leg2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(leg2_r1);
		setRotationAngle(leg2_r1, 1.8326F, 0.0F, 0.0436F);
		leg2_r1.cubeList.add(new ModelBox(leg2_r1, 41, 48, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(9.0F, 0.0F, 0.0F);
		Legs.addChild(Leg2);
		Leg2.cubeList.add(new ModelBox(Leg2, 49, 35, -5.0F, -7.0F, -3.0F, 2, 6, 2, 0.0F, false));
		
		leg6_r1 = new ModelRenderer(this);
		leg6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(leg6_r1);
		setRotationAngle(leg6_r1, 1.789F, 0.0F, 0.0436F);
		leg6_r1.cubeList.add(new ModelBox(leg6_r1, 44, 19, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg5_r1 = new ModelRenderer(this);
		leg5_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(leg5_r1);
		setRotationAngle(leg5_r1, 1.8326F, 0.0F, 0.0436F);
		leg5_r1.cubeList.add(new ModelBox(leg5_r1, 33, 48, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(9.0F, 0.0F, 9.0F);
		Legs.addChild(Leg3);
		Leg3.cubeList.add(new ModelBox(Leg3, 45, 0, -5.0F, -7.0F, -2.0F, 2, 6, 2, 0.0F, false));
		
		leg9_r1 = new ModelRenderer(this);
		leg9_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		Leg3.addChild(leg9_r1);
		setRotationAngle(leg9_r1, 1.789F, 0.0F, 0.0436F);
		leg9_r1.cubeList.add(new ModelBox(leg9_r1, 0, 15, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg8_r1 = new ModelRenderer(this);
		leg8_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		Leg3.addChild(leg8_r1);
		setRotationAngle(leg8_r1, 1.8326F, 0.0F, 0.0436F);
		leg8_r1.cubeList.add(new ModelBox(leg8_r1, 0, 46, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(9.0F, 0.0F, 9.0F);
		Legs.addChild(Leg4);
		Leg4.cubeList.add(new ModelBox(Leg4, 23, 0, -14.0F, -7.0F, -2.0F, 2, 6, 2, 0.0F, false));
		
		leg12_r1 = new ModelRenderer(this);
		leg12_r1.setRotationPoint(-9.0F, 0.0F, 1.0F);
		Leg4.addChild(leg12_r1);
		setRotationAngle(leg12_r1, 1.789F, 0.0F, 0.0436F);
		leg12_r1.cubeList.add(new ModelBox(leg12_r1, 0, 0, -5.0F, -9.0F, 0.0F, 2, 8, 2, 0.0F, false));
		
		leg11_r1 = new ModelRenderer(this);
		leg11_r1.setRotationPoint(-9.0F, 0.0F, 1.0F);
		Leg4.addChild(leg11_r1);
		setRotationAngle(leg11_r1, 1.8326F, 0.0F, 0.0436F);
		leg11_r1.cubeList.add(new ModelBox(leg11_r1, 14, 45, -5.0F, -8.0F, 1.0F, 2, 7, 2, 0.0F, false));
		
		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -1.0F, 0.0F);
		sentinelHound.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 0, 40, -1.0F, -5.0F, 10.0F, 3, 1, 5, 0.0F, false));
		
		tail3_r1 = new ModelRenderer(this);
		tail3_r1.setRotationPoint(0.0F, -4.0F, 21.0F);
		Tail.addChild(tail3_r1);
		setRotationAngle(tail3_r1, 0.4796F, 0.0201F, -0.0387F);
		tail3_r1.cubeList.add(new ModelBox(tail3_r1, 24, 15, -1.0F, -3.0F, -3.0F, 3, 1, 6, 0.0F, false));
		
		tail2_r1 = new ModelRenderer(this);
		tail2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(tail2_r1);
		setRotationAngle(tail2_r1, 0.1309F, 0.0F, 0.0F);
		tail2_r1.cubeList.add(new ModelBox(tail2_r1, 36, 13, -1.0F, -3.0F, 14.0F, 3, 1, 5, 0.0F, false));
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
}