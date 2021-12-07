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

public class ModelFacehugger extends ModelBase {
	
	private final ModelRenderer Facehugger;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer Legs1;
	private final ModelRenderer Leg4_r1;
	private final ModelRenderer Leg3_r1;
	private final ModelRenderer Legs2;
	private final ModelRenderer Leg8_r1;
	private final ModelRenderer Leg7_r1;
	private final ModelRenderer Legs3;
	private final ModelRenderer Leg12_r1;
	private final ModelRenderer Leg11_r1;
	private final ModelRenderer Legs4;
	private final ModelRenderer Leg16_r1;
	private final ModelRenderer Leg15_r1;
	private final ModelRenderer Tail;
	private final ModelRenderer TailPiece12_r1;
	private final ModelRenderer TailPiece11_r1;
	private final ModelRenderer TailPiece10_r1;
	private final ModelRenderer TailPiece8_r1;
	private final ModelRenderer TailPiece7_r1;
	private final ModelRenderer TailPiece6_r1;
	private final ModelRenderer TailPiece5_r1;
	private final ModelRenderer TailPiece4_r1;
	private final ModelRenderer TailPiece3_r1;
	private final ModelRenderer TailPiece2_r1;
	
	public ModelFacehugger() {
		textureWidth = 64;
		textureHeight = 32;
		
		Facehugger = new ModelRenderer(this);
		Facehugger.setRotationPoint(0.0F, 25.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Facehugger.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 10, 25, -6.0F, -7.0F, -2.0F, 11, 2, 4, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Facehugger.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 12, 23, -6.0F, -5.0F, -3.0F, 12, 3, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 39, 10, -3.0F, -8.0F, -3.0F, 6, 3, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 46, 13, -2.0F, -11.0F, -2.0F, 4, 3, 4, 0.0F, false));
		
		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Facehugger.addChild(Legs);
		
		Legs1 = new ModelRenderer(this);
		Legs1.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Legs.addChild(Legs1);
		setRotationAngle(Legs1, 0.0F, -0.3491F, 0.0F);
		Legs1.cubeList.add(new ModelBox(Legs1, 40, 13, -3.0F, -4.0F, 3.0F, 4, 2, 1, 0.0F, false));
		
		Leg4_r1 = new ModelRenderer(this);
		Leg4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs1.addChild(Leg4_r1);
		setRotationAngle(Leg4_r1, -0.4363F, 0.0F, 0.0F);
		Leg4_r1.cubeList.add(new ModelBox(Leg4_r1, 40, 10, -2.0F, -6.0F, 6.0F, 2, 1, 5, 0.0F, false));
		
		Leg3_r1 = new ModelRenderer(this);
		Leg3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs1.addChild(Leg3_r1);
		setRotationAngle(Leg3_r1, -0.1309F, 0.0F, 0.0F);
		Leg3_r1.cubeList.add(new ModelBox(Leg3_r1, 40, 10, -3.0F, -4.0F, 6.0F, 4, 1, 3, 0.0F, false));
		Leg3_r1.cubeList.add(new ModelBox(Leg3_r1, 40, 10, -3.0F, -4.0F, 3.0F, 4, 1, 3, 0.0F, false));
		
		Legs2 = new ModelRenderer(this);
		Legs2.setRotationPoint(-5.0F, 0.0F, 1.0F);
		Legs.addChild(Legs2);
		setRotationAngle(Legs2, -3.1416F, -0.2182F, 3.1416F);
		Legs2.cubeList.add(new ModelBox(Legs2, 40, 13, -3.0F, -4.0F, 3.0F, 4, 2, 1, 0.0F, false));
		
		Leg8_r1 = new ModelRenderer(this);
		Leg8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs2.addChild(Leg8_r1);
		setRotationAngle(Leg8_r1, -0.4363F, 0.0F, 0.0F);
		Leg8_r1.cubeList.add(new ModelBox(Leg8_r1, 40, 10, -2.0F, -6.0F, 6.0F, 2, 1, 5, 0.0F, false));
		
		Leg7_r1 = new ModelRenderer(this);
		Leg7_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs2.addChild(Leg7_r1);
		setRotationAngle(Leg7_r1, -0.1309F, 0.0F, 0.0F);
		Leg7_r1.cubeList.add(new ModelBox(Leg7_r1, 40, 10, -3.0F, -4.0F, 6.0F, 4, 1, 3, 0.0F, false));
		Leg7_r1.cubeList.add(new ModelBox(Leg7_r1, 40, 10, -3.0F, -4.0F, 3.0F, 4, 1, 3, 0.0F, false));
		
