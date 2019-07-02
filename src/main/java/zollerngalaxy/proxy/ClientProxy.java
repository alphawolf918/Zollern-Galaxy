package zollerngalaxy.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zollerngalaxy.lib.helpers.ZollernHelper;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		ZollernHelper.addChatMessage(player, message);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
	}
	
	@Override
	public void initGUI() {
		
	}
	
	@Override
	public Minecraft getMinecraft() {
		return this.mc;
	}
}