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
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.models.ModelFacehugger;

@SideOnly(Side.CLIENT)
public class RenderFacehugger extends RenderLiving<EntityFacehugger> {
	
	private static final ResourceLocation FACEHUGGER_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/facehugger.png");
	
	private static final float f6 = 1.2F;
	
	public RenderFacehugger(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelFacehugger(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityFacehugger entitylivingbaseIn, float partialTickTime) {
		this.scaleFacehugger(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleFacehugger(EntityFacehugger par1EntityFacehugger, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFacehugger entity) {
		return FACEHUGGER_TEXTURES;
	}
}