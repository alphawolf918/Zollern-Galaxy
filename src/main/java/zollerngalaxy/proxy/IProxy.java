package zollerngalaxy.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
	
	public void preInit(FMLPreInitializationEvent event);
	
	public void init(FMLInitializationEvent event);
	
	public void postInit(FMLPostInitializationEvent event);
	
	public void initGUI();
	
	public void doPotionEffect(EntityPlayer player, Potion potionId);
	
	public void sendChatMessage(EntityPlayer player, String message);
	
	public Minecraft getMinecraft();
}