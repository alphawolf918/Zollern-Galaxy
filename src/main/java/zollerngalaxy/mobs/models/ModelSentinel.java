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

public class ModelSentinel extends ModelBase {
	
	private final ModelRenderer sentinel;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer back2_r1;
	
	public ModelSentinel() {
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
}