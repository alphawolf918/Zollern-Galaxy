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

public class ModelXenomorph extends ModelBase {
	
	private final ModelRenderer xenomorph;
	private final ModelRenderer Head;
	private final ModelRenderer HeadThings;
	private final ModelRenderer HeadPiece3_r1;
	private final ModelRenderer HeadPiece2_r1;
	private final ModelRenderer HeadPiece_r1;
	private final ModelRenderer Neck;
	private final ModelRenderer Body;
	private final ModelRenderer BackThings;
	private final ModelRenderer BackThing1;
	private final ModelRenderer backThing3_r1;
	private final ModelRenderer BackThing2;
	private final ModelRenderer backThing6_r1;
	private final ModelRenderer BackThing3;
	private final ModelRenderer backThing9_r1;
	private final ModelRenderer BackThing4;
	private final ModelRenderer backThing12_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer rightArm2_r1;
	private final ModelRenderer rightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer leftArm2_r1;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Tail;
	private final ModelRenderer TailPiece10_r1;
	private final ModelRenderer TailPiece8_r1;
	private final ModelRenderer TailPiece7_r1;
	private final ModelRenderer TailPiece6_r1;
	private final ModelRenderer TailPiece5_r1;
	private final ModelRenderer TailPiece4_r1;
	private final ModelRenderer TailPiece3_r1;
	
