package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.mobs.models.ModelXenomorph;

@SideOnly(Side.CLIENT)
public class RenderXenomorph extends RenderLiving<EntityXenomorph> {
	
	private static final float f6 = 2.0F;
	
	private static final ResourceLocation XENO_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/xenomorph.png");
	
	public RenderXenomorph(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelXenomorph(), 2.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityXenomorph entitylivingbaseIn, float partialTickTime) {
		this.scaleXenomorph(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleXenomorph(EntityXenomorph par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityXenomorph entity) {
		return XENO_TEXTURE;
	}
}