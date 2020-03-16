/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib.helpers;

import net.minecraftforge.common.MinecraftForge;
import zollerngalaxy.events.ZGEvents;

public class ZGHandlers {
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ZGEvents());
	}
	
}