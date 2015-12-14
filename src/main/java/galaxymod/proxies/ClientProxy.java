package galaxymod.proxies;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.renderers.TileEntityRendererNG;
import galaxymod.gui.GuiHud;
import galaxymod.mobs.entities.EntityAlienSquid;
import galaxymod.mobs.entities.EntityGalaxyKnight;
import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.entities.EntityMoolus;
import galaxymod.mobs.entities.EntityOinkus;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.mobs.models.ModelAlienSquid;
import galaxymod.mobs.models.ModelCrawler;
import galaxymod.mobs.models.ModelGalaxyKnight;
import galaxymod.mobs.models.ModelGrayAlien;
import galaxymod.mobs.models.ModelMoolus;
import galaxymod.mobs.models.ModelOinkus;
import galaxymod.mobs.renders.RenderAlienSquid;
import galaxymod.mobs.renders.RenderCrawler;
import galaxymod.mobs.renders.RenderGalaxyKnight;
import galaxymod.mobs.renders.RenderGrayAlien;
import galaxymod.mobs.renders.RenderMoolus;
import galaxymod.mobs.renders.RenderOinkus;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	private static int edenTreasureChestRenderID;
	private static Minecraft mc = FMLClientHandler.instance().getClient();
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		TileEntityRendererNG.registerTileEntityRenderers();
		ClientProxy.registerBlockRenderers();
	}
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityGrayAlien.class,
				new RenderGrayAlien(new ModelGrayAlien(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMoolus.class,
				new RenderMoolus(new ModelMoolus(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityOinkus.class,
				new RenderOinkus(new ModelOinkus(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityAlienSquid.class, new RenderAlienSquid(
						new ModelAlienSquid(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(
				EntityGalaxyKnight.class, new RenderGalaxyKnight(
						new ModelGalaxyKnight(), 0.5F));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawlerBoss.class,
				new RenderCrawler(new ModelCrawler(), 0.5F));
		
	}
	
	public static void registerBlockRenderers() {
		ClientProxy.edenTreasureChestRenderID = RenderingRegistry
				.getNextAvailableRenderId();
	}
	
	@Override
	public int getBlockRender(Block block) {
		if (block == BlockList.edenTreasureChest) {
			return ClientProxy.edenTreasureChestRenderID;
		} else {
			return -1;
		}
	}
	
	@Override
	public void initGUI() {
		MinecraftForge.EVENT_BUS.register(new GuiHud(Minecraft.getMinecraft()));
	}
}