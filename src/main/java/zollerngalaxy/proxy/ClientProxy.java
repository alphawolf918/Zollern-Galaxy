/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import zollerngalaxy.blocks.fluids.IZGFluidModel;
import zollerngalaxy.core.renderers.ZGItemRender;
import zollerngalaxy.events.ZGSkyProviderHandler;
import zollerngalaxy.gui.GuiHUD;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.MobRenders;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.util.ZGDamageSrc;

public class ClientProxy extends CommonProxy {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	
	private static List<IZGFluidModel> modelRegisters = new ArrayList();
	
	@Override
	public void registerInitRendering() {
		BlockColors colors = mc.getBlockColors();
		ZGItemRender.init();
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MobRenders.init();
		
		for (IZGFluidModel model : modelRegisters) {
			model.registerModels();
		}
		
		MinecraftForge.EVENT_BUS.register(new ZGSkyProviderHandler());
		OBJLoader.INSTANCE.addDomain(ZGInfo.MOD_ID);
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
	public boolean addIModelRegister(IZGFluidModel model) {
		return modelRegisters.add(model);
	}
	
	@Override
	public void doPotionEffect(EntityPlayer player, Potion potionId) {
		if (potionId == ZGPotions.infected) {
			player.attackEntityFrom(ZGDamageSrc.deathInfection, ZGDamageSrc.deathInfection.getDamageBase());
		}
		
		if (potionId == ZGPotions.corruption) {
			ZGHelper.performBlueprintCheck(new Random(), ZGItems.blueprintCorruption, player, ZGDamageSrc.deathCorruption);
		}
	}
}