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
import net.minecraft.util.math.MathHelper;

public class ModelMegaCreeper extends ModelBase {
	
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer head3;
	ModelRenderer head2;
	ModelRenderer bipedLeftArm;
	ModelRenderer bipedRightArm;
	
	public ModelMegaCreeper() {
		textureWidth = 64;
		textureHeight = 32;
		
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, true));
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 22, 13, -4.0F, 0.0F, -2.0F, 8, 13, 6, 0.0F, true));
		
		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
		leg3.cubeList.add(new ModelBox(leg3, 16, 21, -2.0F, 0.0F, -2.0F, 4, 6, 5, 0.0F, true));
		
		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(2.0F, 18.0F, -4.0F);
		leg4.cubeList.add(new ModelBox(leg4, 16, 21, -2.0F, 0.0F, -2.0F, 4, 6, 5, 0.0F, true));
		
		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-4.0F, 18.0F, 4.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, 0.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(2.0F, 18.0F, 4.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		head3 = new ModelRenderer(this);
		head3.setRotationPoint(4.0F, -2.0F, -4.0F);
		head3.cubeList.add(new ModelBox(head3, 0, 0, 0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F, true));
		
		head2 = new ModelRenderer(this);
		head2.setRotationPoint(-12.0F, -2.0F, -4.0F);
		head2.cubeList.add(new ModelBox(head2, 0, 0, 0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F, true));
		
		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(-7.0F, 7.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 49, 16, 0.0F, 0.0F, 0.0F, 3, 10, 3, 0.0F, true));
		
		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(4.0F, 7.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 47, 18, 0.0F, -1.0F, 0.0F, 3, 10, 3, 0.0F, true));
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		head.render(par7);
		body.render(par7);
		leg3.render(par7);
		leg4.render(par7);
		leg1.render(par7);
		leg2.render(par7);
		head3.render(par7);
		head2.render(par7);
		bipedLeftArm.render(par7);
		bipedRightArm.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
		boolean flag = true;
		float f2 = -(float) Math.PI / (flag ? 1.5F : 2.25F);
		this.bipedRightArm.rotateAngleX = f2;
		this.bipedLeftArm.rotateAngleX = f2;
		this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
}