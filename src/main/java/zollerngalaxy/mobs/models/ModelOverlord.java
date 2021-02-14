package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelOverlord extends ModelBase {
	
	ModelRenderer bipedArmLeft;
	ModelRenderer bipedArmRight;
	ModelRenderer bipedHead;
	ModelRenderer bipedBody;
	ModelRenderer Body;
	ModelRenderer Leg8;
	ModelRenderer Leg6;
	ModelRenderer Leg4;
	ModelRenderer Leg2;
	ModelRenderer Leg7;
	ModelRenderer Leg5;
	ModelRenderer Leg3;
	ModelRenderer Leg1;
	
	public ModelOverlord() {
		textureWidth = 64;
		textureHeight = 64;
		
		bipedArmLeft = new ModelRenderer(this, 41, 0);
		bipedArmLeft.addBox(-3F, -2F, -2F, 4, 12, 4);
		bipedArmLeft.setRotationPoint(-5F, 7F, -1F);
		bipedArmLeft.setTextureSize(64, 64);
		bipedArmLeft.mirror = true;
		setRotation(bipedArmLeft, -1.32645F, 0F, 0F);
		bipedArmRight = new ModelRenderer(this, 0, 0);
		bipedArmRight.addBox(-1F, -2F, -2F, 4, 12, 4);
		bipedArmRight.setRotationPoint(5F, 7F, -1F);
		bipedArmRight.setTextureSize(64, 64);
		bipedArmRight.mirror = true;
		setRotation(bipedArmRight, -1.32645F, 0F, 0F);
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		bipedHead.setRotationPoint(0F, 5F, -1F);
		bipedHead.setTextureSize(64, 64);
		bipedHead.mirror = true;
		setRotation(bipedHead, 0F, 0F, 0F);
		bipedBody = new ModelRenderer(this, 35, 0);
		bipedBody.addBox(-4F, 0F, -2F, 8, 12, 4);
		bipedBody.setRotationPoint(0F, 5F, -1F);
		bipedBody.setTextureSize(64, 64);
		bipedBody.mirror = true;
		setRotation(bipedBody, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 31, 0);
		Body.addBox(-3F, -3F, -3F, 8, 6, 10);
		Body.setRotationPoint(-1F, 20F, 0F);
		Body.setTextureSize(64, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Leg8 = new ModelRenderer(this, 18, 0);
		Leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg8.setRotationPoint(4F, 20F, -1F);
		Leg8.setTextureSize(64, 64);
		Leg8.mirror = true;
		setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);
		Leg6 = new ModelRenderer(this, 18, 0);
		Leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg6.setRotationPoint(4F, 20F, 0F);
		Leg6.setTextureSize(64, 64);
		Leg6.mirror = true;
		setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);
		Leg4 = new ModelRenderer(this, 18, 0);
		Leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg4.setRotationPoint(4F, 20F, 1F);
		Leg4.setTextureSize(64, 64);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);
		Leg2 = new ModelRenderer(this, 18, 0);
		Leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
		Leg2.setRotationPoint(4F, 20F, 2F);
		Leg2.setTextureSize(64, 64);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, -0.5759587F, 0.1919862F);
		Leg7 = new ModelRenderer(this, 18, 0);
		Leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg7.setRotationPoint(-4F, 20F, -1F);
		Leg7.setTextureSize(64, 64);
		Leg7.mirror = true;
		setRotation(Leg7, 0F, -0.5759587F, -0.1919862F);
		Leg5 = new ModelRenderer(this, 18, 0);
		Leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg5.setRotationPoint(-4F, 20F, 0F);
		Leg5.setTextureSize(64, 64);
		Leg5.mirror = true;
		setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);
		Leg3 = new ModelRenderer(this, 18, 0);
		Leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg3.setRotationPoint(-4F, 20F, 1F);
		Leg3.setTextureSize(64, 64);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);
		Leg1 = new ModelRenderer(this, 18, 0);
		Leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
		Leg1.setRotationPoint(-4F, 20F, 2F);
		Leg1.setTextureSize(64, 64);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0.5759587F, -0.1919862F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		bipedArmLeft.render(par7);
		bipedArmRight.render(par7);
		bipedHead.render(par7);
		bipedBody.render(par7);
		Body.render(par7);
		Leg8.render(par7);
		Leg6.render(par7);
		Leg4.render(par7);
		Leg2.render(par7);
		Leg7.render(par7);
		Leg5.render(par7);
		Leg3.render(par7);
		Leg1.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.bipedArmRight.rotateAngleZ = 0.0F;
		this.bipedArmLeft.rotateAngleZ = 0.0F;
		this.bipedArmRight.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedArmLeft.rotateAngleY = 0.1F - f * 0.6F;
		this.bipedArmRight.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedArmLeft.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedArmRight.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.bipedArmLeft.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.bipedArmRight.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.bipedArmLeft.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.bipedArmRight.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.bipedArmLeft.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		float f6 = ((float) Math.PI / 4F);
		this.Leg1.rotateAngleZ = -f6;
		this.Leg2.rotateAngleZ = f6;
		this.Leg3.rotateAngleZ = -f6 * 0.74F;
		this.Leg4.rotateAngleZ = f6 * 0.74F;
		this.Leg5.rotateAngleZ = -f6 * 0.74F;
		this.Leg6.rotateAngleZ = f6 * 0.74F;
		this.Leg7.rotateAngleZ = -f6;
		this.Leg8.rotateAngleZ = f6;
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
	}
}