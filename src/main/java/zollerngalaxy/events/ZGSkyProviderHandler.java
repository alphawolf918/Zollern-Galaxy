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
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
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
			// Psios-6 (Eden)
			if (world.provider instanceof WorldProviderOrbitEden) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID
							+ ":textures/gui/eden.png"), "psion6.png");
					WorldProviderOrbitEden provider = (WorldProviderOrbitEden) world.provider;
					provider.setSpinDeltaPerTick(provider.getSpinManager().getSpinRate());
					world.provider.setSkyRenderer(sky);
				}
				
				if (world.provider.getCloudRenderer() == null) {
					world.provider.setCloudRenderer(new CloudRenderer());
				}
			}
			
			// Psios-6 (Zollus)
			if (world.provider instanceof WorldProviderOrbitZollus) {
				if (world.provider.getSkyRenderer() == null || world.provider.getSkyRenderer() instanceof SkyProviderOrbit) {
					SkyProviderOrbitZG sky = new SkyProviderOrbitZG(new ResourceLocation(ZGInfo.MOD_ID
							+ ":textures/gui/zollus.png"), "psion6");
					WorldProviderOrbitZollus provider = (WorldProviderOrbitZollus) world.provider;
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