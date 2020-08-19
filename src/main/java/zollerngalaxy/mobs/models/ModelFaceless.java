/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFaceless extends ModelBiped {
	
	private final ModelRenderer torso;
	private final ModelRenderer leftarm;
	private final ModelRenderer head;
	private final ModelRenderer bb_main;
	
	public ModelFaceless() {
		textureWidth = 64;
		textureHeight = 32;
		
		torso = new ModelRenderer(this);
		torso.setRotationPoint(4.0F, 10.0F, -2.0F);
		setRotationAngle(torso, 0.0F, 0.0F, -0.3491F);
		torso.setTextureOffset(24, 24);
		torso.addBox(-9.0F, -9.0F, 0.0F, 9, 9, 4);
		
		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(6.0F, 6.0F, 0.0F);
		setRotationAngle(leftarm, 0.0F, 0.0F, -0.3491F);
		leftarm.setTextureOffset(32, 37);
		leftarm.addBox(-3.4771F, -5.9658F, -2.0F, 3, 12, 4);
		
		head = new ModelRenderer(this);
		head.setRotationPoint(-7.0F, 2.0F, -2.0F);
		setRotationAngle(head, -0.6109F, 1.0472F, 0.4363F);
		head.setTextureOffset(0, 12);
		head.addBox(-1.0F, -11.0F, -6.0F, 1, 11, 11);
		head.setTextureOffset(0, 0);
		head.addBox(-6.0F, -6.0F, -6.0F, 11, 1, 11);
		head.setTextureOffset(24, 12);
		head.addBox(-6.0F, -11.0F, -1.0F, 11, 11, 1);
		
		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		torso.render(par7);
		head.render(par7);
		leftarm.render(par7);
		bb_main.render(par7);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}