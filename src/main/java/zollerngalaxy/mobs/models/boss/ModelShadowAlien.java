/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelShadowAlien extends ModelBase {
	
	public ModelRenderer Neck;
	public ModelRenderer head;
	public ModelRenderer head2;
	public ModelRenderer head3;
	public ModelRenderer head4;
	public ModelRenderer head5;
	public ModelRenderer head6;
	public ModelRenderer head7;
	public ModelRenderer head8;
	public ModelRenderer body;
	public ModelRenderer rightarm;
	public ModelRenderer leftarm;
	public ModelRenderer Tail1;
	public ModelRenderer Tail2;
	public ModelRenderer Tail3;
	public ModelRenderer Tail4;
	public ModelRenderer Tail5;
	
	public ModelShadowAlien.ArmPose leftArmPose;
	public ModelShadowAlien.ArmPose rightArmPose;
	
	public ModelShadowAlien() {
		textureWidth = 64;
		textureHeight = 32;
		
		Neck = new ModelRenderer(this, 9, 20);
		Neck.addBox(0F, 0F, 0F, 6, 4, 5);
		Neck.setRotationPoint(-3F, -4F, -1F);
		Neck.setTextureSize(64, 32);
		Neck.mirror = true;
		setRotation(Neck, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, -4F, 1F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, -0.1396263F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 20);
		head2.addBox(-4F, -8F, -4F, 6, 6, 6);
		head2.setRotationPoint(1F, -2F, 8F);
		head2.setTextureSize(64, 32);
		head2.mirror = true;
		setRotation(head2, -0.2094395F, 0F, 0F);
		head3 = new ModelRenderer(this, 0, 20);
		head3.addBox(-4F, -8F, -4F, 4, 5, 7);
		head3.setRotationPoint(2F, 0F, 12F);
		head3.setTextureSize(64, 32);
		head3.mirror = true;
		setRotation(head3, -0.4014257F, 0F, 0F);
		head4 = new ModelRenderer(this, 26, 16);
		head4.addBox(-4F, -8F, -4F, 2, 6, 6);
		head4.setRotationPoint(8F, -3F, 2F);
		head4.setTextureSize(64, 32);
		head4.mirror = true;
		setRotation(head4, -0.1396263F, 0F, 0F);
		head5 = new ModelRenderer(this, 26, 16);
		head5.addBox(0F, 0F, 0F, 2, 6, 6);
		head5.setRotationPoint(-6F, -12F, -1F);
		head5.setTextureSize(64, 32);
		head5.mirror = true;
		setRotation(head5, -0.1396263F, 0F, 0F);
		head6 = new ModelRenderer(this, 26, 16);
		head6.addBox(0F, 0F, 0F, 2, 6, 4);
		head6.setRotationPoint(5F, -11.5F, 0F);
		head6.setTextureSize(64, 32);
		head6.mirror = true;
		setRotation(head6, -0.1396263F, 0F, 0F);
		head7 = new ModelRenderer(this, 26, 16);
		head7.addBox(0F, 0F, 0F, 2, 6, 4);
		head7.setRotationPoint(-7F, -11.5F, 0F);
		head7.setTextureSize(64, 32);
		head7.mirror = true;
		setRotation(head7, -0.1396263F, 0F, 0F);
		head8 = new ModelRenderer(this, 23, 16);
		head8.addBox(-4F, -8F, -4F, 8, 4, 8);
		head8.setRotationPoint(0F, -7F, 4F);
		head8.setTextureSize(64, 32);
		head8.mirror = true;
		setRotation(head8, 0.2443461F, 0F, 0F);
		body = new ModelRenderer(this, 16, 12);
		body.addBox(-4F, 0F, -2F, 8, 12, 8);
		body.setRotationPoint(0F, -1F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 5);
		rightarm.setRotationPoint(-5F, 1F, 3F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, -1.605703F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 5);
		leftarm.setRotationPoint(5F, 1F, 3F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, -1.605703F, 0F, 0F);
		Tail1 = new ModelRenderer(this, 0, 21);
		Tail1.addBox(0F, 0F, 0F, 6, 5, 6);
		Tail1.setRotationPoint(-3F, 11F, -1F);
		Tail1.setTextureSize(64, 32);
		Tail1.mirror = true;
		setRotation(Tail1, 0.1919862F, 0F, 0F);
		Tail2 = new ModelRenderer(this, 0, 22);
		Tail2.addBox(0F, 0F, 0F, 6, 4, 6);
		Tail2.setRotationPoint(-3F, 16F, 0F);
		Tail2.setTextureSize(64, 32);
		Tail2.mirror = true;
		setRotation(Tail2, 0.6108652F, 0F, 0F);
		Tail3 = new ModelRenderer(this, 31, 16);
		Tail3.addBox(0F, 0F, 0F, 6, 5, 6);
		Tail3.setRotationPoint(-3F, 18F, 1F);
		Tail3.setTextureSize(64, 32);
		Tail3.mirror = true;
		setRotation(Tail3, 0.6283185F, 0F, 0F);
		Tail4 = new ModelRenderer(this, 31, 16);
		Tail4.addBox(0F, 0F, 0F, 6, 9, 6);
		Tail4.setRotationPoint(-3F, 22F, 4F);
		Tail4.setTextureSize(64, 32);
		Tail4.mirror = true;
		setRotation(Tail4, 1.134464F, 0F, 0F);
		Tail5 = new ModelRenderer(this, 31, 16);
		Tail5.addBox(0F, 0F, 0F, 6, 10, 6);
		Tail5.setRotationPoint(-3F, 25F, 9F);
		Tail5.setTextureSize(64, 32);
		Tail5.mirror = true;
		setRotation(Tail5, 1.361357F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Neck.render(par7);
		head.render(par7);
		head2.render(par7);
		head3.render(par7);
		head4.render(par7);
		head5.render(par7);
		head6.render(par7);
		head7.render(par7);
		head8.render(par7);
		body.render(par7);
		rightarm.render(par7);
		leftarm.render(par7);
		Tail1.render(par7);
		Tail2.render(par7);
		Tail3.render(par7);
		Tail4.render(par7);
		Tail5.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		float f6 = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f7 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightarm.rotateAngleY = -(0.1F - f6 * 0.6F);
		this.leftarm.rotateAngleY = 0.1F - f6 * 0.6F;
		this.rightarm.rotateAngleX = -((float) Math.PI / 2F);
		this.leftarm.rotateAngleX = -((float) Math.PI / 2F);
		this.rightarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.leftarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
	}
	
	public void postRenderArm(float scale, EnumHandSide side) {
		this.getArmForSide(side).postRender(scale);
	}
	
	protected ModelRenderer getArmForSide(EnumHandSide side) {
		return side == EnumHandSide.LEFT ? this.leftarm : this.rightarm;
	}
	
	protected EnumHandSide getMainHand(Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			EntityLivingBase entitylivingbase = (EntityLivingBase) entityIn;
			EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
			return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
		} else {
			return EnumHandSide.RIGHT;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static enum ArmPose {
		EMPTY, ITEM, BLOCK, BOW_AND_ARROW;
	}
}