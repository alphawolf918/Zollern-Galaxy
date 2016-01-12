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

import galaxymod.mobs.entities.eden.EntityOinkus;
import galaxymod.mobs.models.ModelOinkus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOinkus extends RenderLiving {
	
	public ModelOinkus model;
	float f6 = 1.7F;
	
	public RenderOinkus(ModelOinkus par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelOinkus) mainModel;
		this.shadowSize *= f6;
	}
	
	protected void scaleOinkus(EntityOinkus par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleOinkus((EntityOinkus) par1EntityLivingBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/oinkus.png");
	}
	
	public void renderOinkus(EntityOinkus entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderOinkus((EntityOinkus) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderOinkus((EntityOinkus) par1Entity, par2, par4, par6, par8, par9);
	}
}