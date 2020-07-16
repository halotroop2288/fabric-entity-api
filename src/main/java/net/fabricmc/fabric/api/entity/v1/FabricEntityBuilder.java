package net.fabricmc.fabric.api.entity.v1;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

public class FabricEntityBuilder {
	public static <T extends Entity> EntityType<T> registerType(TypeBuilder<T> builder) {
		return Registry.register(Registry.ENTITY_TYPE, builder.id, builder.build());
	}

	@Environment(EnvType.CLIENT)
	public static void registerRenderer(RendererBuilder builder) {
		EntityRendererRegistry.INSTANCE.register(builder.entityType, (dispatcher, context) -> builder.build());
	}

	public static class SoundsBuilder {
		private final String mod_id, entityName;
		private SoundEvent ambient, death, hurt, eat, splash, swim, highSpeedSplash, fall, drink;

		public SoundsBuilder(String mod_id, String entityName) {
			this.entityName = entityName;
			this.mod_id = mod_id;
		}

		private String location() {
			assert mod_id != null;
			assert entityName != null;
			return mod_id + ":entity/" + entityName + "/";
		}

		private SoundEvent registerSound(Identifier id) {
			return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
		}

		public SoundsBuilder ambient() {
			ambient = registerSound(new Identifier(location() + "ambient"));
			return this;
		}

		public SoundsBuilder death() {
			death = registerSound(new Identifier(location() + "death"));
			return this;
		}

		public SoundsBuilder hurt() {
			hurt = registerSound(new Identifier(location() + "hurt"));
			return this;
		}

		public SoundsBuilder eat() {
			eat = registerSound(new Identifier(location() + "eat"));
			return this;
		}

		public SoundsBuilder splash() {
			splash = registerSound(new Identifier(location() + "splash"));
			return this;
		}

		public SoundsBuilder swim() {
			swim = registerSound(new Identifier(location() + "swim"));
			return this;
		}

		public SoundsBuilder highSpeedSplash() {
			highSpeedSplash = registerSound(new Identifier(location() + "high_speed_splash"));
			return this;
		}

		public SoundsBuilder fall() {
			fall = registerSound(new Identifier(location() + "fall"));
			return this;
		}

		public SoundsBuilder drink() {
			drink = registerSound(new Identifier(location() + "drink"));
			return this;
		}

		public SoundsBuilder defaults() {
			return this.ambient().death().hurt();
		}

		public SoundsBuilder everything() {
			return this.defaults().drink().fall().highSpeedSplash().splash().swim().eat();
		}

		public SoundEvent getAmbient() {
			return ambient;
		}

		public SoundEvent getDeath() {
			return death;
		}

		public SoundEvent getHurt() {
			return hurt;
		}

		public SoundEvent getEat() {
			return eat;
		}

		public SoundEvent getSplash() {
			return splash;
		}

		public SoundEvent getSwim() {
			return swim;
		}

		public SoundEvent getHighSpeedSplash() {
			return highSpeedSplash;
		}

		public SoundEvent getFall() {
			return fall;
		}

		public SoundEvent getDrink() {
			return drink;
		}
	}

	public static class TypeBuilder<T extends Entity> extends FabricEntityTypeBuilder<T> {
		private final Identifier id;

		protected TypeBuilder(Identifier id, SpawnGroup spawnGroup, EntityType.EntityFactory<T> function) {
			super(spawnGroup, function);
			this.id = id;
		}
	}

	@Environment(EnvType.CLIENT)
	public static class RendererBuilder {
		public EntityType<? extends Entity> entityType;
		public Identifier texture;
		private EntityRenderDispatcher dispatcher;

		@Environment(EnvType.CLIENT)
		public RendererBuilder(EntityType<? extends Entity> type, Identifier texture) {
			this.texture = texture;
			this.entityType = type;
		}

		@Environment(EnvType.CLIENT)
		public EntityRenderer<? extends Entity> build() {
			return new APICustomRenderer<>(this.dispatcher, this.texture);
		}
	}

	@Environment(EnvType.CLIENT)
	private static class APICustomRenderer<T extends Entity> extends EntityRenderer<T> {
		private final Identifier texture;

		@Environment(EnvType.CLIENT)
		protected APICustomRenderer(EntityRenderDispatcher dispatcher, Identifier texture) {
			super(dispatcher);
			this.texture = texture;
		}

		@Override
		public Identifier getTexture(Entity entity) {
			return texture;
		}
	}
}
