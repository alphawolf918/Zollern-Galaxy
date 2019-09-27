package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.models.ModelGrayAlien;

@SideOnly(Side.CLIENT)
public class RenderGrayAlien extends RenderLiving<EntityGrayAlien> {
	
	private ModelGrayAlien model;
	private static float f6 = 0.6F;
	
	public RenderGrayAlien(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelGrayAlien(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityGrayAlien entitylivingbaseIn, float partialTickTime) {
		this.scaleGrayAlien(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleGrayAlien(EntityGrayAlien par1EntityGrayAlien, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGrayAlien entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/grayalien.png");
	}
	
}