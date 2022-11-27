
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfectedPhantomEntity;
import net.yezon.theabyss.client.model.ModelPhantom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class InfectedPhantomRenderer extends MobRenderer<InfectedPhantomEntity, ModelPhantom<InfectedPhantomEntity>> {
	public InfectedPhantomRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPhantom(context.bakeLayer(ModelPhantom.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<InfectedPhantomEntity, ModelPhantom<InfectedPhantomEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/phantoms_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedPhantomEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/phantoms.png");
	}
}
