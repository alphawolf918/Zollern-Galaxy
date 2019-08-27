package zollerngalaxy.mobs.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySquidlus extends EntitySquid {
	
	private float rotationVelocity;
	
	public EntitySquidlus(World worldIn) {
		super(worldIn);
		this.rand.setSeed(1 + this.getEntityId());
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
		this.setSize(1.5F, 1.5F);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntitySquidlus.AIMoveRandom(this));
	}
	
	public static void registerFixesSquid(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntitySquidlus.class);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
	
	static class AIMoveRandom extends EntityAIBase {
		
		private final EntitySquidlus squid;
		
		public AIMoveRandom(EntitySquidlus p_i45859_1_) {
			this.squid = p_i45859_1_;
		}
		
		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			return true;
		}
		
		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void updateTask() {
			int i = this.squid.getIdleTime();
			
			if (i > 100) {
				this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.hasMovementVector()) {
				float f = this.squid.getRNG().nextFloat() * ((float) Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.squid.setMovementVector(f1, f2, f3);
			}
		}
	}
	
}