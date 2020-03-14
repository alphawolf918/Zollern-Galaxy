/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityJellyfish;
import zollerngalaxy.mobs.models.ModelJellyfish;

@SideOnly(Side.CLIENT)
public class RenderJellyfish extends RenderLiving<EntityJellyfish> {
	
	private static final ResourceLocation JELLYFISH_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/jellyfish.png");
	
	private final float f6 = 0.5F;
	
	public RenderJellyfish(RenderManager p_i47192_1_) {
		super(p_i47192_1_, new ModelJellyfish(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityJellyfish entity) {
		return JELLYFISH_TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityJellyfish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		float f = entityLiving.prevSquidPitch + (entityLiving.squidPitch - entityLiving.prevSquidPitch) * partialTicks;
		float f1 = entityLiving.prevSquidYaw + (entityLiving.squidYaw - entityLiving.prevSquidYaw) * partialTicks;
		GlStateManager.translate(0.0F, 0.5F, 0.0F);
		GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(f, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.0F, -1.2F, 0.0F);
	}
	
	@Override
	protected float handleRotationFloat(EntityJellyfish livingBase, float partialTicks) {
		return livingBase.lastTentacleAngle + (livingBase.tentacleAngle - livingBase.lastTentacleAngle) * partialTicks;
	}
	
	@Override
	protected void preRenderCallback(EntityJellyfish entitylivingbaseIn, float partialTickTime) {
		this.scaleJellyfish(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleJellyfish(EntityJellyfish par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
}