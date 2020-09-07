/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityPigShroom;
import zollerngalaxy.mobs.models.ModelPigShroom;

@SideOnly(Side.CLIENT)
public class RenderPigShroom extends RenderLiving<EntityPigShroom> {
	
	private ModelPigShroom model;
	private static float f6 = 0.6F;
	
	public RenderPigShroom(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelPigShroom(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityPigShroom entitylivingbaseIn, float partialTickTime) {
		this.scalePigShroom(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scalePigShroom(EntityPigShroom par1EntityPigShroom, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPigShroom entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/pigshroom.png");
	}
	
}