/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelScorpion extends ModelBase {
	
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer RearEnd;
	ModelRenderer Leg8;
	ModelRenderer Leg6;
	ModelRenderer Leg4;
	ModelRenderer Leg2;
	ModelRenderer Leg7;
	ModelRenderer Leg5;
	ModelRenderer Leg3;
	ModelRenderer Leg1;
	ModelRenderer RearEnd1;
	ModelRenderer RearEnd2;
	ModelRenderer RearEnd3;
	ModelRenderer RearEnd4;
	ModelRenderer RearEnd6;
	ModelRenderer RearEnd5;
	ModelRenderer Leg9;
	ModelRenderer Leg10;
	ModelRenderer CC1;
	ModelRenderer CC2;
	
	public ModelScorpion() {
		textureWidth = 64;
		textureHeight = 32;
		
		Head = new ModelRenderer(this, 32, 4);
		Head.addBox(-4F, -4F, -8F, 8, 8, 8);
		Head.setRotationPoint(0F, 20F, -3F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(-3F, -3F, -3F, 6, 6, 6);
		Body.setRotationPoint(0F, 20F, 0F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		RearEnd = new ModelRenderer(this, 0, 12);
		RearEnd.addBox(-5F, -4F, -6F, 10, 8, 12);
		RearEnd.setRotationPoint(0F, 20F, 9F);
		RearEnd.setTextureSize(64, 32);
		RearEnd.mirror = true;
		setRotation(RearEnd, 0F, 0F, 0F);
		Leg8 = new ModelRenderer(this, 18, 0);
		Leg8.addBox(-1F, -1F, -1F, 20, 2, 2);
		Leg8.setRotationPoint(4F, 20F, -1F);
		Leg8.setTextureSize(64, 32);
		Leg8.mirror = true;
		setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);
		Leg6 = new ModelRenderer(this, 18, 0);
		Leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg6.setRotationPoint(4F, 20F, 0F);
		Leg6.setTextureSize(64, 32);
		Leg6.mirror = true;
		setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);
		Leg4 = new ModelRenderer(this, 18, 0);
		Leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg4.setRotationPoint(4F, 20F, 1F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);
		Leg2 = new ModelRenderer(this, 18, 0);
		Leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg2.setRotationPoint(4F, 20F, 2F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, -0.5759587F, 0.1919862F);
		Leg7 = new ModelRenderer(this, 18, 0);
		Leg7.addBox(-15F, -1F, -1F, 20, 2, 2);
		Leg7.setRotationPoint(-4F, 20F, -4F);
		Leg7.setTextureSize(64, 32);
		Leg7.mirror = true;
		setRotation(Leg7, 0F, -0.5759587F, -0.1919862F);
		Leg5 = new ModelRenderer(this, 18, 0);
		Leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg5.setRotationPoint(-4F, 20F, 0F);
		Leg5.setTextureSize(64, 32);
		Leg5.mirror = true;
		setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);
		Leg3 = new ModelRenderer(this, 18, 0);
		Leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg3.setRotationPoint(-4F, 20F, 1F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);
		Leg1 = new ModelRenderer(this, 18, 0);
		Leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg1.setRotationPoint(-4F, 20F, 2F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
		RearEnd1 = new ModelRenderer(this, 0, 12);
		RearEnd1.addBox(0F, 0F, 0F, 10, 8, 12);
		RearEnd1.setRotationPoint(-5F, 16F, 10F);
		RearEnd1.setTextureSize(64, 32);
		RearEnd1.mirror = true;
		setRotation(RearEnd1, 0.57F, 0F, 0F);
		RearEnd2 = new ModelRenderer(this, 0, 12);
		RearEnd2.addBox(0F, 0F, 0F, 6, 8, 12);
		RearEnd2.setRotationPoint(-3F, 13F, 14F);
		RearEnd2.setTextureSize(64, 32);
		RearEnd2.mirror = true;
		setRotation(RearEnd2, 0.57F, 0F, 0F);
		RearEnd3 = new ModelRenderer(this, 0, 12);
		RearEnd3.addBox(0F, 0F, 0F, 10, 8, 12);
		RearEnd3.setRotationPoint(-5F, 8F, 23F);
		RearEnd3.setTextureSize(64, 32);
		RearEnd3.mirror = true;
		setRotation(RearEnd3, 0.57F, 0F, 0F);
		RearEnd4 = new ModelRenderer(this, 0, 12);
		RearEnd4.addBox(0F, 0F, 0F, 6, 8, 12);
		RearEnd4.setRotationPoint(-3F, 4.466667F, 31F);
		RearEnd4.setTextureSize(64, 32);
		RearEnd4.mirror = true;
		setRotation(RearEnd4, 1.17F, 0F, 0F);
		RearEnd6 = new ModelRenderer(this, 0, 12);
		RearEnd6.addBox(0F, 0F, 0F, 6, 8, 12);
		RearEnd6.setRotationPoint(-3F, -6F, 35F);
		RearEnd6.setTextureSize(64, 32);
		RearEnd6.mirror = true;
		setRotation(RearEnd6, 1.375F, 0F, 0F);
		RearEnd5 = new ModelRenderer(this, 0, 12);
		RearEnd5.addBox(0F, 0F, 0F, 6, 8, 12);
		RearEnd5.setRotationPoint(-3F, -13F, 32F);
		RearEnd5.setTextureSize(64, 32);
		RearEnd5.mirror = true;
		setRotation(RearEnd5, 2.375F, 0F, 0F);
		Leg9 = new ModelRenderer(this, 18, 9);
		Leg9.addBox(0F, 0F, 0F, 4, 2, 6);
		Leg9.setRotationPoint(-14F, 21F, -18F);
		Leg9.setTextureSize(64, 32);
		Leg9.mirror = true;
		setRotation(Leg9, 0F, -0.5759587F, -0.1919862F);
		Leg10 = new ModelRenderer(this, 22, 19);
		Leg10.addBox(0F, 0F, 0F, 4, 2, 6);
		Leg10.setRotationPoint(13F, 22F, -15F);
		Leg10.setTextureSize(64, 32);
		Leg10.mirror = true;
		setRotation(Leg10, 0F, 0.4240413F, -0.1919862F);
		CC1 = new ModelRenderer(this, 22, 19);
		CC1.addBox(0F, 0F, 0F, 2, 2, 5);
		CC1.setRotationPoint(1F, 22F, -14F);
		CC1.setTextureSize(64, 32);
		CC1.mirror = true;
		setRotation(CC1, 0F, 0.4240413F, -0.1919862F);
		CC2 = new ModelRenderer(this, 22, 19);
		CC2.addBox(0F, 0F, -1F, 2, 2, 5);
		CC2.setRotationPoint(-5F, 23F, -14F);
		CC2.setTextureSize(64, 32);
		CC2.mirror = true;
		setRotation(CC2, 0F, 0F, -1F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Head.render(par7);
		Body.render(par7);
		RearEnd.render(par7);
		Leg8.render(par7);
		Leg6.render(par7);
		Leg4.render(par7);
		Leg2.render(par7);
		Leg7.render(par7);
		Leg5.render(par7);
		Leg3.render(par7);
		Leg1.render(par7);
		RearEnd1.render(par7);
		RearEnd2.render(par7);
		RearEnd3.render(par7);
		RearEnd4.render(par7);
		RearEnd6.render(par7);
		RearEnd5.render(par7);
		Leg9.render(par7);
		Leg10.render(par7);
		CC1.render(par7);
		CC2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		this.Head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.CC1.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.CC1.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.CC2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.CC2.rotateAngleX = par5 / (180F / (float) Math.PI);
		float f6 = ((float) Math.PI / 4F);
		this.Leg1.rotateAngleZ = -f6;
		this.Leg2.rotateAngleZ = f6;
		this.Leg3.rotateAngleZ = -f6 * 0.74F;
		this.Leg4.rotateAngleZ = f6 * 0.74F;
		this.Leg5.rotateAngleZ = -f6 * 0.74F;
		this.Leg6.rotateAngleZ = f6 * 0.74F;
		this.Leg7.rotateAngleZ = -f6;
		this.Leg8.rotateAngleZ = f6;
		this.Leg9.rotateAngleZ = f6;
		this.Leg10.rotateAngleZ = f6;
		float f7 = -0.0F;
		float f8 = 0.3926991F;
		this.Leg1.rotateAngleY = f8 * 2.0F + f7;
		this.Leg2.rotateAngleY = -f8 * 2.0F - f7;
		this.Leg3.rotateAngleY = f8 * 1.0F + f7;
		this.Leg4.rotateAngleY = -f8 * 1.0F - f7;
		this.Leg5.rotateAngleY = -f8 * 1.0F + f7;
		this.Leg6.rotateAngleY = f8 * 1.0F - f7;
		this.Leg7.rotateAngleY = -f8 * 2.0F + f7;
		this.Leg8.rotateAngleY = f8 * 2.0F - f7;
		this.Leg9.rotateAngleY = f8 * 2.0F - f7;
		this.Leg10.rotateAngleY = f8 * 2.0F - f7;
		float f9 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * par2;
		float f10 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * par2;
		float f11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * par2;
		float f12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
		float f13 = Math.abs(MathHelper.sin(par1 * 0.6662F + 0.0F) * 0.4F) * par2;
		float f14 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float) Math.PI) * 0.4F) * par2;
		float f15 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * par2;
		float f16 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
		this.Leg1.rotateAngleY += f9;
		this.Leg2.rotateAngleY += -f9;
		this.Leg3.rotateAngleY += f10;
		this.Leg4.rotateAngleY += -f10;
		this.Leg5.rotateAngleY += f11;
		this.Leg6.rotateAngleY += -f11;
		this.Leg7.rotateAngleY += f12;
		this.Leg8.rotateAngleY += -f12;
		this.Leg1.rotateAngleZ += f13;
		this.Leg2.rotateAngleZ += -f13;
		this.Leg3.rotateAngleZ += f14;
		this.Leg4.rotateAngleZ += -f14;
		this.Leg5.rotateAngleZ += f15;
		this.Leg6.rotateAngleZ += -f15;
		this.Leg7.rotateAngleZ += f16;
		this.Leg8.rotateAngleZ += -f16;
		this.Leg9.rotateAngleZ += -f16;
		this.Leg10.rotateAngleZ += -f16;
	}
}