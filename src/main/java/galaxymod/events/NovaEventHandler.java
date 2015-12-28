package galaxymod.events;

import net.minecraftforge.common.MinecraftForge;

public class NovaEventHandler {
	public static void init(){
		MinecraftForge.EVENT_BUS.register(new NovaEvents());
	}
}