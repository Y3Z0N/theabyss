
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.AbyssaurEntity;
import net.yezon.theabyss.client.model.Modelabysaurus_rex;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class AbyssaurRenderer extends MobRenderer<AbyssaurEntity, Modelabysaurus_rex<AbyssaurEntity>> {
	public AbyssaurRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelabysaurus_rex(context.bakeLayer(Modelabysaurus_rex.LAYER_LOCATION)), 0.7999999999999999f);
		this.addLayer(new EyesLayer<AbyssaurEntity, Modelabysaurus_rex<AbyssaurEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/abysaurus_rex_glowing_layer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(AbyssaurEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/abysaurus_rex.png");
	}
}
