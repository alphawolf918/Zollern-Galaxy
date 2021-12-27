/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.lib.helpers;

import net.minecraft.init.Items;
import zollerngalaxy.config.ConfigManagerZG;

public class StackModHelper {
	
	public static void init() {
		if (ConfigManagerZG.enableStackChanges) {
			Items.SADDLE.setMaxStackSize(64);
			Items.ENDER_PEARL.setMaxStackSize(64);
			Items.BUCKET.setMaxStackSize(64);
			Items.SNOWBALL.setMaxStackSize(64);
			Items.SIGN.setMaxStackSize(64);
		}
	}
}