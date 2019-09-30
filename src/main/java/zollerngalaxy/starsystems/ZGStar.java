package zollerngalaxy.starsystems;

import micdoodle8.mods.galacticraft.api.galaxies.Star;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.lib.ZGInfo;

public class ZGStar extends Star {
	
	public ZGStar(String starName) {
		super(starName);
		this.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/" + starName + ".png"));
		this.setTierRequired(-1);
	}
}