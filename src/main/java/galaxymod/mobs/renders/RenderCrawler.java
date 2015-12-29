/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.mobs.renders;

import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.mobs.models.ModelCrawler;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCrawler extends RenderLiving {
	
	public ModelCrawler model;
	float f6 = 4.6F;
	
	public RenderCrawler(ModelCrawler par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelCrawler) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/crawler.png");
	}
	
	public void renderCrawler(EntityCrawlerBoss entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(entity, true);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderCrawler((EntityCrawlerBoss) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderCrawler((EntityCrawlerBoss) par1Entity, par2, par4, par6, par8,
				par9);
	}
	
	protected void scaleCrawler(EntityCrawlerBoss par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleCrawler((EntityCrawlerBoss) par1EntityLivingBase, par2);
	}
}