/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Galacticraft Add-On Mod
 ******************************************************************************/

package galaxymod;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.commands.CommandList;
import galaxymod.core.NGCore;
import galaxymod.creativetabs.ModTabs;
import galaxymod.lib.ModInfo;
import galaxymod.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, dependencies = "required-after:GalacticraftCore", version = ModInfo.VERSION)
public class GalaxyMod {

	@Mod.Instance(ModInfo.MODID)
	public static GalaxyMod INSTANCE;

	@SidedProxy(clientSide = ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide = ModInfo.PROXY_LOCATION
			+ ".CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BlockList.init();
		ModTabs.init();
		BiomeList.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
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