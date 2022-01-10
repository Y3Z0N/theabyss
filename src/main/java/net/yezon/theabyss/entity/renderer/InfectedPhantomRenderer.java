package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.InfectedPhantomEntity;

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
public class InfectedPhantomRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(InfectedPhantomEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelPhantom(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/phantoms.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/phantoms_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelPhantom extends EntityModel<Entity> {
		private final ModelRenderer right_arm;
		private final ModelRenderer left_arm;
		private final ModelRenderer mob_head;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;

		public ModelPhantom() {
			textureWidth = 128;
			textureHeight = 128;
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.5375F, 0.5F, 1.0F);
			right_arm.setTextureOffset(16, 48).addBox(-4.4875F, 0.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_arm.setTextureOffset(0, 34).addBox(-5.0125F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.55F, 1.0F, 1.0F);
			left_arm.setTextureOffset(32, 49).addBox(0.5F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_arm.setTextureOffset(36, 0).addBox(0.0F, -0.5F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, 24.0F, 0.0F);
			mob_head.setTextureOffset(0, 18).addBox(-4.0F, -31.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			mob_head.setTextureOffset(0, 0).addBox(-4.5F, -31.5F, -3.5F, 9.0F, 9.0F, 9.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(28, 30).addBox(-5.0F, -23.0F, -1.0F, 10.0F, 15.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(63, 0).addBox(-4.5F, -22.975F, -0.25F, 9.0F, 15.0F, 3.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-2.8467F, -14.5F, -4.0188F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -1.789F, 0.0F);
			cube_r1.setTextureOffset(0, 6).addBox(0.1546F, -0.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(0.1546F, -6.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 3).addBox(0.1546F, -3.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(2.8467F, -14.5F, -4.0188F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 1.789F, 0.0F);
			cube_r2.setTextureOffset(0, 18).addBox(-1.1546F, -0.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 21).addBox(-1.1546F, -6.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r2.setTextureOffset(24, 18).addBox(-1.1546F, -3.475F, -2.8829F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-4.5F, -14.5F, -0.5F);
			body.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
			cube_r3.setTextureOffset(48, 49).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r3.setTextureOffset(27, 0).addBox(-0.5F, -6.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r3.setTextureOffset(15, 34).addBox(-0.5F, -3.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(4.5F, -14.5F, -0.5F);
			body.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
			cube_r4.setTextureOffset(51, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 52).addBox(-0.5F, -6.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r4.setTextureOffset(6, 53).addBox(-0.5F, -3.5F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.5F, -10.0F, 2.4641F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.5236F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(58, 32).addBox(-3.5F, 0.0F, -3.5F, 8.0F, 8.0F, 3.0F, 0.0F, false);
			cube_r5.setTextureOffset(32, 18).addBox(-4.0F, 0.0F, -4.0F, 9.0F, 8.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
