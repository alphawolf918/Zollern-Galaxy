/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks.renderers.eden;

import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import micdoodle8.mods.galacticraft.core.client.model.block.ModelTreasureChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityRendererEdenTreasureChest extends
		TileEntitySpecialRenderer {
	
	private static final ResourceLocation treasureChestTexture = new ResourceLocation(
			"galaxymod:textures/model/edentreasurechest.png");
	
	private final ModelTreasureChest chestModel = new ModelTreasureChest();
	
	public void renderTileEntityTreasureChestAt(
			TileEntityTreasureChestEden par1TreasureChest, double par2,
			double par4, double par6, float par8) {
		int var9;
		
		if (!par1TreasureChest.hasWorldObj()) {
			var9 = 0;
		} else {
			par1TreasureChest.getBlockType();
			var9 = par1TreasureChest.getBlockMetadata();
		}
		
		ModelTreasureChest var14 = null;
		
		var14 = this.chestModel;
		this.bindTexture(TileEntityRendererEdenTreasureChest.treasureChestTexture);
		
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.0F,
				(float) par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
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
		
		GL11.glRotatef(var11, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float var12 = par1TreasureChest.prevLidAngle
				+ (par1TreasureChest.lidAngle - par1TreasureChest.prevLidAngle)
				* par8;
		
		var12 = 1.0F - var12;
		var12 = 1.0F - var12 * var12 * var12;
		
		if (var14 != null) {
			var14.chestLid.rotateAngleX = -(var12 * (float) Math.PI / 4.0F);
			var14.renderAll(!par1TreasureChest.locked);
		}
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2,
			double par4, double par6, float par8) {
		this.renderTileEntityTreasureChestAt(
				(TileEntityTreasureChestEden) par1TileEntity, par2, par4, par6,
				par8);
	}
}