package zollerngalaxy.core;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.creativetabs.ZGTabs;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.mobs.ZGMobs;
import zollerngalaxy.planets.ZGPlanets;
import zollerngalaxy.proxy.CommonProxy;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.recipes.ZGRecipeRegistry;
import zollerngalaxy.utils.OreDictRegistry;

@Mod(modid = ZGInfo.MOD_ID, version = ZGInfo.modVersion, name = ZGInfo.name,
		dependencies = ZGInfo.DEPENDENCIES)
public class ZollernGalaxyCore {
	
	@SidedProxy(clientSide = ZGInfo.proxyClient, serverSide = ZGInfo.proxyServer)
	public static IProxy proxy;
	
	@Mod.Instance(ZGInfo.MOD_ID)
	private static ZollernGalaxyCore INSTANCE;
	
	private static boolean devMode = true;
	
	public static ZollernGalaxyCore instance() {
		return INSTANCE;
	}
	
	public boolean isInDevMode() {
		return devMode;
	}
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigManagerZG.init(event);
		ModHelperBase.detectMods();
		
		ZGInfo.init(event.getModMetadata());
		ZGItems.init();
		ZGBlocks.init();
		ZGBiomes.init();
		OreDictRegistry.init();
		
		instance().proxy.registerPreRendering();
		instance().proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ZGTabs.init();
		ZGRecipeRegistry.init();
		
		for (BiomeGenBaseGC biome : ZGBiomes.biomeList) {
			biome.registerTypes(biome);
		}
		
		ZGMobs.init();
		ZGPlanets.init();
		instance().proxy.registerInitRendering();
		instance().proxy.init(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ZGDimensions.init();
		
		instance().proxy.registerPostRendering();
		instance().proxy.postInit(event);
	}
	
}