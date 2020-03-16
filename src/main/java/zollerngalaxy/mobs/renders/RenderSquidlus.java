/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
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
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.models.ModelSquidlus;

@SideOnly(Side.CLIENT)
public class RenderSquidlus extends RenderLiving<EntitySquidlus> {
	
	private static final ResourceLocation SQUID_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/squidlus.png");
	
	private final float f6 = 2.5F;
	
	public RenderSquidlus(RenderManager p_i47192_1_) {
		super(p_i47192_1_, new ModelSquidlus(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySquidlus entity) {
		return SQUID_TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntitySquidlus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		float f = entityLiving.prevSquidPitch + (entityLiving.squidPitch - entityLiving.prevSquidPitch) * partialTicks;
		float f1 = entityLiving.prevSquidYaw + (entityLiving.squidYaw - entityLiving.prevSquidYaw) * partialTicks;
		GlStateManager.translate(0.0F, 0.5F, 0.0F);
		GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(f, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.0F, -1.2F, 0.0F);
	}
	
	@Override
	protected float handleRotationFloat(EntitySquidlus livingBase, float partialTicks) {
		return livingBase.lastTentacleAngle + (livingBase.tentacleAngle - livingBase.lastTentacleAngle) * partialTicks;
	}
	
	@Override
	protected void preRenderCallback(EntitySquidlus entitylivingbaseIn, float partialTickTime) {
		this.scaleSquidlus(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleSquidlus(EntitySquidlus par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
}