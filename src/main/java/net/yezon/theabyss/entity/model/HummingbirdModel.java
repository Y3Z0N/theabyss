package net.yezon.theabyss.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.yezon.theabyss.entity.HummingbirdEntity;

import net.minecraft.resources.ResourceLocation;

public class HummingbirdModel extends AnimatedGeoModel<HummingbirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(HummingbirdEntity entity) {
		return new ResourceLocation("theabyss", "animations/hummingbird.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HummingbirdEntity entity) {
		return new ResourceLocation("theabyss", "geo/hummingbird.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HummingbirdEntity entity) {
		return new ResourceLocation("theabyss", "textures/entities/" + entity.getTexture() + ".png");
	}

}
