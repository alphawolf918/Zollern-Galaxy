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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelSentinelWalker extends ModelBase {
	
	private final ModelRenderer walker;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm4_r1;
	private final ModelRenderer RightArm3_r1;
	private final ModelRenderer RightArm2_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm4_r1;
	private final ModelRenderer LeftArm3_r1;
	private final ModelRenderer LeftArm2_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg2_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg2_r1;
	
	public ModelSentinelWalker() {
		textureWidth = 256;
		textureHeight = 256;
		
		walker = new ModelRenderer(this);
		walker.setRotationPoint(0.0F, 6.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -39.0F, 0.0F);
		walker.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 181, 207, -7.0F, -6.0F, -4.0F, 14, 14, 10, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 207, 7, -3.0F, -2.0F, -7.0F, 6, 7, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 208, 36, -6.0F, -7.75F, -5.0F, 12, 18, 12, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -12.0F, 0.0F);
		walker.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 61, 194, -5.0F, -16.75F, -5.0F, 10, 25, 12, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -23.0F, 0.0F);
		walker.addChild(RightArm);
		
		RightArm4_r1 = new ModelRenderer(this);
		RightArm4_r1.setRotationPoint(8.0F, 25.0F, -1.0F);
		RightArm.addChild(RightArm4_r1);
		setRotationAngle(RightArm4_r1, -1.0472F, 0.0F, 0.0F);
		RightArm4_r1.cubeList.add(new ModelBox(RightArm4_r1, 55, 207, -18.0F, 0.0F, -16.0F, 7, 12, 5, 0.0F, false));
		
		RightArm3_r1 = new ModelRenderer(this);
		RightArm3_r1.setRotationPoint(8.0F, 25.0F, -1.0F);
		RightArm.addChild(RightArm3_r1);
		setRotationAngle(RightArm3_r1, -0.7418F, 0.0F, 0.0F);
		RightArm3_r1.cubeList.add(new ModelBox(RightArm3_r1, 55, 207, -18.0F, -13.0F, -16.0F, 7, 12, 5, 0.0F, false));
		
		RightArm2_r1 = new ModelRenderer(this);
		RightArm2_r1.setRotationPoint(8.0F, 25.0F, -1.0F);
		RightArm.addChild(RightArm2_r1);
		setRotationAngle(RightArm2_r1, -0.3927F, 0.0F, 0.0F);
		RightArm2_r1.cubeList.add(new ModelBox(RightArm2_r1, 55, 207, -18.0F, -28.0F, -12.0F, 7, 12, 7, 0.0F, false));
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, -4.0F, -24.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -1.5708F, 0.0F, 0.0F);
		RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 55, 207, -14.0F, -30.0F, -2.0F, 10, 11, 5, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		walker.addChild(LeftArm);
		
		LeftArm4_r1 = new ModelRenderer(this);
		LeftArm4_r1.setRotationPoint(-2.0F, 24.0F, -1.0F);
		LeftArm.addChild(LeftArm4_r1);
		setRotationAngle(LeftArm4_r1, -1.0472F, 0.0F, 0.0F);
		LeftArm4_r1.cubeList.add(new ModelBox(LeftArm4_r1, 55, 207, 5.0F, 0.0F, -16.0F, 7, 12, 5, 0.0F, false));
		
		LeftArm3_r1 = new ModelRenderer(this);
		LeftArm3_r1.setRotationPoint(20.0F, 24.0F, -1.0F);
		LeftArm.addChild(LeftArm3_r1);
		setRotationAngle(LeftArm3_r1, -0.7418F, 0.0F, 0.0F);
		LeftArm3_r1.cubeList.add(new ModelBox(LeftArm3_r1, 55, 207, -17.0F, -13.0F, -16.0F, 7, 12, 5, 0.0F, false));
		
		LeftArm2_r1 = new ModelRenderer(this);
		LeftArm2_r1.setRotationPoint(20.0F, 24.0F, -1.0F);
		LeftArm.addChild(LeftArm2_r1);
		setRotationAngle(LeftArm2_r1, -0.3927F, 0.0F, 0.0F);
		LeftArm2_r1.cubeList.add(new ModelBox(LeftArm2_r1, 55, 207, -17.0F, -28.0F, -12.0F, 7, 12, 7, 0.0F, false));
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, -5.0F, -24.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.5708F, 0.0F, 0.0F);
		LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 55, 207, 4.0F, -30.0F, -2.0F, 10, 11, 5, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(5.1F, -3.0F, 0.0F);
		walker.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 82, 211, -13.1F, -7.0F, -3.0F, 4, 13, 8, 0.0F, true));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 82, 211, -13.1F, 7.0F, -5.0F, 4, 14, 8, 0.0F, true));
		
		RightLeg2_r1 = new ModelRenderer(this);
		RightLeg2_r1.setRotationPoint(1.9F, 11.0F, 0.0F);
		RightLeg.addChild(RightLeg2_r1);
		setRotationAngle(RightLeg2_r1, -0.2618F, 0.0F, 0.0F);
		RightLeg2_r1.cubeList.add(new ModelBox(RightLeg2_r1, 82, 211, -15.0F, -11.0F, -4.0F, 4, 15, 7, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		walker.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 82, 211, 2.0F, 2.0F, -3.0F, 4, 13, 8, 0.0F, false));
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 82, 211, 2.1F, 16.0F, -5.0F, 4, 14, 8, 0.0F, true));
		
		LeftLeg2_r1 = new ModelRenderer(this);
		LeftLeg2_r1.setRotationPoint(5.1F, 20.0F, 0.0F);
		LeftLeg.addChild(LeftLeg2_r1);
		setRotationAngle(LeftLeg2_r1, -0.2618F, 0.0F, 0.0F);
		LeftLeg2_r1.cubeList.add(new ModelBox(LeftLeg2_r1, 82, 211, -3.0F, -11.0F, -4.0F, 4, 15, 7, 0.0F, true));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		walker.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
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
}