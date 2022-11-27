
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.InfcetedCowEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

public class InfcetedCowRenderer extends MobRenderer<InfcetedCowEntity, CowModel<InfcetedCowEntity>> {
	public InfcetedCowRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.5f);
		this.addLayer(new EyesLayer<InfcetedCowEntity, CowModel<InfcetedCowEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/cow_infected_glowinglayer.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(InfcetedCowEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/cow_infected.png");
	}
}
