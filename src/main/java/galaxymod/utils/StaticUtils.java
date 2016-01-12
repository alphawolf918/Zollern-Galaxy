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

package galaxymod.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

public class StaticUtils {
	
	public static final ForgeDirection[] CardinalDirections = new ForgeDirection[] {
			ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH,
			ForgeDirection.WEST };
	
	public static final ForgeDirection neighborsBySide[][] = new ForgeDirection[][] {
			{ ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST,
					ForgeDirection.EAST },
			{ ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.WEST,
					ForgeDirection.EAST },
			{ ForgeDirection.UP, ForgeDirection.DOWN, ForgeDirection.EAST,
					ForgeDirection.WEST },
			{ ForgeDirection.UP, ForgeDirection.DOWN, ForgeDirection.WEST,
					ForgeDirection.EAST },
			{ ForgeDirection.UP, ForgeDirection.DOWN, ForgeDirection.NORTH,
					ForgeDirection.SOUTH },
			{ ForgeDirection.UP, ForgeDirection.DOWN, ForgeDirection.SOUTH,
					ForgeDirection.NORTH } };
	
	public static class Fluids {
		public static boolean fillTankWithContainer(World world,
				IFluidHandler handler, EntityPlayer player) {
			
			ItemStack container = player.getCurrentEquippedItem();
			FluidStack fluid = FluidContainerRegistry
					.getFluidForFilledItem(container);
			
			if (fluid != null) {
				if (handler.fill(ForgeDirection.UNKNOWN, fluid, false) == fluid.amount
						|| player.capabilities.isCreativeMode) {
					if (world.isRemote) {
						return true;
					}
					handler.fill(ForgeDirection.UNKNOWN, fluid, true);
					
					if (!player.capabilities.isCreativeMode) {
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem,
								Inventory.consumeItem(container));
					}
					return true;
				}
			}
			return false;
		}
		
		public static class Inventory {
			/**
			 * Consume a single item from a stack of items
			 * 
			 * @param stack
			 *            The stack from which to consume
			 * @return The remainder of the stack, or null if the stack was
			 *         fully consumed.
			 */
			public static ItemStack consumeItem(ItemStack stack) {
				return consumeItem(stack, 1);
			}
			
			/**
			 * Consume some amount of items from a stack of items. Assumes
			 * you've already validated the consumption. If you try to consume
			 * more than the stack has, it will simply destroy the stack, as if
			 * you'd consumed all of it.
			 * 
			 * @param stack
			 *            The stack from which to consume
			 * @return The remainder of the stack, or null if the stack was
			 *         fully consumed.
			 */
			public static ItemStack consumeItem(ItemStack stack, int amount) {
				if (stack == null) {
					return null;
				}
				
				if (stack.stackSize <= amount) {
					if (stack.getItem().hasContainerItem(stack)) {
						return stack.getItem().getContainerItem(stack);
					} else {
						return null;
					}
				} else {
					stack.splitStack(amount);
					return stack;
				}
			}
		}
		
		public static boolean fillContainerFromTank(World world,
				IFluidHandler handler, EntityPlayer player, FluidStack tankFluid) {
			ItemStack container = player.getCurrentEquippedItem();
			
			if (FluidContainerRegistry.isEmptyContainer(container)) {
				ItemStack returnStack = FluidContainerRegistry
						.fillFluidContainer(tankFluid, container);
				FluidStack fluid = FluidContainerRegistry
						.getFluidForFilledItem(returnStack);
				
				if (fluid == null || returnStack == null) {
					return false;
				}
				if (!player.capabilities.isCreativeMode) {
					if (container.stackSize == 1) {
						container = container.copy();
						player.inventory.setInventorySlotContents(
								player.inventory.currentItem, returnStack);
					} else if (!player.inventory
							.addItemStackToInventory(returnStack)) {
						return false;
					}
					handler.drain(ForgeDirection.UNKNOWN, fluid.amount, true);
					container.stackSize--;
					
					if (container.stackSize <= 0) {
						container = null;
					}
				} else {
					handler.drain(ForgeDirection.UNKNOWN, fluid.amount, true);
				}
				return true;
			}
			return false;
		}
	}
}