package zollerngalaxy.lib.helpers.json;

/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import net.minecraftforge.common.config.Configuration;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;

/**
 * JSON Block/Item generator. Saves a good bit of hassle and time of dealing
 * with JSON files. NOTE: This is only for REGULAR blocks; special ones still
 * need to be modified after they're generated.
 * 
 * @author Zollern Wolf
 */
public final class JSONFactory {
	
	// Change to True or False or make a method like this
	private static final boolean ENABLE = ZollernGalaxyCore.instance().isInDevMode();
	
	// Change to ID of your Mod
	private static final String MOD_ID = ZGInfo.MOD_ID;
	
	// Change to your config file
	private static final Configuration config = ConfigManagerZG.configuration;
	
	// Shouldn't need to edit below this line
	private static final String ASSETS_PATH = "../../../../src/main/resources/assets/";
	private static final String FULL_PATH = ASSETS_PATH + MOD_ID;
	private static final String JSON_TEMPLATE_PATH = "../../../../JSON_Templates/";
	
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static File ITEM_DIR = null;
	private static File BLOCK_DIR = null;
	private static File BLOCK_STATES_DIR = null;
	private static File BLOCK_CUSTOM_DIR = null;
	
	private static void setupItemDir() {
		if (ITEM_DIR == null) {
			ITEM_DIR = JSONFactory.getPath("models/item");
		}
		
		if (!ITEM_DIR.exists()) {
			ITEM_DIR.mkdir();
		}
	}
	
	private static void setupBlockDirs() {
		if (BLOCK_DIR == null) {
			BLOCK_DIR = JSONFactory.getPath("models/block");
		}
		
		if (BLOCK_STATES_DIR == null) {
			BLOCK_STATES_DIR = JSONFactory.getPath("blockstates");
		}
		
		if (BLOCK_CUSTOM_DIR == null) {
			BLOCK_CUSTOM_DIR = JSONFactory.getPath("models/custom");
		}
		
		JSONFactory.setupItemDir();
		
		if (!BLOCK_DIR.exists()) {
			BLOCK_DIR.mkdir();
		}
		
		if (!BLOCK_STATES_DIR.exists()) {
			BLOCK_STATES_DIR.mkdir();
		}
		
		if (!BLOCK_CUSTOM_DIR.exists()) {
			BLOCK_CUSTOM_DIR.mkdir();
		}
	}
	
	private static File getPath(String path) {
		return config.getConfigFile().toPath().resolve(FULL_PATH + "/" + path + "/").toFile();
	}
	
