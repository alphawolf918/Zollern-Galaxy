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
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityHelleton;
import zollerngalaxy.mobs.models.ModelHelleton;

@SideOnly(Side.CLIENT)
public class RenderHelleton extends RenderBiped<EntityHelleton> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/helleton.png");
	
	public RenderHelleton(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelHelleton(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelHelleton(0.5F, true);
				this.modelArmor = new ModelHelleton(1.0F, true);
			}
		});
	}
	
	@Override
	protected void preRenderCallback(EntityHelleton entitylivingbaseIn, float partialTickTime) {
		this.scaleHelleton(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleHelleton(EntityHelleton par1EntityHelleton, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHelleton entity) {
		return SKELETON_TEXTURE;
	}
}