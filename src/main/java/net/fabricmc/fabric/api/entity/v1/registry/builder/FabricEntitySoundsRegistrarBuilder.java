package net.fabricmc.fabric.api.entity.v1.registry.builder;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricEntitySoundsRegistrarBuilder {
	private final String mod_id, entityName;
	private SoundEvent ambient, death, hurt, eat, splash, swim, highSpeedSplash, fall, drink;

	public FabricEntitySoundsRegistrarBuilder(String mod_id, String entityName) {
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

	public FabricEntitySoundsRegistrarBuilder ambient() {
		ambient = registerSound(new Identifier(location() + "ambient"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder death() {
		death = registerSound(new Identifier(location() + "death"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder hurt() {
		hurt = registerSound(new Identifier(location() + "hurt"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder eat() {
		eat = registerSound(new Identifier(location() + "eat"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder splash() {
		splash = registerSound(new Identifier(location() + "splash"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder swim() {
		swim = registerSound(new Identifier(location() + "swim"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder highSpeedSplash() {
		highSpeedSplash = registerSound(new Identifier(location() + "high_speed_splash"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder fall() {
		fall = registerSound(new Identifier(location() + "fall"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder drink() {
		drink = registerSound(new Identifier(location() + "drink"));
		return this;
	}

	public FabricEntitySoundsRegistrarBuilder defaults() {
		return this.ambient().death().hurt();
	}

	public FabricEntitySoundsRegistrarBuilder everything() {
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
