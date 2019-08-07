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
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.creativetabs.ZGTabs;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHandlers;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.MobRegistry;
import zollerngalaxy.network.teleporter.MessageTeleportToDimension;
import zollerngalaxy.planets.ZGPlanets;
import zollerngalaxy.proxy.CommonProxy;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.recipes.ZGRecipeRegistry;
import zollerngalaxy.util.OreDictRegistry;

@Mod(modid = ZGInfo.MOD_ID, version = ZGInfo.MOD_VERSION, name = ZGInfo.NAME,
		dependencies = ZGInfo.DEPENDENCIES)
public class ZollernGalaxyCore {
	
	@SidedProxy(clientSide = ZGInfo.PROXY_CLIENT, serverSide = ZGInfo.PROXY_SERVER)
	public static IProxy proxy;
	
	@Mod.Instance(ZGInfo.MOD_ID)
	private static ZollernGalaxyCore INSTANCE;
	
	private static final boolean DEV_MODE = false;
	
	public static SimpleNetworkWrapper snw;
	
	public static ZollernGalaxyCore instance() {
		return INSTANCE;
	}
	
	public boolean isInDevMode() {
		return DEV_MODE;
	}
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ZGHelper.Log("Beginning Pre-Initilization phase...");
		snw = NetworkRegistry.INSTANCE.newSimpleChannel(ZGInfo.CHANNEL);
		snw.registerMessage(MessageTeleportToDimension.TeleportHandler.class,
				MessageTeleportToDimension.class, 1, Side.SERVER);
		ConfigManagerZG.init(event);
		ZGSoundEvents.init();
		ModHelperBase.detectMods();
		
		ZGInfo.init(event.getModMetadata());
		ZGItems.init();
		ZGBlocks.init();
		ZGBiomes.init();
		OreDictRegistry.init();
		
		instance().proxy.registerPreRendering();
		instance().proxy.preInit(event);
		ZGHelper.Log("Pre-Init phase complete.");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ZGHelper.Log("Beginning Initialization phase...");
		ZGTabs.init();
		ZGRecipeRegistry.init();
		ZGHandlers.init();
		
		for (BiomeGenBaseGC biome : ZGBiomes.biomeList) {
			biome.registerTypes(biome);
		}
		
		MobRegistry.init();
		ZGPlanets.init();
		
		instance().proxy.registerInitRendering();
		instance().proxy.init(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
		ZGHelper.Log("Init phase complete.");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ZGHelper.Log("Beginning Post-Initialization phase...");
		ZGDimensions.init();
		
		instance().proxy.registerPostRendering();
		instance().proxy.postInit(event);
		ZGHelper.Log("Post-init phase complete.");
	}
	
}