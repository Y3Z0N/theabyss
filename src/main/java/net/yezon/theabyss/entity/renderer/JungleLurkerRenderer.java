package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.JungleLurkerEntity;

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
public class JungleLurkerRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(JungleLurkerEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabyss_lurker(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/the_abyss_lurker.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/the_abyss_lurker_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelabyss_lurker extends EntityModel<Entity> {
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer left_arm;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer cube_r26;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer cube_r30;
		private final ModelRenderer cube_r31;
		private final ModelRenderer cube_r32;
		private final ModelRenderer cube_r33;
		private final ModelRenderer cube_r34;
		private final ModelRenderer body;
		private final ModelRenderer cube_r35;
		private final ModelRenderer cube_r36;

		public Modelabyss_lurker() {
			textureWidth = 64;
			textureHeight = 64;
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-2.5F, 3.925F, -1.25F);
			setRotationAngle(right_arm, -0.0613F, -0.05F, 0.2846F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-0.5F, 0.95F, 0.75F);
			right_arm.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.8727F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(32, 47).addBox(-1.0F, -1.5F, -2.75F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(16, 35).addBox(0.0F, 3.5F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(8, 45).addBox(-0.5F, 1.5F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.025F, 6.2535F, -4.1324F);
			right_arm.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.8727F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(3, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.025F, 5.8754F, -5.4846F);
			right_arm.addChild(cube_r3);
			setRotationAngle(cube_r3, -1.3963F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-0.45F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(2.5F, 3.925F, -1.25F);
			setRotationAngle(left_arm, -0.0613F, 0.05F, -0.2846F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.5F, 0.95F, 0.75F);
			left_arm.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.8727F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(50, 24).addBox(-1.0F, -1.5F, -2.75F, 2.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(42, 0).addBox(-1.0F, 3.5F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(52, 7).addBox(-1.5F, 1.5F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.025F, 6.2535F, -4.1324F);
			left_arm.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.8727F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(8, 10).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.025F, 5.8754F, -5.4846F);
			left_arm.addChild(cube_r6);
			setRotationAngle(cube_r6, -1.3963F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(50, 35).addBox(-0.55F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, 12.0F, 4.0F);
			setRotationAngle(right_leg, 0.0F, 0.1745F, 0.0F);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-0.5F, 10.6202F, -3.2607F);
			right_leg.addChild(cube_r7);
			setRotationAngle(cube_r7, -1.1345F, 0.3054F, 0.0F);
			cube_r7.setTextureOffset(0, 0).addBox(-1.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r7.setTextureOffset(22, 23).addBox(-1.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-0.5F, 10.6202F, -3.2607F);
			right_leg.addChild(cube_r8);
			setRotationAngle(cube_r8, -1.1345F, -0.3054F, 0.0F);
			cube_r8.setTextureOffset(0, 1).addBox(0.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r8.setTextureOffset(28, 0).addBox(0.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.65F, 10.9772F, -0.0212F);
			right_leg.addChild(cube_r9);
			setRotationAngle(cube_r9, -1.309F, 0.0F, -0.5236F);
			cube_r9.setTextureOffset(38, 49).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-1.6F, 10.9772F, -0.0212F);
			right_leg.addChild(cube_r10);
			setRotationAngle(cube_r10, -1.309F, 0.0F, 0.5236F);
			cube_r10.setTextureOffset(50, 30).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-1.0F, -0.5F, 1.0F);
			right_leg.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.0472F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 35).addBox(-0.5F, 5.5F, 7.025F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r11.setTextureOffset(46, 42).addBox(0.0F, 5.5F, 2.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r11.setTextureOffset(0, 45).addBox(-0.5F, -0.5F, -2.0F, 2.0F, 8.0F, 4.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-1.3105F, 4.5781F, -6.7005F);
			right_leg.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.246F, -0.0664F, -0.0497F);
			cube_r12.setTextureOffset(0, 0).addBox(0.9889F, -4.0646F, -1.6483F, 0.0F, 4.0F, 4.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, 12.0F, 4.0F);
			setRotationAngle(left_leg, 0.0F, -0.1745F, 0.0F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.5F, 10.6202F, -3.2607F);
			left_leg.addChild(cube_r13);
			setRotationAngle(cube_r13, -1.1345F, -0.3054F, 0.0F);
			cube_r13.setTextureOffset(0, 2).addBox(0.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r13.setTextureOffset(24, 55).addBox(0.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.5F, 10.6202F, -3.2607F);
			left_leg.addChild(cube_r14);
			setRotationAngle(cube_r14, -1.1345F, 0.3054F, 0.0F);
			cube_r14.setTextureOffset(5, 2).addBox(-1.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r14.setTextureOffset(28, 55).addBox(-1.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-0.65F, 10.9772F, -0.0212F);
			left_leg.addChild(cube_r15);
			setRotationAngle(cube_r15, -1.309F, 0.0F, 0.5236F);
			cube_r15.setTextureOffset(44, 50).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(1.6F, 10.9772F, -0.0212F);
			left_leg.addChild(cube_r16);
			setRotationAngle(cube_r16, -1.309F, 0.0F, -0.5236F);
			cube_r16.setTextureOffset(50, 51).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(1.0F, -0.5F, 1.0F);
			left_leg.addChild(cube_r17);
			setRotationAngle(cube_r17, -1.0472F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(0, 38).addBox(-1.5F, 5.5F, 7.025F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r17.setTextureOffset(24, 47).addBox(-1.0F, 5.5F, 2.0F, 1.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r17.setTextureOffset(12, 47).addBox(-1.5F, -0.5F, -2.0F, 2.0F, 8.0F, 4.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(1.3105F, 4.5781F, -6.7005F);
			left_leg.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.246F, 0.0664F, 0.0497F);
			cube_r18.setTextureOffset(0, 23).addBox(-0.9889F, -4.0646F, -1.6483F, 0.0F, 4.0F, 4.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, -4.0F, -4.0F);
			setRotationAngle(mob_head, -0.1309F, 0.0F, 0.0F);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-5.0F, -4.8745F, 4.8524F);
			mob_head.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.9163F, -0.4363F, -0.3491F);
			cube_r19.setTextureOffset(20, 29).addBox(-0.6768F, -0.3495F, -4.2882F, 3.0F, 0.0F, 10.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(5.0F, -4.8745F, 4.8524F);
			mob_head.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.9163F, 0.4363F, 0.3491F);
			cube_r20.setTextureOffset(26, 29).addBox(-2.3232F, -0.3495F, -4.2882F, 3.0F, 0.0F, 10.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.0F, -4.683F, 5.0131F);
			mob_head.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.6981F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(0, 23).addBox(-3.5F, -2.5952F, -4.0765F, 7.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(0.0F, 2.616F, -4.6292F);
			mob_head.addChild(cube_r22);
			setRotationAngle(cube_r22, 1.4399F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(0, 3).addBox(-2.0F, 1.4438F, -3.8232F, 0.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r22.setTextureOffset(26, 24).addBox(-2.0F, 1.4438F, -3.8232F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r22.setTextureOffset(0, 2).addBox(2.0F, 1.4438F, -3.8232F, 0.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r22.setTextureOffset(42, 0).addBox(-2.0F, 2.4438F, -3.8232F, 4.0F, 1.0F, 6.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(0.0F, 8.4279F, -2.6206F);
			mob_head.addChild(cube_r23);
			setRotationAngle(cube_r23, 1.7453F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(33, 12).addBox(-2.0F, 0.5111F, -1.2393F, 4.0F, 0.0F, 3.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(-0.75F, -1.5F, 0.5F);
			mob_head.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.5236F, -0.2618F, 0.0F);
			cube_r24.setTextureOffset(52, 11).addBox(-2.8226F, -1.8219F, -2.627F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.75F, -1.5F, 0.5F);
			mob_head.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.5236F, 0.2618F, 0.0F);
			cube_r25.setTextureOffset(35, 54).addBox(1.8226F, -1.8219F, -2.627F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(0.0F, -1.5F, 0.5F);
			mob_head.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.5236F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(0, 35).addBox(-2.5F, -2.8266F, -3.6353F, 5.0F, 4.0F, 6.0F, 0.0F, false);
			cube_r26.setTextureOffset(25, 23).addBox(-2.0F, 1.1734F, -8.6353F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r26.setTextureOffset(0, 6).addBox(1.975F, 1.1734F, -8.6353F, 0.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r26.setTextureOffset(0, 5).addBox(-1.975F, 1.1734F, -8.6353F, 0.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r26.setTextureOffset(42, 16).addBox(-2.0F, -1.8266F, -8.6353F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 11.0F, 4.25F);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(0.0F, 1.8219F, 1.0074F);
			mob_tail.addChild(cube_r27);
			setRotationAngle(cube_r27, -0.5236F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(24, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(0.0F, -8.4395F, 18.3459F);
			mob_tail.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.9404F, -1.4731F, 0.6178F);
			cube_r28.setTextureOffset(0, 0).addBox(-1.3521F, -0.0325F, -3.8533F, 1.0F, 0.0F, 8.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(1.0F, -3.6199F, 19.2704F);
			mob_tail.addChild(cube_r29);
			setRotationAngle(cube_r29, 1.3526F, 0.0F, -0.1745F);
			cube_r29.setTextureOffset(16, 0).addBox(-1.5F, -2.0F, 0.75F, 1.0F, 0.0F, 8.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(0.0F, -8.4395F, 18.3459F);
			mob_tail.addChild(cube_r30);
			setRotationAngle(cube_r30, 0.0146F, -1.1728F, 1.5596F);
			cube_r30.setTextureOffset(2, 0).addBox(0.3521F, -0.0325F, -3.8533F, 1.0F, 0.0F, 8.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(-1.0F, -3.6199F, 19.2704F);
			mob_tail.addChild(cube_r31);
			setRotationAngle(cube_r31, 1.3526F, 0.0F, 0.1745F);
			cube_r31.setTextureOffset(18, 0).addBox(0.5F, -2.0F, 0.75F, 1.0F, 0.0F, 8.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(0.0F, -3.6199F, 19.2704F);
			mob_tail.addChild(cube_r32);
			setRotationAngle(cube_r32, 1.3526F, 0.0F, 0.0F);
			cube_r32.setTextureOffset(42, 7).addBox(-0.5F, -2.5F, -3.25F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(0.0F, 2.3804F, 14.7361F);
			mob_tail.addChild(cube_r33);
			setRotationAngle(cube_r33, 0.6545F, 0.0F, 0.0F);
			cube_r33.setTextureOffset(36, 37).addBox(0.0F, -1.0F, -4.0F, 0.0F, 2.0F, 8.0F, 0.0F, false);
			cube_r33.setTextureOffset(14, 37).addBox(-1.5F, -3.0F, -4.0F, 3.0F, 2.0F, 8.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(0.0F, 4.4558F, 7.3196F);
			mob_tail.addChild(cube_r34);
			setRotationAngle(cube_r34, 0.0436F, 0.0F, 0.0F);
			cube_r34.setTextureOffset(28, 34).addBox(0.0F, -0.25F, -3.75F, 0.0F, 3.0F, 8.0F, 0.0F, false);
			cube_r34.setTextureOffset(34, 31).addBox(-2.0F, -3.25F, -3.75F, 4.0F, 3.0F, 8.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(0.0F, -18.5F, 0.0F);
			body.addChild(cube_r35);
			setRotationAngle(cube_r35, -1.0036F, 0.0F, 0.0F);
			cube_r35.setTextureOffset(0, 0).addBox(0.0F, -8.5F, -6.0F, 0.0F, 6.0F, 17.0F, 0.0F, false);
			cube_r35.setTextureOffset(0, 0).addBox(-3.0F, -2.5F, -6.0F, 6.0F, 5.0F, 12.0F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(0.0F, -28.0273F, -6.1603F);
			body.addChild(cube_r36);
			setRotationAngle(cube_r36, -1.5708F, 0.0F, 0.0F);
			cube_r36.setTextureOffset(26, 17).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_head.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_tail.render(matrixStack, buffer, packedLight, packedOverlay);
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
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.mob_tail.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
