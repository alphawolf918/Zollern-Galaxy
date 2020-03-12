package zollerngalaxy.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntitySquidlus extends EntitySquid {
	
	public EntitySquidlus(World worldIn) {
		super(worldIn);
		this.rand.setSeed(1 + this.getEntityId());
		this.setSize(1.5F, 1.5F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.21D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		boolean seaHeightMax = this.posY >= 25.0D;
		boolean seaHeightMin = this.posY <= this.getEntityWorld().getSeaLevel();
		boolean canSpawnHereSuper = super.getCanSpawnHere();
		boolean canSpawn = (seaHeightMax && seaHeightMin && canSpawnHereSuper);
		return canSpawn;
	}
	
}