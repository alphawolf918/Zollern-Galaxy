/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.sirens;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.creativetabs.ZGTabs;

public class SirenBlockBase extends ZGBlockBase {
	
	protected SoundEvent sound = null;
	protected boolean isOn = false;
	
	public SirenBlockBase(String blockName, SoundEvent sirenSound, boolean stateIn) {
		super(blockName);
		this.setIsOn(stateIn);
		
		if (stateIn) {
			this.setLightLevel(1.0F);
		}
		
		this.setMaterial(Material.IRON);
		this.setHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.IRON.getHarvestLevel());
		this.setHardness(2F);
		this.setResistance(10F);
		this.setSound(SoundType.METAL);
		this.setSirenBlockSound(sirenSound);
		this.setTickRandomly(true);
	}
	
	public Block setSirenBlockSound(SoundEvent par1) {
		this.sound = par1;
		return this;
	}
	
	public SoundEvent getSirenBlockSound() {
		return this.sound;
	}
	
	public Block setIsOn(boolean stateIn) {
		this.isOn = stateIn;
		return this;
	}
	
	public boolean getIsOn() {
		return this.isOn;
	}
	
	public void playAlarm(World worldIn, BlockPos pos) {
		if (this.isOn && worldIn.isBlockPowered(pos)) {
			float soundPitch = worldIn.rand.nextFloat() * 0.1F + 0.9F;
			worldIn.playSound(null, pos, this.getSirenBlockSound(), SoundCategory.AMBIENT, 1.5F, soundPitch);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		CreativeTabs blocksTab = ZGTabs.zgBlocksTab;
		
		if (this.isOn) {
			return null;
		}
		
		return blocksTab;
	}
}