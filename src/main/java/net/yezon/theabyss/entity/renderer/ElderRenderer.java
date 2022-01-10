package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.ElderEntity;

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
public class ElderRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ElderEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabyss_elder(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/elder_glow.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/elder_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelabyss_elder extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer head_r1;
		private final ModelRenderer head_r2;
		private final ModelRenderer head_r3;
		private final ModelRenderer body;
		private final ModelRenderer left_arm;
		private final ModelRenderer right_arm_r1;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer left_arm_r1;
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer right_arm_r2;
		private final ModelRenderer cube_r6;
		private final ModelRenderer right_arm_r3;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;

		public Modelabyss_elder() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			head_r1 = new ModelRenderer(this);
			head_r1.setRotationPoint(-3.5F, 13.25F, -6.0F);
			head.addChild(head_r1);
			setRotationAngle(head_r1, -0.2618F, 0.0F, 0.0F);
			head_r1.setTextureOffset(39, 17).addBox(3.0F, -26.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			head_r2 = new ModelRenderer(this);
			head_r2.setRotationPoint(-3.25F, 13.25F, -3.5F);
			head.addChild(head_r2);
			setRotationAngle(head_r2, -0.2618F, 0.0F, 0.0F);
			head_r2.setTextureOffset(40, 6).addBox(3.0F, -26.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			head_r3 = new ModelRenderer(this);
			head_r3.setRotationPoint(-3.5F, 13.25F, -1.0F);
			head.addChild(head_r3);
			setRotationAngle(head_r3, -0.2618F, 0.0F, 0.0F);
			head_r3.setTextureOffset(16, 41).addBox(3.0F, -26.0F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(24, 25).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			body.setTextureOffset(0, 16).addBox(-4.5F, -1.75F, -2.5F, 9.0F, 8.0F, 5.0F, 0.0F, false);
			body.setTextureOffset(40, 0).addBox(4.0F, -4.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			body.setTextureOffset(32, 18).addBox(-6.0F, -4.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			right_arm_r1 = new ModelRenderer(this);
			right_arm_r1.setRotationPoint(16.0F, 23.25F, -2.75F);
			left_arm.addChild(right_arm_r1);
			setRotationAngle(right_arm_r1, -0.1309F, 0.0F, 0.0F);
			right_arm_r1.setTextureOffset(0, 0).addBox(-6.0F, -18.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(12.5F, 2.0F, -2.0F);
			left_arm.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(32, 12).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(12.5F, 3.5F, -2.0F);
			left_arm.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0436F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(32, 12).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(12.5F, 6.5F, -2.0F);
			left_arm.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(32, 12).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			left_arm_r1 = new ModelRenderer(this);
			left_arm_r1.setRotationPoint(6.0F, 17.5F, -1.0F);
			left_arm.addChild(left_arm_r1);
			setRotationAngle(left_arm_r1, -0.0436F, 0.0F, 0.0F);
			left_arm_r1.setTextureOffset(32, 0).addBox(4.0F, -22.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-9.5F, 2.0F, -2.0F);
			right_arm.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.0436F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(32, 12).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-9.5F, 3.5F, -2.0F);
			right_arm.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.0436F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(32, 12).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			right_arm_r2 = new ModelRenderer(this);
			right_arm_r2.setRotationPoint(-6.0F, 23.25F, -2.75F);
			right_arm.addChild(right_arm_r2);
			setRotationAngle(right_arm_r2, -0.1309F, 0.0F, 0.0F);
			right_arm_r2.setTextureOffset(24, 0).addBox(-6.0F, -18.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-9.5F, 6.5F, -2.0F);
			right_arm.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.0436F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(23, 16).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
			right_arm_r3 = new ModelRenderer(this);
			right_arm_r3.setRotationPoint(-6.0F, 17.5F, -1.0F);
			right_arm.addChild(right_arm_r3);
			setRotationAngle(right_arm_r3, -0.0436F, 0.0F, 0.0F);
			right_arm_r3.setTextureOffset(16, 29).addBox(-6.0F, -22.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-2.0F, 12.0F, 0.1F);
			left_leg.setTextureOffset(8, 29).addBox(3.0F, -4.0F, -1.1F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			left_leg.setTextureOffset(32, 12).addBox(2.5F, -2.5F, -1.6F, 3.0F, 1.0F, 3.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(2.0F, 12.0F, 0.1F);
			right_leg.setTextureOffset(0, 29).addBox(-5.0F, -4.0F, -1.1F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			right_leg.setTextureOffset(32, 12).addBox(-5.5F, -2.5F, -1.6F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
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
			this.left_arm.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
