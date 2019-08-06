package zollerngalaxy.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemStargate extends ZGItemBase {
	
	private int gateTier = 1;
	
	public ItemStargate(int tier) {
		super("stargate_tier" + tier);
		this.gateTier = tier;
	}
	
	public void teleportPlayer(World world, EntityPlayer player) {
		// TODO
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,
			EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		this.teleportPlayer(worldIn, playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
}