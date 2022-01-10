package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.ShatteredZombieEntity;

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
public class ShatteredZombieRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShatteredZombieEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelshattered_zombie(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/shattered_zombie.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/shattered_zombie_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelshattered_zombie extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer headwear;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_arm;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;

		public Modelshattered_zombie() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			headwear = new ModelRenderer(this);
			headwear.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(headwear);
			headwear.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.25F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-3.0F, 12.8923F, 6.5622F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, -1.0472F, 0.4363F, 0.7854F);
			cube_r1.setTextureOffset(60, 32).addBox(1.5F, -0.5F, -6.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-3.0F, 12.8923F, 6.5622F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, -1.0472F, 0.2182F, 0.0F);
			cube_r2.setTextureOffset(60, 32).addBox(5.5F, -1.5F, -7.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.5F, -1.0F, 6.5F);
			body.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.5236F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(60, 32).addBox(-3.0F, 11.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(60, 32).addBox(-1.5F, 9.5F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(60, 32).addBox(-0.5F, 6.0F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-1.5F, 3.0933F, -7.4103F);
			body.addChild(cube_r4);
			setRotationAngle(cube_r4, -1.1345F, 0.0F, 3.098F);
			cube_r4.setTextureOffset(60, 32).addBox(-1.0F, -9.0F, -5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(60, 32).addBox(-3.0F, -7.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-1.5F, 3.0933F, -7.4103F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.7854F, 0.0F, 3.098F);
			cube_r5.setTextureOffset(60, 32).addBox(-3.5F, -8.5F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-1.5F, 3.0933F, -7.4103F);
			body.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.5236F, 0.0F, 3.098F);
			cube_r6.setTextureOffset(60, 32).addBox(-3.5F, -3.5F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r6.setTextureOffset(60, 32).addBox(-0.5F, -7.0F, 2.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-2.5F, 4.5622F, 2.134F);
			body.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.5236F, -0.4363F, 0.0F);
			cube_r7.setTextureOffset(60, 32).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-5.0F, 22.0F, 0.0F);
			right_arm.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, 0.0436F);
			cube_r8.setTextureOffset(40, 16).addBox(-9.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-11.5F, 10.0F, -2.0F);
			right_arm.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.0436F);
			cube_r9.setTextureOffset(60, 32).addBox(0.75F, -2.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(60, 32).addBox(-0.5F, -1.0F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(60, 32).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r9.setTextureOffset(60, 32).addBox(-1.75F, -2.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
			left_leg.setTextureOffset(0, 16).addBox(1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(1.9F, 12.0F, 0.0F);
			right_leg.setTextureOffset(0, 16).addBox(-5.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(5.0F, 22.0F, 0.0F);
			left_arm.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -0.0436F);
			cube_r10.setTextureOffset(40, 16).addBox(5.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(11.5F, 10.0F, -2.0F);
			left_arm.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -0.0436F);
			cube_r11.setTextureOffset(60, 32).addBox(-1.75F, -2.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			cube_r11.setTextureOffset(60, 32).addBox(-0.5F, -1.0F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			cube_r11.setTextureOffset(60, 32).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			cube_r11.setTextureOffset(60, 32).addBox(0.75F, -2.25F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
