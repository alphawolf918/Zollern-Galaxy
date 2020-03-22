/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib.helpers;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.input.Keyboard;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.ZGInfo;
import com.google.common.base.Function;

public class CommonZGRegisterHelper {
	
	public static Map<Block, String> SINGLE_BLOCK_RENDER_LIST = new HashMap<>();
	public static Map<Item, String> SINGLE_ITEM_RENDER_LIST = new HashMap<>();
	
	public static void registerBlock(Block block) {
		CommonZGRegisterHelper.registerBlock(block, ItemBlock::new);
	}
	
	public static void registerBlock(Block block, @Nullable Function<Block, ItemBlock> itemBlock) {
		String name = block.getUnlocalizedName().substring(5);
		ForgeRegistries.BLOCKS.register(block.setRegistryName(name));
		
		if (block instanceof ISingleZGBlockRender) {
			ISingleZGBlockRender blockRender = (ISingleZGBlockRender) block;
			
			if (blockRender.getName() != null) {
				CommonZGRegisterHelper.SINGLE_BLOCK_RENDER_LIST.put(block, name);
			}
		}
		if (itemBlock != null) {
			ForgeRegistries.ITEMS.register(itemBlock.apply(block).setRegistryName(block.getRegistryName()));
		}
	}
	
	public static void registerItem(Item item) {
		String name = item.getUnlocalizedName().substring(5);
		item.setRegistryName(name);
		ForgeRegistries.ITEMS.register(item);
		
		if (item instanceof ISingleZGItemRender) {
			ISingleZGItemRender itemRender = (ISingleZGItemRender) item;
			
			if (itemRender.getName() != null) {
				CommonZGRegisterHelper.SINGLE_ITEM_RENDER_LIST.put(item, name);
			}
		}
	}
	
	public static void registerBiome(Biome biome) {
		ForgeRegistries.BIOMES.register(biome);
	}
	
	public static void registerBiomeType(Biome biome, @Nonnull BiomeDictionary.Type... biomeType) {
		BiomeDictionary.addTypes(biome, biomeType);
	}
	
	public static void registerForgeBucket(Fluid fluid) {
		FluidRegistry.addBucketForFluid(fluid);
	}
	
	public static void setFireBurn(Block block, int encouragement, int flammibility) {
		Blocks.FIRE.setFireInfo(block, encouragement, flammibility);
	}
	
	public static void registerCarriable(Block block) {
		EntityEnderman.setCarriable(block, true);
	}
	
	public static void registerOreDictionary(String name, Block block) {
		OreDictionary.registerOre(name, block);
	}
	
	public static void registerOreDictionary(String name, Item item) {
		OreDictionary.registerOre(name, item);
	}
	
	public static void registerOreDictionary(String name, ItemStack itemStack) {
		OreDictionary.registerOre(name, itemStack);
	}
	
	public static boolean isClient() {
		return FMLCommonHandler.instance().getSide() == Side.CLIENT;
	}
	
	public static boolean isEffectiveClient() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}
	
	public static boolean isShiftKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
	}
	
	public static boolean isControlKeyDown() {
		return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
	}
	
	public static String ticksToElapsedTime(int ticks) {
		int i = ticks / 20;
		int j = i / 60;
		i = i % 60;
		return i < 10 ? j + ":0" + i : j + ":" + i;
	}
	
	public static ResourceLocation registerEntityLoot(String name) {
		return LootTableList.register(new ResourceLocation(ZGInfo.MOD_ID + ":entities/" + name));
	}
	
	public static ResourceLocation registerChestLoot(String name) {
		return LootTableList.register(new ResourceLocation(ZGInfo.MOD_ID + ":chests/" + name));
	}
	
	public static ResourceLocation registerGameplayLoot(String name) {
		return LootTableList.register(new ResourceLocation(ZGInfo.MOD_ID + ":gameplay/" + name));
	}
}