/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib;

import java.util.Arrays;
import net.minecraftforge.fml.common.ModMetadata;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGInfo {
	
	public static final String MOD_ID = "zollerngalaxy";
	public static final String vMAJOR = "2";
	public static final String vMINOR = "0";
	public static final String vBUILD = "26";
	public static final String MOD_VERSION = vMAJOR + "." + vMINOR + "." + vBUILD;
	public static final String MINECRAFT_VERSION = "1.12.2";
	public static final String OFFICIAL_NAME = "Zollern Galaxy";
	public static final String NAME = OFFICIAL_NAME;
	public static final String PROXY_LOCATION = "zollerngalaxy.proxy.";
	public static final String PROXY_CLIENT = PROXY_LOCATION + "ClientProxy";
	public static final String PROXY_SERVER = PROXY_LOCATION + "CommonProxy";
	public static final String CHANNEL = ZGInfo.MOD_ID;
	public static final String FORGE_MODS = "before:planetprogression@[1.12.2-0.3.8,]; " + "before:extraplanets; " + "before:powersuits;";
	public static final String FORGE_VERSION = "after:forge@[14.23.5.2847,); after:tconstruct; ";
	public static final String DEPENDENCIES = "required-after:galacticraftcore@[4.0.2.261,); " + "required-after:galacticraftplanets@[4.0.2.261,); "
			+ "required-after:micdoodlecore; " + ZGInfo.FORGE_VERSION + ZGInfo.FORGE_MODS;
	
	public static void init(ModMetadata info) {
		info.autogenerated = false;
		info.modId = ZGInfo.MOD_ID;
		info.name = ZGInfo.NAME;
		info.version = ZGInfo.MOD_VERSION;
		info.description = "An adventurous space exploration add-on mod for Galacticraft.";
		info.credits = "All credits to Galacticraft Sources/API, MJRLegends, ExistingEevee and Skaptic.";
		info.authorList = Arrays.asList("Zollern Wolf");
		
		ZGHelper.Log("Mod information load completed.");
	}
}