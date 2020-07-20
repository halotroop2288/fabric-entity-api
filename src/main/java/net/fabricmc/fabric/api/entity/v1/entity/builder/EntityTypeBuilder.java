package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

public class EntityTypeBuilder<T extends Entity> extends FabricEntityTypeBuilder<T> {
	private final Identifier id;

	public EntityTypeBuilder(Identifier id, SpawnGroup spawnGroup, EntityType.EntityFactory<T> function) {
		super(spawnGroup, function);
		this.id = id;
	}

	@Override
	public EntityType<T> build() {
		return Registry.register(Registry.ENTITY_TYPE, this.id, super.build());
	}
}
