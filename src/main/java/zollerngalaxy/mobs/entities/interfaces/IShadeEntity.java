/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.interfaces;

/**
 * An alien entity that is born in darkness or infected by it.
 */
public interface IShadeEntity {
	
	public default boolean isShadowBeing() {
		return true;
	};
	
	public default boolean shouldAttackLightEntity() {
		return true;
	};
	
	public default boolean shouldDropEssence() {
		return true;
	};
	
}