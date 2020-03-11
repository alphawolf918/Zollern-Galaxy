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
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.models.ModelBlubberFish;

@SideOnly(Side.CLIENT)
public class RenderBlubberFish extends RenderLiving<EntityBlubberFish> {
	
	private static final ResourceLocation FISH_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/blubberfish.png");
	
	public RenderBlubberFish(RenderManager p_i47192_1_) {
		super(p_i47192_1_, new ModelBlubberFish(), 0.7F);
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call
	 * Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityBlubberFish entity) {
		return FISH_TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityBlubberFish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		float f = entityLiving.prevFishPitch + (entityLiving.fishPitch - entityLiving.prevFishPitch) * partialTicks;
		float f1 = entityLiving.prevFishYaw + (entityLiving.fishYaw - entityLiving.prevFishYaw) * partialTicks;
		GlStateManager.translate(0.0F, 0.5F, 0.0F);
		GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(f, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.0F, -1.2F, 0.0F);
	}
	
	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	@Override
	protected float handleRotationFloat(EntityBlubberFish livingBase, float partialTicks) {
		return livingBase.lastFinAngle + (livingBase.finAngle - livingBase.lastFinAngle) * partialTicks;
	}
}