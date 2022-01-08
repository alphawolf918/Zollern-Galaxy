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

public class ModelOasisVillager extends ModelBase {
	
	private final ModelRenderer villager;
	private final ModelRenderer Head;
	private final ModelRenderer Neck;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer RightArm_r2_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg2_r1;
	private final ModelRenderer RightLeg_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg2_r1;
	private final ModelRenderer LeftLeg_r1;
	
	public ModelOasisVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		villager = new ModelRenderer(this);
		villager.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, 0.0F, -28.0F, -4.0F, 8, 10, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 0, -9.0F, -28.0F, -4.0F, 8, 10, 8, 0.0F, false));
		
		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Neck);
		Neck.cubeList.add(new ModelBox(Neck, 38, 3, -2.0F, -16.0F, -3.0F, 4, 9, 6, 0.0F, false));
		Neck.cubeList.add(new ModelBox(Neck, 40, 0, -7.0F, -20.0F, -3.0F, 6, 6, 6, 0.0F, false));
		Neck.cubeList.add(new ModelBox(Neck, 37, 1, 0.0F, -20.0F, -3.0F, 6, 6, 6, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 26, 0, -4.0F, -11.75F, -4.0F, 8, 11, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 34, 0, -2.0F, -13.75F, -2.0F, 4, 22, 6, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		villager.addChild(RightArm);
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, 2.0F, 0.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.7854F, 0.0F, 0.0F);
		
		RightArm_r2_r1 = new ModelRenderer(this);
		RightArm_r2_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
		RightArm_r1.addChild(RightArm_r2_r1);
		setRotationAngle(RightArm_r2_r1, 0.0005F, 0.0308F, 0.0309F);
		RightArm_r2_r1.cubeList.add(new ModelBox(RightArm_r2_r1, 32, 1, -8.0872F, -6.3626F, -5.5369F, 4, 16, 4, 0.0F, false));
		RightArm_r2_r1.cubeList.add(new ModelBox(RightArm_r2_r1, 32, 1, -7.9564F, -8.7788F, -11.1917F, 4, 16, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		villager.addChild(LeftArm);
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, 2.0F, 0.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.6545F, 0.0F, 0.0F);
		
		LeftArm_r2_r1 = new ModelRenderer(this);
		LeftArm_r2_r1.setRotationPoint(0.0F, -4.0F, 0.0F);
		LeftArm_r1.addChild(LeftArm_r2_r1);
		setRotationAngle(LeftArm_r2_r1, 0.0005F, 0.0346F, 0.0266F);
		LeftArm_r2_r1.cubeList.add(new ModelBox(LeftArm_r2_r1, 32, 5, 3.9128F, -6.7698F, -4.6761F, 4, 16, 4, 0.0F, false));
		LeftArm_r2_r1.cubeList.add(new ModelBox(LeftArm_r2_r1, 32, 5, 4.0436F, -9.912F, -10.0977F, 4, 16, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		villager.addChild(RightLeg);
		
		RightLeg2_r1 = new ModelRenderer(this);
		RightLeg2_r1.setRotationPoint(1.9F, 12.0F, -1.0F);
		RightLeg.addChild(RightLeg2_r1);
		setRotationAngle(RightLeg2_r1, 0.0F, 0.0F, 0.0F);
		RightLeg2_r1.cubeList.add(new ModelBox(RightLeg2_r1, 34, 2, -5.0F, -19.0F, -4.0F, 4, 19, 4, 0.0F, true));
		
		RightLeg_r1 = new ModelRenderer(this);
		RightLeg_r1.setRotationPoint(1.9F, 12.0F, 0.0F);
		RightLeg.addChild(RightLeg_r1);
		setRotationAngle(RightLeg_r1, 0.0F, 0.0F, 0.0F);
		RightLeg_r1.cubeList.add(new ModelBox(RightLeg_r1, 34, 2, -5.0F, -19.0F, 2.0F, 4, 19, 4, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		villager.addChild(LeftLeg);
		
		LeftLeg2_r1 = new ModelRenderer(this);
		LeftLeg2_r1.setRotationPoint(-1.9F, 12.0F, -1.0F);
		LeftLeg.addChild(LeftLeg2_r1);
		setRotationAngle(LeftLeg2_r1, 0.0F, 0.0F, 0.0F);
		LeftLeg2_r1.cubeList.add(new ModelBox(LeftLeg2_r1, 34, 2, 0.9F, -19.0F, -3.0F, 4, 19, 4, 0.0F, false));
		
		LeftLeg_r1 = new ModelRenderer(this);
		LeftLeg_r1.setRotationPoint(-1.9F, 12.0F, 0.0F);
		LeftLeg.addChild(LeftLeg_r1);
		setRotationAngle(LeftLeg_r1, 0.0F, 0.0F, 0.0F);
		LeftLeg_r1.cubeList.add(new ModelBox(LeftLeg_r1, 34, 2, 0.9F, -19.0F, 2.0F, 4, 19, 4, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		villager.render(f5);
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