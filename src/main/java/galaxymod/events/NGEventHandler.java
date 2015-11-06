package galaxymod.events;

import net.minecraftforge.common.MinecraftForge;

public class NGEventHandler {
	public static void init(){
		MinecraftForge.EVENT_BUS.register(new NGEvents());
	}
}