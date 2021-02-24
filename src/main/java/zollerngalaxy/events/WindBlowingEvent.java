/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.events;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;

public final class WindBlowingEvent extends Event {
	
	private ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	private IProxy proxy = core.proxy;
	
	public enum WindDirection {
		NORTH, EAST, WEST, SOUTH;
	}
	
	private WindDirection currentDirection = WindDirection.NORTH;
	private int directionalChance = ZGHelper.rngInt(1, 100);
	private int windStrength = ZGHelper.rngInt(1, 35);
	private World world;
	private BlockPos playerPos;
	
	public WindBlowingEvent(World worldIn, EntityPlayer player) {
		this.world = worldIn;
		this.playerPos = new BlockPos(player.posX, player.posY, player.posZ);
		
		if (this.directionalChance <= 10) {
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
			this.playWindSound(world, player, posX, posY, posZ);
		} else {
			this.checkBlockAt(posX, posY + 2, posZ, world, player);
		}
	}
	
	private void playWindSound(World worldIn, EntityPlayer player, double posX, double posY, double posZ) {
		BlockPos soundPos = new BlockPos(posX, posY, posZ);
		worldIn.playSound(player, soundPos, ZGSoundEvents.WEATHER_WIND, SoundCategory.WEATHER, 1000.0F, 2.0F + player.getRNG().nextFloat() * 0.4F);
	}
	
	public void pushEntities() {
		if (!this.world.isRemote) {
			double expandBy = 25.0D;
			AxisAlignedBB boundingBox = new AxisAlignedBB(this.playerPos);
			AxisAlignedBB expandedBox = boundingBox.expand(expandBy, expandBy, expandBy);
			Class<? extends Entity> playerClass = EntityPlayer.class;
			List<? extends Entity> playerList = this.world.<Entity> getEntitiesWithinAABB(playerClass, expandedBox);
			Object[] playerArray = playerList.toArray();
			for (Object o : playerArray) {
				if (o instanceof EntityPlayer) {
					EntityPlayer currentPlayer = (EntityPlayer) o;
					if (this.checkForAmulet(currentPlayer)) {
						return;
					}
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
					this.playWindSound(world, currentPlayer, newPos.getX(), newPos.getY(), newPos.getZ());
				}
			}
		}
	}
	
	private boolean checkForAmulet(EntityPlayer player) {
		InventoryPlayer playerInventory = player.inventory;
		Item item = ZGItems.amuletStorm;
		ItemStack stack = new ItemStack(item, 1);
		boolean hasStack = playerInventory.hasItemStack(stack);
		boolean protectionActive = player.isPotionActive(ZGPotions.stormProtection);
		boolean isCreativeMode = player.capabilities.isCreativeMode;
		if (hasStack && !protectionActive && !isCreativeMode) {
			PotionEffect stormProtectionEffect = new PotionEffect(ZGPotions.stormProtection, ZGPotions.protectionTime, 1);
			player.addPotionEffect(stormProtectionEffect);
			if (playerInventory.hasItemStack(stack)) {
				int invSlot = playerInventory.getSlotFor(stack);
				playerInventory.decrStackSize(invSlot, 1);
			}
			this.proxy.sendChatMessage(player, TextFormatting.GOLD + ZGUtils.translate("tooltips.amulet_storm"));
		}
		return player.isPotionActive(ZGPotions.stormProtection);
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