/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.villagers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelPurgotVillager extends ModelBase {
	
	private final ModelRenderer villager;
	private final ModelRenderer Head;
	private final ModelRenderer Nose_r1;
	private final ModelRenderer HeadSpikes;
	private final ModelRenderer HeadSpikes1;
	private final ModelRenderer HeadSpike5_r1;
	private final ModelRenderer HeadSpike4_r1;
	private final ModelRenderer HeadSpikes2;
	private final ModelRenderer HeadSpike10_r1;
	private final ModelRenderer HeadSpike9_r1;
	private final ModelRenderer HeadSpikes3;
	private final ModelRenderer HeadSpike15_r1;
	private final ModelRenderer HeadSpike14_r1;
	private final ModelRenderer HeadSpikes4;
	private final ModelRenderer HeadSpike20_r1;
	private final ModelRenderer HeadSpike19_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Tail;
	private final ModelRenderer Tail8_r1;
	private final ModelRenderer Tail7_r1;
	private final ModelRenderer Tail6_r1;
	private final ModelRenderer Tail5_r1;
	private final ModelRenderer Tail4_r1;
	private final ModelRenderer Tail3_r1;
	private final ModelRenderer Tail2_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	
	public ModelPurgotVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		villager = new ModelRenderer(this);
		villager.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -25.0F, 0.0F);
		villager.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 11, 8, 0.0F, false));
		
		Nose_r1 = new ModelRenderer(this);
		Nose_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(Nose_r1);
		setRotationAngle(Nose_r1, -1.4835F, 0.0F, 0.0F);
		Nose_r1.cubeList.add(new ModelBox(Nose_r1, 24, 0, -1.0F, -1.0F, -27.0F, 2, 4, 2, 0.0F, false));
		
		HeadSpikes = new ModelRenderer(this);
		HeadSpikes.setRotationPoint(0.0F, -2.0F, -2.0F);
		Head.addChild(HeadSpikes);
		
		HeadSpikes1 = new ModelRenderer(this);
		HeadSpikes1.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadSpikes.addChild(HeadSpikes1);
		setRotationAngle(HeadSpikes1, -0.3491F, 0.0F, 0.0F);
		HeadSpikes1.cubeList.add(new ModelBox(HeadSpikes1, 38, 54, -6.0F, -9.0F, -2.0F, 2, 5, 3, 0.0F, false));
		HeadSpikes1.cubeList.add(new ModelBox(HeadSpikes1, 30, 54, -8.0F, -12.0F, -2.0F, 2, 7, 3, 0.0F, false));
		HeadSpikes1.cubeList.add(new ModelBox(HeadSpikes1, 30, 54, -10.0F, -14.0F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpike5_r1 = new ModelRenderer(this);
		HeadSpike5_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes1.addChild(HeadSpike5_r1);
		setRotationAngle(HeadSpike5_r1, 0.0F, 0.0F, -0.4363F);
		HeadSpike5_r1.cubeList.add(new ModelBox(HeadSpike5_r1, 30, 54, -5.0F, -20.0F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpike4_r1 = new ModelRenderer(this);
		HeadSpike4_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes1.addChild(HeadSpike4_r1);
		setRotationAngle(HeadSpike4_r1, 0.0F, 0.0F, -0.1745F);
		HeadSpike4_r1.cubeList.add(new ModelBox(HeadSpike4_r1, 30, 54, -8.0F, -16.0F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpikes2 = new ModelRenderer(this);
		HeadSpikes2.setRotationPoint(0.0F, 0.0F, -1.0F);
		HeadSpikes.addChild(HeadSpikes2);
		setRotationAngle(HeadSpikes2, -2.8324F, -0.0834F, 3.098F);
		HeadSpikes2.cubeList.add(new ModelBox(HeadSpikes2, 38, 54, -6.0F, -9.0F, -2.0F, 2, 5, 3, 0.0F, false));
		HeadSpikes2.cubeList.add(new ModelBox(HeadSpikes2, 30, 54, -8.0F, -12.0F, -2.0F, 2, 7, 3, 0.0F, false));
		HeadSpikes2.cubeList.add(new ModelBox(HeadSpikes2, 30, 54, -10.0F, -14.0F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpike10_r1 = new ModelRenderer(this);
		HeadSpike10_r1.setRotationPoint(-1.0F, -1.0F, 0.0F);
		HeadSpikes2.addChild(HeadSpike10_r1);
		setRotationAngle(HeadSpike10_r1, 0.0F, 0.0F, -0.4363F);
		HeadSpike10_r1.cubeList.add(new ModelBox(HeadSpike10_r1, 30, 54, -4.5774F, -20.9063F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpike9_r1 = new ModelRenderer(this);
		HeadSpike9_r1.setRotationPoint(-1.0F, -1.0F, 0.0F);
		HeadSpikes2.addChild(HeadSpike9_r1);
		setRotationAngle(HeadSpike9_r1, 0.0F, 0.0F, -0.1745F);
		HeadSpike9_r1.cubeList.add(new ModelBox(HeadSpike9_r1, 30, 54, -7.8264F, -16.9848F, -2.0F, 2, 7, 3, 0.0F, false));
		
		HeadSpikes3 = new ModelRenderer(this);
		HeadSpikes3.setRotationPoint(-1.0F, -12.0F, 0.0F);
		HeadSpikes.addChild(HeadSpikes3);
		setRotationAngle(HeadSpikes3, -0.4363F, 0.0F, -3.1416F);
		HeadSpikes3.cubeList.add(new ModelBox(HeadSpikes3, 38, 54, -6.0F, -10.8126F, -2.8452F, 2, 5, 3, 0.0F, false));
		HeadSpikes3.cubeList.add(new ModelBox(HeadSpikes3, 30, 54, -8.0F, -13.8126F, -2.8452F, 2, 7, 3, 0.0F, false));
		HeadSpikes3.cubeList.add(new ModelBox(HeadSpikes3, 30, 54, -10.0F, -15.8126F, -2.8452F, 2, 7, 3, 0.0F, false));
		
		HeadSpike15_r1 = new ModelRenderer(this);
		HeadSpike15_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes3.addChild(HeadSpike15_r1);
		setRotationAngle(HeadSpike15_r1, 0.0F, 0.0F, -0.4363F);
		HeadSpike15_r1.cubeList.add(new ModelBox(HeadSpike15_r1, 30, 54, -4.234F, -21.6428F, -2.8452F, 2, 7, 3, 0.0F, false));
		
		HeadSpike14_r1 = new ModelRenderer(this);
		HeadSpike14_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes3.addChild(HeadSpike14_r1);
		setRotationAngle(HeadSpike14_r1, 0.0F, 0.0F, -0.1745F);
		HeadSpike14_r1.cubeList.add(new ModelBox(HeadSpike14_r1, 30, 54, -7.6852F, -17.7851F, -2.8452F, 2, 7, 3, 0.0F, false));
		
		HeadSpikes4 = new ModelRenderer(this);
		HeadSpikes4.setRotationPoint(1.0F, -12.0F, 0.0F);
		HeadSpikes.addChild(HeadSpikes4);
		setRotationAngle(HeadSpikes4, -2.8362F, -0.0436F, 0.0F);
		HeadSpikes4.cubeList.add(new ModelBox(HeadSpikes4, 38, 54, -6.0F, -10.9074F, -1.3986F, 2, 5, 3, 0.0F, false));
		HeadSpikes4.cubeList.add(new ModelBox(HeadSpikes4, 30, 54, -8.0F, -13.9074F, -1.3986F, 2, 7, 3, 0.0F, false));
		HeadSpikes4.cubeList.add(new ModelBox(HeadSpikes4, 30, 54, -10.0F, -15.9074F, -1.3986F, 2, 7, 3, 0.0F, false));
		
		HeadSpike20_r1 = new ModelRenderer(this);
		HeadSpike20_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes4.addChild(HeadSpike20_r1);
		setRotationAngle(HeadSpike20_r1, 0.0F, 0.0F, -0.4363F);
		HeadSpike20_r1.cubeList.add(new ModelBox(HeadSpike20_r1, 30, 54, -4.1939F, -21.7287F, -1.3986F, 2, 7, 3, 0.0F, false));
		
		HeadSpike19_r1 = new ModelRenderer(this);
		HeadSpike19_r1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		HeadSpikes4.addChild(HeadSpike19_r1);
		setRotationAngle(HeadSpike19_r1, 0.0F, 0.0F, -0.1745F);
		HeadSpike19_r1.cubeList.add(new ModelBox(HeadSpike19_r1, 30, 54, -7.6688F, -17.8785F, -1.3986F, 2, 7, 3, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 18, 20, -4.0F, 0.25F, -2.0F, 8, 12, 4, 0.0F, false));
		
		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 1.0F, 0.0F);
		Body.addChild(Tail);
		Tail.cubeList.add(new ModelBox(Tail, 43, 56, -2.0F, 8.0F, 2.0F, 4, 3, 3, 0.0F, false));
		
		Tail8_r1 = new ModelRenderer(this);
		Tail8_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail8_r1);
		setRotationAngle(Tail8_r1, 0.5672F, 0.0F, 0.0F);
		Tail8_r1.cubeList.add(new ModelBox(Tail8_r1, 43, 56, -1.0F, 9.0F, 7.0F, 2, 3, 6, 0.0F, false));
		
		Tail7_r1 = new ModelRenderer(this);
		Tail7_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail7_r1);
		setRotationAngle(Tail7_r1, 0.394F, -0.0806F, -0.0335F);
		Tail7_r1.cubeList.add(new ModelBox(Tail7_r1, 43, 56, -2.0F, 9.0F, 7.0F, 2, 1, 7, 0.0F, false));
		
		Tail6_r1 = new ModelRenderer(this);
		Tail6_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail6_r1);
		setRotationAngle(Tail6_r1, 0.394F, 0.0806F, 0.0335F);
		Tail6_r1.cubeList.add(new ModelBox(Tail6_r1, 43, 56, 0.0F, 9.0F, 7.0F, 2, 1, 7, 0.0F, false));
		
		Tail5_r1 = new ModelRenderer(this);
		Tail5_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail5_r1);
		setRotationAngle(Tail5_r1, 0.3927F, 0.0F, 0.0F);
		Tail5_r1.cubeList.add(new ModelBox(Tail5_r1, 43, 56, -2.0F, 8.0F, 7.0F, 4, 3, 3, 0.0F, false));
		
		Tail4_r1 = new ModelRenderer(this);
		Tail4_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail4_r1);
		setRotationAngle(Tail4_r1, 0.5236F, 0.0F, 0.0F);
		Tail4_r1.cubeList.add(new ModelBox(Tail4_r1, 43, 56, -2.0F, 9.0F, 3.0F, 4, 3, 3, 0.0F, false));
		
		Tail3_r1 = new ModelRenderer(this);
		Tail3_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Tail.addChild(Tail3_r1);
		setRotationAngle(Tail3_r1, 0.2618F, 0.0F, 0.0F);
		Tail3_r1.cubeList.add(new ModelBox(Tail3_r1, 43, 56, -2.0F, 8.0F, 3.0F, 4, 3, 3, 0.0F, false));
		
		Tail2_r1 = new ModelRenderer(this);
		Tail2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(Tail2_r1);
		setRotationAngle(Tail2_r1, 0.0873F, 0.0F, 0.0F);
		Tail2_r1.cubeList.add(new ModelBox(Tail2_r1, 43, 56, -2.0F, 8.0F, 3.0F, 4, 3, 3, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		villager.addChild(RightArm);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 22, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		villager.addChild(LeftArm);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 22, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		villager.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 12, 47, -2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		villager.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 12, 47, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		villager.render(f5);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		boolean flag = (entityIn instanceof EntityLivingBase) && (((EntityLivingBase) entityIn).getTicksElytraFlying() > 4);
		float f = 1.0F;
		
		if (flag) {
			f = (float) (entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
			f = f / 0.2F;
			f = f * f * f;
		}
		
		if (f < 1.0F) {
			f = 1.0F;
		}
		
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		this.LeftArm.rotateAngleX = -0.75F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.RightArm.rotateAngleX = -0.75F;
		
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		
		this.RightArm.rotateAngleY = 0.0F;
		this.RightArm.rotateAngleZ = 0.0F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			ModelRenderer modelrenderer = this.LeftArm;
			float f1 = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.Body.rotateAngleY *= -1.0F;
			}
			
			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		
		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}