/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.interfaces;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.mobs.entities.companions.EnumCompanionType;

public interface ICompanionEntity {
	
	public default boolean canBeTamed() {
		return true;
	}
	
	public default boolean canCollectItems() {
		return true;
	}
	
	public default boolean canBeRidden() {
		return true;
	}
	
	public default boolean canBeLeashed() {
		return true;
	}
	
	public default boolean shouldDefendOwner() {
		return true;
	}
	
	public default boolean shouldShowNameTag() {
		return ConfigManagerZG.showCompanionNameTags;
	}
	
	public Item getFavoriteFood();
	
	public Item getTamingItem();
	
	public EnumCompanionType getCompanionType();
	
	public InventoryBasic getCompanionInventory();
}