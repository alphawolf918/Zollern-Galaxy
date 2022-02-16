/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelKree extends ModelBiped {
	
	private final ModelRenderer kree;
	private final ModelRenderer bipedHead;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedLeftLeg;
	
	public ModelKree() {
		this(0.0F);
	}
	
	public ModelKree(float modelSize) {
		super(modelSize, 0.0F, 64, 64);
		textureWidth = 64;
		textureHeight = 64;
		
		kree = new ModelRenderer(this);
		kree.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -24.0F, 0.0F);
		kree.addChild(bipedHead);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 1, -4.0F, -13.0F, -4.0F, 8, 10, 8, 0.0F, false));
		
		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(0.0F, -24.0F, 0.0F);
		kree.addChild(bipedBody);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 18, 22, -4.0F, -2.75F, -2.0F, 8, 13, 4, 0.0F, false));
		
		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		kree.addChild(bipedRightArm);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 36, 46, -3.0F, -5.0F, -2.0F, 4, 15, 4, 0.0F, false));
		
		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		kree.addChild(bipedLeftArm);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 36, 46, -1.0F, -5.0F, -2.0F, 4, 15, 4, 0.0F, false));
		
		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		kree.addChild(bipedRightLeg);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 11, 44, -2.1F, -3.0F, -2.0F, 4, 15, 4, 0.0F, true));
		
		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		kree.addChild(bipedLeftLeg);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 12, 44, -2.0F, -3.0F, -2.0F, 4, 15, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		kree.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@SuppressWarnings("incomplete-switch")
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
		
		this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.bipedHead.rotateAngleX = headPitch * 0.017453292F;
		
		this.bipedLeftArm.rotationPointZ = 0.0F;
		this.bipedLeftArm.rotationPointX = 5.0F;
		this.bipedLeftArm.rotateAngleX = -0.75F;
		this.bipedRightArm.rotationPointZ = 0.0F;
		this.bipedRightArm.rotationPointX = -5.0F;
		this.bipedRightArm.rotateAngleX = -0.75F;
		
		this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		this.bipedRightLeg.rotateAngleZ = 0.0F;
		this.bipedLeftLeg.rotateAngleZ = 0.0F;
		
		this.bipedRightArm.rotateAngleY = 0.0F;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			ModelRenderer modelrenderer = this.bipedLeftArm;
			float f1 = this.swingProgress;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.bipedBody.rotateAngleY *= -1.0F;
			}
			
			this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		
		switch (this.leftArmPose) {
			case EMPTY:
				this.bipedLeftArm.rotateAngleY = 0.0F;
				break;
			case BLOCK:
				this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F;
				this.bipedLeftArm.rotateAngleY = 0.5235988F;
				break;
			case ITEM:
				this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
				this.bipedLeftArm.rotateAngleY = 0.0F;
		}
		
		switch (this.rightArmPose) {
			case EMPTY:
				this.bipedRightArm.rotateAngleY = 0.0F;
				break;
			case BLOCK:
				this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.9424779F;
				this.bipedRightArm.rotateAngleY = -0.5235988F;
				break;
			case ITEM:
				this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
				this.bipedRightArm.rotateAngleY = 0.0F;
		}
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = this.getMainHand(entityIn);
			ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
			float f1 = this.swingProgress;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.bipedBody.rotateAngleY *= -1.0F;
			}
			
			this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
			
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
			
			this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			
			if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW) {
				this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY;
				this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY + 0.4F;
				this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F) + this.bipedHead.rotateAngleX;
				this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F) + this.bipedHead.rotateAngleX;
			} else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW) {
				this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY - 0.4F;
				this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY;
				this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F) + this.bipedHead.rotateAngleX;
				this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F) + this.bipedHead.rotateAngleX;
			}
		}
		copyModelAngles(this.bipedHead, this.bipedHeadwear);
	}
}