package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelArcon extends ModelBase {
	
	private final ModelRenderer Arcon;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedHead;
	private final ModelRenderer bipedHead2;
	private final ModelRenderer neck;
	
	public ModelArcon() {
		textureWidth = 64;
		textureHeight = 64;
		
		Arcon = new ModelRenderer(this);
		Arcon.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-7.0F, -22.0F, 0.0F);
		Arcon.addChild(bipedRightArm);
		setRotationAngle(bipedRightArm, -1.5708F, 0.0F, 0.1F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 16, -3.0F, -4.0F, -2.0F, 5, 14, 4, 0.0F, false));
		
		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-3.0F, -12.0F, 1.1F);
		Arcon.addChild(bipedRightLeg);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(3.0F, -12.0F, 1.1F);
		Arcon.addChild(bipedLeftLeg);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(6.0F, -22.0F, 0.0F);
		Arcon.addChild(bipedLeftArm);
		setRotationAngle(bipedLeftArm, -1.5708F, 0.0F, -0.1F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 7, 16, -1.0F, -4.0F, -2.0F, 5, 14, 4, 0.0F, false));
		
		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(-1.0F, -24.0F, 0.0F);
		Arcon.addChild(bipedBody);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 13, 14, -4.0F, 0.0F, -2.0F, 10, 12, 6, 0.0F, false));
		
		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -27.0F, 0.0F);
		Arcon.addChild(bipedHead);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, 1.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F, false));
		
		bipedHead2 = new ModelRenderer(this);
		bipedHead2.setRotationPoint(0.0F, -27.0F, 0.0F);
		Arcon.addChild(bipedHead2);
		bipedHead2.cubeList.add(new ModelBox(bipedHead2, 0, 0, -8.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F, false));
		
		neck = new ModelRenderer(this);
		neck.setRotationPoint(-1.0F, -28.0F, 0.0F);
		Arcon.addChild(neck);
		neck.cubeList.add(new ModelBox(neck, 30, 10, -1.0F, -2.0F, 0.0F, 5, 8, 3, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Arcon.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
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
		
		this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.bipedHead.rotateAngleX = headPitch * 0.017453292F;
		
		this.bipedHead2.rotateAngleY = netHeadYaw * 0.017453292F;
		this.bipedHead2.rotateAngleX = headPitch * 0.017453292F;
		
		this.bipedLeftArm.rotationPointZ = 0.0F;
		this.bipedLeftArm.rotationPointX = 5.0F;
		this.bipedLeftArm.rotateAngleX = -0.75F;
		this.bipedRightArm.rotationPointZ = 0.0F;
		this.bipedRightArm.rotationPointX = -5.0F;
		this.bipedRightArm.rotateAngleX = -0.75F;
		
		this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		this.bipedRightLeg.rotateAngleZ = 0.0F;
		this.bipedLeftLeg.rotateAngleZ = 0.0F;
		
		this.bipedRightArm.rotateAngleY = 0.0F;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			ModelRenderer modelrenderer = this.bipedLeftArm;
			float f1 = this.swingProgress;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.bipedBody.rotateAngleY *= -1.0F;
			}
			
			this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
}