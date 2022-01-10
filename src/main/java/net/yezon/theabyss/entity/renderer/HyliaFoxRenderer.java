package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.HyliaFoxEntity;

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
public class HyliaFoxRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HyliaFoxEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelhylia_fox(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/hylia_fox.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/hylia_fox_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelhylia_fox extends EntityModel<Entity> {
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer right_leg2;
		private final ModelRenderer left_leg2;
		private final ModelRenderer right_leg1;
		private final ModelRenderer left_leg1;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r4;
		private final ModelRenderer body;

		public Modelhylia_fox() {
			textureWidth = 64;
			textureHeight = 64;
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, 16.0F, -3.0F);
			mob_head.setTextureOffset(0, 17).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 6.0F, 6.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-3.0F, -1.0F, -2.5F);
			mob_head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3491F);
			cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(3.0F, -1.0F, -2.5F);
			mob_head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3491F);
			cube_r2.setTextureOffset(0, 17).addBox(-1.0F, -3.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 1.65F, -6.0F);
			mob_head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.1745F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(22, 15).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(-1.0F, 18.0F, 6.0F);
			right_leg2.setTextureOffset(16, 29).addBox(-2.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(1.0F, 18.0F, 6.0F);
			left_leg2.setTextureOffset(8, 29).addBox(0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			right_leg1 = new ModelRenderer(this);
			right_leg1.setRotationPoint(-1.0F, 18.0F, -1.0F);
			right_leg1.setTextureOffset(0, 29).addBox(-2.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			left_leg1 = new ModelRenderer(this);
			left_leg1.setRotationPoint(1.0F, 18.0F, -1.0F);
			left_leg1.setTextureOffset(26, 27).addBox(0.005F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 16.0F, 7.0F);
			setRotationAngle(mob_tail, 1.5708F, 0.0F, 0.0F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			mob_tail.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.1745F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(24, 0).addBox(-2.0F, 0.0F, -1.75F, 4.0F, 10.0F, 5.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 16.0F, 0.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			mob_head.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_tail.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.mob_tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
