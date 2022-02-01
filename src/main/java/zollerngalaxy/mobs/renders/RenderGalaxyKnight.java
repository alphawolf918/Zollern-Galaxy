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
import zollerngalaxy.mobs.entities.companions.EntityGalaxyKnight;
import zollerngalaxy.mobs.models.ModelGalaxyKnight;

@SideOnly(Side.CLIENT)
public class RenderGalaxyKnight extends RenderLiving<EntityGalaxyKnight> {
	
	private ModelGalaxyKnight model;
	private static float f6 = 1.4F;
	
	public RenderGalaxyKnight(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelGalaxyKnight(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityGalaxyKnight entitylivingbaseIn, float partialTickTime) {
		this.scaleGalaxyKnight(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleGalaxyKnight(EntityGalaxyKnight par1EntityGalaxyKnight, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGalaxyKnight entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/galaxyknight.png");
	}
	
}