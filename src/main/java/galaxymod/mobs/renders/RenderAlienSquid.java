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

import galaxymod.mobs.entities.eden.EntityAlienSquid;
import galaxymod.mobs.models.ModelAlienSquid;
import net.minecraft.client.renderer.entity.RenderSquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAlienSquid extends RenderSquid {
	public ModelAlienSquid model;
	float f6 = 2.6F;
	private static final ResourceLocation squidTextures = new ResourceLocation(
			"textures/entity/squid.png");
	
	public RenderAlienSquid(ModelAlienSquid par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelAlienSquid) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySquid p_110775_1_) {
		return squidTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/aliensquid.png");
	}
	
	public void renderAlien(EntityAlienSquid entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderAlien((EntityAlienSquid) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderAlien((EntityAlienSquid) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleAlienSquid(EntityAlienSquid par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleAlienSquid((EntityAlienSquid) par1EntityLivingBase, par2);
	}
}