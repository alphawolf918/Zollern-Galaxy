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
import zollerngalaxy.mobs.entities.EntityGalaxyDragon;
import zollerngalaxy.mobs.models.ModelGalaxyDragon;

@SideOnly(Side.CLIENT)
public class RenderGalaxyDragon extends RenderLiving<EntityGalaxyDragon> {
	
	private ModelGalaxyDragon model;
	private static float f6 = 1.8F;
	
	public RenderGalaxyDragon(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelGalaxyDragon(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityGalaxyDragon entitylivingbaseIn, float partialTickTime) {
		this.scaleDragon(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleDragon(EntityGalaxyDragon par1EntityDragon, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGalaxyDragon entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/dragon.png");
	}
	
}