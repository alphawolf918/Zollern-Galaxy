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

/**
 * Model by Zollern Wolf
 */
public class ModelShark extends ModelBase {
	
	private final ModelRenderer headParts;
	private final ModelRenderer bodyParts;
	private final ModelRenderer topFin;
	private final ModelRenderer sideFinLeft;
	private final ModelRenderer sideFinRight;
	private final ModelRenderer headParts2;
	private final ModelRenderer backFinTop;
	private final ModelRenderer backFinBottom;
	private final ModelRenderer tailFins;
	
	public ModelShark() {
		textureWidth = 64;
		textureHeight = 64;
		
		headParts = new ModelRenderer(this);
		headParts.setRotationPoint(0.0F, 19.8128F, 2.7327F);
		setRotationAngle(headParts, 0.3491F, 0.0F, 0.0F);
		headParts.cubeList.add(new ModelBox(headParts, 0, 17, -3.0F, -6.0F, -9.0F, 6, 3, 7, 0.0F, false));
		
		bodyParts = new ModelRenderer(this);
		bodyParts.setRotationPoint(0.0F, 24.0F, 0.0F);
		bodyParts.cubeList.add(new ModelBox(bodyParts, 0, 0, -4.0F, -8.0F, -3.0F, 8, 5, 12, 0.0F, false));
		bodyParts.cubeList.add(new ModelBox(bodyParts, 0, 27, -2.0F, -7.0F, 7.0F, 4, 3, 6, 0.0F, false));
		bodyParts.cubeList.add(new ModelBox(bodyParts, 30, 17, -3.0F, -6.0F, 9.0F, 6, 3, 5, 0.0F, false));
		
		topFin = new ModelRenderer(this);
		topFin.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(topFin, -0.3491F, 0.0F, 0.0F);
		topFin.cubeList.add(new ModelBox(topFin, 20, 21, -1.0F, -18.0F, -2.0F, 2, 10, 6, 0.0F, false));
		
		sideFinLeft = new ModelRenderer(this);
		sideFinLeft.setRotationPoint(-0.3088F, 22.0896F, -2.501F);
		setRotationAngle(sideFinLeft, -0.5236F, 0.0873F, 0.5236F);
		sideFinLeft.cubeList.add(new ModelBox(sideFinLeft, 36, 25, 1.0F, -8.0F, 2.0F, 6, 3, 1, 0.0F, false));
		
		sideFinRight = new ModelRenderer(this);
		sideFinRight.setRotationPoint(4.3282F, 20.1299F, -3.5292F);
		setRotationAngle(sideFinRight, -0.5236F, 0.0873F, -0.5236F);
		sideFinRight.cubeList.add(new ModelBox(sideFinRight, 28, 8, -12.3824F, -9.0F, 3.0F, 6, 3, 1, 0.0F, false));
		
		headParts2 = new ModelRenderer(this);
		headParts2.setRotationPoint(0.0F, 24.0F, 0.0F);
		headParts2.cubeList.add(new ModelBox(headParts2, 28, 0, -3.0F, -5.0F, -7.0F, 6, 2, 6, 0.0F, false));
		
		backFinTop = new ModelRenderer(this);
		backFinTop.setRotationPoint(1.0F, 27.0285F, 5.1069F);
		setRotationAngle(backFinTop, -0.4363F, 0.0F, 0.0F);
		backFinTop.cubeList.add(new ModelBox(backFinTop, 0, 0, -2.0F, -17.0F, 0.0F, 2, 9, 3, 0.0F, false));
		
		backFinBottom = new ModelRenderer(this);
		backFinBottom.setRotationPoint(-1.0F, 11.8044F, 4.6281F);
		setRotationAngle(backFinBottom, -0.4363F, 0.0F, -3.1416F);
		backFinBottom.cubeList.add(new ModelBox(backFinBottom, 33, 34, -2.0F, -16.0F, 1.0F, 2, 8, 3, 0.0F, false));
		
		tailFins = new ModelRenderer(this);
		tailFins.setRotationPoint(0.0F, 24.0F, 0.0F);
		tailFins.cubeList.add(new ModelBox(tailFins, 19, 17, -2.0F, -5.0F, 14.0F, 4, 1, 3, 0.0F, false));
		tailFins.cubeList.add(new ModelBox(tailFins, 0, 36, -2.0F, -12.0F, 16.0F, 4, 7, 1, 0.0F, false));
		tailFins.cubeList.add(new ModelBox(tailFins, 10, 36, -2.0F, -4.0F, 16.0F, 4, 6, 1, 0.0F, false));
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		headParts.render(f5);
		bodyParts.render(f5);
		topFin.render(f5);
		sideFinLeft.render(f5);
		sideFinRight.render(f5);
		headParts2.render(f5);
		backFinTop.render(f5);
		backFinBottom.render(f5);
		tailFins.render(f5);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}