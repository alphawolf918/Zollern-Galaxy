/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.tileentities.renderers;

import micdoodle8.mods.galacticraft.core.client.model.block.ModelTreasureChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.tileentities.TileEntityTier10TreasureChestZG;

@SideOnly(Side.CLIENT)
public class TileEntityTier10TreasureChestZGRenderer extends TileEntitySpecialRenderer<TileEntityTier10TreasureChestZG> {
	
	private static final ResourceLocation treasureChestTexture = new ResourceLocation(ZGInfo.MOD_ID, "textures/models/treasure_chest_tlaloc.png");
	
	private final ModelTreasureChest chestModel = new ModelTreasureChest();
	
	@Override
	public void render(TileEntityTier10TreasureChestZG chest, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		int var9;
		
		if (!chest.hasWorld()) {
			var9 = 0;
		} else {
			var9 = chest.getBlockMetadata();
		}
		
		ModelTreasureChest var14 = null;
		
		var14 = this.chestModel;
		this.bindTexture(TileEntityTier10TreasureChestZGRenderer.treasureChestTexture);
		
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		GlStateManager.translate(0.5F, 0.5F, 0.5F);
		short var11 = 0;
		
		if (var9 == 2) {
			var11 = 180;
		}
		
		if (var9 == 3) {
			var11 = 0;
		}
		
		if (var9 == 4) {
			var11 = 90;
		}
		
		if (var9 == 5) {
			var11 = -90;
		}
		
		GlStateManager.rotate(var11, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, -0.5F, -0.5F);
		float var12 = chest.prevLidAngle + (chest.lidAngle - chest.prevLidAngle) * partialTicks;
		
		var12 = 1.0F - var12;
		var12 = 1.0F - var12 * var12 * var12;
		
		if (var14 != null) {
			var14.chestLid.rotateAngleX = -(var12 * ZGInfo.quarterPI);
			var14.renderAll(!chest.locked);
		}
		
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	}
}