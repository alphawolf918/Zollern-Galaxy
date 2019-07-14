package zollerngalaxy.lib.helpers.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraftforge.common.config.Configuration;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON Block/Item generator. Saves a good bit of hassle and time of dealing
 * with JSON files. NOTE: This is only for REGULAR blocks; special ones still
 * need to be modified after they're generated.
 * 
 * @author Zollern Wolf
 */
public final class JSONRegistryHelper {
	
	// Change to True or False or make a method like this
	private static final boolean ENABLE = ZollernGalaxyCore.instance().isInDevMode();
	
	// Change to ID of your Mod
	private static final String MOD_ID = ZGInfo.MOD_ID;
	
	// Change to your config file
	private static final Configuration config = ConfigManagerZG.configuration;
	
	// Shouldn't need to edit below this line
	private static final String ASSETS_PATH = "../../../../src/main/resources/assets/";
	private static final String FULL_PATH = ASSETS_PATH + MOD_ID;
	
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static File ITEM_DIR = null;
	private static File BLOCK_DIR = null;
	private static File BLOCK_STATES_DIR = null;
	
	private static void setupItemDir() {
		if (ITEM_DIR == null) {
			ITEM_DIR = JSONRegistryHelper.getPath("models/item");
		}
		
		if (!ITEM_DIR.exists()) {
			ITEM_DIR.mkdir();
		}
	}
	
	private static void setupBlockDirs() {
		if (BLOCK_DIR == null) {
			BLOCK_DIR = JSONRegistryHelper.getPath("models/block");
		}
		
		if (BLOCK_STATES_DIR == null) {
			BLOCK_STATES_DIR = JSONRegistryHelper.getPath("blockstates");
		}
		
		JSONRegistryHelper.setupItemDir();
		
		if (!BLOCK_DIR.exists()) {
			BLOCK_DIR.mkdir();
		}
		
		if (!BLOCK_STATES_DIR.exists()) {
			BLOCK_STATES_DIR.mkdir();
		}
	}
	
	private static File getPath(String path) {
		return config.getConfigFile().toPath().resolve(FULL_PATH + "/" + path + "/").toFile();
	}
	
	public static void registerItem(String itemName) {
		if (!ENABLE) {
			return;
		}
		
		JSONRegistryHelper.setupItemDir();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> layers = new LinkedHashMap<>();
		
		layers.put("layer0", MOD_ID + ":items/" + itemName);
		
		json.put("parent", "item/generated");
		json.put("textures", layers);
		
		String jsonFileName = itemName + ".json";
		
		File file = new File(ITEM_DIR, jsonFileName);
		
		while (file.exists()) {
			file.delete();
			file = new File(ITEM_DIR, jsonFileName);
		}
		
		try (FileWriter writer = new FileWriter(file)) {
			GSON.toJson(json, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void registerBlock(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONRegistryHelper.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> all = new LinkedHashMap<>();
		
		all.put("all", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "block/cube_all");
		json.put("textures", all);
		
		File file = new File(BLOCK_DIR, jsonFileName);
		
		while (file.exists()) {
			file.delete();
			file = new File(BLOCK_DIR, jsonFileName);
		}
		
		try (FileWriter writer = new FileWriter(file)) {
			GSON.toJson(json, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONRegistryHelper.registerBlockState(blockName);
	}
	
	private static void registerBlockState(String blockName) {
		String jsonFileName = blockName + ".json";
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> normal = new LinkedHashMap<>();
		Map<String, Object> model = new LinkedHashMap<>();
		
		model.put("model", MOD_ID + ":" + blockName);
		normal.put("normal", model);
		json.put("variants", normal);
		
		File file = new File(BLOCK_STATES_DIR, jsonFileName);
		
		while (file.exists()) {
			file.delete();
			file = new File(BLOCK_STATES_DIR, jsonFileName);
		}
		
		try (FileWriter writer = new FileWriter(file)) {
			GSON.toJson(json, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONRegistryHelper.registerBlockItem(blockName);
	}
	
	private static void registerBlockItem(String blockName) {
		String jsonFileName = blockName + ".json";
		Map<String, Object> json = new LinkedHashMap<>();
		
		json.put("parent", MOD_ID + ":block/" + blockName);
		File file = new File(ITEM_DIR, jsonFileName);
		
		while (file.exists()) {
			file.delete();
			file = new File(ITEM_DIR, jsonFileName);
		}
		
		try (FileWriter writer = new FileWriter(file)) {
			GSON.toJson(json, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}