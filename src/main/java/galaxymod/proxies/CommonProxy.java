/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

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