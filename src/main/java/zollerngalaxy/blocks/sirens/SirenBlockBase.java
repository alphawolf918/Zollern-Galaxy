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
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.State;

public class SirenBlockBase extends ZGBlockBase {
	
	public static State state = State.OFF;
	
	protected SoundEvent sirenSound = null;
	protected Block sirenON = null;
	
	public SirenBlockBase(State state, String sirenType) {
		super(sirenType + "siren" + ((state == State.ON) ? "_ON" : ""));
		this.setMaterial(Material.IRON);
		this.state = State.OFF;
		if (this.state == State.ON) {
			this.setLightLevel(1.0F);
		} else {
			this.setLightLevel(0.0F);
		}
		this.setHardness(2F);
		this.setResistance(10);
		this.setSound(SoundType.METAL);
		this.setTickRandomly(true);
	}
	
	public Block setSirenBlocks(Block sirenOnIn) {
		this.sirenON = sirenOnIn;
		return this;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.stateCheck(worldIn, pos);
	}
	
	public void stateCheck(World par1World, BlockPos pos) {
		if (!par1World.isRemote) {
			if (state == State.ON && par1World.isBlockIndirectlyGettingPowered(pos) > 0) {
				par1World.scheduleBlockUpdate(pos, this, 2, 2);
				par1World.setBlockState(pos, this.sirenON.getDefaultState()); // On
			} else if (this.state == State.OFF && par1World.isBlockIndirectlyGettingPowered(pos) > 0) {
				par1World.setBlockState(pos, this.sirenON.getDefaultState()); // On
			}
			if (this.state == State.OFF && !(par1World.isBlockIndirectlyGettingPowered(pos) > 0)) {
				par1World.setBlockState(pos, this.getDefaultState()); // Off
			}
		}
	}
	
	public Block setSirenBlockSound(SoundEvent soundEventIn) {
		this.sirenSound = soundEventIn;
		return this;
	}
	
	public SoundEvent getSirenBlockSound() {
		return this.sirenSound;
	}
	
	public void playAlarm(World par1World, BlockPos pos) {
		if (state == State.ON && par1World.isBlockIndirectlyGettingPowered(pos) > 0) {
			double amp = 1.5D;
			double x = pos.getX() + amp;
			double y = pos.getY() + amp;
			double z = pos.getZ() + amp;
			par1World.playSound(x, y, z, this.sirenSound, SoundCategory.MASTER, 10.0F, 2.5F, true);
		}
	}
}