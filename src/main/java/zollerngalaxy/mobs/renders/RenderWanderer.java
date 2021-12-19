/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityWanderer;
import zollerngalaxy.mobs.models.ModelWanderer;

@SideOnly(Side.CLIENT)
public class RenderWanderer extends RenderBiped<EntityWanderer> {
	
	private static final float f6 = 1.0F;
	
	private static final ResourceLocation WANDERER_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/wanderer.png");
	
	public RenderWanderer(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelWanderer(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityWanderer entitylivingbaseIn, float partialTickTime) {
		this.scaleWanderer(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleWanderer(EntityWanderer par1EntityWanderer, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWanderer entity) {
		return WANDERER_TEXTURES;
	}
}