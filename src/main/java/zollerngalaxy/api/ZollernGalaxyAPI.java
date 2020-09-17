/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.api;

import zollerngalaxy.lib.helpers.ZGHelper;

/**
 * Zollern Galaxy Official API
 * * * * *
 * When using this, be sure to call the init function to run your code, and when doing so, call
 * super.init(); first so that it can call everything before it.
 * * * * *
 * It should also be noted that when developing an add-on for this mod, you'll need to add
 * "before:zollerngalaxy; " to your Forge optional dependencies. Make sure to keep the space at the
 * end!
 * * * * *
 * As for how this is used, be creative!
 */
public abstract class ZollernGalaxyAPI {
	
	private static boolean hasAPILoaded = false;
	
	public static void init() {
		ZollernGalaxyAPI.mainInit();
		if (ZollernGalaxyAPI.hasAPILoaded) {
			ZGHelper.Log("Loaded API successfully!");
		} else {
			ZGHelper.Log("The Zollern Galaxy API was not used correctly in an add-on mod!");
		}
	}
	
	private static void mainInit() {
		ZollernGalaxyAPI.hasAPILoaded = true;
	}
	
}