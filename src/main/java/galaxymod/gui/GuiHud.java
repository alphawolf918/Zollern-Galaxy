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

package galaxymod.gui;

import galaxymod.biomes.BiomeSpace;
import galaxymod.core.EnumPlanetClass;
import galaxymod.core.PlanetNova;
import galaxymod.items.ItemList;
import galaxymod.utils.NovaHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiHud extends Gui {
	
	private Minecraft mc;
	protected FontRenderer fontRendererObj;
	public EntityPlayer player;
	int i3;
	int j3;
	int k3;
	
	public GuiHud(Minecraft mc) {
		super();
		this.mc = mc;
		this.fontRendererObj = mc.fontRenderer;
	}
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		ScaledResolution scaledresolution = new ScaledResolution(this.mc,
				this.mc.displayWidth, this.mc.displayHeight);
		int k = scaledresolution.getScaledWidth();
		int l = scaledresolution.getScaledHeight();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		i3 = 14737632;
		int i4 = MathHelper
				.floor_double(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		EntityPlayer player = this.mc.thePlayer;
		if (player.getHeldItem() != null) {
			if (player.getHeldItem().getItem().equals(ItemList.hud)) {
				j3 = MathHelper.floor_double(player.posX);
				k3 = MathHelper.floor_double(player.posY);
				int l3 = MathHelper.floor_double(player.posZ);
				if (this.mc.theWorld != null
						&& this.mc.theWorld.blockExists(j3, k3, l3)) {
					Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(j3,
							l3);
					int yPos = 8;
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glDisable(GL11.GL_LIGHTING);
					
					BiomeGenBase biome = chunk.getBiomeGenForWorldCoords(
							j3 & 15, l3 & 15,
							this.mc.theWorld.getWorldChunkManager());
					if (biome instanceof BiomeSpace) {
						
						// Biome Name
						String biomeName = biome.biomeName;
						String s = "Biome: " + biomeName;
						fontRendererObj.drawString(s, 2, 26, i3);
						fontRendererObj.drawString(s, 26, yPos - 20, i3);
						
						// Biome Temp
						float biomeTemp = biome.temperature;
						String temp = "Temp: " + biomeTemp * 10.0 + " F";
						fontRendererObj.drawString(temp, 2, 36, i3);
						fontRendererObj.drawString(temp, 26, yPos - 30, i3);
						
						// Planet Name
						PlanetNova planet = ((BiomeSpace) biome)
								.getPlanetForBiome();
						String planetName = NovaHelper
								.capitalizeFirstLetter(planet.getName());
						String p = "Planet: " + planetName;
						fontRendererObj.drawString(p, 2, 46, i3);
						fontRendererObj.drawString(p, 26, yPos - 40, i3);
						
						// Planet Class
						EnumPlanetClass planetClass = planet.getPlanetClass();
						String pClass = planetClass.getPlanetStrClass();
						String pc = "Class " + pClass;
						fontRendererObj.drawString(pc, 2, 56, i3);
						fontRendererObj.drawString(pc, 26, yPos - 54, i3);
						
						// Gasses
						String strGasses = "Gasses: ";
						String gasses = planet.getGasses();
						fontRendererObj.drawString(strGasses, 2, 66, i3);
						fontRendererObj
								.drawString(strGasses, 26, yPos - 64, i3);
						String actualGasses = gasses.toString();
						fontRendererObj.drawString(actualGasses, 2, 76, i3);
						fontRendererObj.drawString(actualGasses, 26, yPos - 74,
								i3);
					}
				}
			}
		}
	}
}