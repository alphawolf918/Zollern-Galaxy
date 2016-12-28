/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks;

import galaxymod.ZollernGalaxyCore;
import galaxymod.utils.ZGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockNova extends Block {
	
	protected static Item dropItem = null;
	
	protected static int dropItemAmountMin = 1;
	protected static int dropItemAmountMax = 1;
	
	private Random rand = new Random();
	
	public static SoundType soundTypeXeno = new SoundType("xeno", 4.0F, 2.0F) {
		
		@Override
		public String getBreakSound() {
			return "galaxymod:dig.xeno";
		}
		
		@Override
		public String getStepResourcePath() {
			return "galaxymod:step.xeno";
		}
	};
	
	public Block setBlockHarvestLevel(String toolClass, int toolLevel) {
		this.setHarvestLevel(toolClass, toolLevel);
		return this;
	}
	
	public BlockNova(Material par1Material) {
		super(par1Material);
		this.setDefaults();
	}
	
	public BlockNova(String strTexture, Material blockMaterial) {
		super(blockMaterial);
		this.setDefaults();
		this.setNameAndTexture(strTexture);
	}
	
	public BlockNova(String strTexture) {
		this(strTexture, Material.rock);
	}
	
	public Block setDefaults() {
		this.setHardResist(1.8F, 4.8F);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeStone);
		return this;
	}
	
	public Block setSoundType(SoundType soundType) {
		this.setStepSound(soundType);
		return this;
	}
	
	public BlockNova getInstance() {
		return this;
	}
	
	public Block setHardResist(float par1Hardness, float par2Resistance) {
		ZGHelper.setHardnessAndResistance(this, par1Hardness, par2Resistance);
		return this;
	}
	
	public Block setHardResist(float par1HardResist) {
		ZGHelper.setHardnessAndResistance(this, par1HardResist);
		return this;
	}
	
	public Block setName(String strName) {
		ZGHelper.setName(this, strName);
		return this;
	}
	
	public Block setTexture(String strTexture) {
		ZGHelper.setTexture(this, strTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strTexture) {
		ZGHelper.setNameAndTexture(this, strTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strName, String strTexture) {
		ZGHelper.setNameAndTexture(this, strName, strTexture);
		return this;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernGalaxyCore.novaTabBlocks;
	}
}