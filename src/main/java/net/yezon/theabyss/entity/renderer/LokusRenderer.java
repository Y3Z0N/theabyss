package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.LokusEntity;

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
public class LokusRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LokusEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modellokus(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/lokus.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/lokus_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modellokus extends EntityModel<Entity> {
		private final ModelRenderer torso;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer tail;
		private final ModelRenderer cube_r3;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer neck_and_head;
		private final ModelRenderer neck;
		private final ModelRenderer cube_r6;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer head;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer up_jaw;
		private final ModelRenderer cube_r11;
		private final ModelRenderer down_jaw;
		private final ModelRenderer cube_r12;

		public Modellokus() {
			textureWidth = 128;
			textureHeight = 128;
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			torso.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(44, 41).addBox(-6.0F, -28.0F, -24.0F, 12.0F, 14.0F, 14.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			torso.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.1309F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(35, 9).addBox(-5.0F, -30.0F, -6.0F, 10.0F, 12.0F, 17.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, -6.0F, 5.5F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 30.0F, -5.5F);
			tail.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.0873F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-6.0F, -30.0F, 3.0F, 12.0F, 0.0F, 26.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-3.5F, 1.35F, -1.0F);
			right_leg.setTextureOffset(0, 0).addBox(-1.5F, 22.4F, -7.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
			right_leg.setTextureOffset(35, 38).addBox(-1.5F, 21.65F, -4.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
			right_leg.setTextureOffset(0, 0).addBox(2.5F, 21.65F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(3.5F, 22.65F, 1.0F);
			right_leg.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0873F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(0, 19).addBox(-5.0F, -22.0F, -2.0F, 2.0F, 22.0F, 2.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(3.5F, 22.65F, 1.0F);
			right_leg.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.1745F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(63, 69).addBox(-8.0F, -27.0F, -8.0F, 6.0F, 12.0F, 7.0F, 0.0F, false);
			neck_and_head = new ModelRenderer(this);
			neck_and_head.setRotationPoint(0.0F, 24.0F, 0.0F);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, 0.0F, 0.0F);
			neck_and_head.addChild(neck);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			neck.addChild(cube_r6);
			setRotationAngle(cube_r6, -1.4399F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 26).addBox(-3.0F, 11.0F, -45.0F, 6.0F, 6.0F, 23.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(3.5F, 1.35F, -1.0F);
			left_leg.setTextureOffset(0, 0).addBox(-0.5F, 22.4F, -7.0F, 2.0F, 0.0F, 3.0F, 0.0F, true);
			left_leg.setTextureOffset(35, 38).addBox(-0.5F, 21.65F, -4.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);
			left_leg.setTextureOffset(0, 0).addBox(-3.5F, 21.65F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-3.5F, 22.65F, 1.0F);
			left_leg.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0873F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(0, 19).addBox(3.0F, -22.0F, -2.0F, 2.0F, 22.0F, 2.0F, 0.0F, true);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-3.5F, 22.65F, 1.0F);
			left_leg.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.1745F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(63, 69).addBox(2.0F, -27.0F, -8.0F, 6.0F, 12.0F, 7.0F, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -22.0F, -20.625F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, 46.0F, 20.625F);
			head.addChild(cube_r9);
			setRotationAngle(cube_r9, -1.309F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(72, 0).addBox(-7.0F, -8.0F, -55.0F, 14.0F, 14.0F, 0.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 46.0F, 20.625F);
			head.addChild(cube_r10);
			setRotationAngle(cube_r10, -1.4399F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(0, 55).addBox(-5.0F, 11.0F, -54.0F, 10.0F, 11.0F, 9.0F, 0.0F, false);
			up_jaw = new ModelRenderer(this);
			up_jaw.setRotationPoint(0.0F, 46.0F, 20.625F);
			head.addChild(up_jaw);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
			up_jaw.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.4399F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(31, 69).addBox(-4.5F, 22.0F, -54.0F, 9.0F, 14.0F, 7.0F, 0.0F, false);
			down_jaw = new ModelRenderer(this);
			down_jaw.setRotationPoint(0.0F, 46.0F, 20.625F);
			head.addChild(down_jaw);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
			down_jaw.addChild(cube_r12);
			setRotationAngle(cube_r12, -1.4399F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(0, 75).addBox(-4.0F, 22.0F, -49.0F, 8.0F, 13.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
			tail.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			neck_and_head.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