		Legs3 = new ModelRenderer(this);
		Legs3.setRotationPoint(2.0F, 0.0F, 0.0F);
		Legs.addChild(Legs3);
		setRotationAngle(Legs3, -3.1416F, 0.1745F, 3.1416F);
		Legs3.cubeList.add(new ModelBox(Legs3, 40, 13, -3.0F, -4.0F, 3.0F, 4, 2, 1, 0.0F, false));
		
		Leg12_r1 = new ModelRenderer(this);
		Leg12_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs3.addChild(Leg12_r1);
		setRotationAngle(Leg12_r1, -0.4363F, 0.0F, 0.0F);
		Leg12_r1.cubeList.add(new ModelBox(Leg12_r1, 40, 10, -2.0F, -6.0F, 6.0F, 2, 1, 5, 0.0F, false));
		
		Leg11_r1 = new ModelRenderer(this);
		Leg11_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs3.addChild(Leg11_r1);
		setRotationAngle(Leg11_r1, -0.1309F, 0.0F, 0.0F);
		Leg11_r1.cubeList.add(new ModelBox(Leg11_r1, 40, 10, -3.0F, -4.0F, 6.0F, 4, 1, 3, 0.0F, false));
		Leg11_r1.cubeList.add(new ModelBox(Leg11_r1, 40, 10, -3.0F, -4.0F, 3.0F, 4, 1, 3, 0.0F, false));
		
		Legs4 = new ModelRenderer(this);
		Legs4.setRotationPoint(4.0F, 0.0F, -1.0F);
		Legs.addChild(Legs4);
		setRotationAngle(Legs4, 0.0F, 0.0873F, 0.0F);
		Legs4.cubeList.add(new ModelBox(Legs4, 40, 13, -3.0F, -4.0F, 3.0F, 4, 2, 1, 0.0F, false));
		
		Leg16_r1 = new ModelRenderer(this);
		Leg16_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs4.addChild(Leg16_r1);
		setRotationAngle(Leg16_r1, -0.4363F, 0.0F, 0.0F);
		Leg16_r1.cubeList.add(new ModelBox(Leg16_r1, 40, 10, -2.0F, -6.0F, 6.0F, 2, 1, 5, 0.0F, false));
		
