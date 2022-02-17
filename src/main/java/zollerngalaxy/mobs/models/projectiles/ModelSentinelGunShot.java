/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.projectiles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSentinelGunShot extends ModelBase {
	
	private final ModelRenderer sentinelShot;
	
	public ModelSentinelGunShot() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.sentinelShot = new ModelRenderer(this, 0, 0);
		this.sentinelShot.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.sentinelShot.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
	}
	
	public void renderSentinelShot() {
		this.sentinelShot.render(0.0625F);
	}
}