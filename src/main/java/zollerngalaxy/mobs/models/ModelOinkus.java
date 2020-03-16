/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelOinkus extends ModelBase {
	
	ModelRenderer cheekThingRight;
	ModelRenderer cheekThingLeft;
	ModelRenderer sideThingRight;
	ModelRenderer headThing;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer tailThing;
	ModelRenderer sideThingLeft;
	private float field_78145_g;
	private float field_78151_h;
	
	public ModelOinkus() {
		textureWidth = 64;
		textureHeight = 32;
		
		cheekThingRight = new ModelRenderer(this, 9, 0);
		cheekThingRight.addBox(0F, 0F, 0F, 2, 5, 4);
		cheekThingRight.setRotationPoint(4F, 9F, -12F);
		cheekThingRight.setTextureSize(64, 32);
		cheekThingRight.mirror = true;
		setRotation(cheekThingRight, 0F, 0F, 0F);
		cheekThingLeft = new ModelRenderer(this, 9, 0);
		cheekThingLeft.addBox(0F, 0F, 0F, 2, 5, 4);
		cheekThingLeft.setRotationPoint(-6F, 9F, -12F);
		cheekThingLeft.setTextureSize(64, 32);
		cheekThingLeft.mirror = true;
		setRotation(cheekThingLeft, 0F, 0F, 0F);
		sideThingRight = new ModelRenderer(this, 34, 18);
		sideThingRight.addBox(0F, 0F, 0F, 5, 5, 9);
		sideThingRight.setRotationPoint(5F, 10F, 0F);
		sideThingRight.setTextureSize(64, 32);
		sideThingRight.mirror = true;
		setRotation(sideThingRight, 0F, 0F, 0F);
		headThing = new ModelRenderer(this, 1, 1);
		headThing.addBox(0F, 0F, 0F, 6, 3, 7);
		headThing.setRotationPoint(-3F, 7F, -9F);
		headThing.setTextureSize(64, 32);
		headThing.mirror = true;
		setRotation(headThing, 0.296706F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -8F, 8, 8, 8);
		head.setRotationPoint(0F, 12F, -6F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 28, 8);
		body.addBox(-5F, -10F, -7F, 10, 16, 8);
		body.setRotationPoint(0F, 11F, 3F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg1.setRotationPoint(-3F, 18F, 7F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg2.setRotationPoint(3F, 18F, 7F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addBox(-2F, 18F, -2F, 4, 6, 4);
		leg3.setRotationPoint(-3F, 0F, -5F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg4.setRotationPoint(3F, 18F, -5F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		tailThing = new ModelRenderer(this, 3, 0);
		tailThing.addBox(0F, 0F, 0F, 6, 3, 13);
		tailThing.setRotationPoint(-3F, 5F, -3F);
		tailThing.setTextureSize(64, 32);
		tailThing.mirror = true;
		setRotation(tailThing, 0.3665191F, 0F, 0F);
		sideThingLeft = new ModelRenderer(this, 34, 18);
		sideThingLeft.addBox(0F, 0F, 0F, 5, 5, 9);
		sideThingLeft.setRotationPoint(-10F, 10F, 0F);
		sideThingLeft.setTextureSize(64, 32);
		sideThingLeft.mirror = true;
		setRotation(sideThingLeft, 0F, 0F, 0F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_,
			float p_78088_7_) {
		this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
		if (this.isChild) {
			float f6 = 2.0F;
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, this.field_78145_g * p_78088_7_, this.field_78151_h * p_78088_7_);
			this.head.render(p_78088_7_);
			headThing.render(p_78088_7_);
			cheekThingRight.render(p_78088_7_);
			cheekThingLeft.render(p_78088_7_);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * p_78088_7_, 0.0F);
			sideThingRight.render(p_78088_7_);
			this.body.render(p_78088_7_);
			this.leg1.render(p_78088_7_);
			this.leg2.render(p_78088_7_);
			this.leg3.render(p_78088_7_);
			this.leg4.render(p_78088_7_);
			tailThing.render(p_78088_7_);
			sideThingLeft.render(p_78088_7_);
			GL11.glPopMatrix();
		} else {
			cheekThingRight.render(p_78088_7_);
			cheekThingLeft.render(p_78088_7_);
			sideThingRight.render(p_78088_7_);
			headThing.render(p_78088_7_);
			head.render(p_78088_7_);
			body.render(p_78088_7_);
			leg1.render(p_78088_7_);
			leg2.render(p_78088_7_);
			leg3.render(p_78088_7_);
			leg4.render(p_78088_7_);
			tailThing.render(p_78088_7_);
			sideThingLeft.render(p_78088_7_);
		}
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		float f6 = (180F / (float) Math.PI);
		this.head.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.head.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.headThing.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.headThing.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.tailThing.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.tailThing.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.cheekThingLeft.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.cheekThingLeft.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.cheekThingRight.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.cheekThingRight.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
		this.leg2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.leg3.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.leg4.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
	}
}