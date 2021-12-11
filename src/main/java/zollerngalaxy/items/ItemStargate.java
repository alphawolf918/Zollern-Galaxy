/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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
import zollerngalaxy.compatibility.PlanetProgressionCompat;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.network.teleporter.MessageTeleportToDimension;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;

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
		if (!ConfigManagerZG.disableStarGates) {
			switch (this.gateTier) {
				default:
					this.proxy.sendChatMessage(player, ZGUtils.translate("tooltips.protocolnotfunctional"));
					break;
				case 0:
					this.proxy.sendChatMessage(player, ZGUtils.translate("tooltips.unknownprotocol"));
					break;
				case 1:
					this.sendToPlanet(ConfigManagerZG.planetKriffonDimensionId, ConfigManagerZG.planetZollusDimensionId, player);
					break;
				case 2:
					this.sendToPlanet(ConfigManagerZG.planetPurgotDimensionId, ConfigManagerZG.planetKriffonDimensionId, player);
					break;
				case 3:
					if (player.dimension == ConfigManagerZG.planetExodusDimensionId) {
						this.sendToPlanet(ConfigManagerZG.planetVortexDimensionId, ConfigManagerZG.planetExodusDimensionId, player);
					} else {
						this.sendToPlanet(ConfigManagerZG.planetPurgotDimensionId, ConfigManagerZG.planetEdenDimensionId, player);
					}
					break;
				case 4:
					this.sendToPlanet(ConfigManagerZG.planetXathiusDimensionId, ConfigManagerZG.planetEdenDimensionId, player);
					break;
				case 5:
					this.sendToPlanet(ConfigManagerZG.planetOasisDimensionId, ConfigManagerZG.planetXathiusDimensionId, player);
					break;
				case 6:
					this.sendToPlanet(ConfigManagerZG.planetXantheonDimensionId, ConfigManagerZG.planetOasisDimensionId, player);
					break;
				case 7:
					this.sendToPlanet(ConfigManagerZG.planetAtheonDimensionId, ConfigManagerZG.planetXantheonDimensionId, player);
					break;
				case 8:
					this.sendToPlanet(ConfigManagerZG.planetPerditaDimensionId, ConfigManagerZG.planetAtheonDimensionId, player);
					break;
				case 9:
					this.sendToPlanet(ConfigManagerZG.planetAltumDimensionId, ConfigManagerZG.planetPerditaDimensionId, player);
					break;
				case 10:
					this.sendToPlanet(ConfigManagerZG.planetCaligroDimensionId, ConfigManagerZG.planetAltumDimensionId, player);
					break;
				case 918:
					// TODO: Make other planet a random destination of previous
					// planets.
					this.sendToPlanet(ConfigManagerZG.planetCandoraDimensionId, ConfigManagerZG.planetOasisDimensionId, player);
					break;
			}
		} else {
			proxy.sendChatMessage(player, TextFormatting.DARK_RED + "Use of Star Gates has been disabled in the config.");
		}
	}
	
	private void sendToServer(int dimId, EntityPlayer player) {
		int playerId = player.getEntityId();
		CelestialBody destination = ZGDimensions.getCelestialBodyByID(dimId);
		
		boolean canTP = true;
		String txtFormat = TextFormatting.BOLD + " " + TextFormatting.DARK_RED;
		String bodyName = destination.getLocalizedName();
		String msg = "Unable to teleport; " + bodyName + " not yet discovered.";
		msg += " Could not locate destination on galaxy map.";
		
		// Thank you MJRLegends
		if (ModHelperBase.usePlanetProgression && ConfigManagerZG.enablePlanetProgressionsCompat) {
			if (player instanceof EntityPlayerMP) {
				EntityPlayerMP playerMP = (EntityPlayerMP) player;
				if (!PlanetProgressionCompat.hasResearched(playerMP, destination)) {
					canTP = false;
					proxy.sendChatMessage(player, msg);
				}
			}
		}
		
		if (canTP) {
			this.snw.sendToServer(new MessageTeleportToDimension(dimId, playerId));
		}
	}
	
	private void sendToPlanet(int toDimensionId, int fromDimensionId, EntityPlayer player) {
		int dim = player.dimension;
		int sendToDim = (dim == fromDimensionId) ? toDimensionId : fromDimensionId;
		if (toDimensionId == ConfigManagerZG.planetEdenDimensionId && dim == ConfigManagerZG.planetExodusDimensionId) {
			sendToDim = ConfigManagerZG.planetVortexDimensionId;
		}
		this.sendToServer(sendToDim, player);
	}
	
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