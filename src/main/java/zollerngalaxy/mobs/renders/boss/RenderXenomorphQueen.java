/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders.boss;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.boss.EntityXenomorphQueen;
import zollerngalaxy.mobs.models.boss.ModelXenomorphQueen;

@SideOnly(Side.CLIENT)
public class RenderXenomorphQueen extends RenderLiving<EntityXenomorphQueen> {
	
	private static final float f6 = 4.0F;
	
	private static final ResourceLocation XENO_QUEEN_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/xenomorph.png");
	
	public RenderXenomorphQueen(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelXenomorphQueen(), 4.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityXenomorphQueen entitylivingbaseIn, float partialTickTime) {
		this.scaleXenomorphQueen(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleXenomorphQueen(EntityXenomorphQueen par1EntityXenomorphQueen, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityXenomorphQueen entity) {
		return XENO_QUEEN_TEXTURES;
	}
}