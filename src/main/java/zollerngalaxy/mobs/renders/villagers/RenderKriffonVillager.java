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
import zollerngalaxy.mobs.entities.villagers.EntityKriffonVillager;
import zollerngalaxy.mobs.models.villagers.ModelKriffonVillager;

@SideOnly(Side.CLIENT)
public class RenderKriffonVillager extends RenderLiving<EntityKriffonVillager> {
	
	private static final ResourceLocation villagerTexture = new ResourceLocation(ZGInfo.MOD_ID, "textures/entity/villagers/kriffonvillager.png");
	private boolean texSwitch;
	
	protected ModelKriffonVillager villagerModel;
	
	public RenderKriffonVillager(RenderManager manager) {
		super(manager, new ModelKriffonVillager(), 0.5F);
		this.villagerModel = (ModelKriffonVillager) this.mainModel;
	}
	
	@Override
	protected void preRenderCallback(EntityKriffonVillager villager, float par2) {
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
	protected ResourceLocation getEntityTexture(EntityKriffonVillager par1Entity) {
		return texSwitch ? OverlaySensorGlasses.altTexture : RenderKriffonVillager.villagerTexture;
	}
	
	@Override
	public void doRender(EntityKriffonVillager villager, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(villager, par2, par4, par6, par8, par9);
		if (OverlaySensorGlasses.overrideMobTexture()) {
			texSwitch = true;
			super.doRender(villager, par2, par4, par6, par8, par9);
			texSwitch = false;
			OverlaySensorGlasses.postRenderMobs();
		}
	}
}
