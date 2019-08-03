package zollerngalaxy.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
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
import zollerngalaxy.items.ZGItems;
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
		BlockPos blockPos = new BlockPos(this.mc.getRenderViewEntity().posX, this.mc
				.getRenderViewEntity().getEntityBoundingBox().minY,
				this.mc.getRenderViewEntity().posZ);
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
				
				if (biome instanceof BiomeSpace) {
					BiomeSpace spaceBiome = (BiomeSpace) biome;
					ZGPlanet planet = spaceBiome.getPlanetForBiome();
					String planetName = planet.getLocalizedName();
					String s = "Planet: " + planetName;
					
					fontRendererObj.drawString(s, 2, 26, i3);
					fontRendererObj.drawString(s, 26, yPos - 20, i3);
				}
			}
		}
	}
}