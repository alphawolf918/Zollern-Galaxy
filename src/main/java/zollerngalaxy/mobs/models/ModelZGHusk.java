package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelZGHusk extends ModelBase {
	
	private final ModelRenderer Shape3;
	private final ModelRenderer Shape2;
	private final ModelRenderer Shape1;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer Shape4;
	private final ModelRenderer Shape6;
	private final ModelRenderer Shape5;
	private final ModelRenderer Shape8;
	private final ModelRenderer Shape7;
	
	public ModelZGHusk() {
		textureWidth = 64;
		textureHeight = 64;
		
		Shape3 = new ModelRenderer(this);
		Shape3.setRotationPoint(-3.0F, -12.0F, -2.0F);
		setRotationAngle(Shape3, -0.5585F, 0.0F, 0.0F);
		Shape3.cubeList.add(new ModelBox(Shape3, 0, 0, 0.0F, 0.0F, 0.0F, 6, 2, 5, 0.0F, true));
		
		Shape2 = new ModelRenderer(this);
		Shape2.setRotationPoint(5.0F, -8.0F, 0.0F);
		setRotationAngle(Shape2, -0.2443F, -0.3491F, 0.0F);
		Shape2.cubeList.add(new ModelBox(Shape2, 0, 0, 0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F, true));
		
		Shape1 = new ModelRenderer(this);
		Shape1.setRotationPoint(-7.0F, -8.0F, 0.0F);
		setRotationAngle(Shape1, -0.2443F, 0.3491F, 0.0F);
		Shape1.cubeList.add(new ModelBox(Shape1, 0, 0, 0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F, true));
		
		head = new ModelRenderer(this);
		head.setRotationPoint(-1.0F, -2.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 26, -4.0F, -8.0F, -4.0F, 10, 10, 9, 0.0F, true));
		
		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));
		
		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedRightArm, -1.6406F, 0.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(bipedLeftArm, -1.6406F, 0.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		rightleg.cubeList.add(new ModelBox(rightleg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		leftleg.cubeList.add(new ModelBox(leftleg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));
		
		Shape4 = new ModelRenderer(this);
		Shape4.setRotationPoint(-4.0F, -9.0F, 5.0F);
		Shape4.cubeList.add(new ModelBox(Shape4, 0, 0, 0.0F, 0.0F, 0.0F, 8, 7, 4, 0.0F, true));
		
		Shape6 = new ModelRenderer(this);
		Shape6.setRotationPoint(-3.0F, -8.0F, 9.0F);
		setRotationAngle(Shape6, -0.3142F, 0.0F, 0.0F);
		Shape6.cubeList.add(new ModelBox(Shape6, 0, 0, 0.0F, 0.0F, 0.0F, 7, 6, 3, 0.0F, true));
		
		Shape5 = new ModelRenderer(this);
		Shape5.setRotationPoint(-2.0F, -7.0F, 11.0F);
		setRotationAngle(Shape5, -0.4712F, 0.0F, 0.0F);
		Shape5.cubeList.add(new ModelBox(Shape5, 0, 0, 0.0F, 0.0F, 0.0F, 5, 5, 3, 0.0F, true));
		
		Shape8 = new ModelRenderer(this);
		Shape8.setRotationPoint(-1.0F, -6.0F, 12.0F);
		setRotationAngle(Shape8, -0.5585F, 0.0F, 0.0F);
		Shape8.cubeList.add(new ModelBox(Shape8, 0, 0, 0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F, true));
		
		Shape7 = new ModelRenderer(this);
		Shape7.setRotationPoint(-1.0F, -5.0F, 15.0F);
		setRotationAngle(Shape7, -0.9774F, 0.0F, 0.0F);
		Shape7.cubeList.add(new ModelBox(Shape7, 0, 0, 0.0F, 0.0F, 0.0F, 3, 4, 2, 0.0F, true));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Shape3.render(f5);
		Shape2.render(f5);
		Shape1.render(f5);
		head.render(f5);
		body.render(f5);
		bipedRightArm.render(f5);
		bipedLeftArm.render(f5);
		rightleg.render(f5);// ModelZombie
		leftleg.render(f5);
		Shape4.render(f5);
		Shape6.render(f5);
		Shape5.render(f5);
		Shape8.render(f5);
		Shape7.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn) {
		float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.head.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.head.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape1.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape1.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape2.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape2.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape3.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape3.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape4.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape4.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape5.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape5.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape6.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape6.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape7.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape7.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape8.rotateAngleY = p_78087_5_ / (180F / (float) Math.PI);
		this.Shape8.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
		this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedRightArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.bipedLeftArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		this.rightleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
		this.leftleg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float) Math.PI) * 1.4F * p_78087_2_;
		this.rightleg.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;
	}
	
}