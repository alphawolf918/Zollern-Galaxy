/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.mobs.renderers;

import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.models.ModelGrayAlien;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGrayAlien extends RenderBiped {
	public ModelGrayAlien model;
	private final ModelBiped modelArmorChestplate;
	private final ModelBiped modelArmor;

	public RenderGrayAlien(ModelBiped par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelGrayAlien) mainModel;
		this.modelArmorChestplate = new ModelBiped(1.0F);
		this.modelArmor = new ModelBiped(0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/grey.png");
	}

	public void renderAlien(EntityGrayAlien entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderAlien((EntityGrayAlien) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderAlien((EntityGrayAlien) par1Entity, par2, par4, par6, par8, par9);
	}
}