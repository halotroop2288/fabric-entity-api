package net.fabricmc.fabric.api.entity.v1.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.world.World;

public abstract class AbstractFishEntity extends FishEntity {
	public AbstractFishEntity(EntityType<? extends FishEntity> entityType, World world) {
		super(entityType, world);
	}

	/*
	 * Override me! Not having these could make big problems!
	 */
	public static DefaultAttributeContainer createFishDefaultAttributes() {
		return DefaultAttributeContainer.builder().build();
	}
}
