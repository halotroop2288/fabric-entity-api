package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricEntityTypeBuilder<T extends Entity> extends net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder<T> {
	private final Identifier id;
	private SpawnEggItem egg;
	private boolean generateEgg;
	private int eggColorA, eggColorB;
	private Item.Settings eggSettings;

	public FabricEntityTypeBuilder(Identifier id, SpawnGroup spawnGroup, EntityType.EntityFactory<T> function) {
		super(spawnGroup, function);
		this.id = id;
	}

	public FabricEntityTypeBuilder<T> egg(int colorA, int colorB, Item.Settings eggSettings) {
		this.generateEgg = true;
		this.eggColorA = colorA;
		this.eggColorB = colorB;
		this.eggSettings = eggSettings;
		return this;
	}

	public EntityType<T> build() {
		EntityType<T> entityType = Registry.register(Registry.ENTITY_TYPE, this.id, super.build());

		if (generateEgg) {
			egg = Registry.register(Registry.ITEM, new Identifier(id.getNamespace(), id.getPath() + "_egg"),
					new SpawnEggItem(entityType, this.eggColorA, this.eggColorB, eggSettings));
		}

		return entityType;
	}

	public SpawnEggItem getEgg() {
		return egg;
	}
}
