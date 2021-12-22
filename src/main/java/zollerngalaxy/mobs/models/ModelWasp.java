package zollerngalaxy.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWasp extends ModelBase {
	
	private final ModelRenderer Wasp;
	private final ModelRenderer waspHead;
	private final ModelRenderer modelrenderer;
	private final ModelRenderer modelrenderer1;
	private final ModelRenderer waspBody;
	private final ModelRenderer waspRightWing;
	private final ModelRenderer waspOuterRightWing;
	private final ModelRenderer waspLeftWing;
	private final ModelRenderer waspOuterLeftWing;
	private final ModelRenderer waspStinger;
	
	public ModelWasp() {
		textureWidth = 64;
		textureHeight = 64;
		
		Wasp = new ModelRenderer(this);
		Wasp.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		waspHead = new ModelRenderer(this);
		waspHead.setRotationPoint(0.0F, -23.0F, -5.0F);
		Wasp.addChild(waspHead);
		setRotationAngle(waspHead, 0.1745F, 0.0F, 0.0F);
		waspHead.cubeList.add(new ModelBox(waspHead, 1, 1, -3.0F, 0.0F, -2.0F, 7, 5, 9, 0.0F, false));
		
		modelrenderer = new ModelRenderer(this);
		modelrenderer.setRotationPoint(0.0F, 0.0F, 0.0F);
		waspHead.addChild(modelrenderer);
		
		modelrenderer1 = new ModelRenderer(this);
		modelrenderer1.setRotationPoint(0.0F, 0.0F, 0.0F);
		waspHead.addChild(modelrenderer1);
		
		waspBody = new ModelRenderer(this);
		waspBody.setRotationPoint(0.0F, -24.0F, 0.0F);
		Wasp.addChild(waspBody);
		waspBody.cubeList.add(new ModelBox(waspBody, 34, 2, -3.0F, 5.0F, -3.0F, 6, 11, 6, 0.0F, false));
		
		waspRightWing = new ModelRenderer(this);
		waspRightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
		waspBody.addChild(waspRightWing);
		setRotationAngle(waspRightWing, 0.0F, 0.0F, -0.1745F);
		waspRightWing.cubeList.add(new ModelBox(waspRightWing, 37, 0, -12.0F, 8.0F, 1.5F, 10, 5, 1, 0.0F, false));
		
		waspOuterRightWing = new ModelRenderer(this);
		waspOuterRightWing.setRotationPoint(-12.0F, 1.0F, 1.5F);
		waspRightWing.addChild(waspOuterRightWing);
		waspOuterRightWing.cubeList.add(new ModelBox(waspOuterRightWing, 38, 1, -8.0F, 8.0F, 0.0F, 8, 3, 1, 0.0F, false));
		
		waspLeftWing = new ModelRenderer(this);
		waspLeftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
		waspBody.addChild(waspLeftWing);
		setRotationAngle(waspLeftWing, 0.0F, 0.0F, 0.1745F);
		waspLeftWing.cubeList.add(new ModelBox(waspLeftWing, 37, 0, 2.0F, 9.0F, 1.5F, 10, 5, 1, 0.0F, true));
		
		waspOuterLeftWing = new ModelRenderer(this);
		waspOuterLeftWing.setRotationPoint(12.0F, 1.0F, 1.5F);
		waspLeftWing.addChild(waspOuterLeftWing);
		waspOuterLeftWing.cubeList.add(new ModelBox(waspOuterLeftWing, 38, 11, 0.0F, 8.0F, 0.0F, 8, 3, 1, 0.0F, true));
		
		waspStinger = new ModelRenderer(this);
		waspStinger.setRotationPoint(0.0F, -3.0F, 0.0F);
		Wasp.addChild(waspStinger);
		setRotationAngle(waspStinger, 0.4363F, 0.0F, 0.0F);
		waspStinger.cubeList.add(new ModelBox(waspStinger, 40, 12, -2.0F, -6.3942F, -7.7994F, 4, 2, 3, 0.0F, false));
		waspStinger.cubeList.add(new ModelBox(waspStinger, 36, 11, -3.0F, -7.0F, -5.0F, 6, 2, 6, 0.0F, false));
		waspStinger.cubeList.add(new ModelBox(waspStinger, 41, 12, -1.0F, -6.7557F, -12.9409F, 2, 2, 5, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Wasp.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}