/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.mobs.renders;

import galaxymod.mobs.entities.zollus.EntityFrostGiant;
import galaxymod.mobs.models.ModelFrostGiant;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFrostGiant extends RenderLiving {
	
	public ModelFrostGiant model;
	float f6 = 3.6F;
	
	public RenderFrostGiant(ModelFrostGiant par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelFrostGiant) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/frostgiant.png");
	}
	
	public void renderAlien(EntityFrostGiant entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderAlien((EntityFrostGiant) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderAlien((EntityFrostGiant) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleFrostGiant(EntityFrostGiant par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleFrostGiant((EntityFrostGiant) par1EntityLivingBase, par2);
	}
}