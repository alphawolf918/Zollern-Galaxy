package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ItemHUD extends ZGItemBase {
	
	public ItemHUD() {
		super("hud");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip,
			ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + "Shows all planetary");
			tooltip.add(TextFormatting.ITALIC + "and biome data.");
			tooltip.add(TextFormatting.ITALIC + "Only works when held.");
		} else {
			tooltip.add("Hold LSHIFT for more information.");
		}
	}
}