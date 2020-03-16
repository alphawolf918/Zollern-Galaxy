/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.skyproviders;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class SkyProviderPurgot extends SkyProviderBaseZG {
	
	private ResourceLocation psios6Texture = new ResourceLocation("zollerngalaxy:textures/gui/psion6.png");
	private ResourceLocation edenTexture = new ResourceLocation("zollerngalaxy:textures/gui/eden.png");
	private ResourceLocation zollusTexture = new ResourceLocation("zollerngalaxy:textures/gui/zollus.png");
	
	public SkyProviderPurgot(IGalacticraftWorldProvider provider) {
		super();
		this.sunSize = 1.0F * provider.getSolarSize();
	}
	
	@Override
	protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc) {
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder worldrenderer = tessellator.getBuffer();
		float scale;
		
		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.blendFunc(770, 771);
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		scale = 11.0F / 3.5F;
		worldrenderer.begin(7, DefaultVertexFormats.POSITION);
		worldrenderer.pos(-scale, 99.9D, -scale).endVertex();
		worldrenderer.pos(scale, 99.9D, -scale).endVertex();
		worldrenderer.pos(scale, 99.9D, scale).endVertex();
		worldrenderer.pos(-scale, 99.9D, scale).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		// Psion-6
		GlStateManager.disableTexture2D();
		GlStateManager.blendFunc(770, 1);
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		
		// Some blanking to conceal the stars
		// scale = 1.5F;// this.sunSize / 3.5F;
		worldrenderer.begin(7, DefaultVertexFormats.POSITION);
		worldrenderer.pos(-scale, 99.9D, -scale).endVertex();
		worldrenderer.pos(scale, 99.9D, -scale).endVertex();
		worldrenderer.pos(scale, 99.9D, scale).endVertex();
		worldrenderer.pos(-scale, 99.9D, scale).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		scale = this.sunSize + 3.0F;
		mc.getTextureManager().bindTexture(this.psios6Texture);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(-scale, 100.0D, -scale).tex(0.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, -scale).tex(1.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, scale).tex(1.0D, 1.0D).endVertex();
		worldrenderer.pos(-scale, 100.0D, scale).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		
		GlStateManager.disableBlend();
		GlStateManager.pushMatrix();
		
		// Eden
		scale = 1.2F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(50.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		mc.getTextureManager().bindTexture(this.edenTexture);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(-scale, 100.0D, -scale).tex(0.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, -scale).tex(1.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, scale).tex(1.0D, 1.0D).endVertex();
		worldrenderer.pos(-scale, 100.0D, scale).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		
		// Zollus
		scale = 2.0F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(150.0F, 1.0F, 0.0F, 1.0F);
		GlStateManager.rotate(-200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		mc.getTextureManager().bindTexture(this.zollusTexture);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
		worldrenderer.pos(-scale, 100.0D, -scale).tex(0.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, -scale).tex(1.0D, 0.0D).endVertex();
		worldrenderer.pos(scale, 100.0D, scale).tex(1.0D, 1.0D).endVertex();
		worldrenderer.pos(-scale, 100.0D, scale).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		
		GlStateManager.popMatrix();
	}
	
	@Override
	protected double[] getMaxStarCount() {
		return new double[] { 50000D, 150D, 100D };
	}
	
	@Override
	protected float[] getStarBrightness() {
		return new float[] { 0.35F, 0.35F };
	}
	
	@Override
	protected boolean useDefaultStarBrightness() {
		return false;
	}
	
	@Override
	protected float getRainStrength(World world, float partialTicks) {
		return 0.0F;
	}
	
	public float getSkyBrightness(float par1) {
		float var2 = FMLClientHandler.instance().getClient().world.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.sin(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);
		
		if (var3 < 0.0F) {
			var3 = 0.0F;
		}
		if (var3 > 1.0F) {
			var3 = 1.0F;
		}
		return var3 * var3 * 1F;
	}
}