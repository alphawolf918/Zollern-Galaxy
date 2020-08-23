/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util.capabilities.lore;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class LoreProvider implements ICapabilitySerializable<NBTBase> {
	
	@CapabilityInject(ILore.class)
	public static final Capability<ILore> LORE_CAP = null;
	
	private ILore instance = LORE_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == LORE_CAP;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == LORE_CAP ? LORE_CAP.<T> cast(this.instance) : null;
	}
	
	@Override
	public NBTBase serializeNBT() {
		return LORE_CAP.getStorage().writeNBT(LORE_CAP, this.instance, null);
	}
	
	@Override
	public void deserializeNBT(NBTBase nbt) {
		LORE_CAP.getStorage().readNBT(LORE_CAP, this.instance, null, nbt);
	}
	
}