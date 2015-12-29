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

package galaxymod.dimensions.providers.renderers;

import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.lib.ModInfo;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.network.PacketSimple;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;

public class SkyProviderEden extends IRenderHandler {
	private static final ResourceLocation sunTexture = new ResourceLocation(
			ModInfo.MODID, "textures/gui/psion6.png");
	
	public int starGLCallList = GLAllocation.generateDisplayLists(3);
	public int glSkyList;
	public int glSkyList2;
	
	public SkyProviderEden() {
		GL11.glPushMatrix();
		GL11.glNewList(this.starGLCallList, GL11.GL_COMPILE);
		this.renderStars();
		GL11.glEndList();
		GL11.glPopMatrix();
		final Tessellator tessellator = Tessellator.instance;
		this.glSkyList = this.starGLCallList + 1;
		GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
		final byte byte2 = 64;
		final int i = 256 / byte2 + 2;
		float f = 16F;
		
		for (int j = -byte2 * i; j <= byte2 * i; j += byte2) {
			for (int l = -byte2 * i; l <= byte2 * i; l += byte2) {
				tessellator.startDrawingQuads();
				tessellator.addVertex(j + 0, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + byte2);
				tessellator.addVertex(j + 0, f, l + byte2);
				tessellator.draw();
			}
		}
		
		GL11.glEndList();
		this.glSkyList2 = this.starGLCallList + 2;
		GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
		f = -16F;
		tessellator.startDrawingQuads();
		
		for (int k = -byte2 * i; k <= byte2 * i; k += byte2) {
			for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2) {
				tessellator.addVertex(k + byte2, f, i1 + 0);
				tessellator.addVertex(k + 0, f, i1 + 0);
				tessellator.addVertex(k + 0, f, i1 + byte2);
				tessellator.addVertex(k + byte2, f, i1 + byte2);
			}
		}
		
