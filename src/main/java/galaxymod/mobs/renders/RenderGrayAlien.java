package galaxymod.mobs.renders;

import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.models.ModelGrayAlien;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderGrayAlien extends RenderLiving {
	public ModelGrayAlien model;
	float f6 = 0.6F;
	
	public RenderGrayAlien(ModelGrayAlien par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelGrayAlien) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("galaxymod:textures/entity/grey.png");
	}
	
	public void renderAlien(EntityGrayAlien entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderAlien((EntityGrayAlien) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderAlien((EntityGrayAlien) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleGrayAlien(EntityGrayAlien par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleGrayAlien((EntityGrayAlien) par1EntityLivingBase, par2);
	}
}