		Leg15_r1 = new ModelRenderer(this);
		Leg15_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs4.addChild(Leg15_r1);
		setRotationAngle(Leg15_r1, -0.1309F, 0.0F, 0.0F);
		Leg15_r1.cubeList.add(new ModelBox(Leg15_r1, 40, 10, -3.0F, -4.0F, 6.0F, 4, 1, 3, 0.0F, false));
		Leg15_r1.cubeList.add(new ModelBox(Leg15_r1, 40, 10, -3.0F, -4.0F, 3.0F, 4, 1, 3, 0.0F, false));
		
		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -2.0F, 0.0F);
		Facehugger.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 40, 0, -8.0F, -3.0F, -2.0F, 2, 1, 4, 0.0F, false));
		
		TailPiece12_r1 = new ModelRenderer(this);
		TailPiece12_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece12_r1);
		setRotationAngle(TailPiece12_r1, 0.0F, 0.0F, -2.5307F);
		TailPiece12_r1.cubeList.add(new ModelBox(TailPiece12_r1, 34, 0, 9.0F, 6.0F, -1.0F, 7, 2, 2, 0.0F, false));
		
		TailPiece11_r1 = new ModelRenderer(this);
		TailPiece11_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece11_r1);
		setRotationAngle(TailPiece11_r1, 0.0F, 0.0F, -2.4435F);
		TailPiece11_r1.cubeList.add(new ModelBox(TailPiece11_r1, 40, 0, 16.0F, 5.0F, -1.0F, 3, 2, 2, 0.0F, false));
		
		TailPiece10_r1 = new ModelRenderer(this);
		TailPiece10_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece10_r1);
		setRotationAngle(TailPiece10_r1, 0.0F, 0.0F, 2.7053F);
		TailPiece10_r1.cubeList.add(new ModelBox(TailPiece10_r1, 40, 0, 3.0F, 18.0F, -1.0F, 3, 2, 2, 0.0F, false));
		TailPiece10_r1.cubeList.add(new ModelBox(TailPiece10_r1, 40, 0, 5.0F, 18.0F, -2.0F, 3, 2, 4, 0.0F, false));
		
		TailPiece8_r1 = new ModelRenderer(this);
		TailPiece8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece8_r1);
		setRotationAngle(TailPiece8_r1, 0.0F, 0.0F, 1.789F);
		TailPiece8_r1.cubeList.add(new ModelBox(TailPiece8_r1, 40, 0, -10.0F, 16.0F, -2.0F, 3, 2, 4, 0.0F, false));
		
		TailPiece7_r1 = new ModelRenderer(this);
		TailPiece7_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece7_r1);
		setRotationAngle(TailPiece7_r1, 0.0F, 0.0F, 0.8727F);
		TailPiece7_r1.cubeList.add(new ModelBox(TailPiece7_r1, 40, 0, -18.0F, 3.0F, -2.0F, 3, 2, 4, 0.0F, false));
		
		TailPiece6_r1 = new ModelRenderer(this);
		TailPiece6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece6_r1);
		setRotationAngle(TailPiece6_r1, 0.0F, 0.0F, 0.6981F);
		TailPiece6_r1.cubeList.add(new ModelBox(TailPiece6_r1, 40, 0, -16.0F, 1.0F, -2.0F, 3, 2, 4, 0.0F, false));
		
		TailPiece5_r1 = new ModelRenderer(this);
		TailPiece5_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece5_r1);
		setRotationAngle(TailPiece5_r1, 0.0F, 0.0F, 0.4363F);
		TailPiece5_r1.cubeList.add(new ModelBox(TailPiece5_r1, 40, 0, -14.0F, -2.0F, -2.0F, 3, 2, 4, 0.0F, false));
		
		TailPiece4_r1 = new ModelRenderer(this);
		TailPiece4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece4_r1);
		setRotationAngle(TailPiece4_r1, 0.0F, 0.0F, 0.2618F);
		TailPiece4_r1.cubeList.add(new ModelBox(TailPiece4_r1, 40, 0, -12.0F, -3.0F, -2.0F, 3, 1, 4, 0.0F, false));
		
		TailPiece3_r1 = new ModelRenderer(this);
		TailPiece3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece3_r1);
		setRotationAngle(TailPiece3_r1, 0.0F, 0.0F, 0.1745F);
		TailPiece3_r1.cubeList.add(new ModelBox(TailPiece3_r1, 40, 0, -10.0F, -3.0F, -2.0F, 2, 1, 4, 0.0F, false));
		
		TailPiece2_r1 = new ModelRenderer(this);
		TailPiece2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece2_r1);
		setRotationAngle(TailPiece2_r1, 0.0F, 0.0F, 0.0873F);
		TailPiece2_r1.cubeList.add(new ModelBox(TailPiece2_r1, 40, 0, -9.0F, -3.0F, -2.0F, 2, 1, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Facehugger.render(f5);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		float f = ((float) Math.PI / 4F);
		// this.Legs1.rotateAngleZ = -((float) Math.PI / 4F);
		// this.Legs2.rotateAngleZ = ((float) Math.PI / 4F);
		// this.Legs3.rotateAngleZ = -0.58119464F;
		// this.Legs4.rotateAngleZ = 0.58119464F;
		float f1 = -0.0F;
		float f2 = 0.3926991F;
		// this.Legs1.rotateAngleY = ((float) Math.PI / 4F);
		// this.Legs2.rotateAngleY = -((float) Math.PI / 4F);
		// this.Legs3.rotateAngleY = 0.3926991F;
		// this.Legs4.rotateAngleY = -0.3926991F;
		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * limbSwingAmount;
		this.Legs1.rotateAngleY += f3;
		this.Legs2.rotateAngleY += -f3;
		this.Legs3.rotateAngleY += f4;
		this.Legs4.rotateAngleY += -f4;
		this.Legs1.rotateAngleZ += f7;
		this.Legs2.rotateAngleZ += -f7;
		this.Legs3.rotateAngleZ += f8;
		this.Legs4.rotateAngleZ += -f8;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}