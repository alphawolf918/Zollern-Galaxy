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

package galaxymod;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.commands.CommandList;
import galaxymod.core.NGCore;
import galaxymod.creativetabs.ModTabs;
import galaxymod.items.ItemList;
import galaxymod.lib.ModInfo;
import galaxymod.lib.Recipes;
import galaxymod.mobs.Mobs;
import galaxymod.proxies.CommonProxy;
import galaxymod.worldgen.eden.NGWorldGenManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, dependencies = "required-after:GalacticraftCore", version = ModInfo.VERSION)
public class GalaxyMod {

	@Mod.Instance(ModInfo.MODID)
	private static GalaxyMod INSTANCE;

	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION
			+ ".CommonProxy")
	public static CommonProxy proxy;

	public static final int modGuiIndex = 11;

	public static GalaxyMod instance() {
		return INSTANCE;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModTabs.init();
		BlockList.init();
		ItemList.init();
		Mobs.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initRenderers();
		BiomeList.init();
		Recipes.init();
		GameRegistry.registerWorldGenerator(new NGWorldGenManager(), 30);
		NGCore.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void serverPreInit(FMLServerStartingEvent event) {
		CommandList.init(event);
	}
}