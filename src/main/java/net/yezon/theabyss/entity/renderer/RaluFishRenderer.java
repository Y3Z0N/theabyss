package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.RaluFishEntity;

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
public class RaluFishRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RaluFishEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelralu_fish(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/ralu_fish.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/ralu_fish.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelralu_fish extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer tail;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;

		public Modelralu_fish() {
			textureWidth = 32;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -5.0F, 0.0F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.0044F);
			cube_r1.setTextureOffset(0, 10).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 0.0F, true);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -5.0F, 0.0F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0044F);
			cube_r2.setTextureOffset(0, 10).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-1.0F, -1.5F, -1.0F);
			body.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -0.5672F, 0.0F);
			cube_r3.setTextureOffset(0, 2).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, true);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(1.0F, -1.5F, -1.0F);
			body.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.5672F, 0.0F);
			cube_r4.setTextureOffset(0, 2).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, -2.0F, 3.0F);
			body.addChild(tail);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			tail.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0044F, 0.0F);
			cube_r5.setTextureOffset(0, 6).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			tail.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, -0.0044F, 0.0F);
			cube_r6.setTextureOffset(0, 6).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 5.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.tail.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
