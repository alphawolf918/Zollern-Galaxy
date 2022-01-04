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
import zollerngalaxy.mobs.entities.boss.EntityVexBotBoss;
import zollerngalaxy.mobs.models.boss.ModelVexbotBoss;

@SideOnly(Side.CLIENT)
public class RenderVexbotBoss extends RenderLiving<EntityVexBotBoss> {
	
	private static final float f6 = 0.6F;
	
	private static final ResourceLocation VEXBOT_BOSS_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/vexbotboss.png");
	
	public RenderVexbotBoss(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVexbotBoss(), 3.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityVexBotBoss entitylivingbaseIn, float partialTickTime) {
		this.scaleVexbotBoss(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleVexbotBoss(EntityVexBotBoss par1EntityVexBotBoss, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVexBotBoss entity) {
		return VEXBOT_BOSS_TEXTURE;
	}
}