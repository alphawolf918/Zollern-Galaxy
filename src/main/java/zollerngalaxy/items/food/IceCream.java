package zollerngalaxy.items.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IceCream extends ItemSweetFood {
	
	public IceCream() {
		super("icecream", MobEffects.FIRE_RESISTANCE);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(Items.BOWL);
	}
	
}