/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntitySpiderling;
import zollerngalaxy.mobs.models.ModelSpiderling;

@SideOnly(Side.CLIENT)
public class RenderSpiderling extends RenderLiving<EntitySpiderling> {
	
	private static final ResourceLocation SCORPION_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/spiderling.png");
	
	private static final float f6 = 0.4F;
	
	public RenderSpiderling(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSpiderling(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntitySpiderling entitylivingbaseIn, float partialTickTime) {
		this.scaleScorpion(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleScorpion(EntitySpiderling par1EntitySpiderling, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySpiderling entity) {
		return SCORPION_TEXTURES;
	}
}