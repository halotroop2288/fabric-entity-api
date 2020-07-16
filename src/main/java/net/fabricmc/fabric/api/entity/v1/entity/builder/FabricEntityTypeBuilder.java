package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricEntityTypeBuilder<T extends Entity> extends net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder<T> {
	private final Identifier id;

	public FabricEntityTypeBuilder(Identifier id, SpawnGroup spawnGroup, EntityType.EntityFactory<T> function) {
		super(spawnGroup, function);
		this.id = id;
	}

	public static <T extends Entity> EntityType<T> registerType(FabricEntityTypeBuilder<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, builder.id, builder.build());
	}
}
