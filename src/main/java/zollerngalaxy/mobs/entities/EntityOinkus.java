package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import zollerngalaxy.core.ZGLootTables;

public class EntityOinkus extends EntityPig implements IEntityBreathable {
	
	public EntityOinkus(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}
	
	public static void registerFixesPig(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityOinkus.class);
	}
	
	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return ZGLootTables.ENTITY_OINKUS;
	}
	
	@Override
	public EntityOinkus createChild(EntityAgeable ageable) {
		return new EntityOinkus(this.world);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
}