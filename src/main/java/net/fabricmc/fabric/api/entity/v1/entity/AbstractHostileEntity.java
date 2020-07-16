package net.fabricmc.fabric.api.entity.v1.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public abstract class AbstractHostileEntity extends HostileEntity {
	protected AbstractHostileEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}

	/*
	 * Override me! Not having these could make big problems!
	 */
	public static DefaultAttributeContainer createHostileDefaultAttributes() {
		return DefaultAttributeContainer.builder().build();
	}
}
