package net.fabricmc.fabric.api.entity.v1.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

public abstract class AbstractWaterCreatureEntity extends WaterCreatureEntity {
	public AbstractWaterCreatureEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
	}

	/*
	 * Override me! Not having these could make big problems!
	 */
	public static DefaultAttributeContainer createWaterCreatureDefaultAttributes() {
		return DefaultAttributeContainer.builder().build();
	}
}
