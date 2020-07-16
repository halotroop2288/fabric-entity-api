package net.fabricmc.fabric.api.entity.v1.entity.builder;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class FabricEntityRendererBuilder {
	public EntityType<? extends Entity> entityType;
	public Identifier texture;
	private EntityRenderDispatcher dispatcher;

	@Environment(EnvType.CLIENT)
	public FabricEntityRendererBuilder(EntityType<? extends Entity> type, Identifier texture) {
		this.texture = texture;
		this.entityType = type;
	}

	@Environment(EnvType.CLIENT)
	public EntityRenderer<? extends Entity> build() {
		return new APICustomRenderer<>(this.dispatcher, this.texture);
	}

	@Environment(EnvType.CLIENT)
	public FabricEntityRendererBuilder register() {
		EntityRendererRegistry.INSTANCE.register(this.entityType, (dispatcher, context) -> this.build());
		return this;
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
