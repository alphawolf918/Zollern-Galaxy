/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders.zombiemutations;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.zombiemutations.EntityVolatile;
import zollerngalaxy.mobs.models.zombiemutations.ModelVolatile;

@SideOnly(Side.CLIENT)
public class RenderVolatile extends RenderBiped<EntityVolatile> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation VOLATILE_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/volatile.png");
	
	public RenderVolatile(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVolatile(), 0.5F);
		LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelVolatile(0.5F, true);
				this.modelArmor = new ModelVolatile(1.0F, true);
			}
		};
		this.addLayer(layerbipedarmor);
	}
	
	@Override
	protected void preRenderCallback(EntityVolatile entitylivingbaseIn, float partialTickTime) {
		this.scaleVolatile(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleVolatile(EntityVolatile par1EntityVolatile, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVolatile entity) {
		return VOLATILE_TEXTURES;
	}
}