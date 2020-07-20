package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class ClientEntityBuilder<T extends Entity> extends ServerEntityBuilder<T> {
	@Environment(EnvType.CLIENT)
	EntityRenderer<T> entityRenderer;
	@Environment(EnvType.CLIENT)
	EntityModel<T> entityModel;

	public ClientEntityBuilder(Identifier id, EntityType<T> type) {
		super(id, type);
	}

	@Environment(EnvType.CLIENT)
	public ClientEntityBuilder<T> entityRenderer(EntityRenderer<T> renderer, EntityModel<T> model) {
		this.entityRenderer = renderer;
		this.entityModel = model;
		return this;
	}

	@Override
	ServerEntityBuilder<T> register() {
		return super.register();
	}
}
