package zollerngalaxy.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.World;

public class EntitySquidlus extends EntitySquid {
	
	private float rotationVelocity;
	
	public EntitySquidlus(World worldIn) {
		super(worldIn);
		// this.rand.setSeed(1 + this.getEntityId());
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
		this.setSize(1.5F, 1.5F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
}