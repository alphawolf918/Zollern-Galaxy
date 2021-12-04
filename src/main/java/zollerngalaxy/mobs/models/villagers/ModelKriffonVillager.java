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

public class ModelKriffonVillager extends ModelBase {
	
	private final ModelRenderer villager;
	private final ModelRenderer Head;
	private final ModelRenderer Nose_r1;
	private final ModelRenderer Horns;
	private final ModelRenderer Horn2_r1;
	private final ModelRenderer Horn1_r1;
	private final ModelRenderer Horns2;
	private final ModelRenderer Horn4_r1;
	private final ModelRenderer Horn3_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArmThing_r1;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArmThing_r1;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	
	public ModelKriffonVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		villager = new ModelRenderer(this);
		villager.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -12.0F, -4.0F, 8, 12, 8, 0.0F, false));
		
		Nose_r1 = new ModelRenderer(this);
		Nose_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Head.addChild(Nose_r1);
		setRotationAngle(Nose_r1, -1.4399F, 0.0F, 0.0F);
		Nose_r1.cubeList.add(new ModelBox(Nose_r1, 37, 19, -1.0F, -4.0F, -29.0F, 2, 6, 2, 0.0F, false));
		
		Horns = new ModelRenderer(this);
		Horns.setRotationPoint(3.0F, 21.0F, 1.0F);
		Head.addChild(Horns);
		setRotationAngle(Horns, 0.0F, -1.2654F, 0.0F);
		
		Horn2_r1 = new ModelRenderer(this);
		Horn2_r1.setRotationPoint(1.0F, 8.0F, 0.0F);
		Horns.addChild(Horn2_r1);
		setRotationAngle(Horn2_r1, -0.7577F, 0.0477F, -0.1609F);
		Horn2_r1.cubeList.add(new ModelBox(Horn2_r1, 0, 0, 4.342F, -40.32F, -26.6486F, 1, 6, 2, 0.0F, false));
		
		Horn1_r1 = new ModelRenderer(this);
		Horn1_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns.addChild(Horn1_r1);
		setRotationAngle(Horn1_r1, -0.2618F, 0.0F, 0.0F);
		Horn1_r1.cubeList.add(new ModelBox(Horn1_r1, 0, 0, -2.6993F, -37.7532F, -4.9212F, 2, 6, 2, 0.0F, false));
		
		Horns2 = new ModelRenderer(this);
		Horns2.setRotationPoint(-7.0F, 19.0F, -1.0F);
		Head.addChild(Horns2);
		setRotationAngle(Horns2, 3.0543F, 1.3526F, -3.1416F);
		
		Horn4_r1 = new ModelRenderer(this);
		Horn4_r1.setRotationPoint(1.0F, 8.0F, 0.0F);
		Horns2.addChild(Horn4_r1);
		setRotationAngle(Horn4_r1, -0.7577F, 0.0477F, -0.1609F);
		Horn4_r1.cubeList.add(new ModelBox(Horn4_r1, 0, 0, 3.7538F, -41.7473F, -25.3828F, 1, 6, 2, 0.0F, false));
		
		Horn3_r1 = new ModelRenderer(this);
		Horn3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Horns2.addChild(Horn3_r1);
		setRotationAngle(Horn3_r1, -0.2618F, 0.0F, 0.0F);
		Horn3_r1.cubeList.add(new ModelBox(Horn3_r1, 0, 0, -3.2164F, -38.3339F, -3.0826F, 2, 6, 2, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 40, 0, -4.0F, -1.75F, -2.0F, 8, 14, 4, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		villager.addChild(RightArm);
		
		RightArmThing_r1 = new ModelRenderer(this);
		RightArmThing_r1.setRotationPoint(5.0F, 20.0F, -9.0F);
		RightArm.addChild(RightArmThing_r1);
		setRotationAngle(RightArmThing_r1, -0.4349F, -0.0368F, -0.0791F);
		RightArmThing_r1.cubeList.add(new ModelBox(RightArmThing_r1, 46, 0, -9.0F, -29.0F, -2.0F, 5, 7, 4, 0.0F, false));
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, 20.0F, -9.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.4363F, 0.0F, 0.0F);
		RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 46, 0, -9.0F, -26.0F, -2.0F, 5, 15, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		villager.addChild(LeftArm);
		
		LeftArmThing_r1 = new ModelRenderer(this);
		LeftArmThing_r1.setRotationPoint(14.0F, 20.0F, -9.0F);
		LeftArm.addChild(LeftArmThing_r1);
		setRotationAngle(LeftArmThing_r1, -0.4305F, 0.0735F, 0.1585F);
		LeftArmThing_r1.cubeList.add(new ModelBox(LeftArmThing_r1, 46, 0, -17.0F, -27.0F, -2.0F, 5, 7, 4, 0.0F, false));
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, 20.0F, -9.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.4363F, 0.0F, 0.0F);
		LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 46, 0, 4.0F, -26.0F, -2.0F, 5, 15, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		villager.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 19, 44, -2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		villager.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 20, 44, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
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