package zollerngalaxy.util;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

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
				System.err.println(ret);
			}
		}
		return ret;
	}
	
}
