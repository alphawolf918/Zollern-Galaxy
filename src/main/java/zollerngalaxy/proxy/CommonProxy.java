package zollerngalaxy.proxy;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy implements IProxy, IGuiHandler {
	
	@Override
	public void registerPreRendering() {
	}
	
	@Override
	public void registerPostRendering() {
	}
	
	@Override
	public void registerInitRendering() {
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@Override
	public void initGUI() {
		
	}
	
	@Override
	public Minecraft getMinecraft() {
		return null;
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		
	}
	
	@Override
	public void doPotionEffect(EntityPlayer player, Potion potionId) {
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}
	
	@Override
	public WorldProvider getWorldProviderForDimension(int dimID) {
		return WorldUtil.getProviderForDimensionServer(dimID);
	}
}