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

package galaxymod.core;

import galaxymod.dimensions.providers.WorldProviderNova;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

public class TeleportTypeNG implements ITeleportType {
	
	@Override
	public boolean useParachute() {
		return true;
	}
	
	@Override
	public Vector3 getPlayerSpawnLocation(WorldServer world,
			EntityPlayerMP player) {
		if (player != null) {
			GCPlayerStats stats = GCPlayerStats.get(player);
			return new Vector3(stats.coordsTeleportedFromX, 250.0,
					stats.coordsTeleportedFromZ);
		}
		return null;
	}
	
	@Override
	public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
		double y = 250.0f;
		WorldProvider provider = world.provider;
		if (provider instanceof WorldProviderNova) {
			WorldProviderNova novaProvider = (WorldProviderNova) provider;
			y = novaProvider.getYCoordinateToTeleport();
		}
		return new Vector3(entity.posX, y, entity.posZ);
	}
	
	@Override
	public Vector3 getParaChestSpawnLocation(WorldServer world,
			EntityPlayerMP player, Random rand) {
		double x = (rand.nextDouble() * 2 - 1.0D) * 5.0D;
		double z = (rand.nextDouble() * 2 - 1.0D) * 5.0D;
		return new Vector3(player.posX + x, 230.0D, player.posZ + z);
	}
	
	@Override
	public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player,
			boolean ridingAutoRocket) {
	}
}