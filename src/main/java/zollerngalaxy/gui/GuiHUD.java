package zollerngalaxy.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZG;
import zollerngalaxy.core.enums.EnumPlanetClass;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.planets.ZGPlanet;

@SideOnly(Side.CLIENT)
public class GuiHUD extends Gui {
	
	private Minecraft mc;
	protected FontRenderer fontRendererObj;
	public EntityPlayer player;
	int k3;
	
	public GuiHUD(Minecraft mc) {
		super();
		this.mc = mc;
		this.fontRendererObj = mc.fontRenderer;
	}
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {
			return;
		}
		
		int i3 = 14737632;
		BlockPos blockPos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity()
				.getEntityBoundingBox().minY, this.mc.getRenderViewEntity().posZ);
		ScaledResolution scaledresolution = new ScaledResolution(this.mc);
		int k = scaledresolution.getScaledWidth();
		int l = scaledresolution.getScaledHeight();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		EntityPlayer player = this.mc.player;
		Item handItem = player.getHeldItemMainhand().getItem();
		if (handItem == ZGItems.hud) {
			if (this.mc.world != null) {
				Chunk chunk = this.mc.world.getChunkFromBlockCoords(blockPos);
				int yPos = 8;
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_LIGHTING);
				Biome biome = chunk.getBiome(blockPos, this.mc.world.getBiomeProvider());
				WorldProvider worldProvider = this.mc.world.provider;
				
				if (biome instanceof BiomeSpace) {
					BiomeSpace biomeSpace = (BiomeSpace) biome;
					WorldProviderZG spaceProvider = (WorldProviderZG) worldProvider;
					
					// Biome Name
					String biomeName = biome.getBiomeName();
					String s = "Biome: " + biomeName;
					fontRendererObj.drawString(s, 2, 26, i3);
					fontRendererObj.drawString(s, 26, yPos - 20, i3);
					
					// Planet Temp (Displays in either F or C)
					String tempType = ConfigManagerZG.temperatureType;
					float biomeTemp = biomeSpace.getBiomeTemp();
					float planetTemp = spaceProvider.getPlanetTemp();
					planetTemp = (spaceProvider.isDaytime()) ? planetTemp + biomeTemp : planetTemp - biomeTemp;
					tempType = (tempType != "F" && tempType != "C") ? "F" : tempType;
					if (tempType == "F") {
						String strTemp = "" + Math.round(planetTemp * 1.0f);
						strTemp = (strTemp.length() > 4) ? strTemp.substring(0, 4) : strTemp;
						String temp = "Temp: " + strTemp + " F";
						fontRendererObj.drawString(temp, 2, 36, i3);
						fontRendererObj.drawString(temp, 26, yPos - 30, i3);
					} else if (tempType == "C") {
						float planetTempCelsius = Math.round(((planetTemp - 32) * 5) / 9);
						String strTemp = "" + (planetTempCelsius * 1.0f);
						String temp = "Temp: " + strTemp + " C";
						fontRendererObj.drawString(temp, 2, 36, i3);
						fontRendererObj.drawString(temp, 26, yPos - 30, i3);
					} else {
						String s2 = "Error";
						fontRendererObj.drawString(s2, 2, 36, i3);
						fontRendererObj.drawString(s2, 26, yPos - 30, i3);
					}
					
					// Planet Name
					ZGPlanet planet = biomeSpace.getPlanetForBiome();
					if (planet != null) {
						String planetName = ZGHelper.capitalizeFirstLetter(planet.getName());
						String p = "Planet: " + planetName;
						fontRendererObj.drawString(p, 2, 46, i3);
						fontRendererObj.drawString(p, 26, yPos - 40, i3);
					}
					
					// Planet Class
					EnumPlanetClass planetClass = planet.getPlanetClass();
					String pClass = planetClass.getPlanetStrClass();
					String pc = "Class " + pClass + " Planet";
					fontRendererObj.drawString(pc, 2, 56, i3);
					fontRendererObj.drawString(pc, 26, yPos - 54, i3);
					
					// Gasses
					String strGasses = "Gasses: ";
					String gasses = planet.getGasses();
					fontRendererObj.drawString(strGasses, 2, 66, i3);
					fontRendererObj.drawString(strGasses, 26, yPos - 64, i3);
					String actualGasses = gasses.toString();
					fontRendererObj.drawString(actualGasses, 2, 76, i3);
					fontRendererObj.drawString(actualGasses, 26, yPos - 74, i3);
					
					// Radioactivity
					float planetRadLevel = planet.getRadiationLevel();
					String strRad = "Radiation: " + planetRadLevel + "%";
					fontRendererObj.drawString(strRad, 2, 86, i3);
					fontRendererObj.drawString(strRad, 26, yPos - 84, i3);
					
					// Toxicity
					float planetToxLevel = planet.getToxicLevel();
					String strTox = "Toxicity: " + planetToxLevel + "%";
					fontRendererObj.drawString(strTox, 2, 96, i3);
					fontRendererObj.drawString(strTox, 26, yPos - 94, i3);
					
					// Wind Level
					float planetWindLevel = planet.getWindLevel();
					String strWind = "Wind Level: " + planetWindLevel + "%";
					fontRendererObj.drawString(strWind, 2, 106, i3);
					fontRendererObj.drawString(strWind, 26, yPos - 104, i3);
				}
			}
		}
	}
}