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
import zollerngalaxy.mobs.entities.villagers.EntityCentotlVillager;
import zollerngalaxy.mobs.models.villagers.ModelCentotlVillager;

@SideOnly(Side.CLIENT)
public class RenderCentotlVillager extends RenderLiving<EntityCentotlVillager> {
	
	private static final ResourceLocation villagerTexture = new ResourceLocation(ZGInfo.MOD_ID, "textures/entity/villagers/centotlvillager.png");
	private boolean texSwitch;
	
	protected ModelCentotlVillager villagerModel;
	
	public RenderCentotlVillager(RenderManager manager) {
		super(manager, new ModelCentotlVillager(), 0.5F);
		this.villagerModel = (ModelCentotlVillager) this.mainModel;
	}
	
	@Override
	protected void preRenderCallback(EntityCentotlVillager villager, float par2) {
		float f1 = 1.5375F;
		
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
	protected ResourceLocation getEntityTexture(EntityCentotlVillager par1Entity) {
		return texSwitch ? OverlaySensorGlasses.altTexture : RenderCentotlVillager.villagerTexture;
	}
	
	@Override
	public void doRender(EntityCentotlVillager villager, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(villager, par2, par4, par6, par8, par9);
		if (OverlaySensorGlasses.overrideMobTexture()) {
			texSwitch = true;
			super.doRender(villager, par2, par4, par6, par8, par9);
			texSwitch = false;
			OverlaySensorGlasses.postRenderMobs();
		}
	}
}
