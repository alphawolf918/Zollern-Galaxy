package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ItemHUD extends ZGItemBase {
	
	public ItemHUD() {
		super("hud");
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add("Shows all planetary");
			tooltip.add("and biome data.");
			tooltip.add("Only works when held.");
		} else {
			tooltip.add("Hold LSHIFT for more information.");
		}
	}
}