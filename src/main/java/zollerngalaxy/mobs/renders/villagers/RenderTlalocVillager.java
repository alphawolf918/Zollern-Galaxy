/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.renders.villagers;

import org.lwjgl.opengl.GL11;
import micdoodle8.mods.galacticraft.core.client.gui.overlay.OverlaySensorGlasses;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.villagers.EntityTlalocVillager;
import zollerngalaxy.mobs.models.villagers.ModelTlalocVillager;

@SideOnly(Side.CLIENT)
public class RenderTlalocVillager extends RenderLiving<EntityTlalocVillager> {
	
	private static final ResourceLocation villagerTexture = new ResourceLocation(ZGInfo.MOD_ID, "textures/entity/villagers/tlalocvillager.png");
	private boolean texSwitch;
	
	protected ModelTlalocVillager villagerModel;
	
	public RenderTlalocVillager(RenderManager manager) {
		super(manager, new ModelTlalocVillager(), 0.5F);
		this.villagerModel = (ModelTlalocVillager) this.mainModel;
	}
	
	@Override
	protected void preRenderCallback(EntityTlalocVillager villager, float par2) {
		float f1 = 1.2375F;
		
		if (villager.getGrowingAge() < 0) {
			f1 = (float) (f1 * 0.5D);
			this.shadowSize = 0.25F;
		} else {
			this.shadowSize = 0.5F;
		}
		
		if (texSwitch) {
			OverlaySensorGlasses.preRenderMobs();
		}
		
		GL11.glScalef(f1, f1, f1);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTlalocVillager par1Entity) {
		return texSwitch ? OverlaySensorGlasses.altTexture : RenderTlalocVillager.villagerTexture;
	}
	
	@Override
	public void doRender(EntityTlalocVillager villager, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(villager, par2, par4, par6, par8, par9);
		if (OverlaySensorGlasses.overrideMobTexture()) {
			texSwitch = true;
			super.doRender(villager, par2, par4, par6, par8, par9);
			texSwitch = false;
			OverlaySensorGlasses.postRenderMobs();
		}
	}
}