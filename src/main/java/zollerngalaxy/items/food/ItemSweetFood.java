package zollerngalaxy.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSweetFood extends ZGItemFood {
	
	protected Potion mobEffect = null;
	
	public ItemSweetFood(String name, Potion potionIn) {
		super(name, 4, 6, false);
		this.setAlwaysEdible();
		this.mobEffect = potionIn;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote && this.mobEffect != null) {
			player.addPotionEffect(new PotionEffect(mobEffect, 360, 2, true, false));
		}
	}
}