package zollerngalaxy.core;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.planets.ZGPlanets;
import zollerngalaxy.proxy.CommonProxy;
import zollerngalaxy.proxy.IProxy;

@Mod(modid = ZGInfo.MOD_ID, version = ZGInfo.modVersion, name = ZGInfo.name,
		dependencies = ZGInfo.DEPENDENCIES)
public class ZollernGalaxyCore {
	
	@SidedProxy(clientSide = ZGInfo.proxyClient,
			serverSide = ZGInfo.proxyServer)
	public static IProxy proxy;
	
	@Mod.Instance(ZGInfo.MOD_ID)
	private static ZollernGalaxyCore INSTANCE;
	
	public static ZollernGalaxyCore instance() {
		return INSTANCE;
	}
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigManagerZG.init(event);
		ModHelperBase.detectMods();
		// PLACEHOLDER
		ZGInfo.init(event.getModMetadata());
		
		ZGBlocks.init();
		instance().proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// STUFF
		ZGPlanets.init();
		instance().proxy.registerInitRendering();
		instance().proxy.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// THINGS
		instance().proxy.postInit(event);
	}
	
}