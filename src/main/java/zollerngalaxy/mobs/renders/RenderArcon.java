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
import zollerngalaxy.mobs.entities.EntityArcon;
import zollerngalaxy.mobs.models.ModelArcon;

@SideOnly(Side.CLIENT)
public class RenderArcon extends RenderLiving<EntityArcon> {
	
	private static final float f6 = 1.5F;
	
	private static final ResourceLocation ARCON_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/arcon.png");
	
	public RenderArcon(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelArcon(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityArcon entitylivingbaseIn, float partialTickTime) {
		this.scaleArcon(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleArcon(EntityArcon par1EntityArcon, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityArcon entity) {
		return ARCON_TEXTURES;
	}
}