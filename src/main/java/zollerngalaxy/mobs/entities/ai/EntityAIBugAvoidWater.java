/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import javax.annotation.Nullable;
import net.minecraft.util.math.Vec3d;
import zollerngalaxy.mobs.entities.base.EntityBugZG;
import zollerngalaxy.util.RandPosGenBug;

public class EntityAIBugAvoidWater extends EntityAIBugWander {
	
	protected final float probability;
	
	public EntityAIBugAvoidWater(EntityBugZG p_i47301_1_, double p_i47301_2_) {
		this(p_i47301_1_, p_i47301_2_, 0.001F);
	}
	
	public EntityAIBugAvoidWater(EntityBugZG p_i47302_1_, double p_i47302_2_, float p_i47302_4_) {
		super(p_i47302_1_, p_i47302_2_);
		this.probability = p_i47302_4_;
	}
	
	@Override
	@Nullable
	protected Vec3d getPosition() {
		if (this.entity.isInWater()) {
			Vec3d vec3d = RandPosGenBug.getLandPos(this.entity, 15, 7);
			return vec3d == null ? super.getPosition() : vec3d;
		} else {
			return this.entity.getRNG().nextFloat() >= this.probability ? RandPosGenBug.getLandPos(this.entity, 10, 7) : super
					.getPosition();
		}
	}
}