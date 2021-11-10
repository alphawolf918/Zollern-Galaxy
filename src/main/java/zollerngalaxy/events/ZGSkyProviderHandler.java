/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.events;

import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.client.SkyProviderOrbit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderOrbitZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitAltum;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitAtheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitCaligro;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitCandora;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitExodus;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitKriffon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitMetztli;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitOasis;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPerdita;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPurgot;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitVortex;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXantheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXathius;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitZollus;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.util.ZGUtils;

public class ZGSkyProviderHandler {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(ClientTickEvent event) {
		final Minecraft minecraft = ZGUtils.getClient();
		final WorldClient world = minecraft.world;
		final EntityPlayerSP player = minecraft.player;
		
		if (event.phase == Phase.START && player != null && world != null) {
			// Psios-6 (Zollus)
			if (world.provider instanceof WorldProviderOrbitZollus) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/zollus.png"), "psion6", world.provider);
					WorldProviderOrbitZollus provider = (WorldProviderOrbitZollus) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Psios-6 (Kriffon)
			if (world.provider instanceof WorldProviderOrbitKriffon) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/kriffus.png"), "psion6", world.provider);
					WorldProviderOrbitKriffon provider = (WorldProviderOrbitKriffon) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Psios-6 (Purgot)
			if (world.provider instanceof WorldProviderOrbitPurgot) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/purgot.png"), "psion6", world.provider);
					WorldProviderOrbitPurgot provider = (WorldProviderOrbitPurgot) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Psios-6 (Eden)
			if (world.provider instanceof WorldProviderOrbitEden) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/eden.png"), "psion6", world.provider);
					WorldProviderOrbitEden provider = (WorldProviderOrbitEden) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Praedyth (Xathius)
			if (world.provider instanceof WorldProviderOrbitXathius) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/xathius.png"), "praedyth", world.provider);
					WorldProviderOrbitXathius provider = (WorldProviderOrbitXathius) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Praedyth (Oasis)
			if (world.provider instanceof WorldProviderOrbitOasis) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/oasis.png"), "praedyth", world.provider);
					WorldProviderOrbitOasis provider = (WorldProviderOrbitOasis) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Praedyth (Xantheon)
			if (world.provider instanceof WorldProviderOrbitXantheon) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/xantheon.png"), "praedyth", world.provider);
					WorldProviderOrbitXantheon provider = (WorldProviderOrbitXantheon) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Praedyth (Candora)
			if (world.provider instanceof WorldProviderOrbitCandora) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/candora.png"), "praedyth", world.provider);
					WorldProviderOrbitCandora provider = (WorldProviderOrbitCandora) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Praedyth (Atheon)
			if (world.provider instanceof WorldProviderOrbitAtheon) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/atheon.png"), "praedyth", world.provider);
					WorldProviderOrbitAtheon provider = (WorldProviderOrbitAtheon) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Sol-2 (Perdita)
			if (world.provider instanceof WorldProviderOrbitPerdita) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/perdita.png"), "sol2", world.provider);
					WorldProviderOrbitPerdita provider = (WorldProviderOrbitPerdita) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Sol-2 (Altum)
			if (world.provider instanceof WorldProviderOrbitAltum) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/altum.png"), "sol2", world.provider);
					WorldProviderOrbitAltum provider = (WorldProviderOrbitAltum) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Sol-2 (Caligro)
			if (world.provider instanceof WorldProviderOrbitCaligro) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/caligro.png"), "sol2", world.provider);
					WorldProviderOrbitCaligro provider = (WorldProviderOrbitCaligro) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Sol-2 (Exodus)
			if (world.provider instanceof WorldProviderOrbitExodus) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/exodus.png"), "sol2", world.provider);
					WorldProviderOrbitExodus provider = (WorldProviderOrbitExodus) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Pantheon (Vortex)
			if (world.provider instanceof WorldProviderOrbitVortex) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/vortex.png"), "pantheon", world.provider);
					WorldProviderOrbitVortex provider = (WorldProviderOrbitVortex) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Pantheon (Metztli)
			if (world.provider instanceof WorldProviderOrbitMetztli) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/metztli.png"), "metztli", world.provider);
					WorldProviderOrbitMetztli provider = (WorldProviderOrbitMetztli) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
		}
	}
}