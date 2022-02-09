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
import zollerngalaxy.mobs.entities.boss.EntityCrawler;
import zollerngalaxy.mobs.models.boss.ModelCrawler;

@SideOnly(Side.CLIENT)
public class RenderCrawler extends RenderLiving<EntityCrawler> {
	
	private static final float f6 = 4.6F;
	
	private static final ResourceLocation CRAWLER_BOSS_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/crawler.png");
	
	public RenderCrawler(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelCrawler(), 3.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityCrawler entitylivingbaseIn, float partialTickTime) {
		this.scaleCrawlerBoss(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleCrawlerBoss(EntityCrawler par1EntityCrawler, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCrawler entity) {
		return CRAWLER_BOSS_TEXTURE;
	}
}