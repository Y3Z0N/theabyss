
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.SummonedSeekerEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class SummonedSeekerRenderer extends HumanoidMobRenderer<SummonedSeekerEntity, HumanoidModel<SummonedSeekerEntity>> {
	public SummonedSeekerRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(SummonedSeekerEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/firefly_entity.png");
	}
}
