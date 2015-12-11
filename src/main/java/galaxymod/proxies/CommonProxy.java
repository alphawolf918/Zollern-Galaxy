package galaxymod.proxies;

import net.minecraft.block.Block;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class CommonProxy {
	public void initRenderers() {
		
	}
	
	public void initGUI() {
		
	}
	
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	public void spawnParticle(String string, double x, double y, double z) {
	}
	
	public void spawnMotionParticle(String string, double x, double y,
			double z, double motionX, double motionY, double motionZ) {
	}
	
	public int getBlockRender(Block block) {
		return -1;
	}
}