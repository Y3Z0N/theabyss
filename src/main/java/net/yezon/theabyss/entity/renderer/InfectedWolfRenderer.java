package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.InfectedWolfEntity;

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
public class InfectedWolfRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(InfectedWolfEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelinfected_wolf(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/abyss_wolf.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/abyss_wolf_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelinfected_wolf extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer body;
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer tail;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_leg_back;
		private final ModelRenderer right_leg_back;

		public Modelinfected_wolf() {
			textureWidth = 64;
			textureHeight = 64;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(body);
			body.setTextureOffset(0, 18).addBox(-5.0F, -16.0F, -8.0F, 10.0F, 9.0F, 8.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-4.0F, -15.0F, 0.0F, 8.0F, 8.0F, 10.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, -12.0F, -8.0F);
			main.addChild(mob_head);
			setRotationAngle(mob_head, 0.1309F, 0.0F, 0.0F);
			mob_head.setTextureOffset(28, 10).addBox(-4.0F, -3.0F, -7.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);
			mob_head.setTextureOffset(26, 0).addBox(-2.0F, 0.0F, -12.0F, 4.0F, 4.0F, 5.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-4.0F, 1.0F, -6.0F);
			mob_head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.2618F, 0.0F);
			cube_r1.setTextureOffset(24, 35).addBox(0.55F, -4.0F, 2.0F, 0.0F, 7.0F, 5.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(4.0F, 1.0F, -6.0F);
			mob_head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.2618F, 0.0F);
			cube_r2.setTextureOffset(34, 35).addBox(-0.55F, -4.0F, 2.0F, 0.0F, 7.0F, 5.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-2.0F, -3.0F, -2.0F);
			mob_head.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.2182F, 0.0F, -0.48F);
			cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(2.0F, -3.0F, -2.0F);
			mob_head.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.2182F, 0.0F, 0.48F);
			cube_r4.setTextureOffset(0, 4).addBox(0.0F, -3.0F, 0.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, -10.0F, 10.0F);
			main.addChild(tail);
			tail.setTextureOffset(25, 25).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 11.0F, 0.0F, false);
			tail.setTextureOffset(44, 40).addBox(-2.0F, -2.0F, 11.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.5F, -7.0F, -6.5F);
			main.addChild(left_leg);
			left_leg.setTextureOffset(44, 25).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.5F, -7.0F, -6.5F);
			main.addChild(right_leg);
			right_leg.setTextureOffset(12, 35).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			left_leg_back = new ModelRenderer(this);
			left_leg_back.setRotationPoint(2.5F, -7.0F, 8.5F);
			main.addChild(left_leg_back);
			left_leg_back.setTextureOffset(44, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			right_leg_back = new ModelRenderer(this);
			right_leg_back.setRotationPoint(-2.5F, -7.0F, 8.5F);
			main.addChild(right_leg_back);
			right_leg_back.setTextureOffset(0, 35).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg_back.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg_back.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
