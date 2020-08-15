/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.models.ModelShadowSkeleton;

@SideOnly(Side.CLIENT)
public class RenderShadowSkeleton extends RenderBiped<EntityShadowSkeleton> {
	
	private static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/shadowskeleton.png");
	
	public RenderShadowSkeleton(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShadowSkeleton(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelShadowSkeleton(0.5F, true);
				this.modelArmor = new ModelShadowSkeleton(1.0F, true);
			}
		});
	}
	
	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShadowSkeleton entity) {
		return SKELETON_TEXTURE;
	}
}