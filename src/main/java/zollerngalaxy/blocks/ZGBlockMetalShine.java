/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

public class ZGBlockMetalShine extends ZGBlockMetal {
	
	public ZGBlockMetalShine(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setLightLevel(1.0F);
	}
	
	public ZGBlockMetalShine(String strTexture) {
		this(strTexture, 2.5F);
	}
	
}