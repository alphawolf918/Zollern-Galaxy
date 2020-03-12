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
import zollerngalaxy.mobs.entities.EntityGypsyFish;
import zollerngalaxy.mobs.models.ModelGypsyFish;

@SideOnly(Side.CLIENT)
public class RenderGypsyFish extends RenderLiving<EntityGypsyFish> {
	
	private static final ResourceLocation FISH_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/gypsyfish.png");
	
	private final float f6 = 1.8F;
	
	public RenderGypsyFish(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelGypsyFish(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGypsyFish entity) {
		return FISH_TEXTURES;
	}
	
	@Override
	protected void preRenderCallback(EntityGypsyFish entitylivingbaseIn, float partialTickTime) {
		this.scaleGypsyFish(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleGypsyFish(EntityGypsyFish par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
}