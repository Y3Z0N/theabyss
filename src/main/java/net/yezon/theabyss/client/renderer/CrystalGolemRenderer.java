
package net.yezon.theabyss.client.renderer;

import net.yezon.theabyss.entity.CrystalGolemEntity;
import net.yezon.theabyss.client.model.Modelcrystal_golem_big;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

public class CrystalGolemRenderer extends MobRenderer<CrystalGolemEntity, Modelcrystal_golem_big<CrystalGolemEntity>> {
	public CrystalGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcrystal_golem_big(context.bakeLayer(Modelcrystal_golem_big.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<CrystalGolemEntity, Modelcrystal_golem_big<CrystalGolemEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("theabyss:textures/entities/golem_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalGolemEntity entity) {
		return new ResourceLocation("theabyss:textures/entities/golem.png");
	}
}
