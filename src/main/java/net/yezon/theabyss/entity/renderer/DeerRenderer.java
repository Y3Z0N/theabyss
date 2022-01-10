package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.DeerEntity;

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
public class DeerRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DeerEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeldeer(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/deer.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/deer_glow_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeldeer extends EntityModel<Entity> {
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer horn_left;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer horn_right;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer right_leg1;
		private final ModelRenderer left_leg1;
		private final ModelRenderer right_leg2;
		private final ModelRenderer left_leg2;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r14;
		private final ModelRenderer body;
		private final ModelRenderer cube_r15;

		public Modeldeer() {
			textureWidth = 64;
			textureHeight = 64;
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, 5.5F, -8.5F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 5.5F, 2.5F);
			mob_head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(18, 31).addBox(-1.5F, -9.0F, -7.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 23).addBox(-2.5F, -10.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-2.5F, -3.5F, 1.0F);
			mob_head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.4363F, 0.0F, 0.5672F);
			cube_r2.setTextureOffset(16, 25).addBox(-2.25F, -1.2093F, -0.6941F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(2.5F, -3.5F, 1.0F);
			mob_head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.4363F, 0.0F, -0.5672F);
			cube_r3.setTextureOffset(32, 23).addBox(-0.75F, -1.2093F, -0.6941F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			horn_left = new ModelRenderer(this);
			horn_left.setRotationPoint(3.0244F, -7.5927F, -1.2413F);
			mob_head.addChild(horn_left);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			horn_left.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.5523F, -0.1055F, 1.1188F);
			cube_r4.setTextureOffset(28, 38).addBox(-0.2236F, -5.1972F, -0.6244F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(4.0432F, -1.8554F, -2.1988F);
			horn_left.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.9511F, 0.0735F, 0.5188F);
			cube_r5.setTextureOffset(0, 14).addBox(-3.8021F, -0.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(4.5962F, -1.0826F, -2.3115F);
			horn_left.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.974F, 0.1638F, 0.9501F);
			cube_r6.setTextureOffset(38, 26).addBox(-1.008F, -5.0117F, -0.992F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(4.0432F, -1.8554F, -2.1988F);
			horn_left.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.954F, -0.2493F, 0.9422F);
			cube_r7.setTextureOffset(16, 23).addBox(-4.2521F, -2.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-2.0244F, 4.0927F, 1.2413F);
			horn_left.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.3054F, 0.0F, 0.5236F);
			cube_r8.setTextureOffset(40, 32).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			horn_right = new ModelRenderer(this);
			horn_right.setRotationPoint(-3.0244F, -7.5927F, -1.2413F);
			mob_head.addChild(horn_right);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
			horn_right.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.5523F, 0.1055F, -1.1188F);
			cube_r9.setTextureOffset(10, 10).addBox(-0.7764F, -5.1972F, -0.6244F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-4.0432F, -1.8554F, -2.1988F);
			horn_right.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.9511F, -0.0735F, -0.5188F);
			cube_r10.setTextureOffset(0, 10).addBox(-0.1979F, -0.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-4.5962F, -1.0826F, -2.3115F);
			horn_right.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.974F, -0.1638F, -0.9501F);
			cube_r11.setTextureOffset(0, 23).addBox(0.008F, -5.0117F, -0.992F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-4.0432F, -1.8554F, -2.1988F);
			horn_right.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.954F, 0.2493F, -0.9422F);
			cube_r12.setTextureOffset(0, 12).addBox(0.2521F, -2.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(2.0244F, 4.0927F, 1.2413F);
			horn_right.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.3054F, 0.0F, -0.5236F);
			cube_r13.setTextureOffset(24, 38).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			right_leg1 = new ModelRenderer(this);
			right_leg1.setRotationPoint(-1.25F, 15.25F, -6.5F);
			right_leg1.setTextureOffset(32, 31).addBox(-2.0F, -1.25F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			left_leg1 = new ModelRenderer(this);
			left_leg1.setRotationPoint(1.25F, 15.25F, -6.5F);
			left_leg1.setTextureOffset(0, 33).addBox(0.0F, -1.25F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(-1.25F, 16.0F, 6.0F);
			right_leg2.setTextureOffset(8, 33).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			right_leg2.setTextureOffset(28, 0).addBox(-2.25F, -1.75F, -1.75F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(1.25F, 16.0F, 6.0F);
			left_leg2.setTextureOffset(16, 38).addBox(0.0F, 2.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			left_leg2.setTextureOffset(28, 8).addBox(-0.75F, -1.75F, -1.75F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.0F, -13.0F, 7.0F);
			mob_tail.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.7418F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(22, 23).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-3.0F, -14.0F, -8.0F, 6.0F, 7.0F, 16.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.0F, -13.0F, -6.0F);
			body.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.4363F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			mob_head.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
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
			this.right_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.left_leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.mob_tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
