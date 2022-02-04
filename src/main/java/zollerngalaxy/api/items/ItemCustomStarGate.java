/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.api.items;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.network.teleporter.MessageTeleportToDimension;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;

public abstract class ItemCustomStarGate extends Item {
	
	protected ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	protected IProxy proxy = core.proxy;
	protected SimpleNetworkWrapper snw = core.snw;
	
	protected int toDimensionId = this.getNullId();
	protected int fromDimensionId = this.getNullId();
	
	public ItemCustomStarGate(int toDimensionIn, int fromDimensionIn) {
		super();
		this.setDimensions(toDimensionIn, fromDimensionIn);
		this.setMaxStackSize(1);
	}
	
	/**
	 * Set the TO dimension ID for this Star Gate.
	 * 
	 * @param toDimensionIn
	 * @return
	 */
	public Item setToDimensionId(int toDimensionIn) {
		this.toDimensionId = toDimensionIn;
		return this;
	}
	
	/**
	 * Set the FROM dimension ID for this Star Gate.
	 * 
	 * @param fromDimensionIn
	 * @return
	 */
	public Item setFromDimensionId(int fromDimensionIn) {
		this.fromDimensionId = fromDimensionIn;
		return this;
	}
	
	/**
	 * Set TO and FROM dimension IDs for this Star Gate.
	 * 
	 * @param toDimensionIn
	 * @param fromDimensionIn
	 * @return
	 */
	public Item setDimensions(int toDimensionIn, int fromDimensionIn) {
		this.setToDimensionId(toDimensionIn);
		this.setFromDimensionId(fromDimensionIn);
		return this;
	}
	
	/**
	 * Get the FROM dimension ID for this Star Gate.
	 * 
	 * @return
	 */
	public int getFromDimensionId() {
		return this.fromDimensionId;
	}
	
	/**
	 * Get the TO dimension ID for this Star Gate.
	 * 
	 * @return
	 */
	public int getToDimensionId() {
		return this.toDimensionId;
	}
	
	/**
	 * Override this method to make it appear in your own Creative Tab.
	 * It will appear in Zollern Galaxy's Items tab by default.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZGTabs.zgItemsTab;
	}
	
	/**
	 * If this is the ID returned for the dimension, it will consider it null and cancel it out.
	 * Override this method to use your own, if desired.
	 * 
	 * @return
	 */
	protected int getNullId() {
		return -1;
	}
	
	/**
	 * Do some basic null checking and then get ready to teleport the Player.
	 * 
	 * @param world
	 * @param player
	 */
	protected void teleportPlayer(World world, EntityPlayer player) {
		if (!ConfigManagerZG.disableStarGates) {
			if (this.getToDimensionId() != -1 && this.getFromDimensionId() != this.getNullId()) {
				this.sendToPlanet(player);
			} else {
				proxy.sendChatMessage(player, TextFormatting.DARK_RED + "Dimension IDs were invalid. Unable to teleport.");
			}
		} else {
			proxy.sendChatMessage(player, TextFormatting.DARK_RED + "Use of Star Gates has been disabled in the config.");
		}
	}
	
	/**
	 * Prepares to send the Player to the appropriate dimension (remember to set them!).
	 * If the Player is not at the destination dimension, send them there.
	 * If they are there, send them to the other set dimension.
	 * 
	 * @param player
	 */
	protected void sendToPlanet(EntityPlayer player) {
		int toDim = this.getToDimensionId();
		int fromDim = this.getFromDimensionId();
		int playerDim = player.dimension;
		
		if (playerDim != toDim) {
			this.sendToServer(toDim, player);
		} else {
			this.sendToServer(fromDim, player);
		}
	}
	
	/**
	 * This does the actual teleportation: it sends the IMessage to the Simple Network Wrapper to
	 * change the Player's dimension.
	 * Override this method to use your own way, if desired.
	 * 
	 * @param dimId
	 * @param player
	 */
	protected void sendToServer(int dimId, EntityPlayer player) {
		int playerId = player.getEntityId();
		boolean canTP = true;
		
		if (canTP) {
			this.snw.sendToServer(new MessageTeleportToDimension(dimId, playerId));
		}
	}
	
	/**
	 * Calls the teleportPlayer() method.
	 * Override this method with your own, if desired.
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		this.teleportPlayer(worldIn, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	/**
	 * Override to provide your own information.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate("tooltips.stargate"));
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate("tooltips.stargate2"));
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate("tooltips.stargate3"));
		} else {
			tooltip.add(TextFormatting.GOLD + ZGUtils.translate("tooltips.holdshift"));
		}
	}
}