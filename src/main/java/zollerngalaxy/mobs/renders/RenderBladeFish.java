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
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.models.ModelBladeFish;

@SideOnly(Side.CLIENT)
public class RenderBladeFish extends RenderLiving<EntityBladeFish> {
	
	private static final ResourceLocation FISH_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/bladefish.png");
	
	private final float f6 = 1.6F;
	
	public RenderBladeFish(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBladeFish(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBladeFish entity) {
		return FISH_TEXTURES;
	}
	
	@Override
	protected void preRenderCallback(EntityBladeFish entitylivingbaseIn, float partialTickTime) {
		this.scaleBladeFish(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleBladeFish(EntityBladeFish par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
}