/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.mobs.renders;

import galaxymod.mobs.entities.xathius.slimes.EntitySlimeRaspberry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSlimeRaspberry extends RenderLiving {
	
	private static final ResourceLocation slimeTextures = new ResourceLocation(
			"galaxymod:textures/entity/slimes/raspberryslime.png");
	private ModelBase scaleAmount;
	private static final String __OBFID = "CL_00001024";
	
	public RenderSlimeRaspberry(ModelBase p_i1267_1_, ModelBase p_i1267_2_,
			float p_i1267_3_) {
		super(p_i1267_1_, p_i1267_3_);
		this.scaleAmount = p_i1267_2_;
	}
	
	protected int shouldRenderPass(EntitySlimeRaspberry p_77032_1_,
			int p_77032_2_, float p_77032_3_) {
		if (p_77032_1_.isInvisible()) {
			return 0;
		} else if (p_77032_2_ == 0) {
			this.setRenderPassModel(this.scaleAmount);
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			return 1;
		} else {
			if (p_77032_2_ == 1) {
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
			
			return -1;
		}
	}
	
	protected void preRenderCallback(EntitySlimeRaspberry p_77041_1_,
			float p_77041_2_) {
		float f1 = p_77041_1_.getSlimeSize();
		float f2 = (p_77041_1_.prevSquishFactor + (p_77041_1_.squishFactor - p_77041_1_.prevSquishFactor)
				* p_77041_2_)
				/ (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		GL11.glScalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}
	
	protected ResourceLocation getEntityTexture(EntitySlimeRaspberry p_110775_1_) {
		return slimeTextures;
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase p_77041_1_,
			float p_77041_2_) {
		this.preRenderCallback((EntitySlimeRaspberry) p_77041_1_, p_77041_2_);
	}
	
	@Override
	protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_,
			float p_77032_3_) {
		return this.shouldRenderPass((EntitySlimeRaspberry) p_77032_1_,
				p_77032_2_, p_77032_3_);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntitySlimeRaspberry) p_110775_1_);
	}
}