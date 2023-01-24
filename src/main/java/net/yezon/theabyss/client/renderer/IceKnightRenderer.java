
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.IceKnightEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class IceKnightRenderer extends HumanoidMobRenderer<IceKnightEntity, HumanoidModel<IceKnightEntity>> {
	public IceKnightRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.7f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<IceKnightEntity, HumanoidModel<IceKnightEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/ice_knight_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(IceKnightEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/ice_knight.png");
	}
}
