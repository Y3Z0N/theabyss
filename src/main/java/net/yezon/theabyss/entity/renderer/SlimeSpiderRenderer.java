package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.SlimeSpiderEntity;

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
public class SlimeSpiderRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SlimeSpiderEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelslime_spider(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/slime_spider.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/slime_spider_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelslime_spider extends EntityModel<Entity> {
		private final ModelRenderer BODY;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer HEAD;
		private final ModelRenderer CLAWL;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer CLAWR;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer LEG_L_1;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer LEG_L_2;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer LEG_L_3;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer LEG_L_4;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer LEG_R_1;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer LEG_R_2;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer cube_r26;
		private final ModelRenderer LEG_R_3;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer LEG_R_4;
		private final ModelRenderer cube_r30;
		private final ModelRenderer cube_r31;
		private final ModelRenderer cube_r32;

		public Modelslime_spider() {
			textureWidth = 128;
			textureHeight = 128;
			BODY = new ModelRenderer(this);
			BODY.setRotationPoint(0.5F, 24.0F, 0.0F);
			BODY.setTextureOffset(0, 23).addBox(-5.25F, -11.75F, -7.5F, 9.0F, 8.0F, 12.0F, 0.0F, false);
			BODY.setTextureOffset(36, 49).addBox(-4.75F, -9.0F, -12.0F, 8.0F, 6.0F, 9.0F, 0.0F, false);
			BODY.setTextureOffset(48, 29).addBox(-3.75F, -13.25F, 7.5F, 6.0F, 2.0F, 12.0F, 0.0F, false);
			BODY.setTextureOffset(58, 0).addBox(-3.75F, -13.25F, -6.75F, 6.0F, 2.0F, 10.0F, 0.0F, false);
			BODY.setTextureOffset(0, 0).addBox(-6.5F, -11.75F, 6.0F, 11.0F, 8.0F, 15.0F, 0.0F, false);
			BODY.setTextureOffset(37, 0).addBox(-5.0F, -10.5F, 21.0F, 8.0F, 6.0F, 2.0F, 0.0F, false);
			BODY.setTextureOffset(58, 12).addBox(-5.0F, -10.5F, 4.5F, 8.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-12.0F, -6.75F, 12.0F);
			BODY.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.1745F, 0.0F);
			cube_r1.setTextureOffset(28, 29).addBox(4.0F, -4.0F, -4.25F, 3.0F, 6.0F, 14.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(12.0F, -6.75F, 12.0F);
			BODY.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -0.1745F, 0.0F);
			cube_r2.setTextureOffset(38, 9).addBox(-9.0F, -4.0F, -3.75F, 3.0F, 6.0F, 14.0F, 0.0F, false);
			HEAD = new ModelRenderer(this);
			HEAD.setRotationPoint(-0.25F, 16.5F, -10.5F);
			HEAD.setTextureOffset(0, 43).addBox(-4.5F, -5.0F, -8.25F, 9.0F, 8.0F, 9.0F, 0.0F, false);
			HEAD.setTextureOffset(46, 8).addBox(-3.375F, -3.625F, -9.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			HEAD.setTextureOffset(36, 32).addBox(2.375F, -3.625F, -9.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			HEAD.setTextureOffset(8, 12).addBox(1.5F, 0.125F, -9.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			HEAD.setTextureOffset(27, 49).addBox(2.625F, -1.75F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			HEAD.setTextureOffset(0, 12).addBox(-4.625F, -1.75F, -9.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			HEAD.setTextureOffset(9, 0).addBox(-2.5F, 0.125F, -9.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			CLAWL = new ModelRenderer(this);
			CLAWL.setRotationPoint(5.25F, -0.75F, -6.0F);
			HEAD.addChild(CLAWL);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			CLAWL.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2618F, -0.2618F, 0.0F);
			cube_r3.setTextureOffset(18, 60).addBox(-1.5F, -1.5F, -3.75F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0907F, 2.1826F, -8.3428F);
			CLAWL.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.2618F, 0.9599F, 0.0F);
			cube_r4.setTextureOffset(12, 60).addBox(-1.5F, -0.5F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			CLAWL.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.2618F, 0.3054F, 0.0F);
			cube_r5.setTextureOffset(12, 69).addBox(1.0F, -0.75F, -7.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);
			CLAWR = new ModelRenderer(this);
			CLAWR.setRotationPoint(-4.75F, -0.75F, -6.0F);
			HEAD.addChild(CLAWR);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			CLAWR.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.2618F, 0.2618F, 0.0F);
			cube_r6.setTextureOffset(0, 60).addBox(-1.5F, -1.5F, -3.75F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-0.0907F, 2.1826F, -8.3428F);
			CLAWR.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.2618F, -0.9599F, 0.0F);
			cube_r7.setTextureOffset(52, 3).addBox(0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			CLAWR.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.2618F, -0.3054F, 0.0F);
			cube_r8.setTextureOffset(37, 8).addBox(-3.0F, -0.75F, -7.5F, 2.0F, 2.0F, 5.0F, 0.0F, false);
			LEG_L_1 = new ModelRenderer(this);
			LEG_L_1.setRotationPoint(2.0F, 15.75F, -9.0F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(13.5F, 4.0F, -7.0F);
			LEG_L_1.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, -0.1309F);
			cube_r9.setTextureOffset(50, 76).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(10.0F, -3.0F, -3.0F);
			LEG_L_1.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.5236F, 0.0F, -1.0908F);
			cube_r10.setTextureOffset(34, 76).addBox(-1.0F, -3.75F, -2.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(3.0F, -4.5F, 0.0F);
			LEG_L_1.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.4363F, 0.3927F, 1.1345F);
			cube_r11.setTextureOffset(0, 69).addBox(1.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_L_2 = new ModelRenderer(this);
			LEG_L_2.setRotationPoint(2.0F, 15.75F, -5.5F);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(13.5F, 4.0F, -6.0F);
			LEG_L_2.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, -0.1309F);
			cube_r12.setTextureOffset(46, 76).addBox(0.25F, -5.75F, 2.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(10.0F, -3.0F, -2.0F);
			LEG_L_2.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.3054F, 0.0F, -1.0908F);
			cube_r13.setTextureOffset(12, 76).addBox(-1.0F, -3.75F, -0.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(3.0F, -4.5F, 1.0F);
			LEG_L_2.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.1309F, 0.3927F, 1.1345F);
			cube_r14.setTextureOffset(60, 64).addBox(1.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_L_3 = new ModelRenderer(this);
			LEG_L_3.setRotationPoint(2.0F, 15.75F, -1.0F);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(13.5F, 4.0F, -5.0F);
			LEG_L_3.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, -0.1309F);
			cube_r15.setTextureOffset(72, 31).addBox(1.5F, -4.75F, 5.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(10.0F, -3.0F, -1.0F);
			LEG_L_3.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, -1.0908F);
			cube_r16.setTextureOffset(73, 43).addBox(-1.0F, -3.5F, 0.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(3.0F, -4.5F, 2.0F);
			LEG_L_3.addChild(cube_r17);
			setRotationAngle(cube_r17, -0.0436F, 0.3927F, 1.1345F);
			cube_r17.setTextureOffset(48, 64).addBox(1.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_L_4 = new ModelRenderer(this);
			LEG_L_4.setRotationPoint(2.5F, 15.75F, 3.5F);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(13.0F, 4.0F, -4.0F);
			LEG_L_4.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, -0.1309F);
			cube_r18.setTextureOffset(4, 43).addBox(0.25F, -3.75F, 11.25F, 1.0F, 8.0F, 1.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(9.5F, -3.0F, 0.0F);
			LEG_L_4.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.5236F, 0.0F, -1.0908F);
			cube_r19.setTextureOffset(72, 67).addBox(-2.0F, -0.75F, 3.5F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(2.5F, -4.5F, 3.0F);
			LEG_L_4.addChild(cube_r20);
			setRotationAngle(cube_r20, -0.5672F, 0.3927F, 1.1345F);
			cube_r20.setTextureOffset(36, 64).addBox(1.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_R_1 = new ModelRenderer(this);
			LEG_R_1.setRotationPoint(-2.0F, 15.75F, -9.0F);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-13.5F, 4.0F, -7.0F);
			LEG_R_1.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.0F, 0.1309F);
			cube_r21.setTextureOffset(42, 76).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-10.0F, -3.0F, -3.0F);
			LEG_R_1.addChild(cube_r22);
			setRotationAngle(cube_r22, -0.5236F, 0.0F, 1.0908F);
			cube_r22.setTextureOffset(72, 20).addBox(-1.0F, -3.75F, -2.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-3.0F, -4.5F, 0.0F);
			LEG_R_1.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.4363F, -0.3927F, -1.1345F);
			cube_r23.setTextureOffset(61, 46).addBox(-4.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_R_2 = new ModelRenderer(this);
			LEG_R_2.setRotationPoint(-2.0F, 15.75F, -5.5F);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(-13.5F, 4.0F, -6.0F);
			LEG_R_2.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.0F, 0.0F, 0.1309F);
			cube_r24.setTextureOffset(20, 76).addBox(-1.25F, -5.75F, 2.5F, 1.0F, 10.0F, 1.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(-10.0F, -3.0F, -2.0F);
			LEG_R_2.addChild(cube_r25);
			setRotationAngle(cube_r25, -0.3054F, 0.0F, 1.0908F);
			cube_r25.setTextureOffset(71, 56).addBox(-1.0F, -3.75F, -0.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(-3.0F, -4.5F, 1.0F);
			LEG_R_2.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.1309F, -0.3927F, -1.1345F);
			cube_r26.setTextureOffset(48, 29).addBox(-4.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_R_3 = new ModelRenderer(this);
			LEG_R_3.setRotationPoint(-2.0F, 15.75F, -1.0F);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(-13.5F, 4.0F, -5.0F);
			LEG_R_3.addChild(cube_r27);
			setRotationAngle(cube_r27, 0.0F, 0.0F, 0.1309F);
			cube_r27.setTextureOffset(64, 0).addBox(-2.5F, -4.75F, 5.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(-10.0F, -3.0F, -1.0F);
			LEG_R_3.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.0F, 0.0F, 1.0908F);
			cube_r28.setTextureOffset(26, 69).addBox(-1.0F, -3.5F, 0.75F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(-3.0F, -4.5F, 2.0F);
			LEG_R_3.addChild(cube_r29);
			setRotationAngle(cube_r29, -0.0436F, -0.3927F, -1.1345F);
			cube_r29.setTextureOffset(0, 23).addBox(-4.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEG_R_4 = new ModelRenderer(this);
			LEG_R_4.setRotationPoint(-2.5F, 15.75F, 3.5F);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(-13.0F, 4.0F, -4.0F);
			LEG_R_4.addChild(cube_r30);
			setRotationAngle(cube_r30, 0.0F, 0.0F, 0.1309F);
			cube_r30.setTextureOffset(0, 43).addBox(-1.25F, -3.75F, 11.25F, 1.0F, 8.0F, 1.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(-9.5F, -3.0F, 0.0F);
			LEG_R_4.addChild(cube_r31);
			setRotationAngle(cube_r31, 0.5236F, 0.0F, 1.0908F);
			cube_r31.setTextureOffset(30, 23).addBox(0.0F, -0.75F, 3.5F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(-2.5F, -4.5F, 3.0F);
			LEG_R_4.addChild(cube_r32);
			setRotationAngle(cube_r32, -0.5672F, -0.3927F, -1.1345F);
			cube_r32.setTextureOffset(0, 0).addBox(-4.0F, -4.5F, -2.0F, 3.0F, 9.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			BODY.render(matrixStack, buffer, packedLight, packedOverlay);
			HEAD.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_L_1.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_L_2.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_L_3.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_L_4.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_R_1.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_R_2.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_R_3.render(matrixStack, buffer, packedLight, packedOverlay);
			LEG_R_4.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LEG_L_1.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEG_L_2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEG_L_3.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEG_R_2.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEG_R_3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEG_R_4.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LEG_L_4.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEG_R_1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
