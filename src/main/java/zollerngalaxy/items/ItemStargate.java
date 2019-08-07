package zollerngalaxy.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
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
		int playerId = player.getEntityId();
		
		switch (this.gateTier) {
		default:
			this.proxy.sendChatMessage(player, "This tier isn't functional yet.");
		case 0:
			this.proxy.sendChatMessage(player,
					"Unknown tier detected; unable to transfer biological entity.");
			break;
		case 1:
			if (player.dimension == ConfigManagerZG.planetZollusDimensionId) {
				this.sendToServer(ConfigManagerZG.planetKriffonDimensionId, playerId);
			} else {
				this.sendToServer(ConfigManagerZG.planetZollusDimensionId, playerId);
			}
			break;
		case 2:
			if (player.dimension == ConfigManagerZG.planetKriffonDimensionId) {
				this.sendToServer(ConfigManagerZG.planetPurgotDimensionId, playerId);
			} else {
				this.sendToServer(ConfigManagerZG.planetKriffonDimensionId, playerId);
			}
			break;
		case 3:
			if (player.dimension == ConfigManagerZG.planetPurgotDimensionId) {
				this.sendToServer(ConfigManagerZG.planetEdenDimensionId, playerId);
			} else {
				this.sendToServer(ConfigManagerZG.planetPurgotDimensionId, playerId);
			}
			break;
		}
		// TODO: Add more planets and moons! To be continued...
	}
	
	private void sendToServer(int dimId, int playerId) {
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
}