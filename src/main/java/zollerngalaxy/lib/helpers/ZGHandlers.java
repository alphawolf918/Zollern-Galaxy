package zollerngalaxy.lib.helpers;

import net.minecraftforge.common.MinecraftForge;
import zollerngalaxy.events.ZGEvents;

public class ZGHandlers {
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ZGEvents());
	}
	
}