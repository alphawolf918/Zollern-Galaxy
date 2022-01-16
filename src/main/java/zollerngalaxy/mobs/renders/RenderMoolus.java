/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityEdenCow;
import zollerngalaxy.mobs.models.ModelMoolus;

@SideOnly(Side.CLIENT)
public class RenderMoolus extends RenderLiving<EntityEdenCow> {
	
	private ModelMoolus model;
	private static float f6 = 1.7F;
	
	public RenderMoolus(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelMoolus(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityEdenCow entitylivingbaseIn, float partialTickTime) {
		this.scaleMoolus(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleMoolus(EntityEdenCow par1EntityMoolus, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityEdenCow entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/moolus.png");
	}
	
}