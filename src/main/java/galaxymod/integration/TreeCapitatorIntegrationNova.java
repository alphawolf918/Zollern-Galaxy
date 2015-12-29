/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.integration;

import galaxymod.blocks.BlockList;
import galaxymod.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameData;

public class TreeCapitatorIntegrationNova {
	
	public static void init() {
		
		NBTTagCompound tpModCfg = new NBTTagCompound();
		NBTTagList treeList = new NBTTagList();
		NBTTagCompound tree = new NBTTagCompound();
		
		String edenWoodLog = blockName(BlockList.edenWoodLog);
		String edenWoodLeaves = blockName(BlockList.edenWoodLeaves);
		
		tpModCfg.setString("modID", ModInfo.MODID);
		
		// Edenwood Tree
		tree.setString("treeName", "edenwood");
		tree.setString("logs", String.format("%s, 0; %s, 4; %s, 8",
				edenWoodLog, edenWoodLog, edenWoodLog));
		tree.setString("leaves",
				String.format("%s, 0; %s, 8", edenWoodLeaves, edenWoodLeaves));
		tree.setBoolean("requireLeafDecayCheck", false);
		treeList.appendTag(tree);
		
		FMLInterModComms.sendMessage("TreeCapitator", "ThirdPartyModConfig",
				tpModCfg);
		FMLInterModComms.sendMessage("Treecapitator", "ThirdPartyModConfig",
				tpModCfg);
	}
	
	private static String blockName(Block block) {
		return GameData.getBlockRegistry().getNameForObject(block);
	}
	
	private static String itemName(Item item) {
		return GameData.getItemRegistry().getNameForObject(item);
	}
	
}