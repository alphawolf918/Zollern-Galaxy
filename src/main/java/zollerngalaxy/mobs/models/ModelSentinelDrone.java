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

public class ModelSentinelDrone extends ModelBase {
	
	private final ModelRenderer sentinel;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer back2_r1;
	
	public ModelSentinelDrone() {
		textureWidth = 32;
		textureHeight = 32;
		
		sentinel = new ModelRenderer(this);
		sentinel.setRotationPoint(2.0F, 24.0F, 2.0F);
		
		head = new ModelRenderer(this);
		head.setRotationPoint(-2.0F, 0.0F, -2.0F);
		sentinel.addChild(head);
		head.cubeList.add(new ModelBox(head, 15, 3, -1.0F, -9.0F, -2.0F, 3, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 12, 8, 0.0F, -8.0F, -3.0F, 1, 1, 1, 0.0F, false));
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		sentinel.addChild(body);
		body.cubeList.add(new ModelBox(body, 0, 8, -4.0F, -9.0F, -3.0F, 5, 3, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 13, -3.0F, -9.0F, -1.0F, 3, 3, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 4, -4.0F, -6.0F, -3.0F, 5, 1, 3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -10.0F, -3.0F, 5, 1, 3, 0.0F, false));
		
		back2_r1 = new ModelRenderer(this);
		back2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(back2_r1);
		setRotationAngle(back2_r1, -0.0436F, 0.0F, 0.0F);
		back2_r1.cubeList.add(new ModelBox(back2_r1, 12, 11, -3.0F, -9.0F, 0.0F, 3, 3, 2, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		sentinel.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
		
		this.head.rotateAngleY = netheadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * 0.017453292F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			float f1 = this.swingProgress;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.body.rotateAngleY *= -1.0F;
			}
			
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
		}
	}
}