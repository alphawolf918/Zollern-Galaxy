package galaxymod.items.food;

import galaxymod.ProjectNovaCore;
import galaxymod.lib.NovaHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class RawFood extends ItemFood {
	public RawFood(String strTexture) {
		super(2, 2F, false);
		NovaHelper.setTab(this);
		NovaHelper.setNameAndTexture(this, strTexture);
		setMaxStackSize(64);
		this.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ProjectNovaCore.novaTabItems;
	}
}