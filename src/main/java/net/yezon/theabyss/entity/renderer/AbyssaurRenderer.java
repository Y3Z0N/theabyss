package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.AbyssaurEntity;

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
public class AbyssaurRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AbyssaurEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabysaurus_rex(), 0.7999999999999999f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/abysaurus_rex.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/abysaurus_rex_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelabysaurus_rex extends EntityModel<Entity> {
		private final ModelRenderer entity_tail;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer entity_leg_left;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer entity_head;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer entitiy_arm_left;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer entitiy_arm_right;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer body;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer entity_leg_right;
		private final ModelRenderer cube_r26;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer cube_r30;
		private final ModelRenderer cube_r31;
		public Modelabysaurus_rex() {
			textureWidth = 256;
			textureHeight = 256;
			entity_tail = new ModelRenderer(this);
			entity_tail.setRotationPoint(0.4F, -2.2F, 12.75F);
			setRotationAngle(entity_tail, -0.1309F, 0.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-0.4F, 2.8333F, 14.1937F);
			entity_tail.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(68, 27).addBox(-4.5F, -4.7882F, 0.2801F, 9.0F, 9.0F, 12.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-0.4F, 27.7F, -13.8F);
			entity_tail.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0873F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(88, 89).addBox(-5.5F, -33.5F, 19.0F, 11.0F, 11.0F, 10.0F, 0.0F, false);
			cube_r2.setTextureOffset(52, 76).addBox(-6.5F, -35.0F, 10.5F, 13.0F, 13.0F, 10.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.1F, 4.8507F, 33.3459F);
			entity_tail.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2618F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(32, 99).addBox(-3.0F, -6.3006F, 0.3274F, 5.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-0.4F, 4.3719F, 25.4912F);
			entity_tail.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.1745F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(88, 64).addBox(-3.5F, -5.8348F, -2.0431F, 7.0F, 7.0F, 12.0F, 0.0F, false);
			entity_leg_left = new ModelRenderer(this);
			entity_leg_left.setRotationPoint(8.5F, -0.7857F, 6.0714F);
			entity_leg_left.setTextureOffset(55, 99).addBox(-1.75F, 21.7857F, -7.0714F, 5.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-1.05F, 24.6857F, -6.3214F);
			entity_leg_left.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0436F, 0.2618F, 0.0F);
			cube_r5.setTextureOffset(0, 71).addBox(-0.9519F, -1.9F, -3.1624F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.75F, 24.5357F, -6.0714F);
			entity_leg_left.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0873F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(78, 48).addBox(-1.0F, -2.0F, -4.25F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(2.25F, 24.7857F, -6.0714F);
			entity_leg_left.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0436F, -0.3054F, 0.0F);
			cube_r7.setTextureOffset(78, 54).addBox(-0.9876F, -2.0F, -3.9079F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-11.5F, 24.7857F, -6.0714F);
			entity_leg_left.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.3491F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(98, 10).addBox(10.0F, -29.5F, -8.5F, 5.0F, 14.0F, 11.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-10.75F, 24.7857F, -6.0714F);
			entity_leg_left.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.6109F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(32, 116).addBox(10.0F, -15.0F, -1.25F, 3.0F, 13.0F, 4.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-10.75F, 24.7857F, -6.0714F);
			entity_leg_left.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.7854F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(104, 110).addBox(9.5F, -9.0F, 13.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
			entity_head = new ModelRenderer(this);
			entity_head.setRotationPoint(0.0F, -8.3333F, -28.5F);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 5.5833F, -10.5F);
			entity_head.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.3927F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 18).addBox(-4.5F, -2.8942F, -12.8346F, 9.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r11.setTextureOffset(41, 31).addBox(4.5F, -2.8942F, -12.8346F, 0.0F, 1.0F, 13.0F, 0.0F, false);
			cube_r11.setTextureOffset(41, 30).addBox(-4.5F, -2.8942F, -12.8346F, 0.0F, 1.0F, 13.0F, 0.0F, false);
			cube_r11.setTextureOffset(78, 48).addBox(-4.5F, -1.8942F, -12.8346F, 9.0F, 3.0F, 13.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.5192F, -18.1464F);
			entity_head.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0873F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(41, 28).addBox(5.0F, 4.0F, -6.5F, 0.0F, 2.0F, 13.0F, 0.0F, false);
			cube_r12.setTextureOffset(41, 26).addBox(-5.0F, 4.0F, -6.5F, 0.0F, 2.0F, 13.0F, 0.0F, false);
			cube_r12.setTextureOffset(0, 16).addBox(-5.0F, 4.0F, -6.5F, 10.0F, 2.0F, 0.0F, 0.0F, false);
			cube_r12.setTextureOffset(58, 0).addBox(-5.0F, -4.0F, -6.5F, 10.0F, 8.0F, 13.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, 34.5833F, 28.5F);
			entity_head.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0873F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(0, 39).addBox(-7.0F, -43.5F, -37.5F, 14.0F, 13.0F, 13.0F, 0.0F, false);
			entitiy_arm_left = new ModelRenderer(this);
			entitiy_arm_left.setRotationPoint(7.5F, -0.3333F, -18.5417F);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-0.975F, 10.5237F, -2.8439F);
			entitiy_arm_left.addChild(cube_r14);
			setRotationAngle(cube_r14, 1.0036F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(8, 19).addBox(1.4F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-0.775F, 10.6714F, -2.7875F);
			entitiy_arm_left.addChild(cube_r15);
			setRotationAngle(cube_r15, 1.0036F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(12, 19).addBox(-0.625F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-7.5F, 21.8333F, 20.0417F);
			entitiy_arm_left.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0436F, 0.0F, 0.0F);
			cube_r16.setTextureOffset(18, 0).addBox(6.125F, -14.15F, -22.975F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r16.setTextureOffset(17, 18).addBox(7.9F, -14.3F, -23.025F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-7.5F, 21.8333F, 20.0417F);
			entitiy_arm_left.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.6981F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(14, 115).addBox(5.5F, -32.0F, -4.0F, 4.0F, 8.0F, 5.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(-7.5F, 21.8333F, 20.0417F);
			entitiy_arm_left.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.6109F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(58, 0).addBox(6.0F, -5.0F, -27.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			entitiy_arm_right = new ModelRenderer(this);
			entitiy_arm_right.setRotationPoint(-7.5F, -0.8333F, -19.0417F);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(7.5F, 22.3333F, 20.5417F);
			entitiy_arm_right.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0436F, 0.0F, 0.0F);
			cube_r19.setTextureOffset(14, 0).addBox(-8.9F, -14.3F, -23.025F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r19.setTextureOffset(0, 0).addBox(-7.125F, -14.15F, -22.975F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(0.975F, 11.0237F, -2.3439F);
			entitiy_arm_right.addChild(cube_r20);
			setRotationAngle(cube_r20, 1.0036F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(4, 19).addBox(-2.4F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.775F, 11.1714F, -2.2875F);
			entitiy_arm_right.addChild(cube_r21);
			setRotationAngle(cube_r21, 1.0036F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(0, 19).addBox(-0.375F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(7.5F, 21.8333F, 20.0417F);
			entitiy_arm_right.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.6981F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(91, 0).addBox(-9.5F, -32.0F, -4.0F, 4.0F, 8.0F, 5.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(7.5F, 21.8333F, 20.0417F);
			entitiy_arm_right.addChild(cube_r23);
			setRotationAngle(cube_r23, -0.6109F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(0, 39).addBox(-9.0F, -5.0F, -27.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.6167F, 12.5F);
			setRotationAngle(body, -0.0436F, 0.0F, 0.0F);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(0.0F, 25.0516F, -12.1556F);
			body.addChild(cube_r24);
			setRotationAngle(cube_r24, -0.3491F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(40, 51).addBox(-6.0F, -25.8071F, -41.713F, 12.0F, 11.0F, 14.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.0F, 25.0516F, -12.1556F);
			body.addChild(cube_r25);
			setRotationAngle(cube_r25, -0.0436F, 0.0F, 0.0F);
			cube_r25.setTextureOffset(0, 65).addBox(-7.0F, -35.0F, -24.5F, 14.0F, 13.0F, 12.0F, 0.0F, false);
			cube_r25.setTextureOffset(110, 35).addBox(-8.0F, -35.275F, -13.5F, 16.0F, 14.0F, 2.0F, 0.0F, false);
			cube_r25.setTextureOffset(68, 110).addBox(-8.0F, -35.0F, 10.5F, 16.0F, 14.0F, 2.0F, 0.0F, false);
			cube_r25.setTextureOffset(0, 0).addBox(-9.0F, -37.0F, -11.5F, 18.0F, 17.0F, 22.0F, 0.0F, false);
			entity_leg_right = new ModelRenderer(this);
			entity_leg_right.setRotationPoint(-8.5F, -0.7857F, 6.0714F);
			entity_leg_right.setTextureOffset(21, 90).addBox(-3.25F, 21.7857F, -7.0714F, 5.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(1.05F, 24.6857F, -6.3214F);
			entity_leg_right.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.0436F, -0.2618F, 0.0F);
			cube_r26.setTextureOffset(41, 45).addBox(-1.0481F, -1.9F, -3.1624F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(-0.75F, 24.5357F, -6.0714F);
			entity_leg_right.addChild(cube_r27);
			setRotationAngle(cube_r27, 0.0873F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(53, 45).addBox(-1.0F, -2.0F, -4.25F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(-2.25F, 24.7857F, -6.0714F);
			entity_leg_right.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.0436F, 0.3054F, 0.0F);
			cube_r28.setTextureOffset(0, 65).addBox(-1.0124F, -2.0F, -3.9079F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(11.5F, 24.7857F, -6.0714F);
			entity_leg_right.addChild(cube_r29);
			setRotationAngle(cube_r29, -0.3491F, 0.0F, 0.0F);
			cube_r29.setTextureOffset(0, 90).addBox(-15.0F, -29.5F, -8.5F, 5.0F, 14.0F, 11.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(10.75F, 24.7857F, -6.0714F);
			entity_leg_right.addChild(cube_r30);
			setRotationAngle(cube_r30, -0.6109F, 0.0F, 0.0F);
			cube_r30.setTextureOffset(0, 115).addBox(-13.0F, -15.0F, -1.25F, 3.0F, 13.0F, 4.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(10.75F, 24.7857F, -6.0714F);
			entity_leg_right.addChild(cube_r31);
			setRotationAngle(cube_r31, 0.7854F, 0.0F, 0.0F);
			cube_r31.setTextureOffset(0, 0).addBox(-13.5F, -9.0F, 13.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			entity_tail.render(matrixStack, buffer, packedLight, packedOverlay);
			entity_leg_left.render(matrixStack, buffer, packedLight, packedOverlay);
			entity_head.render(matrixStack, buffer, packedLight, packedOverlay);
			entitiy_arm_left.render(matrixStack, buffer, packedLight, packedOverlay);
			entitiy_arm_right.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			entity_leg_right.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.entity_tail.rotateAngleY = MathHelper.cos(f * 0.2F) * -0.2F * f1;
			this.entity_leg_right.rotateAngleX = MathHelper.cos(f * 0.5F) * 1.0F * f1;
			this.entitiy_arm_left.rotateAngleX = MathHelper.cos(f * 0.3F) * f1;
			this.entity_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.entity_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.entity_leg_left.rotateAngleX = MathHelper.cos(f * 0.5F) * -1.0F * f1;
			this.entitiy_arm_right.rotateAngleX = MathHelper.cos(f * 0.3F + (float) Math.PI) * f1;
		}
	}
}
