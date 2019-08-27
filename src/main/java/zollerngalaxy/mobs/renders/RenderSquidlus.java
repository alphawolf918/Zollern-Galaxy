package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.models.ModelSquidlus;

@SideOnly(Side.CLIENT)
public class RenderSquidlus extends RenderLiving<EntitySquidlus> {
	
	private ModelSquidlus model;
	private static float f6 = 2.6F;
	
	public RenderSquidlus(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSquidlus(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntitySquidlus entitylivingbaseIn, float partialTickTime) {
		this.scaleSquidlus(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleSquidlus(EntitySquidlus par1Entity, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySquidlus entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/squidlus.png");
	}
	
}