/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.infected;

public interface IInfectedBlock {
	
	public default boolean isInfected() {
		return true;
	};
	
	public default boolean canInfect() {
		return true;
	};
	
	public default boolean spreadsInfection() {
		return true;
	};
}