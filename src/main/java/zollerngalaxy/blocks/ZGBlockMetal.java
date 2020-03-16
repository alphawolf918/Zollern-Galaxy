/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockMetal extends ZGBlockBase {
	
	public ZGBlockMetal(String strTexture) {
		super(strTexture, 2.4F);
		this.setMaterial(Material.IRON);
		this.setSoundType(SoundType.METAL);
		this.setBlockType(EnumBlockType.METAL);
	}
	
	public ZGBlockMetal(String strTexture, float hardResist) {
		this(strTexture);
		this.setHardResist(hardResist);
	}
	
}