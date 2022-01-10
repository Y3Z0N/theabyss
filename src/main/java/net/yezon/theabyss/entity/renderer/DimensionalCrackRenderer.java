package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.DimensionalCrackEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
public class DimensionalCrackRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(DimensionalCrackEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeldimensional_crack(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/dimensional_crack.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/dimensional_crack.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modeldimensional_crack extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer big_crystal;
		private final ModelRenderer cube_middle;
		private final ModelRenderer cube_r1;
		private final ModelRenderer crack;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer crystal1;
		private final ModelRenderer cube_r7;
		private final ModelRenderer crystal2;
		private final ModelRenderer cube_r8;
		private final ModelRenderer crystal3;
		private final ModelRenderer cube_r9;
		private final ModelRenderer crystal4;
		private final ModelRenderer cube_r10;
		private final ModelRenderer small_crystal1;
		private final ModelRenderer cube_r11;
		private final ModelRenderer small_crystal2;
		private final ModelRenderer cube_r12;
		private final ModelRenderer small_crystal3;
		private final ModelRenderer cube_r13;

		public Modeldimensional_crack() {
			textureWidth = 128;
			textureHeight = 128;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 2.5F, 0.0F);
			big_crystal = new ModelRenderer(this);
			big_crystal.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(big_crystal);
			cube_middle = new ModelRenderer(this);
			cube_middle.setRotationPoint(0.0F, -8.0F, 0.0F);
			big_crystal.addChild(cube_middle);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			cube_middle.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.4606F, -0.4267F, -0.6826F);
			cube_r1.setTextureOffset(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			crack = new ModelRenderer(this);
			crack.setRotationPoint(0.0F, 0.0F, 0.0F);
			big_crystal.addChild(crack);
			crack.setTextureOffset(0, 32).addBox(-12.0F, -22.0F, 0.0F, 24.0F, 28.0F, 0.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-0.15F, -13.075F, 0.0F);
			crack.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.48F, -2.0508F);
			cube_r2.setTextureOffset(0, 12).addBox(0.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-2.1F, -7.625F, 0.0F);
			crack.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.48F, 2.5744F);
			cube_r3.setTextureOffset(48, 12).addBox(0.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-4.1F, -9.25F, 0.0F);
			crack.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.48F, -2.6616F);
			cube_r4.setTextureOffset(9, 60).addBox(0.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(3.9F, -9.25F, 0.0F);
			crack.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.48F, -0.48F);
			cube_r5.setTextureOffset(60, 12).addBox(0.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.6F, -5.075F, 0.0F);
			crack.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.48F, 0.4363F);
			cube_r6.setTextureOffset(21, 60).addBox(0.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, false);
			crystal1 = new ModelRenderer(this);
			crystal1.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(crystal1);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-40.0F, -19.0F, 0.0F);
			crystal1.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.4606F, -0.4267F, -0.6826F);
			cube_r7.setTextureOffset(42, 56).addBox(-8.0F, 2.0F, 2.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			crystal2 = new ModelRenderer(this);
			crystal2.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(crystal2);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(48.0F, -28.0F, 0.0F);
			crystal2.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.4606F, -0.4267F, -0.6826F);
			cube_r8.setTextureOffset(48, 44).addBox(-8.0F, 2.0F, 2.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			crystal3 = new ModelRenderer(this);
			crystal3.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(crystal3);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, -11.0F, 56.0F);
			crystal3.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.4606F, -0.4267F, -0.6826F);
			cube_r9.setTextureOffset(48, 32).addBox(-8.0F, 2.0F, 2.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			crystal4 = new ModelRenderer(this);
			crystal4.setRotationPoint(0.0F, -10.0F, 0.0F);
			main.addChild(crystal4);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, -16.0F, -49.0F);
			crystal4.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.4606F, -0.4267F, -0.6826F);
			cube_r10.setTextureOffset(48, 0).addBox(-8.0F, 2.0F, 2.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			small_crystal1 = new ModelRenderer(this);
			small_crystal1.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(small_crystal1);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-21.0F, -26.0F, 0.0F);
			small_crystal1.addChild(cube_r11);
			setRotationAngle(cube_r11, -0.4606F, -0.4267F, -0.6826F);
			cube_r11.setTextureOffset(0, 60).addBox(-5.0F, 5.0F, 5.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			small_crystal2 = new ModelRenderer(this);
			small_crystal2.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(small_crystal2);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(20.0F, -13.0F, 0.0F);
			small_crystal2.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.4606F, -0.4267F, -0.6826F);
			cube_r12.setTextureOffset(0, 6).addBox(-5.0F, 5.0F, 5.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			small_crystal3 = new ModelRenderer(this);
			small_crystal3.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(small_crystal3);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, -19.0F, 22.0F);
			small_crystal3.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.4606F, -0.4267F, -0.6826F);
			cube_r13.setTextureOffset(0, 0).addBox(-5.0F, 5.0F, 5.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
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

			this.crystal4.rotateAngleX = f2 / 20.f;
			this.crystal3.rotateAngleX = f2 / 20.f;
			this.small_crystal3.rotateAngleX = f2 / 20.f;
			this.crystal2.rotateAngleZ = f2 / 20.f;
			this.small_crystal2.rotateAngleZ = f2 / 20.f;
			this.crystal1.rotateAngleZ = f2 / 20.f;
			this.small_crystal1.rotateAngleZ = f2 / 20.f;
			this.cube_middle.rotateAngleY = f2 / 20.f;
		}
	}

}
