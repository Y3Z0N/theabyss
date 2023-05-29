package net.yezon.theabyss.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.yezon.theabyss.entity.InfectedDragonflyEntity;

import net.minecraft.resources.ResourceLocation;

public class InfectedDragonflyModel extends AnimatedGeoModel<InfectedDragonflyEntity> {
	@Override
	public ResourceLocation getAnimationResource(InfectedDragonflyEntity entity) {
		return new ResourceLocation("theabyss", "animations/dragonfly.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(InfectedDragonflyEntity entity) {
		return new ResourceLocation("theabyss", "geo/dragonfly.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(InfectedDragonflyEntity entity) {
		return new ResourceLocation("theabyss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
