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
import galaxymod.lib.NovaHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;

public class BlockNova extends Block {
	
	protected static Item dropItem = null;
	
	protected static int dropItemAmountMin = 1;
	protected static int dropItemAmountMax = 1;
	
	protected static int xpDropMin = 3;
	protected static int xpDropMax = 4;
	
	protected static IPlantable plantBlock = null;
	
	private Random rand = new Random();
	
	public static SoundType soundTypeXeno = new SoundType("xeno", 2.0F, 0.5F) {
		
		@Override
		public String getBreakSound() {
			return "galaxymod:dig.xeno";
		}
		
		@Override
		public String getStepResourcePath() {
			return "galaxymod:step.xeno";
		}
		
	};
	
	public Block setPlantToSustain(Block plantBlock) {
		if (plantBlock instanceof IPlantable) {
			this.plantBlock = (IPlantable) plantBlock;
			return this;
		} else {
			this.plantBlock = null;
		}
		return this;
	}
	
	public Block setBlockHarvestLevel(String toolClass, int toolLevel) {
		this.setHarvestLevel(toolClass, toolLevel);
		return this;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z,
			ForgeDirection direction, IPlantable plantable) {
		if (this.plantBlock != null && plantable.equals(this.plantBlock)
				&& this.plantBlock instanceof IPlantable) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, this.xpDropMin,
					this.xpDropMax);
			
			return j1;
		}
		return 0;
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
		return this;
	}
	
	public Block setExpDrop(int min, int max) {
		this.xpDropMin = min;
		this.xpDropMax = max;
		return this;
	}
	
	public BlockNova getInstance() {
		return this;
	}
	
	public void registerOre(String strName) {
		OreDictionary.registerOre(strName, this);
	}
	
	public Block setDropItem(Item itemDropped) {
		this.dropItem = itemDropped;
		return this;
	}
	
	public Block setDropItem(Item itemDropped, int amountDropped) {
		this.setDropItem(itemDropped);
		this.setItemAmountDropped(amountDropped);
		return this;
	}
	
	public Block setDropItem(Item itemDropped, int amountDroppedMin,
			int amountDroppedMax) {
		this.setDropItem(itemDropped);
		this.dropItemAmountMin = amountDroppedMin;
		this.dropItemAmountMax = amountDroppedMax;
		return this;
	}
	
	public Block setItemAmountDropped(int par1) {
		this.dropItemAmountMin = par1;
		return this;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		if (this.dropItem != null) {
			return this.dropItem;
		} else {
			return Item.getItemFromBlock(this);
		}
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		if (par1Rand.nextInt(2) == 1) {
			return this.dropItemAmountMax;
		} else {
			return this.dropItemAmountMin;
		}
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