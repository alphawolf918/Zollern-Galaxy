package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Made by @author DabbingEevee.
 */
public class ModelKrull extends ModelBiped {
	
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer MouthFlapTop;
	private final ModelRenderer MouthFlapBottom;
	private final ModelRenderer MouthFlapLeft;
	private final ModelRenderer MouthFlapRight;
	
	public ModelKrull() {
		textureWidth = 64;
		textureHeight = 64;
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 2.0F, 0.0F);
		Head.setTextureOffset(0, 0);
		Head.addBox(-4.0F, -18.0F, -4.0F, 8, 8, 8);
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(32, 32);
		Body.addBox(-4.0F, -8.0F, -2.0F, 8, 12, 4);
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(0, 40);
		RightArm.addBox(-3.0F, -10.0F, -2.0F, 4, 16, 4);
		RightArm.setTextureOffset(48, 0);
		RightArm.addBox(-6.0F, -9.0F, -0.5F, 3, 13, 1);
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(32, 0);
		LeftArm.addBox(-1.0F, -10.0F, -2.0F, 4, 16, 4);
		LeftArm.setTextureOffset(48, 48);
		LeftArm.addBox(3.0F, -9.0F, -0.5F, 3, 13, 1);
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(16, 16);
		RightLeg.addBox(-2.0F, -8.0F, -2.0F, 4, 20, 4);
		RightLeg.setTextureOffset(48, 20);
		RightLeg.addBox(1.9F, 5.0F, -3.0F, 4, 5, 1);
		RightLeg.setTextureOffset(48, 14);
		RightLeg.addBox(-2.0F, 5.0F, -3.0F, 4, 5, 1);
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 16);
		LeftLeg.addBox(-2.0F, -8.0F, -2.0F, 4, 20, 4);
		
		MouthFlapTop = new ModelRenderer(this);
		MouthFlapTop.setRotationPoint(0.0F, -16.0F, -4.0F);
		MouthFlapTop.setTextureOffset(32, 48);
		MouthFlapTop.addBox(-4.0F, -8.0F, 0.0F, 8, 8, 0);
		
		MouthFlapBottom = new ModelRenderer(this);
		MouthFlapBottom.setRotationPoint(0.0F, -8.0F, -4.0F);
		MouthFlapBottom.setTextureOffset(16, 48);
		MouthFlapBottom.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 0);
		
		MouthFlapLeft = new ModelRenderer(this);
		MouthFlapLeft.setRotationPoint(4.0F, -12.0F, -4.0F);
		MouthFlapLeft.setTextureOffset(32, 20);
		MouthFlapLeft.addBox(0.0F, -4.0F, 0.0F, 8, 8, 0);
		
		MouthFlapRight = new ModelRenderer(this);
		MouthFlapRight.setRotationPoint(-4.0F, -12.0F, -5.0F);
		MouthFlapRight.setTextureOffset(16, 40);
		MouthFlapRight.addBox(-8.0F, -4.0F, 1.0F, 8, 8, 0);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Head.render(par7);
		Body.render(par7);
		RightArm.render(par7);
		LeftArm.render(par7);
		RightLeg.render(par7);
		LeftLeg.render(par7);
		MouthFlapTop.render(par7);
		MouthFlapBottom.render(par7);
		MouthFlapLeft.render(par7);
		MouthFlapRight.render(par7);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}