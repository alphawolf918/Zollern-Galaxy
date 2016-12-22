/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.dimensions.providers.renderers.core;

import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.dimensions.providers.kriffon.WorldProviderKriffon;
import galaxymod.dimensions.providers.oasis.WorldProviderOasis;
import galaxymod.dimensions.providers.purgot.WorldProviderPurgot;
import galaxymod.dimensions.providers.renderers.SkyProviderEden;
import galaxymod.dimensions.providers.renderers.SkyProviderKriffon;
import galaxymod.dimensions.providers.renderers.SkyProviderOasis;
import galaxymod.dimensions.providers.renderers.SkyProviderPurgot;
import galaxymod.dimensions.providers.renderers.SkyProviderXathius;
import galaxymod.dimensions.providers.renderers.SkyProviderZollus;
import galaxymod.dimensions.providers.xathius.WorldProviderXathius;
import galaxymod.dimensions.providers.zollus.WorldProviderZollus;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZGSkyProviderHandler {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onSkyRendererTick(ClientTickEvent event) {
		Minecraft minecraft = FMLClientHandler.instance().getClient();
		WorldClient world = minecraft.theWorld;
		
		if (world != null) {
			if (world.provider instanceof WorldProviderEden) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderEden(
							(IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			} else if (world.provider instanceof WorldProviderZollus) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderZollus(
							(IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			} else if (world.provider instanceof WorldProviderKriffon) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderKriffon(
							(IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			} else if (world.provider instanceof WorldProviderPurgot) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderPurgot(
							(IGalacticraftWorldProvider) world.provider));
					if (world.provider.getCloudRenderer() == null) {
						world.provider.setCloudRenderer(new CloudRenderer());
					}
				}
			} else if (world.provider instanceof WorldProviderOasis) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderOasis(
							(IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			} else if (world.provider instanceof WorldProviderXathius) {
				if (world.provider.getSkyRenderer() == null) {
					world.provider.setSkyRenderer(new SkyProviderXathius(
							(IGalacticraftWorldProvider) world.provider));
				}
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}
	}
}
