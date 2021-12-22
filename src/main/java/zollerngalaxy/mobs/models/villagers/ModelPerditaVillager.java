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

public class ModelPerditaVillager extends ModelBase {
	
	private final ModelRenderer villager;
	private final ModelRenderer Head;
	private final ModelRenderer Mandibles;
	private final ModelRenderer Side1;
	private final ModelRenderer cube4_r1;
	private final ModelRenderer cube3_r1;
	private final ModelRenderer cube2_r1;
	private final ModelRenderer Side2;
	private final ModelRenderer cube8_r1;
	private final ModelRenderer cube7_r1;
	private final ModelRenderer cube6_r1;
	private final ModelRenderer Side3;
	private final ModelRenderer cube12_r1;
	private final ModelRenderer cube11_r1;
	private final ModelRenderer cube10_r1;
	private final ModelRenderer Side4;
	private final ModelRenderer cube16_r1;
	private final ModelRenderer cube15_r1;
	private final ModelRenderer cube14_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightFoot;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftFoot;
	
	public ModelPerditaVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		villager = new ModelRenderer(this);
		villager.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 1, -4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F, false));
		
		Mandibles = new ModelRenderer(this);
		Mandibles.setRotationPoint(0.0F, -1.0F, 0.0F);
		Head.addChild(Mandibles);
		
		Side1 = new ModelRenderer(this);
		Side1.setRotationPoint(0.0F, 0.0F, -1.0F);
		Mandibles.addChild(Side1);
		setRotationAngle(Side1, 0.0F, 0.2618F, 0.0F);
		Side1.cubeList.add(new ModelBox(Side1, 0, 1, -6.0F, 0.0F, -2.0F, 2, 0, 5, 0.0F, false));
		
		cube4_r1 = new ModelRenderer(this);
		cube4_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side1.addChild(cube4_r1);
		setRotationAngle(cube4_r1, 0.0F, -0.7418F, 0.0F);
		cube4_r1.cubeList.add(new ModelBox(cube4_r1, 0, 1, -9.0F, -1.0F, -7.0F, 1, 0, 6, 0.0F, false));
		
		cube3_r1 = new ModelRenderer(this);
		cube3_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side1.addChild(cube3_r1);
		setRotationAngle(cube3_r1, 0.0F, -0.3491F, 0.0F);
		cube3_r1.cubeList.add(new ModelBox(cube3_r1, 0, 1, -8.0F, -1.0F, -6.0F, 2, 0, 6, 0.0F, false));
		
		cube2_r1 = new ModelRenderer(this);
		cube2_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side1.addChild(cube2_r1);
		setRotationAngle(cube2_r1, 0.0F, -0.0436F, 0.0F);
		cube2_r1.cubeList.add(new ModelBox(cube2_r1, 0, 1, -7.0F, -1.0F, -5.0F, 2, 0, 5, 0.0F, false));
		
		Side2 = new ModelRenderer(this);
		Side2.setRotationPoint(0.0F, -2.0F, -1.0F);
		Mandibles.addChild(Side2);
		setRotationAngle(Side2, 0.0F, 0.3491F, 3.1416F);
		Side2.cubeList.add(new ModelBox(Side2, 0, 1, -6.0F, -2.0F, -2.0F, 2, 0, 5, 0.0F, false));
		
		cube8_r1 = new ModelRenderer(this);
		cube8_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side2.addChild(cube8_r1);
		setRotationAngle(cube8_r1, 0.0F, -0.7418F, 0.0F);
		cube8_r1.cubeList.add(new ModelBox(cube8_r1, 0, 1, -9.0F, -2.0F, -7.0F, 1, 0, 6, 0.0F, false));
		
		cube7_r1 = new ModelRenderer(this);
		cube7_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side2.addChild(cube7_r1);
		setRotationAngle(cube7_r1, 0.0F, -0.3491F, 0.0F);
		cube7_r1.cubeList.add(new ModelBox(cube7_r1, 0, 1, -8.0F, -2.0F, -6.0F, 2, 0, 6, 0.0F, false));
		
		cube6_r1 = new ModelRenderer(this);
		cube6_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side2.addChild(cube6_r1);
		setRotationAngle(cube6_r1, 0.0F, -0.0436F, 0.0F);
		cube6_r1.cubeList.add(new ModelBox(cube6_r1, 0, 1, -7.0F, -2.0F, -5.0F, 2, 0, 5, 0.0F, false));
		
		Side3 = new ModelRenderer(this);
		Side3.setRotationPoint(0.0F, -9.0F, -1.0F);
		Mandibles.addChild(Side3);
		setRotationAngle(Side3, 0.0F, 0.4363F, 3.1416F);
		Side3.cubeList.add(new ModelBox(Side3, 0, 1, -6.0F, -2.0F, -2.0F, 2, 0, 5, 0.0F, false));
		
		cube12_r1 = new ModelRenderer(this);
		cube12_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side3.addChild(cube12_r1);
		setRotationAngle(cube12_r1, 0.0F, -0.7418F, 0.0F);
		cube12_r1.cubeList.add(new ModelBox(cube12_r1, 0, 1, -9.0F, -2.0F, -7.0F, 1, 0, 6, 0.0F, false));
		
		cube11_r1 = new ModelRenderer(this);
		cube11_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side3.addChild(cube11_r1);
		setRotationAngle(cube11_r1, 0.0F, -0.3491F, 0.0F);
		cube11_r1.cubeList.add(new ModelBox(cube11_r1, 0, 1, -8.0F, -2.0F, -6.0F, 2, 0, 6, 0.0F, false));
		
		cube10_r1 = new ModelRenderer(this);
		cube10_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Side3.addChild(cube10_r1);
		setRotationAngle(cube10_r1, 0.0F, -0.0436F, 0.0F);
		cube10_r1.cubeList.add(new ModelBox(cube10_r1, 0, 1, -7.0F, -2.0F, -5.0F, 2, 0, 5, 0.0F, false));
		
		Side4 = new ModelRenderer(this);
		Side4.setRotationPoint(0.0F, -6.0F, -1.0F);
		Mandibles.addChild(Side4);
		setRotationAngle(Side4, 0.0F, 0.5672F, 0.0F);
		Side4.cubeList.add(new ModelBox(Side4, 0, 1, -6.0F, 0.0F, -2.0F, 2, 0, 5, 0.0F, false));
		
		cube16_r1 = new ModelRenderer(this);
		cube16_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side4.addChild(cube16_r1);
		setRotationAngle(cube16_r1, 0.0F, -0.7418F, 0.0F);
		cube16_r1.cubeList.add(new ModelBox(cube16_r1, 0, 1, -9.0F, -1.0F, -7.0F, 1, 0, 6, 0.0F, false));
		
		cube15_r1 = new ModelRenderer(this);
		cube15_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side4.addChild(cube15_r1);
		setRotationAngle(cube15_r1, 0.0F, -0.3491F, 0.0F);
		cube15_r1.cubeList.add(new ModelBox(cube15_r1, 0, 1, -8.0F, -1.0F, -6.0F, 2, 0, 6, 0.0F, false));
		
		cube14_r1 = new ModelRenderer(this);
		cube14_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
		Side4.addChild(cube14_r1);
		setRotationAngle(cube14_r1, 0.0F, -0.0436F, 0.0F);
		cube14_r1.cubeList.add(new ModelBox(cube14_r1, 0, 1, -7.0F, -1.0F, -5.0F, 2, 0, 5, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		villager.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 18, 20, -4.0F, 0.25F, -2.0F, 8, 12, 4, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		villager.addChild(RightArm);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 22, -3.0F, -2.0F, -3.0F, 4, 12, 4, 0.0F, false));
		
		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(4.0F, 6.0F, 1.0F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, -0.2618F, 0.0F, 0.0F);
		RightArm_r1.cubeList.add(new ModelBox(RightArm_r1, 45, 23, -4.0F, -8.0F, -2.0F, 4, 7, 3, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		villager.addChild(LeftArm);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 22, -1.0F, -2.0F, -3.0F, 4, 12, 4, 0.0F, false));
		
		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-6.0F, 6.0F, 1.0F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.2618F, 0.0F, 0.0F);
		LeftArm_r1.cubeList.add(new ModelBox(LeftArm_r1, 45, 23, 2.0F, -8.0F, -2.0F, 4, 7, 3, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		villager.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 12, 45, -2.1F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(RightFoot);
		RightFoot.cubeList.add(new ModelBox(RightFoot, 44, 28, -2.0F, 10.0F, -6.0F, 4, 2, 4, 0.0F, false));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		villager.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 12, 45, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(-3.8F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.cubeList.add(new ModelBox(LeftFoot, 44, 28, 2.0F, 10.0F, -6.0F, 4, 2, 4, 0.0F, false));
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