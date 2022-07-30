/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.infected;

import net.minecraft.item.Item;
import zollerngalaxy.blocks.ZGOreGem;

public class ZGOreGemInfected extends ZGOreGem implements IInfectedBlock {
	
	public ZGOreGemInfected(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist, gemItem);
	}
}