
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfectedCreeperEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

public class InfectedCreeperRenderer extends MobRenderer<InfectedCreeperEntity, CreeperModel<InfectedCreeperEntity>> {
	public InfectedCreeperRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(InfectedCreeperEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/dark_creeper_new.png");
	}
}