	public static void registerItem(String itemName) {
		if (!ENABLE) {
			return;
		}
		
		JSONFactory.setupItemDir();
		
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
	
	public static void registerTool(String toolName) {
		if (!ENABLE) {
			return;
		}
		
		JSONFactory.setupItemDir();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> layers = new LinkedHashMap<>();
		
		layers.put("layer0", MOD_ID + ":items/" + toolName);
		
		json.put("parent", "item/handheld");
		json.put("textures", layers);
		
		String jsonFileName = toolName + ".json";
		
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
		JSONFactory.setupBlockDirs();
		
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
		
		JSONFactory.registerBlockState(blockName);
	}
	
	public static void registerLeaves(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> all = new LinkedHashMap<>();
		
		all.put("all", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "block/leaves");
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
		
		JSONFactory.registerBlockState(blockName);
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
		
		JSONFactory.registerBlockItem(blockName);
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
	
	public static void registerFlowerBlock(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> cross = new LinkedHashMap<>();
		
		cross.put("cross", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "block/cross");
		json.put("textures", cross);
		
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
		
		JSONFactory.registerFlowerBlockState(blockName);
	}
	
	public static void registerSapling(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> cross = new LinkedHashMap<>();
		
		cross.put("cross", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "block/cross");
		json.put("textures", cross);
		
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
		
		JSONFactory.registerSaplingBlockState(blockName);
	}
	
	public static void registerIngotStack(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> textures = new LinkedHashMap<>();
		Map<String, Object> n0 = new LinkedHashMap<>();
		Map<String, Object> particle = new LinkedHashMap<>();
		Map<String, Object> elements = new LinkedHashMap<>();
		Map<String, Object> groups = new LinkedHashMap<>();
		
		// Textures
		textures.put("n0", MOD_ID + ":" + blockName);
		textures.put("particle", MOD_ID + ":" + blockName);
		json.put("textures", textures);
		
		// Elements
		JsonArray from1 = new JsonArray();
		from1.add(new JsonPrimitive(5));
		from1.add(new JsonPrimitive(0));
		from1.add(new JsonPrimitive(2));
		JsonArray to1 = new JsonArray();
		to1.add(new JsonPrimitive(11));
		to1.add(new JsonPrimitive(2));
		to1.add(new JsonPrimitive(5));
		elements.put("name", "Shape1");
		elements.put("from", from1);
		elements.put("to", to1);
		elements.put("shade", false);
		
		//
		Map<String, Object> faces1 = new LinkedHashMap<>();
		//
		//
		Map<String, Object> north1 = new LinkedHashMap<>();
		Map<String, Object> uv1 = new LinkedHashMap<>();
		JsonArray uv1A = new JsonArray();
		uv1A.add(new JsonPrimitive(9));
		uv1A.add(new JsonPrimitive(3));
		uv1A.add(new JsonPrimitive(3));
		uv1A.add(new JsonPrimitive(5));
		north1.put("uv", uv1A);
		north1.put("texture", "#0");
		//
		//
		Map<String, Object> east1 = new LinkedHashMap<>();
		Map<String, Object> uv2 = new LinkedHashMap<>();
		JsonArray uv1B = new JsonArray();
		uv1B.add(new JsonPrimitive(12));
		uv1B.add(new JsonPrimitive(3));
		uv1B.add(new JsonPrimitive(9));
		uv1B.add(new JsonPrimitive(5));
		east1.put("uv", uv1B);
		east1.put("texture", "#0");
		//
		//
		Map<String, Object> south1 = new LinkedHashMap<>();
		Map<String, Object> uv3 = new LinkedHashMap<>();
		JsonArray uv1C = new JsonArray();
		uv1C.add(new JsonPrimitive(18));
		uv1C.add(new JsonPrimitive(3));
		uv1C.add(new JsonPrimitive(12));
		uv1C.add(new JsonPrimitive(5));
		south1.put("uv", uv1C);
		south1.put("texture", "#0");
		//
		//
		Map<String, Object> west1 = new LinkedHashMap<>();
		Map<String, Object> uv4 = new LinkedHashMap<>();
		JsonArray uv1D = new JsonArray();
		uv1D.add(new JsonPrimitive(3));
		uv1D.add(new JsonPrimitive(3));
		uv1D.add(new JsonPrimitive(0));
		uv1D.add(new JsonPrimitive(5));
		west1.put("uv", uv1D);
		west1.put("texture", "#0");
		//
		//
		Map<String, Object> up1 = new LinkedHashMap<>();
		Map<String, Object> uv5 = new LinkedHashMap<>();
		JsonArray uv1E = new JsonArray();
		uv1E.add(new JsonPrimitive(3));
		uv1E.add(new JsonPrimitive(3));
		uv1E.add(new JsonPrimitive(9));
		uv1E.add(new JsonPrimitive(0));
		up1.put("uv", uv1E);
		up1.put("texture", "#0");
		//
		//
		Map<String, Object> down1 = new LinkedHashMap<>();
		Map<String, Object> uv6 = new LinkedHashMap<>();
		JsonArray uv1F = new JsonArray();
		uv1F.add(new JsonPrimitive(9));
		uv1F.add(new JsonPrimitive(0));
		uv1F.add(new JsonPrimitive(15));
		uv1F.add(new JsonPrimitive(3));
		down1.put("uv", uv1E);
		down1.put("texture", "#0");
		//
		//
		//
		//
		faces1.put("north", north1);
		faces1.put("east", east1);
		faces1.put("south", south1);
		faces1.put("west", west1);
		faces1.put("up", up1);
		faces1.put("down", down1);
		//
		//
		//
		//
		JsonArray f1 = new JsonArray();
		elements.put("faces", faces1);
		json.put("elements", elements);
		
		// Groups
		// TODO
		
		// Write
		File file = new File(BLOCK_CUSTOM_DIR, jsonFileName);
		
		while (file.exists()) {
			file.delete();
			file = new File(BLOCK_CUSTOM_DIR, jsonFileName);
		}
		
		try (FileWriter writer = new FileWriter(file)) {
			GSON.toJson(json, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void registerSaplingBlockState(String blockName) {
		String jsonFileName = blockName + ".json";
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> stages = new LinkedHashMap<>();
		Map<String, Object> model = new LinkedHashMap<>();
		
		model.put("model", MOD_ID + ":" + blockName);
		stages.put("stage=0", model);
		stages.put("stage=1", model);
		json.put("variants", stages);
		
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
		
		JSONFactory.registerBlockAsItem(blockName);
	}
	
	private static void registerFlowerBlockState(String blockName) {
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
		
		JSONFactory.registerBlockAsItem(blockName);
	}
	
	private static void registerBlockAsItem(String blockName) {
		String jsonFileName = blockName + ".json";
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> layers = new LinkedHashMap<>();
		
		layers.put("layer0", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "item/generated");
		json.put("textures", layers);
		
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
	
	public static void registerLogBlock(String blockName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> defaults = new LinkedHashMap<>();
		Map<String, Object> textures = new LinkedHashMap<>();
		Map<String, Object> variants = new LinkedHashMap<>();
		
		textures.put("bottom", MOD_ID + ":blocks/" + blockName + "_top");
		textures.put("top", MOD_ID + ":blocks/" + blockName + "_top");
		textures.put("side", MOD_ID + ":blocks/" + blockName);
		
		defaults.put("textures", textures);
		defaults.put("model", "cube_bottom_top");
		
		List<InnerArray> yList = new LinkedList<InnerArray>();
		yList.add(new InnerArray(90));
		yList.add(new InnerArray(180));
		yList.add(new InnerArray(270));
		
		List<EmptyArray> eList = new LinkedList<EmptyArray>();
		eList.add(new EmptyArray());
		
		variants.put("normal", yList);
		variants.put("inventory", eList);
		
		json.put("forge_marker", 1);
		json.put("defaults", defaults);
		json.put("variants", variants);
		
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
		
		JSONFactory.registerLogBlockState(blockName);
	}
	
	private static void registerLogBlockState(String blockName) {
		String jsonFileName = blockName + ".json";
		
		Map<String, Object> json = new LinkedHashMap();
		Map<String, Object> textures = new LinkedHashMap();
		
		textures.put("all", MOD_ID + ":blocks/" + blockName + "_top");
		textures.put("top", MOD_ID + ":blocks/" + blockName + "_top");
		textures.put("right", MOD_ID + ":blocks/" + blockName);
		textures.put("left", MOD_ID + ":blocks/" + blockName);
		
		json.put("parent", "block/cube");
		json.put("textures", textures);
		
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
		
		JSONFactory.registerBlockItem(blockName);
	}
	
	public static void registerGrassBlock(String blockName, String blockBottomName) {
		if (!ENABLE) {
			return;
		}
		
		String jsonFileName = blockName + ".json";
		JSONFactory.setupBlockDirs();
		
		Map<String, Object> json = new LinkedHashMap<>();
		Map<String, Object> defaults = new LinkedHashMap<>();
		Map<String, Object> textures = new LinkedHashMap<>();
		Map<String, Object> variants = new LinkedHashMap<>();
		
		textures.put("bottom", MOD_ID + ":blocks/" + blockBottomName);
		textures.put("top", MOD_ID + ":blocks/" + blockName);
		textures.put("side", MOD_ID + ":blocks/" + blockName + "_side");
		
		defaults.put("textures", textures);
		defaults.put("model", "cube_bottom_top");
		
		List<InnerArray> yList = new LinkedList<InnerArray>();
		yList.add(new InnerArray(90));
		yList.add(new InnerArray(180));
		yList.add(new InnerArray(270));
		
		List<EmptyArray> eList = new LinkedList<EmptyArray>();
		eList.add(new EmptyArray());
		
		variants.put("normal", yList);
		variants.put("inventory", eList);
		
		json.put("forge_marker", 1);
		json.put("defaults", defaults);
		json.put("variants", variants);
		
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
		
		JSONFactory.registerGrassBlockState(blockName, blockBottomName);
	}
	
	private static void registerGrassBlockState(String blockName, String blockBottomName) {
		String jsonFileName = blockName + ".json";
		
		Map<String, Object> json = new LinkedHashMap();
		Map<String, Object> textures = new LinkedHashMap();
		
		textures.put("all", MOD_ID + ":blocks/" + blockBottomName);
		textures.put("top", MOD_ID + ":blocks/" + blockName);
		textures.put("right", MOD_ID + ":blocks/" + blockName + "_side");
		textures.put("left", MOD_ID + ":blocks/" + blockName + "_side");
		
		json.put("parent", "block/cube");
		json.put("textures", textures);
		
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
		
		JSONFactory.registerBlockItem(blockName);
	}
	
	protected static class InnerArray {
		int y = 0;
		
		protected InnerArray(int yIn) {
			this.y = yIn;
		}
	}
	
	protected static class EmptyArray {
		
	}
}