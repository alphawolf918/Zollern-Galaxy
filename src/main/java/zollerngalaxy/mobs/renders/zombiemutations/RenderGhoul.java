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
import zollerngalaxy.mobs.entities.zombiemutations.EntityGhoul;
import zollerngalaxy.mobs.models.zombiemutations.ModelGhoul;

@SideOnly(Side.CLIENT)
public class RenderGhoul extends RenderLiving<EntityGhoul> {
	
	private static final float f6 = 1.1F;
	
	private static final ResourceLocation GHOUL_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/ghoul.png");
	
	public RenderGhoul(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelGhoul(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityGhoul entitylivingbaseIn, float partialTickTime) {
		this.scaleGhoul(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleGhoul(EntityGhoul par1EntityGhoul, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGhoul entity) {
		return GHOUL_TEXTURES;
	}
}