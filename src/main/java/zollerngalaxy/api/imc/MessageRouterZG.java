/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.api.imc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import zollerngalaxy.lib.helpers.ZGHelper;

public class MessageRouterZG {
	
	protected static Map<String, Method> handlers = new HashMap<String, Method>();
	
	public static void route(FMLInterModComms.IMCEvent event) {
		for (FMLInterModComms.IMCMessage message : event.getMessages()) {
			Method handler = handlers.get(message.key);
			if (handler != null) {
				try {
					handler.invoke(message);
				} catch (IllegalAccessException e) {
					ZGHelper.LogWarn("IllegalAccessException while handling message <" + message.key + ">, ignoring. Error: " + e.getMessage());
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					ZGHelper.LogWarn("IllegalArgumentException while handling message <" + message.key + ">, ignoring. Error: " + e.getMessage());
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					ZGHelper.LogWarn("InvocationTargetException while handling message <" + message.key + ">, ignoring. Error: " + e.getMessage());
					e.printStackTrace();
				}
			} else {
				ZGHelper.LogWarn("Received an InterModComms event with an unrecognized key <" + message.key + ">");
			}
		}
	}
	
	public static void register(String key, Method handler) {
		handlers.put(key, handler);
	}
	
}