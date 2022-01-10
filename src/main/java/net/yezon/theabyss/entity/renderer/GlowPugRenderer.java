package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.GlowPugEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GlowPugRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(GlowPugEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelglow_pug(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/glow_pug_texture.png");
					}
				};
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/glow_pug_texture_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelglow_pug extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer MushCap;
		private final ModelRenderer Plant;
		private final ModelRenderer RightLeg1;
		private final ModelRenderer RightLeg2;
		private final ModelRenderer LeftLeg1;
		private final ModelRenderer LeftLeg2;

		public Modelglow_pug() {
			textureWidth = 64;
			textureHeight = 64;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 17.0F, 0.0F);
			Body.setTextureOffset(0, 16).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 10.0F, 0.0F, false);
			MushCap = new ModelRenderer(this);
			MushCap.setRotationPoint(0.0F, -3.0F, 0.0F);
			Body.addChild(MushCap);
			MushCap.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 4.0F, 12.0F, 0.0F, false);
			Plant = new ModelRenderer(this);
			Plant.setRotationPoint(0.0F, -4.0F, 0.0F);
			MushCap.addChild(Plant);
			setRotationAngle(Plant, 0.0F, 0.7854F, 0.0F);
			Plant.setTextureOffset(24, 32).addBox(-6.0F, -11.0F, 0.0F, 12.0F, 11.0F, 0.0F, 0.0F, false);
			Plant.setTextureOffset(0, 20).addBox(0.0F, -11.0F, -6.0F, 0.0F, 11.0F, 12.0F, 0.0F, false);
			RightLeg1 = new ModelRenderer(this);
			RightLeg1.setRotationPoint(-4.0F, 2.0F, -5.0F);
			Body.addChild(RightLeg1);
			RightLeg1.setTextureOffset(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			RightLeg2 = new ModelRenderer(this);
			RightLeg2.setRotationPoint(-4.0F, 2.0F, 5.0F);
			Body.addChild(RightLeg2);
			RightLeg2.setTextureOffset(30, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			LeftLeg1 = new ModelRenderer(this);
			LeftLeg1.setRotationPoint(4.0F, 2.0F, -5.0F);
			Body.addChild(LeftLeg1);
			LeftLeg1.setTextureOffset(42, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			LeftLeg2 = new ModelRenderer(this);
			LeftLeg2.setRotationPoint(4.0F, 2.0F, 5.0F);
			Body.addChild(LeftLeg2);
			LeftLeg2.setTextureOffset(36, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.RightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftLeg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
