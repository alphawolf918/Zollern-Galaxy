/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGalaxyKnight extends ModelBase {
	
	ModelRenderer foot1;
	ModelRenderer shoulder2;
	ModelRenderer shoulder1;
	ModelRenderer headthing;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer foot2;
	
	public ModelGalaxyKnight() {
		textureWidth = 64;
		textureHeight = 64;
		
		foot1 = new ModelRenderer(this, 5, 0);
		foot1.addBox(0F, 0F, 0F, 4, 2, 6);
		foot1.setRotationPoint(0F, 22F, -5F);
		foot1.setTextureSize(64, 64);
		foot1.mirror = true;
		setRotation(foot1, 0F, 0F, 0F);
		shoulder2 = new ModelRenderer(this, 16, 53);
		shoulder2.addBox(0F, 0F, 0F, 3, 5, 3);
		shoulder2.setRotationPoint(8F, -1F, -2F);
		shoulder2.setTextureSize(64, 64);
		shoulder2.mirror = true;
		setRotation(shoulder2, 0F, 0F, 0F);
		shoulder1 = new ModelRenderer(this, 16, 53);
		shoulder1.addBox(0F, 0F, 0F, 3, 5, 3);
		shoulder1.setRotationPoint(-10F, -1F, -2F);
		shoulder1.setTextureSize(64, 64);
		shoulder1.mirror = true;
		setRotation(shoulder1, 0F, 0F, 0F);
		headthing = new ModelRenderer(this, 26, 55);
		headthing.addBox(0F, 0F, 0F, 4, 2, 6);
		headthing.setRotationPoint(-2F, -11F, 0F);
		headthing.setTextureSize(64, 64);
		headthing.mirror = true;
		setRotation(headthing, 0.3569147F, 0F, 0.0349066F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 9, 8);
		head.setRotationPoint(0F, -2F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 31);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		foot2 = new ModelRenderer(this, 5, 0);
		foot2.addBox(0F, 0F, 0F, 4, 2, 6);
		foot2.setRotationPoint(-4F, 22F, -5F);
		foot2.setTextureSize(64, 64);
		foot2.mirror = true;
		setRotation(foot2, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		foot1.render(par7);
		shoulder2.render(par7);
		shoulder1.render(par7);
		headthing.render(par7);
		head.render(par7);
		body.render(par7);
		rightarm.render(par7);
		leftarm.render(par7);
		rightleg.render(par7);
		leftleg.render(par7);
		foot2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_,
			float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		this.head.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.head.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.headthing.rotateAngleY = this.head.rotateAngleY;
		this.headthing.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 2.0F * p_78087_2_ * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 2.0F
				* p_78087_2_ * 0.5F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F)
				* 1.4F * p_78087_2_;
		this.foot2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F
				* p_78087_2_;
		this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 1.4F * p_78087_2_;
		this.foot1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F
				* p_78087_2_;
		this.rightleg.rotateAngleY = 0.0F;
		this.foot2.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;
		this.foot1.rotateAngleY = 0.0F;
	}
	
}