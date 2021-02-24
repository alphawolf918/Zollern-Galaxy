/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders.zombiemutations;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.zombiemutations.EntityOverlord;
import zollerngalaxy.mobs.models.zombiemutations.ModelOverlord;

@SideOnly(Side.CLIENT)
public class RenderOverlord extends RenderLiving<EntityOverlord> {
	
	private static final float f6 = 2.0F;
	
	private static final ResourceLocation OVERLORD_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/overlord.png");
	
	public RenderOverlord(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelOverlord(), 1.35F);
	}
	
	@Override
	protected void preRenderCallback(EntityOverlord entitylivingbaseIn, float partialTickTime) {
		this.scaleOverlord(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleOverlord(EntityOverlord par1EntityOverlord, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityOverlord entity) {
		return OVERLORD_TEXTURES;
	}
}