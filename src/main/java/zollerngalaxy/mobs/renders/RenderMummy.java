/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.models.ModelMummy;

@SideOnly(Side.CLIENT)
public class RenderMummy extends RenderBiped<EntityMummy> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation MUMMY_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/mummy.png");
	
	public RenderMummy(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelMummy(), 0.5F);
		LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelMummy(0.5F, true);
				this.modelArmor = new ModelMummy(1.0F, true);
			}
		};
		this.addLayer(layerbipedarmor);
	}
	
	@Override
	protected void preRenderCallback(EntityMummy entitylivingbaseIn, float partialTickTime) {
		this.scaleMummy(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleMummy(EntityMummy par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMummy entity) {
		return MUMMY_TEXTURES;
	}
}