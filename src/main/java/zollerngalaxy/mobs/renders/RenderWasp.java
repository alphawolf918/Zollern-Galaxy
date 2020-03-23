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
import zollerngalaxy.mobs.entities.EntityWasp;
import zollerngalaxy.mobs.models.ModelWasp;

@SideOnly(Side.CLIENT)
public class RenderWasp extends RenderLiving<EntityWasp> {
	
	private static final ResourceLocation WASP_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/wasp.png");
	
	private final float f6 = 0.6F;
	
	public RenderWasp(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelWasp(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWasp entity) {
		return WASP_TEXTURES;
	}
	
	@Override
	protected void preRenderCallback(EntityWasp entitylivingbaseIn, float partialTickTime) {
		this.scaleWasp(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleWasp(EntityWasp par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
}