/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.events;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;
import zollerngalaxy.lib.helpers.ZGHelper;

public class WindBlowingEvent extends Event {
	
	public enum WindDirection {
		NORTH, EAST, WEST, SOUTH;
	}
	
	private WindDirection currentDirection = WindDirection.NORTH;
	private int directionalChance = ZGHelper.rngInt(1, 100);
	private int windStrength = ZGHelper.rngInt(10, 15);
	private World world;
	
	public WindBlowingEvent(World worldIn) {
		this.world = worldIn;
		if (directionalChance == 0) {
			this.updateDirectionBasedOnChance();
		}
	}
	
	private void pushEntities() {
		// TODO
	}
	
	public void setDirection(WindDirection dir) {
		this.currentDirection = dir;
	}
	
	public void setStrength(int strength) {
		this.windStrength = strength;
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
	
}