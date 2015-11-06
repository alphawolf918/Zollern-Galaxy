package galaxymod.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs {

	public static CreativeTabs ngTab;

	public static void init() {
		ngTab = new NGTab("NovaGalactic");
	}
}