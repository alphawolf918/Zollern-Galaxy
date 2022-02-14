/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityKree;
import zollerngalaxy.mobs.models.ModelKree;

@SideOnly(Side.CLIENT)
public class RenderKree extends RenderLiving<EntityKree> {
	
	private static final float f6 = 1.2F;
	
	private static final ResourceLocation KREE_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/kree.png");
	
	public RenderKree(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelKree(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
	}
	
	@Override
	protected void preRenderCallback(EntityKree entitylivingbaseIn, float partialTickTime) {
		this.scaleKree(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleKree(EntityKree par1EntityKree, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKree entity) {
		return KREE_TEXTURE;
	}
}