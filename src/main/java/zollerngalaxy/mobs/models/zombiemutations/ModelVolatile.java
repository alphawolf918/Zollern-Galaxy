/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.models.zombiemutations;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelVolatile extends ModelBiped {
	
	public ModelVolatile() {
		this(0.0F, false);
	}
	
	protected ModelVolatile(float par1, float par2, int par3, int par4) {
		super(par1, par2, par3, par4);
	}
	
	public ModelVolatile(float par1, boolean par2) {
		super(par1, 0.0F, 64, 32);
	}
	
}