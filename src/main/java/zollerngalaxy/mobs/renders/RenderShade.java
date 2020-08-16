/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityShade;
import zollerngalaxy.mobs.models.ModelShade;

@SideOnly(Side.CLIENT)
public class RenderShade extends RenderBiped<EntityShade> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation SHADE_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/shade.png");
	
	public RenderShade(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShade(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityShade entitylivingbaseIn, float partialTickTime) {
		this.scaleShade(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleShade(EntityShade par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShade entity) {
		return SHADE_TEXTURES;
	}
}