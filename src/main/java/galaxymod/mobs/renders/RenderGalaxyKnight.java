/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.mobs.renders;

import galaxymod.mobs.entities.EntityGalaxyKnight;
import galaxymod.mobs.models.ModelGalaxyKnight;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGalaxyKnight extends RenderLiving {
	
	public RenderGalaxyKnight(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
	}
	
	public ModelGalaxyKnight model;
	float f6 = 1.6F;
	
	public RenderGalaxyKnight(ModelGalaxyKnight par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelGalaxyKnight) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"galaxymod:textures/entity/galaxyknight.png");
	}
	
	public void renderKnight(EntityGalaxyKnight entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderKnight((EntityGalaxyKnight) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderKnight((EntityGalaxyKnight) par1Entity, par2, par4, par6, par8,
				par9);
	}
	
	protected void scaleGalaxyKnight(EntityGalaxyKnight par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleGalaxyKnight((EntityGalaxyKnight) par1EntityLivingBase, par2);
	}
}