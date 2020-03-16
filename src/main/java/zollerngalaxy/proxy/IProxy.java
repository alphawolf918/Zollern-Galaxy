/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import zollerngalaxy.blocks.fluids.IZGFluidModel;

public interface IProxy {
	
	public void registerPreRendering();
	
	public void preInit(FMLPreInitializationEvent event);
	
	public void init(FMLInitializationEvent event);
	
	public void registerInitRendering();
	
	public void postInit(FMLPostInitializationEvent event);
	
	public void registerPostRendering();
	
	public void initGUI();
	
	public void doPotionEffect(EntityPlayer player, Potion potionId);
	
	public void sendChatMessage(EntityPlayer player, String message);
	
	public Minecraft getMinecraft();
	
	public EntityPlayer getPlayerEntity(MessageContext ctx);
	
	public boolean addIModelRegister(IZGFluidModel model);
}