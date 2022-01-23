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
import zollerngalaxy.mobs.entities.EntityBloodWorm;
import zollerngalaxy.mobs.models.ModelBloodWorm;

@SideOnly(Side.CLIENT)
public class RenderBloodWorm extends RenderLiving<EntityBloodWorm> {
	
	private static final float f6 = 1.0F;
	
	private static final ResourceLocation BLOODWORM_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/bloodworm.png");
	
	public RenderBloodWorm(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBloodWorm(), 2.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityBloodWorm entitylivingbaseIn, float partialTickTime) {
		this.scaleBloodWorm(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleBloodWorm(EntityBloodWorm par1EntityBloodWorm, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBloodWorm entity) {
		return BLOODWORM_TEXTURE;
	}
}