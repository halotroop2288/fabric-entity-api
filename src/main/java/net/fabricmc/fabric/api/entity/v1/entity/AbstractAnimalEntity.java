package net.fabricmc.fabric.api.entity.v1.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;

public abstract class AbstractAnimalEntity extends AnimalEntity {
	public AbstractAnimalEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public PassiveEntity createChild(PassiveEntity mate) {
		PassiveEntity child = (PassiveEntity) (this.getType().create(world));

		if (child != null) {
			child.setPos(this.getX(), this.getY(), this.getZ());
			world.spawnEntity(child);
		}

		return child;
	}
}
