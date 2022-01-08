package zollerngalaxy.mobs.renders;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityVexBotGold;
import zollerngalaxy.mobs.models.ModelVexbot;

@SideOnly(Side.CLIENT)
public class RenderVexbotGold extends RenderLiving<EntityVexBotGold> {
	
	private static final float f6 = 1.0F;
	
	private static final ResourceLocation VEXBOT_GOLDEN_TEXTURE = new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/vexbot_gold.png");
	
	public RenderVexbotGold(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVexbot(), 2.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityVexBotGold entitylivingbaseIn, float partialTickTime) {
		this.scaleVexBot(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleVexBot(EntityVexBotGold par1EntityVexbox, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVexBotGold entity) {
		return VEXBOT_GOLDEN_TEXTURE;
	}
}