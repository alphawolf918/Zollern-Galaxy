/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders.boss;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.boss.EntityShadowAlien;
import zollerngalaxy.mobs.models.boss.ModelShadowAlien;

@SideOnly(Side.CLIENT)
public class RenderShadowAlien extends RenderLiving<EntityShadowAlien> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation SHADOW_ALIEN_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/shadowalien.png");
	
	public RenderShadowAlien(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShadowAlien(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityShadowAlien entitylivingbaseIn, float partialTickTime) {
		this.scaleShadowAlien(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleShadowAlien(EntityShadowAlien par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShadowAlien entity) {
		return SHADOW_ALIEN_TEXTURES;
	}
}