	public ModelXenomorph() {
		textureWidth = 64;
		textureHeight = 64;
		
		xenomorph = new ModelRenderer(this);
		xenomorph.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -25.0F, -4.0F);
		xenomorph.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 2, 0, -4.0F, -15.0F, -4.0F, 8, 8, 8, 0.0F, false));
		
		HeadThings = new ModelRenderer(this);
		HeadThings.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(HeadThings);
		
		HeadPiece3_r1 = new ModelRenderer(this);
		HeadPiece3_r1.setRotationPoint(0.0F, 15.0F, 0.0F);
		HeadThings.addChild(HeadPiece3_r1);
		setRotationAngle(HeadPiece3_r1, -0.5672F, 0.0F, 0.0F);
		HeadPiece3_r1.cubeList.add(new ModelBox(HeadPiece3_r1, 36, 52, -3.0F, -31.0F, 0.0F, 6, 5, 13, 0.0F, false));
		
		HeadPiece2_r1 = new ModelRenderer(this);
		HeadPiece2_r1.setRotationPoint(0.0F, 15.0F, 0.0F);
		HeadThings.addChild(HeadPiece2_r1);
		setRotationAngle(HeadPiece2_r1, -0.3927F, 0.0F, 0.0F);
		HeadPiece2_r1.cubeList.add(new ModelBox(HeadPiece2_r1, 32, 52, -4.0F, -30.0F, -2.0F, 8, 5, 13, 0.0F, false));
		
		HeadPiece_r1 = new ModelRenderer(this);
		HeadPiece_r1.setRotationPoint(0.0F, 17.0F, 0.0F);
		HeadThings.addChild(HeadPiece_r1);
		setRotationAngle(HeadPiece_r1, -0.2182F, 0.0F, 0.0F);
		HeadPiece_r1.cubeList.add(new ModelBox(HeadPiece_r1, 32, 50, -4.0F, -32.0F, -4.0F, 8, 7, 13, 0.0F, false));
		
		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
		xenomorph.addChild(Neck);
		Neck.cubeList.add(new ModelBox(Neck, 7, 3, -2.0F, -35.0F, -2.0F, 5, 6, 3, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -24.0F, 0.0F);
		xenomorph.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 16, 14, -4.0F, -5.75F, -3.0F, 8, 14, 6, 0.0F, false));
		
		BackThings = new ModelRenderer(this);
		BackThings.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(BackThings);
		
		BackThing1 = new ModelRenderer(this);
		BackThing1.setRotationPoint(0.0F, -1.0F, 0.0F);
		BackThings.addChild(BackThing1);
		setRotationAngle(BackThing1, -0.0436F, 0.0F, 0.0F);
		BackThing1.cubeList.add(new ModelBox(BackThing1, 0, 0, 1.0F, -4.0F, 3.0F, 3, 2, 2, 0.0F, false));
		BackThing1.cubeList.add(new ModelBox(BackThing1, 0, 0, 1.0F, -4.0F, 4.0F, 3, 2, 4, 0.0F, false));
		
		backThing3_r1 = new ModelRenderer(this);
		backThing3_r1.setRotationPoint(0.0F, 0.0F, 3.0F);
		BackThing1.addChild(backThing3_r1);
		setRotationAngle(backThing3_r1, 0.1745F, 0.0F, 0.0F);
		backThing3_r1.cubeList.add(new ModelBox(backThing3_r1, 0, 0, 1.0F, -3.0F, 4.0F, 3, 1, 5, 0.0F, false));
		
		BackThing2 = new ModelRenderer(this);
		BackThing2.setRotationPoint(-6.0F, -1.0F, 0.0F);
		BackThings.addChild(BackThing2);
		setRotationAngle(BackThing2, -0.0436F, 0.0F, 0.0F);
		BackThing2.cubeList.add(new ModelBox(BackThing2, 0, 0, 1.0F, -4.0F, 3.0F, 3, 2, 2, 0.0F, false));
		BackThing2.cubeList.add(new ModelBox(BackThing2, 0, 0, 1.0F, -4.0F, 4.0F, 3, 2, 4, 0.0F, false));
		
		backThing6_r1 = new ModelRenderer(this);
		backThing6_r1.setRotationPoint(0.0F, 0.0F, 3.0F);
		BackThing2.addChild(backThing6_r1);
		setRotationAngle(backThing6_r1, 0.1745F, 0.0F, 0.0F);
		backThing6_r1.cubeList.add(new ModelBox(backThing6_r1, 0, 0, 1.0F, -3.0F, 4.0F, 3, 1, 5, 0.0F, false));
		
		BackThing3 = new ModelRenderer(this);
		BackThing3.setRotationPoint(-6.0F, 5.0F, 0.0F);
		BackThings.addChild(BackThing3);
		setRotationAngle(BackThing3, -0.0436F, 0.0F, 0.0F);
		BackThing3.cubeList.add(new ModelBox(BackThing3, 0, 0, 1.0F, -4.0F, 3.0F, 3, 2, 2, 0.0F, false));
		BackThing3.cubeList.add(new ModelBox(BackThing3, 0, 0, 1.0F, -4.0F, 4.0F, 3, 2, 4, 0.0F, false));
		
		backThing9_r1 = new ModelRenderer(this);
		backThing9_r1.setRotationPoint(0.0F, 0.0F, 3.0F);
		BackThing3.addChild(backThing9_r1);
		setRotationAngle(backThing9_r1, 0.1745F, 0.0F, 0.0F);
		backThing9_r1.cubeList.add(new ModelBox(backThing9_r1, 0, 0, 1.0F, -3.0F, 4.0F, 3, 1, 5, 0.0F, false));
		
		BackThing4 = new ModelRenderer(this);
		BackThing4.setRotationPoint(0.0F, 5.0F, 0.0F);
		BackThings.addChild(BackThing4);
		setRotationAngle(BackThing4, -0.0436F, 0.0F, 0.0F);
		BackThing4.cubeList.add(new ModelBox(BackThing4, 0, 0, 1.0F, -4.0F, 3.0F, 3, 2, 2, 0.0F, false));
		BackThing4.cubeList.add(new ModelBox(BackThing4, 0, 0, 1.0F, -4.0F, 4.0F, 3, 2, 4, 0.0F, false));
		
		backThing12_r1 = new ModelRenderer(this);
		backThing12_r1.setRotationPoint(0.0F, 0.0F, 3.0F);
		BackThing4.addChild(backThing12_r1);
		setRotationAngle(backThing12_r1, 0.1745F, 0.0F, 0.0F);
		backThing12_r1.cubeList.add(new ModelBox(backThing12_r1, 0, 0, 1.0F, -3.0F, 4.0F, 3, 1, 5, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
		xenomorph.addChild(RightArm);
		
		rightArm2_r1 = new ModelRenderer(this);
		rightArm2_r1.setRotationPoint(5.0F, 15.0F, -6.0F);
		RightArm.addChild(rightArm2_r1);
		setRotationAngle(rightArm2_r1, -1.0908F, 0.0F, 0.0F);
		rightArm2_r1.cubeList.add(new ModelBox(rightArm2_r1, 46, 46, -9.0F, -9.0F, -11.0F, 4, 10, 4, 0.0F, false));
		
		rightArm_r1 = new ModelRenderer(this);
		rightArm_r1.setRotationPoint(5.0F, 16.0F, -7.0F);
		RightArm.addChild(rightArm_r1);
		setRotationAngle(rightArm_r1, -0.3491F, 0.0F, 0.0F);
		rightArm_r1.cubeList.add(new ModelBox(rightArm_r1, 46, 46, -9.0F, -24.0F, -2.0F, 5, 14, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
		xenomorph.addChild(LeftArm);
		
		leftArm2_r1 = new ModelRenderer(this);
		leftArm2_r1.setRotationPoint(9.0F, 15.0F, -6.0F);
		LeftArm.addChild(leftArm2_r1);
		setRotationAngle(leftArm2_r1, -1.0908F, 0.0F, 0.0F);
		leftArm2_r1.cubeList.add(new ModelBox(leftArm2_r1, 46, 46, -9.0F, -9.0F, -11.0F, 4, 10, 4, 0.0F, false));
		
		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setRotationPoint(-5.0F, 16.0F, -7.0F);
		LeftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, -0.3491F, 0.0F, 0.0F);
		leftArm_r1.cubeList.add(new ModelBox(leftArm_r1, 46, 46, 4.0F, -24.0F, -2.0F, 5, 14, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
		xenomorph.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 34, 50, -3.1F, -4.0F, -3.0F, 4, 16, 5, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
		xenomorph.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 34, 50, -1.0F, -4.0F, -3.0F, 4, 16, 5, 0.0F, false));
		
		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -1.0F, -4.0F);
		xenomorph.addChild(Tail);
		setRotationAngle(Tail, -0.2182F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, -2.0F, -18.9052F, 1.1342F, 4, 3, 2, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 0, -3.0F, -18.9052F, 3.1342F, 6, 3, 4, 0.0F, false));
		
		TailPiece10_r1 = new ModelRenderer(this);
		TailPiece10_r1.setRotationPoint(0.0F, 0.0F, 9.0F);
		Tail.addChild(TailPiece10_r1);
		setRotationAngle(TailPiece10_r1, 0.48F, 0.0F, 0.0F);
		TailPiece10_r1.cubeList.add(new ModelBox(TailPiece10_r1, 0, 0, -1.0F, -13.8637F, 27.0353F, 2, 3, 5, 0.0F, false));
		TailPiece10_r1.cubeList.add(new ModelBox(TailPiece10_r1, 0, 0, -2.0F, -13.8637F, 22.0353F, 4, 3, 5, 0.0F, false));
		
		TailPiece8_r1 = new ModelRenderer(this);
		TailPiece8_r1.setRotationPoint(0.0F, 0.0F, 7.0F);
		Tail.addChild(TailPiece8_r1);
		setRotationAngle(TailPiece8_r1, 1.0472F, 0.0F, 0.0F);
		TailPiece8_r1.cubeList.add(new ModelBox(TailPiece8_r1, 0, 0, -2.0F, 2.2976F, 22.9491F, 4, 3, 5, 0.0F, false));
		
		TailPiece7_r1 = new ModelRenderer(this);
		TailPiece7_r1.setRotationPoint(0.0F, 0.0F, 7.0F);
		Tail.addChild(TailPiece7_r1);
		setRotationAngle(TailPiece7_r1, 0.829F, 0.0F, 0.0F);
		TailPiece7_r1.cubeList.add(new ModelBox(TailPiece7_r1, 0, 0, -3.0F, -2.2766F, 18.2943F, 6, 3, 5, 0.0F, false));
		
		TailPiece6_r1 = new ModelRenderer(this);
		TailPiece6_r1.setRotationPoint(0.0F, 0.0F, 7.0F);
		Tail.addChild(TailPiece6_r1);
		setRotationAngle(TailPiece6_r1, 0.4363F, 0.0F, 0.0F);
		TailPiece6_r1.cubeList.add(new ModelBox(TailPiece6_r1, 0, 0, -3.0F, -8.9052F, 12.8658F, 6, 3, 5, 0.0F, false));
		
		TailPiece5_r1 = new ModelRenderer(this);
		TailPiece5_r1.setRotationPoint(0.0F, 0.0F, 4.0F);
		Tail.addChild(TailPiece5_r1);
		setRotationAngle(TailPiece5_r1, -0.5672F, 0.0F, 0.0F);
		TailPiece5_r1.cubeList.add(new ModelBox(TailPiece5_r1, 0, 0, -3.0F, -18.8284F, -1.8284F, 6, 3, 6, 0.0F, false));
		
		TailPiece4_r1 = new ModelRenderer(this);
		TailPiece4_r1.setRotationPoint(0.0F, 0.0F, 4.0F);
		Tail.addChild(TailPiece4_r1);
		setRotationAngle(TailPiece4_r1, -0.3491F, 0.0F, 0.0F);
		TailPiece4_r1.cubeList.add(new ModelBox(TailPiece4_r1, 0, 0, -3.0F, -18.3736F, -1.1492F, 6, 3, 4, 0.0F, false));
		
		TailPiece3_r1 = new ModelRenderer(this);
		TailPiece3_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tail.addChild(TailPiece3_r1);
		setRotationAngle(TailPiece3_r1, -0.2182F, 0.0F, 0.0F);
		TailPiece3_r1.cubeList.add(new ModelBox(TailPiece3_r1, 0, 0, -3.0F, -19.6252F, 1.3095F, 6, 3, 4, 0.0F, false));
		// ModelZombie
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		xenomorph.render(f5);
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