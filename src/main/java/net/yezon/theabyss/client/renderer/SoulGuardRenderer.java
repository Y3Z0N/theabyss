
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.SoulGuardEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class SoulGuardRenderer extends HumanoidMobRenderer<SoulGuardEntity, HumanoidModel<SoulGuardEntity>> {
	public SoulGuardRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.7f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<SoulGuardEntity, HumanoidModel<SoulGuardEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/soul-sand-demon.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SoulGuardEntity entity) {
		return new ResourceLocation("theabyss:textures/soul-sand-demon.png");
	}
}
