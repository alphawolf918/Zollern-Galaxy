/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.blocks;

import galaxymod.ProjectNovaCore;
import galaxymod.utils.NovaHelper;
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
	
	public static SoundType soundTypeXeno = new SoundType("xeno", 4.0F, 0.5F) {
		
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
	
	public Block setDefaults() {
		this.setHardResist(1.8F, 9.8F);
		this.setStepSound(soundTypeStone);
		// this.setDropItem(Item.getItemFromBlock(this));
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
		NovaHelper.setHardnessAndResistance(this, par1Hardness, par2Resistance);
		return this;
	}
	
	public Block setHardResist(float par1HardResist) {
		NovaHelper.setHardnessAndResistance(this, par1HardResist);
		return this;
	}
	
	public Block setName(String strName) {
		NovaHelper.setName(this, strName);
		return this;
	}
	
	public Block setTexture(String strTexture) {
		NovaHelper.setTexture(this, strTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strTexture) {
		NovaHelper.setNameAndTexture(this, strTexture);
		return this;
	}
	
	public Block setNameAndTexture(String strName, String strTexture) {
		NovaHelper.setNameAndTexture(this, strName, strTexture);
		return this;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ProjectNovaCore.novaTabBlocks;
	}
}