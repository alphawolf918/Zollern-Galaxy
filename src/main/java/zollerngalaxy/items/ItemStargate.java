package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
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
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.network.teleporter.MessageTeleportToDimension;
import zollerngalaxy.proxy.IProxy;

public class ItemStargate extends ZGItemBase {
	
	private int gateTier = 0;
	private SimpleNetworkWrapper snw = ZollernGalaxyCore.snw;
	private IProxy proxy = ZollernGalaxyCore.proxy;
	
	public ItemStargate(int tier) {
		super("stargate_tier" + tier);
		this.setMaxStackSize(1);
		this.gateTier = tier;
	}
	
	private void teleportPlayer(World world, EntityPlayer player) {
		int dim = player.dimension;
		
		CelestialBody destination = ZGDimensions.getPlanetFromDimID(dim);
		
		switch (this.gateTier) {
		default:
			this.proxy.sendChatMessage(player, "This tier isn't functional yet.");
			break;
		case 0:
			this.proxy.sendChatMessage(player,
					"Unknown tier detected; unable to transfer biological entity.");
			break;
		case 1:
			if (dim == ConfigManagerZG.planetZollusDimensionId) {
				this.sendToServer(ConfigManagerZG.planetKriffonDimensionId, player, destination);
			} else {
				this.sendToServer(ConfigManagerZG.planetZollusDimensionId, player, destination);
			}
			break;
		case 2:
			if (dim == ConfigManagerZG.planetKriffonDimensionId) {
				this.sendToServer(ConfigManagerZG.planetPurgotDimensionId, player, destination);
			} else {
				this.sendToServer(ConfigManagerZG.planetKriffonDimensionId, player, destination);
			}
			break;
		case 3:
			if (dim == ConfigManagerZG.planetPurgotDimensionId) {
				this.sendToServer(ConfigManagerZG.planetEdenDimensionId, player, destination);
			} else {
				this.sendToServer(ConfigManagerZG.planetPurgotDimensionId, player, destination);
			}
			break;
		}
		// TODO: Add more planets and moons! To be continued...
	}
	
	private void sendToServer(int dimId, EntityPlayer player, CelestialBody destination) {
		int playerId = player.getEntityId();
		this.snw.sendToServer(new MessageTeleportToDimension(dimId, playerId));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,
			EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		this.teleportPlayer(worldIn, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip,
			ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + "A gateway between two");
			tooltip.add(TextFormatting.ITALIC + "worlds, moving the Player");
			tooltip.add(TextFormatting.ITALIC + "through space and time.");
		} else {
			tooltip.add("Hold LSHIFT for more information.");
		}
	}
}