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

/**
 * Model by @author Zollern Wolf
 */
public class ModelGalaxyKnight extends ModelBase {
	
	private final ModelRenderer RightFoot;
	private final ModelRenderer LeftShoulder;
	private final ModelRenderer RightShoulder;
	private final ModelRenderer HeadThing;
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftFoot;
	
	public ModelGalaxyKnight() {
		textureWidth = 64;
		textureHeight = 64;
		
		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(0.0F, 22.0F, -5.0F);
		RightFoot.cubeList.add(new ModelBox(RightFoot, 5, 0, 0.0F, 0.0F, 0.0F, 4, 2, 6, 0.0F, true));
		
		LeftShoulder = new ModelRenderer(this);
		LeftShoulder.setRotationPoint(8.0F, -1.0F, -2.0F);
		LeftShoulder.cubeList.add(new ModelBox(LeftShoulder, 16, 53, 0.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F, true));
		
		RightShoulder = new ModelRenderer(this);
		RightShoulder.setRotationPoint(-10.0F, -1.0F, -2.0F);
		RightShoulder.cubeList.add(new ModelBox(RightShoulder, 16, 53, 0.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F, true));
		
		HeadThing = new ModelRenderer(this);
		HeadThing.setRotationPoint(-2.0F, -11.0F, 0.0F);
		setRotationAngle(HeadThing, 0.3569F, 0.0F, 0.0349F);
		HeadThing.cubeList.add(new ModelBox(HeadThing, 6, 0, 0.0349F, -0.1117F, -3.1601F, 4, 2, 8, 0.0F, true));
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -2.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F, true));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 16, 31, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 15, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 16, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(-4.0F, 22.0F, -5.0F);
		LeftFoot.cubeList.add(new ModelBox(LeftFoot, 5, 0, 0.0F, 0.0F, 0.0F, 4, 2, 6, 0.0F, true));
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch,
			float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, HeadPitch, scale, entityIn);
		RightFoot.render(scale);
		LeftShoulder.render(scale);
		RightShoulder.render(scale);
		HeadThing.render(scale);
		Head.render(scale);
		Body.render(scale);
		RightArm.render(scale);
		LeftArm.render(scale);
		RightLeg.render(scale);
		LeftLeg.render(scale);
		LeftFoot.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch,
			float scaleFactor, Entity entityIn) {
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
		this.HeadThing.rotateAngleY = netHeadYaw * 0.017453292F;
		this.HeadThing.rotateAngleX = headPitch * 0.017453292F;
		
		this.LeftShoulder.rotationPointZ = 0.0F;
		this.LeftShoulder.rotationPointX = 5.0F;
		this.LeftShoulder.rotateAngleX = -0.75F;
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		this.LeftArm.rotateAngleX = -0.75F;
		this.RightShoulder.rotationPointZ = 0.0F;
		this.RightShoulder.rotationPointX = -5.0F;
		this.RightShoulder.rotateAngleX = -0.75F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.RightArm.rotateAngleX = -0.75F;
		
		this.RightShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftShoulder.rotateAngleZ = 0.0F;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleZ = 0.0F;
		
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.RightFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.LeftFoot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.RightFoot.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.LeftFoot.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.RightFoot.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		this.LeftFoot.rotateAngleZ = 0.0F;
		
		this.RightShoulder.rotateAngleY = 0.0F;
		this.RightShoulder.rotateAngleZ = 0.0F;
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
			
			this.RightShoulder.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightShoulder.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftShoulder.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftShoulder.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightShoulder.rotateAngleY += this.Body.rotateAngleY;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftShoulder.rotateAngleY += this.Body.rotateAngleY;
			this.LeftShoulder.rotateAngleX += this.Body.rotateAngleY;
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
		
		this.RightShoulder.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftShoulder.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightShoulder.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftShoulder.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}