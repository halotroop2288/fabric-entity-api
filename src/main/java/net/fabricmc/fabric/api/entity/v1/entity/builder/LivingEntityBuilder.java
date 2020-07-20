package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;

public class LivingEntityBuilder<T extends LivingEntity> extends ClientEntityBuilder<T> {
	SpawnEggItem egg;

	public LivingEntityBuilder(Identifier id, EntityType<T> type) {
		super(id, type);
	}

	/**
	 * Creates a spawn egg to be registered during {@link LivingEntityBuilder#register()}.
	 * Note: This should not be used for non-living entities!
	 *
	 * @param colorA   the primary color of the spawn egg
	 * @param colorB   the secondary color of the spawn egg
	 * @param settings the settings for the spawn egg item
	 */
	public LivingEntityBuilder<T> egg(int colorA, int colorB, Item.Settings settings) {
		egg = new SpawnEggItem(entityType, colorA, colorB, settings);
		return this;
	}

	@Override
	ServerEntityBuilder<T> register() {
		return super.register();
	}

	public SpawnEggItem getEgg() {
		return egg;
	}
}