		tessellator.draw();
		GL11.glEndList();
	}
	
	private final Minecraft minecraft = FMLClientHandler.instance().getClient();
	
	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		if (!ClientProxyCore.overworldTextureRequestSent) {
			GalacticraftCore.packetPipeline.sendToServer(new PacketSimple(
					PacketSimple.EnumSimplePacket.S_REQUEST_OVERWORLD_IMAGE,
					new Object[] {}));
			ClientProxyCore.overworldTextureRequestSent = true;
		}
		
		float var20 = (float) (mc.thePlayer.posY - 200.0F) / 1000.0F;
		final float var21 = Math.max(1.0F - var20 * 4.0F, 0.0F);
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		final Vec3 var2 = this.minecraft.theWorld.getSkyColor(
				this.minecraft.renderViewEntity, partialTicks);
		float var3 = (float) var2.xCoord * var21;
		float var4 = (float) var2.yCoord * var21;
		float var5 = (float) var2.zCoord * var21;
		float var8;
		
		WorldProviderEden gcProvider = null;
		
		if (world.provider instanceof WorldProviderEden) {
			gcProvider = (WorldProviderEden) world.provider;
		}
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(1, 1, 1);
		final Tessellator var23 = Tessellator.instance;
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glColor3f(0, 0, 0);
		GL11.glCallList(this.glSkyList);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.disableStandardItemLighting();
		final float[] var24 = this.minecraft.theWorld.provider
				.calcSunriseSunsetColors(
						this.minecraft.theWorld.getCelestialAngle(partialTicks),
						partialTicks);
		float var9;
		float var10;
		float var11;
		float var12;
		
		if (gcProvider != null) {
			var20 = gcProvider.getStarBrightness(partialTicks);
		}
		if (var24 != null) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			GL11.glPushMatrix();
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(MathHelper.sin(this.minecraft.theWorld
					.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F
					: 0.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			var8 = var24[0];
			var9 = var24[1];
			var10 = var24[2];
			float var13;
			
			if (this.minecraft.gameSettings.anaglyph) {
				var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
				var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
				var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
				var8 = var11;
				var9 = var12;
				var10 = var13;
			}
			
			var23.startDrawing(6);
			
			var23.setColorRGBA_F(var8 * var21, var9 * var21, var10 * var21,
					var24[3] * var21);
			var23.addVertex(0.0D, 100.0D, 0.0D);
			final byte var26 = 16;
			var23.setColorRGBA_F(var24[0] * var21, var24[1] * var21, var24[2]
					* var21, 0.0F);
			
			for (int var27 = 0; var27 <= var26; ++var27) {
				var13 = var27 * (float) Math.PI * 2.0F / var26;
				final float var14 = MathHelper.sin(var13);
				final float var15 = MathHelper.cos(var13);
				var23.addVertex(var14 * 120.0F, var15 * 120.0F, -var15 * 40.0F
						* var24[3]);
			}
			
			var23.draw();
			GL11.glPopMatrix();
			GL11.glShadeModel(GL11.GL_FLAT);
		}
		
		if (var20 > 0.0F) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var20);
			GL11.glCallList(this.starGLCallList);
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glPushMatrix();
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 5F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F,
				0.0F, 0.0F);
		var12 = 20.0F;
		FMLClientHandler.instance().getClient().renderEngine
				.bindTexture(SkyProviderEden.sunTexture);
		var23.startDrawingQuads();
		var23.addVertexWithUV(-var12, 150.0D, -var12, 0.0D, 0.0D);
		var23.addVertexWithUV(var12, 150.0D, -var12, 1.0D, 0.0D);
		var23.addVertexWithUV(var12, 150.0D, var12, 1.0D, 1.0D);
		var23.addVertexWithUV(-var12, 150.0D, var12, 0.0D, 1.0D);
		var23.draw();
		
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		
		GL11.glDisable(GL11.GL_BLEND);
		
		world.getMoonPhase();
		var23.startDrawingQuads();
		var23.addVertexWithUV(-var12, -500.0D, var12, 0, 1);
		var23.addVertexWithUV(var12, -500.0D, var12, 1, 1);
		var23.addVertexWithUV(var12, -500.0D, -var12, 1, 0);
		var23.addVertexWithUV(-var12, -500.0D, -var12, 0, 0);
		var23.draw();
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(0.0F, 0.0F, 0.0F);
		final double var25 = mc.thePlayer.getPosition(partialTicks).yCoord
				- world.getHorizon();
		
		if (var25 < 0.0D) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 12.0F, 0.0F);
			GL11.glCallList(this.glSkyList2);
			GL11.glPopMatrix();
			var10 = 1.0F;
			var11 = -((float) (var25 + 65.0D));
			var12 = -var10;
			var23.startDrawingQuads();
			var23.setColorRGBA_I(0, 255);
			var23.addVertex(-var10, var11, var10);
			var23.addVertex(var10, var11, var10);
			var23.addVertex(var10, var12, var10);
			var23.addVertex(-var10, var12, var10);
			var23.addVertex(-var10, var12, -var10);
			var23.addVertex(var10, var12, -var10);
			var23.addVertex(var10, var11, -var10);
			var23.addVertex(-var10, var11, -var10);
			var23.addVertex(var10, var12, -var10);
			var23.addVertex(var10, var12, var10);
			var23.addVertex(var10, var11, var10);
			var23.addVertex(var10, var11, -var10);
			var23.addVertex(-var10, var11, -var10);
			var23.addVertex(-var10, var11, var10);
			var23.addVertex(-var10, var12, var10);
			var23.addVertex(-var10, var12, -var10);
			var23.addVertex(-var10, var12, -var10);
			var23.addVertex(-var10, var12, var10);
			var23.addVertex(var10, var12, var10);
			var23.addVertex(var10, var12, -var10);
			var23.draw();
		}
		
		GL11.glColor3f(70F / 256F, 70F / 256F, 70F / 256F);
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, -((float) (var25 - 16.0D)), 0.0F);
		GL11.glCallList(this.glSkyList2);
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
	}
	
	private void renderStars() {
		final Random var1 = new Random(10842L);
		final Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		
		for (int var3 = 0; var3 < (ConfigManagerCore.moreStars ? 20000 : 6000); ++var3) {
			double var4 = var1.nextFloat() * 2.0F - 1.0F;
			double var6 = var1.nextFloat() * 2.0F - 1.0F;
			double var8 = var1.nextFloat() * 2.0F - 1.0F;
			final double var10 = 0.15F + var1.nextFloat() * 0.1F;
			double var12 = var4 * var4 + var6 * var6 + var8 * var8;
			
			if (var12 < 1.0D && var12 > 0.01D) {
				var12 = 1.0D / Math.sqrt(var12);
				var4 *= var12;
				var6 *= var12;
				var8 *= var12;
				final double var14 = var4
						* (ConfigManagerCore.moreStars ? var1.nextDouble() * 100D + 150D
								: 100.0D);
				final double var16 = var6
						* (ConfigManagerCore.moreStars ? var1.nextDouble() * 100D + 150D
								: 100.0D);
				final double var18 = var8
						* (ConfigManagerCore.moreStars ? var1.nextDouble() * 100D + 150D
								: 100.0D);
				final double var20 = Math.atan2(var4, var8);
				final double var22 = Math.sin(var20);
				final double var24 = Math.cos(var20);
				final double var26 = Math.atan2(
						Math.sqrt(var4 * var4 + var8 * var8), var6);
				final double var28 = Math.sin(var26);
				final double var30 = Math.cos(var26);
				final double var32 = var1.nextDouble() * Math.PI * 2.0D;
				final double var34 = Math.sin(var32);
				final double var36 = Math.cos(var32);
				
				for (int var38 = 0; var38 < 4; ++var38) {
					final double var39 = 0.0D;
					final double var41 = ((var38 & 2) - 1) * var10;
					final double var43 = ((var38 + 1 & 2) - 1) * var10;
					final double var47 = var41 * var36 - var43 * var34;
					final double var49 = var43 * var36 + var41 * var34;
					final double var53 = var47 * var28 + var39 * var30;
					final double var55 = var39 * var28 - var47 * var30;
					final double var57 = var55 * var22 - var49 * var24;
					final double var61 = var49 * var22 + var55 * var24;
					var2.addVertex(var14 + var57, var16 + var53, var18 + var61);
				}
			}
		}
		
		var2.draw();
	}
	
	private Vec3 getCustomSkyColor() {
		return Vec3.createVectorHelper(0.26796875D, 0.1796875D, 1.0D);
	}
	
	public float getSkyBrightness(float par1) {
		final float var2 = FMLClientHandler.instance().getClient().theWorld
				.getCelestialAngle(par1);
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
