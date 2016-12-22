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
import org.lwjgl.opengl.GL11;

public class ModelMoolus extends ModelBase {
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer udders;
	ModelRenderer head2;
	private float field_78145_g;
	private float field_78151_h;
	
	public ModelMoolus() {
		textureWidth = 64;
		textureHeight = 32;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -6F, 8, 8, 6);
		head.setRotationPoint(-3F, 4F, -8F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 18, 4);
		body.addBox(-6F, -10F, -7F, 12, 18, 10);
		body.setRotationPoint(0F, 5F, 2F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
		leg1.setRotationPoint(-3F, 12F, 7F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
		leg2.setRotationPoint(3F, 12F, 7F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
		leg3.setRotationPoint(-3F, 12F, -5F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
		leg4.setRotationPoint(3F, 12F, -5F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		horn1 = new ModelRenderer(this, 22, 0);
		horn1.addBox(-4F, -5F, -4F, 1, 3, 1);
		horn1.setRotationPoint(-2F, 2F, -9F);
		horn1.setTextureSize(64, 32);
		horn1.mirror = true;
		setRotation(horn1, 0F, 0F, 0F);
		horn2 = new ModelRenderer(this, 22, 0);
		horn2.addBox(3F, -5F, -4F, 1, 3, 1);
		horn2.setRotationPoint(4F, 2F, -9F);
		horn2.setTextureSize(64, 32);
		horn2.mirror = true;
		setRotation(horn2, 0F, 0F, 0F);
		udders = new ModelRenderer(this, 52, 0);
		udders.addBox(-2F, -3F, 0F, 4, 6, 2);
		udders.setRotationPoint(0F, 14F, 6F);
		udders.setTextureSize(64, 32);
		udders.mirror = true;
		setRotation(udders, 1.570796F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(0F, 0F, 0F, 8, 8, 6);
		head2.setRotationPoint(1F, 0F, -14F);
		head2.setTextureSize(64, 32);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		if (this.isChild) {
			float f6 = 1.5F;
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, this.field_78145_g * par7,
					this.field_78151_h * par7);
			this.head.render(par7);
			this.head2.render(par7);
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
			GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
			this.body.render(par7);
			this.leg1.render(par7);
			this.leg2.render(par7);
			this.leg3.render(par7);
			this.leg4.render(par7);
			GL11.glPopMatrix();
		} else {
			head.render(par7);
			body.render(par7);
			leg1.render(par7);
			leg2.render(par7);
			leg3.render(par7);
			leg4.render(par7);
			horn1.render(par7);
			horn2.render(par7);
			udders.render(par7);
			head2.render(par7);
		}
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		float f6 = (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}
}