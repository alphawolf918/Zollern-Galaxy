/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import zollerngalaxy.api.ZollernGalaxyAPI;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.celestial.spacestations.ZGSpaceStations;
import zollerngalaxy.compat.ZGCompats;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.enchantments.EnchantmentListZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.ZGStructures;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHandlers;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.MobRegistry;
import zollerngalaxy.network.teleporter.MessageTeleportToDimension;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.proxy.CommonProxy;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.recipes.ZGRecipeRegistry;
import zollerngalaxy.util.OreDictRegistry;
import zollerngalaxy.util.RegisterUtilsZG;
import zollerngalaxy.util.ZGLore;

@Mod(modid = ZGInfo.MOD_ID, version = ZGInfo.MOD_VERSION, name = ZGInfo.NAME, acceptedMinecraftVersions = ZGInfo.MC_RANGE, dependencies = ZGInfo.DEPENDENCIES)
public class ZollernGalaxyCore {
	
	@SidedProxy(clientSide = ZGInfo.PROXY_CLIENT, serverSide = ZGInfo.PROXY_SERVER)
	public static IProxy proxy;
	
	@Mod.Instance(ZGInfo.MOD_ID)
	private static ZollernGalaxyCore INSTANCE;
	
	// CHANGE THESE TO FALSE BEFORE DEPLOYMENT!!
	private static final boolean DEV_MODE = false; // Controls creating the JSON files.
	private static final boolean TEST_MODE = false; // Set to True when developing!
	
	// Block/Item Registering Lists
	public static List<Item> itemList = new ArrayList<>();
	public static List<Block> blocksList = new ArrayList<>();
	
	// Network Wrapper
	public static SimpleNetworkWrapper snw;
	
	/**
	 * Use to access static variables and/or grab an instance of this class.
	 * 
	 * @return An instance of ZollernGalaxyCore.
	 */
	public static ZollernGalaxyCore instance() {
		return INSTANCE;
	}
	
	/**
	 * If the mod is in Developer Mode, the JSON generators will run through
	 * every block, item, and recipe to re-generate them over the top of the
	 * current ones, as well as generate new ones.
	 * 
	 * @return Whether or not Developer Mode is active.
	 */
	public boolean isInDevMode() {
		return DEV_MODE;
	}
	
	/**
	 * If the mod is in Test Mode, it will send a message to the user that
	 * the copy is not genuine, thereby preventing it from being claimed as real.
	 * This also allows for more control when testing.
	 * 
	 * @return Whether or not Testing Mode is active.
	 */
	public boolean isInTestMode() {
		return TEST_MODE;
	}
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ZGHelper.Log("Beginning Pre-Initilization phase...");
		snw = NetworkRegistry.INSTANCE.newSimpleChannel(ZGInfo.CHANNEL);
		snw.registerMessage(MessageTeleportToDimension.TeleportHandler.class, MessageTeleportToDimension.class, 1, Side.SERVER);
		ConfigManagerZG.init(event);
		ZGSoundEvents.init();
		ModHelperBase.detectMods();
		ZGInfo.init(event.getModMetadata());
		ZGLore.init();
		ZGPotions.init();
		EnchantmentListZG.init();
		RegisterUtilsZG.registerEventHandler(new RegistrationHandlerZG());
		ZGItems.init();
		ZGBlocks.init();
		ZGFluids.init();
		ZGBiomes.init();
		ZGStructures.init();
		ZGPlanets.init();
		ZGSpaceStations.init();
		OreDictRegistry.init();
		ZGCompats.init();
		
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
		
		instance().proxy.registerInitRendering();
		instance().proxy.init(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
		ZollernGalaxyAPI.init();
		ZGHelper.Log("Init phase complete.");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ZGHelper.Log("Beginning Post-Initialization phase...");
		ZGDimensions.init();
		
		instance().proxy.registerPostRendering();
		instance().proxy.postInit(event);
		ZGHelper.Log("Post-Init phase complete.");
	}
	
	@Mod.EventBusSubscriber(modid = ZGInfo.MOD_ID)
	public static class RegistrationHandlerZG {
		
		@SubscribeEvent
		public static void registerBlocksEvent(RegistryEvent.Register<Block> event) {
			for (Block block : ZollernGalaxyCore.blocksList) {
				event.getRegistry().register(block);
			}
		}
		
		@SubscribeEvent
		public static void registerItemsEvent(RegistryEvent.Register<Item> event) {
			for (Item item : ZollernGalaxyCore.itemList) {
				event.getRegistry().register(item);
			}
		}
	}
}