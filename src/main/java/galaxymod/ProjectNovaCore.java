/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it. - Use it to get ideas and
 * concepts. You CAN'T: - Redistribute it. - Claim it as your own. Steve Kung's
 * "More Planets" was a big help.
 ******************************************************************************/

package galaxymod;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.commands.CommandList;
import galaxymod.core.NGPlanets;
import galaxymod.creativetabs.ProjectNovaTab;
import galaxymod.gui.GuiHandlerNG;
import galaxymod.integration.TreeCapitatorIntegrationNova;
import galaxymod.items.ItemList;
import galaxymod.lib.ModInfo;
import galaxymod.lib.OreDictionaryNova;
import galaxymod.lib.RecipeManagerNova;
import galaxymod.mobs.Mobs;
import galaxymod.proxies.CommonProxy;
import galaxymod.tileentities.TileEntityListNG;
import galaxymod.worldgen.NGWorldGenManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME,
		dependencies = "required-after:GalacticraftCore",
		version = ModInfo.VERSION)
public class ProjectNovaCore {
	
	@Mod.Instance(ModInfo.MODID)
	private static ProjectNovaCore INSTANCE;
	
	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs novaTabBlocks;
	public static CreativeTabs novaTabItems;
	
	public static final int modGuiIndex = 11;
	
	public static ProjectNovaCore getInstance() {
		return INSTANCE;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BlockList.init();
		ItemList.init();
		Mobs.init();
		TreeCapitatorIntegrationNova.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initRenderers();
		NGPlanets.init();
		novaTabBlocks = new ProjectNovaTab("NovaGalacticBlocks", new ItemStack(
				BlockList.edenSurfaceRock, 1));
		novaTabItems = new ProjectNovaTab("NovaGalacticItems", new ItemStack(
				ItemList.ingotViri, 1));
		BiomeList.init();
		RecipeManagerNova.init();
		GameRegistry.registerWorldGenerator(new NGWorldGenManager(), 30);
		OreDictionaryNova.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		TileEntityListNG.init();
		proxy.initGUI();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandlerNG());
	}
	
	@EventHandler
	public void serverPreInit(FMLServerStartingEvent event) {
		CommandList.init(event);
	}
}