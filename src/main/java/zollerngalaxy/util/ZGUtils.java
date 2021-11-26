/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util;

import org.apache.logging.log4j.Level;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGUtils {
	
	public static boolean isClient() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT;
	}
	
	public static boolean isServer() {
		return FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER;
	}
	
	public static Minecraft getClient() {
		return FMLClientHandler.instance().getClient();
	}
	
	public static MinecraftServer getServer() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}
	
	public static Minecraft getMinecraft() {
		return Minecraft.getMinecraft();
	}
	
	public static String translate(String key) {
		String result = I18n.translateToLocal(key);
		int comment = result.indexOf('#');
		String ret = (comment > 0) ? result.substring(0, comment).trim() : result;
		for (int i = 0; i < key.length(); ++i) {
			Character c = key.charAt(i);
			if (Character.isUpperCase(c)) {
				ZGHelper.Log(Level.ERROR, ret);
			}
		}
		return ret;
	}
	
	public static float ConvertFromZero(float valIn) {
		return ((valIn <= 0F) ? 0.1F : valIn);
	}
	
	public static double ConvertFromZero(double valIn) {
		return ((valIn <= 0D) ? 0.1D : valIn);
	}
}