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

public class ModelGalaxyDragon extends ModelBase {
	
	private final ModelRenderer Dragon;
	private final ModelRenderer wingbase22;
	private final ModelRenderer wingbase21;
	private final ModelRenderer tailfin2;
	private final ModelRenderer tailfin1;
	private final ModelRenderer tailbase4;
	private final ModelRenderer tailbase3;
	private final ModelRenderer tailbase2;
	private final ModelRenderer tailbase1;
	private final ModelRenderer neck2;
	private final ModelRenderer leg4;
	private final ModelRenderer leg3;
	private final ModelRenderer leg2;
	private final ModelRenderer leg1;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer neck1;
	private final ModelRenderer wingbase1;
	private final ModelRenderer wingbase2;
	
	public ModelGalaxyDragon() {
		textureWidth = 256;
		textureHeight = 256;
		
		Dragon = new ModelRenderer(this);
		Dragon.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		wingbase22 = new ModelRenderer(this);
		wingbase22.setRotationPoint(-5.9F, -16.0F, 2.0F);
		Dragon.addChild(wingbase22);
		wingbase22.cubeList.add(new ModelBox(wingbase22, 4, 3, 0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F, true));
		
		wingbase21 = new ModelRenderer(this);
		wingbase21.setRotationPoint(5.2F, -16.0F, 2.0F);
		Dragon.addChild(wingbase21);
		wingbase21.cubeList.add(new ModelBox(wingbase21, 4, 3, 0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F, true));
		
		tailfin2 = new ModelRenderer(this);
		tailfin2.setRotationPoint(0.9F, -10.0F, 25.0F);
		Dragon.addChild(tailfin2);
		setRotationAngle(tailfin2, 1.85F, 0.3142F, 0.0F);
		tailfin2.cubeList.add(new ModelBox(tailfin2, 125, 89, 0.0F, 0.0F, 0.0F, 2, 5, 8, 0.0F, true));
		
		tailfin1 = new ModelRenderer(this);
		tailfin1.setRotationPoint(-2.9F, -9.0F, 25.0F);
		Dragon.addChild(tailfin1);
		setRotationAngle(tailfin1, 1.85F, -0.3142F, 0.0F);
		tailfin1.cubeList.add(new ModelBox(tailfin1, 125, 89, 0.0F, 0.0F, 1.0F, 2, 5, 8, 0.0F, true));
		
		tailbase4 = new ModelRenderer(this);
		tailbase4.setRotationPoint(-2.8667F, -10.0F, 21.0F);
		Dragon.addChild(tailbase4);
		setRotationAngle(tailbase4, 1.5708F, 0.0F, 0.0F);
		tailbase4.cubeList.add(new ModelBox(tailbase4, 28, 17, 0.0F, 0.0F, 0.0F, 6, 5, 7, 0.0F, true));
		
		tailbase3 = new ModelRenderer(this);
		tailbase3.setRotationPoint(-2.8667F, -9.0F, 17.0F);
		Dragon.addChild(tailbase3);
		setRotationAngle(tailbase3, 1.5708F, 0.0F, 0.0F);
		tailbase3.cubeList.add(new ModelBox(tailbase3, 28, 17, 0.0F, 0.0F, 0.0F, 6, 5, 7, 0.0F, true));
		
		tailbase2 = new ModelRenderer(this);
		tailbase2.setRotationPoint(-2.8667F, -7.3333F, 14.0F);
		Dragon.addChild(tailbase2);
		setRotationAngle(tailbase2, 1.5708F, 0.0F, 0.0F);
		tailbase2.cubeList.add(new ModelBox(tailbase2, 28, 17, 0.0F, 0.0F, 0.0F, 6, 5, 7, 0.0F, true));
		
		tailbase1 = new ModelRenderer(this);
		tailbase1.setRotationPoint(-3.8667F, -6.0F, 0.0F);
		Dragon.addChild(tailbase1);
		setRotationAngle(tailbase1, 1.5708F, 0.0F, 0.0F);
		tailbase1.cubeList.add(new ModelBox(tailbase1, 28, 17, 0.0F, 0.0F, 0.0F, 8, 14, 7, 0.0F, true));
		
		neck2 = new ModelRenderer(this);
		neck2.setRotationPoint(-3.8667F, -22.0F, -7.0F);
		Dragon.addChild(neck2);
		neck2.cubeList.add(new ModelBox(neck2, 17, 0, 0.0F, 0.0F, 0.0F, 8, 8, 6, 0.0F, true));
		
		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(3.0F, -6.0F, -5.0F);
		Dragon.addChild(leg4);
		leg4.cubeList.add(new ModelBox(leg4, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.0F, -24.0F, -5.0F);
		Dragon.addChild(leg3);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 18.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(3.0F, -6.0F, 7.0F);
		Dragon.addChild(leg2);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-3.0F, -6.0F, 7.0F);
		Dragon.addChild(leg1);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -13.0F, 3.0F);
		Dragon.addChild(body);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 28, 14, -5.0F, -10.0F, -7.0F, 10, 16, 8, 0.0F, true));
		
		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -25.0F, -9.0F);
		Dragon.addChild(head);
		head.cubeList.add(new ModelBox(head, 124, 40, -4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F, true));
		
		nose = new ModelRenderer(this);
		nose.setRotationPoint(-3.8667F, 0.0F, -14.0F);
		head.addChild(nose);
		nose.cubeList.add(new ModelBox(nose, 15, 0, 0.0F, 0.0F, 0.0F, 8, 4, 9, 0.0F, true));
		
		neck1 = new ModelRenderer(this);
		neck1.setRotationPoint(-3.8667F, -26.0F, -10.0F);
		Dragon.addChild(neck1);
		neck1.cubeList.add(new ModelBox(neck1, 10, 11, 0.0F, 0.0F, 0.0F, 8, 8, 6, 0.0F, true));
		
		wingbase1 = new ModelRenderer(this);
		wingbase1.setRotationPoint(-4.8667F, -15.0F, 2.0F);
		Dragon.addChild(wingbase1);
		wingbase1.cubeList.add(new ModelBox(wingbase1, 4, 4, 0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F, true));
		
		wingbase2 = new ModelRenderer(this);
		wingbase2.setRotationPoint(4.2F, -15.0F, 2.0F);
		Dragon.addChild(wingbase2);
		wingbase2.cubeList.add(new ModelBox(wingbase2, 4, 3, 0.0F, 0.0F, 0.0F, 1, 2, 5, 0.0F, true));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
		this.Dragon.render(scale);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}
	
}