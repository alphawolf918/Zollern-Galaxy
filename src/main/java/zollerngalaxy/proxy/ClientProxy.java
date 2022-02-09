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
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.fluids.IZGFluidModel;
import zollerngalaxy.core.renderers.ZGItemRender;
import zollerngalaxy.events.ZGSkyProviderHandler;
import zollerngalaxy.gui.GuiHUD;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.MobRenders;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.tileentities.TileEntityTier10TreasureChestZG;
import zollerngalaxy.tileentities.TileEntityTier4TreasureChestZG;
import zollerngalaxy.tileentities.renderers.TileEntityTier10TreasureChestZGRenderer;
import zollerngalaxy.tileentities.renderers.TileEntityTier4TreasureChestZGRenderer;
import zollerngalaxy.util.ClientUtilsZG;
import zollerngalaxy.util.RegisterUtilsZG;
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
		RegisterUtilsZG.registerEventHandler(this);
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void renderBlocksTileEntitySpecialRenderers() {
		ClientUtilsZG.registerTileEntityRenderer(TileEntityTier10TreasureChestZG.class, new TileEntityTier10TreasureChestZGRenderer());
		ClientUtilsZG.registerTileEntityRenderer(TileEntityTier4TreasureChestZG.class, new TileEntityTier4TreasureChestZGRenderer());
	}
	
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event) {
		this.renderBlocksTileEntitySpecialRenderers();
	}
}