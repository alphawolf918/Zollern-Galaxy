package zollerngalaxy.mobs.entities.projectiles.render;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.projectiles.EntitySentinelGunShot;
import zollerngalaxy.mobs.models.projectiles.ModelSentinelGunShot;

@SideOnly(Side.CLIENT)
public class RenderSentinelGunShot extends Render<EntitySentinelGunShot> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(ZGInfo.MOD_ID, "textures/entity/projectiles/sentinelshot.png");
	private final ModelSentinelGunShot model = new ModelSentinelGunShot();
	
	float f6 = 2.0F;
	
	public RenderSentinelGunShot(RenderManager manager) {
		super(manager);
	}
	
	@Override
	public void doRender(EntitySentinelGunShot entity, double x, double y, double z, float entityYaw, float partialTicks) {
		float lightMapSaveX = OpenGlHelper.lastBrightnessX;
		float lightMapSaveY = OpenGlHelper.lastBrightnessY;
		float red = 255.0F, green = 0.0F, blue = 0.0F;
		this.bindEntityTexture(entity);
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 90.0F, 0.0F, 1.0F);
		this.scaleSentinel(entity, f6);
		
		GlStateManager.color(red / 255.0F, green / 255.0F, blue / 255.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
		GlStateManager.disableLighting();
		this.bindEntityTexture(entity);
		GlStateManager.enableBlend();
		this.model.renderSentinelShot();
		GlStateManager.disableBlend();
		
		GlStateManager.enableBlend();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightMapSaveX, lightMapSaveY);
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
	}
	
	protected void scaleSentinel(EntitySentinelGunShot par1EntitySentinel, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntitySentinelGunShot entity) {
		return RenderSentinelGunShot.TEXTURE;
	}
}