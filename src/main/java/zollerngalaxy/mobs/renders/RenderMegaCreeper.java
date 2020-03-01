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
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.models.ModelMegaCreeper;

@SideOnly(Side.CLIENT)
public class RenderMegaCreeper extends RenderLiving<EntityMegaCreeper> {
	
	private static final ResourceLocation MEGA_CREEPER_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID
			+ ":textures/entity/megacreeper.png");
	
	private static final float f6 = 1.6F;
	
	public RenderMegaCreeper(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelMegaCreeper(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityMegaCreeper entitylivingbaseIn, float partialTickTime) {
		this.scaleMegaCreeper(entitylivingbaseIn, partialTickTime);
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
		float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		f = f * f;
		f = f * f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		GlStateManager.scale(f2, f3, f2);
	}
	
	protected void scaleMegaCreeper(EntityMegaCreeper par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	/**
	 * Gets an RGBA int color multiplier to apply.
	 */
	@Override
	protected int getColorMultiplier(EntityMegaCreeper entitylivingbaseIn, float lightBrightness, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
		
		if ((int) (f * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int) (f * 0.2F * 255.0F);
			i = MathHelper.clamp(i, 0, 255);
			return i << 24 | 822083583;
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMegaCreeper entity) {
		return MEGA_CREEPER_TEXTURES;
	}
}