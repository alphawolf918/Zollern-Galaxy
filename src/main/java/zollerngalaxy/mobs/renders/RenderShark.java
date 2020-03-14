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
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.models.ModelShark;

@SideOnly(Side.CLIENT)
public class RenderShark extends RenderLiving<EntityShark> {
	
	private static final ResourceLocation FISH_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/shark.png");
	
	private final float f6 = 2.2F;
	
	public RenderShark(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShark(), 0.7F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShark entity) {
		return FISH_TEXTURES;
	}
	
	@Override
	protected void preRenderCallback(EntityShark entitylivingbaseIn, float partialTickTime) {
		this.scaleShark(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleShark(EntityShark par1EntityShark, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
}