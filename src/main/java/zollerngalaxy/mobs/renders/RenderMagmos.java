package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.mobs.models.ModelMagmos;

@SideOnly(Side.CLIENT)
public class RenderMagmos extends RenderLiving<EntityMagmos> {
	
	private ModelMagmos model;
	private static float f6 = 1.4F;
	
	public RenderMagmos(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelMagmos(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityMagmos entitylivingbaseIn, float partialTickTime) {
		this.scaleMagmos(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleMagmos(EntityMagmos par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMagmos entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/magmos.png");
	}
	
}