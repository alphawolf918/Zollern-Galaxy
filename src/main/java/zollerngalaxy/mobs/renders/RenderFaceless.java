package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityFaceless;
import zollerngalaxy.mobs.models.ModelFaceless;

@SideOnly(Side.CLIENT)
public class RenderFaceless extends RenderBiped<EntityFaceless> {
	
	// private static final float f6 = 1.6F;
	
	private static final ResourceLocation FACELESS_TEXTURES = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/faceless.png");
	
	public RenderFaceless(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelFaceless(), 0.5F);
	}
	
	// @Override
	// protected void preRenderCallback(EntityFaceless entitylivingbaseIn, float partialTickTime) {
	// this.scaleFaceless(entitylivingbaseIn, partialTickTime);
	// }
	//
	// protected void scaleFaceless(EntityFaceless par1EntityFaceless, float par2) {
	// GL11.glScalef(f6, f6, f6);
	// }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFaceless entity) {
		return FACELESS_TEXTURES;
	}
}