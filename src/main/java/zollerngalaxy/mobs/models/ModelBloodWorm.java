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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBloodWorm extends ModelBase {
	
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer body2;
	private final ModelRenderer head2;
	
	public ModelBloodWorm() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -4F, -6F, 8, 8, 6);
		this.head.setRotationPoint(-2F, 18F, -8F);
		this.head.setTextureSize(64, 32);
		this.setRotation(this.head, 0F, 0F, 0F);
		this.body = new ModelRenderer(this, 8, 4);
		this.body.addBox(-6F, -10F, -7F, 15, 12, 10);
		this.body.setRotationPoint(0F, 16F, 0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(this.body, 1.570796F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 5, 4);
		this.body2.addBox(0F, 0F, 0F, 16, 11, 12);
		this.body2.setRotationPoint(-6F, 23F, 0F);
		this.body2.setTextureSize(64, 32);
		this.setRotation(this.body2, 1.570796F, 0F, 0F);
		this.head2 = new ModelRenderer(this, 0, 0);
		this.head2.addBox(-4F, -4F, -6F, 8, 8, 6);
		this.head2.setRotationPoint(5F, 18F, -8F);
		this.head2.setTextureSize(64, 32);
		this.setRotation(this.head2, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		this.head.render(par7);
		this.body.render(par7);
		this.body2.render(par7);
		this.head2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		float f6 = (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.body2.rotateAngleX = ((float) Math.PI / 2F);
	}
}