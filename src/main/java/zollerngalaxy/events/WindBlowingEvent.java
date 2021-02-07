/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.events;

import java.util.List;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.ZGHelper;

public class WindBlowingEvent extends Event {
	
	public enum WindDirection {
		NORTH, EAST, WEST, SOUTH;
	}
	
	private WindDirection currentDirection = WindDirection.NORTH;
	private int directionalChance = ZGHelper.rngInt(1, 100);
	private int windStrength = ZGHelper.rngInt(1, 35);
	private World world;
	private BlockPos playerPos;
	
	public WindBlowingEvent(World worldIn) {
		this.world = worldIn;
		this.playerPos = new BlockPos(ClientProxyCore.playerPosX, ClientProxyCore.playerPosY, ClientProxyCore.playerPosZ);
		
		if (directionalChance <= 10) {
			this.updateDirectionBasedOnChance();
		}
		
		int windBlowChance = ConfigManagerZG.windBlowChance;
		
		if (ZGHelper.rngInt(1, 100) <= windBlowChance && world.canBlockSeeSky(playerPos)) {
			this.pushEntities();
		}
	}
	
	private void checkBlockAt(double posX, double posY, double posZ, World world, EntityPlayer player) {
		BlockPos pos = new BlockPos(posX, posY, posZ);
		if (world.getBlockState(pos) == Blocks.AIR.getDefaultState() && world.canBlockSeeSky(pos)) {
			this.playWindSound(world, player, posX, posY, posZ);
			player.setPositionAndUpdate(posX, posY, posZ);
		} else {
			this.checkBlockAt(posX, posY + 2, posZ, world, player);
		}
	}
	
	private void playWindSound(World worldIn, EntityPlayer player, double posX, double posY, double posZ) {
		BlockPos soundPos = new BlockPos(posX, posY, posZ);
		worldIn.playSound(player, soundPos, ZGSoundEvents.WEATHER_WIND, SoundCategory.WEATHER, 1000.0F, 5.0F + player.getRNG().nextFloat() * 0.2F);
	}
	
	public void pushEntities() {
		if (!this.world.isRemote) {
			double expandBy = 25.0D;
			AxisAlignedBB boundingBox = new AxisAlignedBB(this.playerPos);
			Class<? extends Entity> playerClass = EntityPlayer.class;
			AxisAlignedBB expandedBox = boundingBox.expand(expandBy, expandBy, expandBy);
			List<? extends Entity> playerList = this.world.<Entity> getEntitiesWithinAABB(playerClass, expandedBox);
			Object[] playerArray = playerList.toArray();
			for (Object o : playerArray) {
				if (o instanceof EntityPlayer) {
					EntityPlayer currentPlayer = (EntityPlayer) o;
					BlockPos newPos = playerPos;
					switch (this.getDirection()) {
						case NORTH:
							newPos = playerPos.north(windStrength);
							break;
						case SOUTH:
							newPos = playerPos.south(windStrength);
							break;
						case EAST:
							newPos = playerPos.east(windStrength);
							break;
						case WEST:
							newPos = playerPos.west(windStrength);
							break;
						default:
							newPos = playerPos.up(windStrength);
							break;
					}
					this.playWindSound(world, currentPlayer, newPos.getX(), newPos.getY(), newPos.getZ());
					this.checkBlockAt(newPos.getX(), newPos.getY(), newPos.getZ(), world, currentPlayer);
				}
			}
		}
	}
	
	public void setDirection(WindDirection dir) {
		this.currentDirection = dir;
	}
	
	public void setStrength(int strength) {
		this.windStrength = strength;
	}
	
	public void setPlayerPos(BlockPos pos) {
		this.playerPos = pos;
	}
	
	public void updateDirectionBasedOnChance() {
		int dirChance = ZGHelper.rngInt(1, 4);
		WindDirection dir = this.currentDirection;
		switch (dirChance) {
			case 1:
				dir = WindDirection.NORTH;
				break;
			case 2:
				dir = WindDirection.SOUTH;
				break;
			case 3:
				dir = WindDirection.EAST;
				break;
			case 4:
				dir = WindDirection.WEST;
				break;
		}
		this.setDirection(dir);
	}
	
	public void updateChance() {
		this.directionalChance = ZGHelper.rngInt(1, 100);
	}
	
	public WindDirection getDirection() {
		return this.currentDirection;
	}
	
	public int getStrength() {
		return this.windStrength;
	}
	
	public BlockPos getPlayerPos() {
		return this.playerPos;
	}
	
	public World getWorld() {
		return this.world;
	}
	
}