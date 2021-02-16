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
import zollerngalaxy.mobs.entities.zombiemutations.EntitySeeker;
import zollerngalaxy.mobs.models.zombiemutations.ModelSeeker;

@SideOnly(Side.CLIENT)
public class RenderSeeker extends RenderLiving<EntitySeeker> {
	
	private static final float f6 = 0.6F;
	
	private static final ResourceLocation SEEKER_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/seeker.png");
	
	public RenderSeeker(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelSeeker(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntitySeeker entitylivingbaseIn, float partialTickTime) {
		this.scaleSeeker(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleSeeker(EntitySeeker par1EntitySeeker, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySeeker entity) {
		return SEEKER_TEXTURES;
	}
}