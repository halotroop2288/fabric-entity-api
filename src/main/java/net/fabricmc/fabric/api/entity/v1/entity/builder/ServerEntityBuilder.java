package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

class ServerEntityBuilder<T extends Entity> {
	EntityType<T> entityType;
	Identifier id;

	ServerEntityBuilder(Identifier id, EntityType<T> type) {
		this.entityType = type;
		this.id = id;
	}

	ServerEntityBuilder<T> register() {
		return this;
	}
}
