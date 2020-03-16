/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class LoreStorage implements IStorage<ILore> {
	
	@Override
	public NBTBase writeNBT(Capability<ILore> capability, ILore instance, EnumFacing side) {
		return null;// TODO new NBTTagInt(instance.get);
	}
	
	@Override
	public void readNBT(Capability<ILore> capability, ILore instance, EnumFacing side, NBTBase nbt) {
		// TODO instance.addLoreBook(((NBTTagInt) nbt).getInt());
	}
}