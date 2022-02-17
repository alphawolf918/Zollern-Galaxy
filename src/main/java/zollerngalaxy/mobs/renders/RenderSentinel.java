/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntitySentinel;
import zollerngalaxy.mobs.models.ModelSentinel;

@SideOnly(Side.CLIENT)
public class RenderSentinel extends RenderLiving<EntitySentinel> {
	
	private static final ResourceLocation ENTITY_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/sentinel.png");
	
	private static final float f6 = 3.0F;
	
	public RenderSentinel(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSentinel(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntitySentinel entitylivingbaseIn, float partialTickTime) {
		this.scaleSentinel(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleSentinel(EntitySentinel par1EntitySentinel, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySentinel entity) {
		return ENTITY_TEXTURES;
	}
}