package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.models.ModelOinkus;

@SideOnly(Side.CLIENT)
public class RenderOinkus extends RenderLiving<EntityOinkus> {
	
	private ModelOinkus model;
	private static float f6 = 1.7F;
	
	public RenderOinkus(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelOinkus(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityOinkus entitylivingbaseIn, float partialTickTime) {
		this.scaleOinkus(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleOinkus(EntityOinkus par1EntityOinkus, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityOinkus entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/oinkus.png");
	}
	
}