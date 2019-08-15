package zollerngalaxy.proxy;

import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import zollerngalaxy.core.renderers.ZGItemRender;
import zollerngalaxy.gui.GuiHUD;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.MobRenders;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void registerInitRendering() {
		BlockColors colors = mc.getBlockColors();
		
		ZGItemRender.init();
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MobRenders.init();
	}
	
	@Override
	public void sendChatMessage(EntityPlayer player, String message) {
		ZGHelper.addChatMessage(player, message);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		this.initGUI();
	}
	
	@Override
	public void initGUI() {
		MinecraftForge.EVENT_BUS.register(new GuiHUD(this.getMinecraft()));
	}
	
	@Override
	public Minecraft getMinecraft() {
		return this.mc;
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.side.isClient() ? this.getMinecraft().player : super.getPlayerEntity(ctx);
	}
	
	@Override
	public WorldProvider getWorldProviderForDimension(int dimID) {
		return WorldUtil.getProviderForDimensionClient(dimID);
	}
}