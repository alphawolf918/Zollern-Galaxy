package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelArcon extends ModelBase {
	
	private final ModelRenderer bipedRightArm;
	private final ModelRenderer bipedRightLeg;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer bipedLeftArm;
	private final ModelRenderer bipedBody;
	private final ModelRenderer bipedHead;
	private final ModelRenderer neck;
	private final ModelRenderer bipedHead2;
	private final ModelRenderer headThing;
	
	public ModelArcon() {
		textureWidth = 64;
		textureHeight = 64;
		
		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-7.0F, 2.0F, 0.0F);
		bipedRightArm.cubeList.add(new ModelBox(bipedRightArm, 0, 16, -2.0F, -2.0F, -0.9F, 4, 12, 4, 0.0F, false));
		
		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-3.0F, 12.0F, 1.1F);
		bipedRightLeg.cubeList.add(new ModelBox(bipedRightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(3.0F, 12.0F, 1.1F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(10.0F, -10.0F, 0.0F);
		bipedLeftArm.cubeList.add(new ModelBox(bipedLeftArm, 0, 16, -5.0F, 10.0F, -0.9F, 4, 12, 4, 0.0F, false));
		
		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(-1.0F, 0.0F, 0.0F);
		bipedBody.cubeList.add(new ModelBox(bipedBody, 16, 12, -4.0F, 1.0F, -2.0F, 10, 11, 6, 0.0F, false));
		
		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, -3.0F, 0.0F);
		bipedHead.cubeList.add(new ModelBox(bipedHead, 0, 0, -8.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F, false));
		
		neck = new ModelRenderer(this);
		neck.setRotationPoint(-1.0F, -4.0F, 0.0F);
		neck.cubeList.add(new ModelBox(neck, 0, 19, -2.0F, 0.0F, 0.0F, 6, 6, 3, 0.0F, false));
		
		bipedHead2 = new ModelRenderer(this);
		bipedHead2.setRotationPoint(9.0F, -3.0F, 0.0F);
		bipedHead2.cubeList.add(new ModelBox(bipedHead2, 0, 0, -8.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F, false));
		
		headThing = new ModelRenderer(this);
		headThing.setRotationPoint(-2.0F, -12.0F, 0.0F);
		headThing.cubeList.add(new ModelBox(headThing, 0, 17, -3.0F, -5.0F, -4.0F, 11, 7, 9, 0.0F, false));
		headThing.cubeList.add(new ModelBox(headThing, 0, 17, -1.0F, -11.0F, -4.0F, 7, 7, 9, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bipedRightArm.render(f5);
		bipedRightLeg.render(f5);
		bipedLeftLeg.render(f5);
		bipedLeftArm.render(f5);
		bipedBody.render(f5);
		bipedHead.render(f5);
		neck.render(f5);
		bipedHead2.render(f5);
		headThing.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		boolean flag = false;
		float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
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