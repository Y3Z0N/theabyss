package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.ScorpionEntity;

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
public class ScorpionRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ScorpionEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelscorpion(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/the_abyss_scropion.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/the_abyss_scorpion_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelscorpion extends EntityModel<Entity> {
		private final ModelRenderer right_leg4;
		private final ModelRenderer cube_r1;
		private final ModelRenderer right_leg3;
		private final ModelRenderer cube_r2;
		private final ModelRenderer right_leg2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer left_leg4;
		private final ModelRenderer cube_r6;
		private final ModelRenderer left_leg3;
		private final ModelRenderer cube_r7;
		private final ModelRenderer left_leg2;
		private final ModelRenderer cube_r8;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer body;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer left_arm;
		private final ModelRenderer cube_r26;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;

		public Modelscorpion() {
			textureWidth = 64;
			textureHeight = 64;
			right_leg4 = new ModelRenderer(this);
			right_leg4.setRotationPoint(0.0F, 19.0F, 2.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-3.3834F, -0.5F, 2.974F);
			right_leg4.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1703F, 0.5218F, 0.3882F);
			cube_r1.setTextureOffset(4, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(33, 34).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg3 = new ModelRenderer(this);
			right_leg3.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-3.3834F, -5.5F, 2.974F);
			right_leg3.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.1027F, 0.2286F, 0.3676F);
			cube_r2.setTextureOffset(0, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(19, 17).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-3.3834F, -5.5F, 0.974F);
			right_leg2.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0131F, -0.2114F, 0.2061F);
			cube_r3.setTextureOffset(25, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(36, 36).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(0.0F, 19.0F, 0.0F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-3.3834F, -0.5F, -1.026F);
			right_leg.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.1916F, -0.5034F, 0.411F);
			cube_r4.setTextureOffset(4, 17).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-3.3834F, -0.5F, -1.026F);
			right_leg.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.0607F, -0.5296F, 0.158F);
			cube_r5.setTextureOffset(25, 11).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			left_leg4 = new ModelRenderer(this);
			left_leg4.setRotationPoint(0.0F, 19.0F, 2.0F);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(3.3834F, -0.5F, 2.974F);
			left_leg4.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.1703F, -0.5218F, -0.3882F);
			cube_r6.setTextureOffset(0, 38).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6.setTextureOffset(8, 0).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			left_leg3 = new ModelRenderer(this);
			left_leg3.setRotationPoint(0.0F, 19.0F, 0.0F);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(3.3834F, -0.5F, 2.974F);
			left_leg3.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.1027F, -0.2286F, -0.3676F);
			cube_r7.setTextureOffset(0, 17).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r7.setTextureOffset(38, 14).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(3.3834F, -5.5F, 0.974F);
			left_leg2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0131F, 0.2114F, -0.2061F);
			cube_r8.setTextureOffset(29, 0).addBox(3.5F, 0.5F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r8.setTextureOffset(38, 12).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(3.3834F, -5.5F, -1.026F);
			left_leg.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.1916F, 0.5034F, -0.411F);
			cube_r9.setTextureOffset(28, 40).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(3.3834F, -5.5F, -1.026F);
			left_leg.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.0607F, 0.5296F, -0.158F);
			cube_r10.setTextureOffset(36, 38).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-1.25F, -5.8123F, -6.964F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.48F, 0.3491F, 0.1745F);
			cube_r11.setTextureOffset(23, 24).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(1.25F, -5.8123F, -6.964F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.48F, -0.3491F, -0.1745F);
			cube_r12.setTextureOffset(0, 26).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-2.0F, -3.8921F, -8.5834F);
			body.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.3665F, 0.1309F, -0.3491F);
			cube_r13.setTextureOffset(7, 24).addBox(0.0F, -1.175F, -0.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(2.0F, -3.8921F, -8.5834F);
			body.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.3665F, -0.1309F, 0.3491F);
			cube_r14.setTextureOffset(19, 24).addBox(-1.0F, -1.175F, -0.25F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(1.0F, -4.8488F, -6.2737F);
			body.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.3927F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 31).addBox(-3.5F, -1.5F, -2.0F, 5.0F, 3.0F, 4.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-2.4331F, 19.9375F, -5.1187F);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-6.2056F, -0.2125F, -1.8976F);
			right_arm.addChild(cube_r16);
			setRotationAngle(cube_r16, -3.1416F, -1.2654F, -3.1416F);
			cube_r16.setTextureOffset(36, 0).addBox(-5.0008F, -0.95F, -1.036F, 5.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-4.7739F, -0.2125F, -6.3864F);
			right_arm.addChild(cube_r17);
			setRotationAngle(cube_r17, -2.1484F, -0.9754F, 2.0427F);
			cube_r17.setTextureOffset(18, 34).addBox(-5.9953F, -1.95F, -1.5349F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r17.setTextureOffset(0, 11).addBox(-5.9953F, 1.05F, -0.0349F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.4331F, -0.1875F, 0.6187F);
			right_arm.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, -0.48F, 0.0F);
			cube_r18.setTextureOffset(34, 17).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-4.7739F, -0.2125F, -6.3864F);
			right_arm.addChild(cube_r19);
			setRotationAngle(cube_r19, 2.4638F, -1.1725F, -2.4118F);
			cube_r19.setTextureOffset(0, 40).addBox(-6.0703F, 0.05F, -0.5349F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r19.setTextureOffset(0, 9).addBox(-6.0703F, -0.95F, -0.0349F, 5.0F, 1.0F, 0.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 19.0F, 8.0F);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-2.0F, -6.6112F, 6.7854F);
			mob_tail.addChild(cube_r20);
			setRotationAngle(cube_r20, 2.0071F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(19, 20).addBox(1.0F, -2.0682F, -1.1901F, 2.0F, 3.0F, 11.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.0F, -15.7781F, -8.8419F);
			mob_tail.addChild(cube_r21);
			setRotationAngle(cube_r21, 2.1817F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(2, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-1.5F, -14.8576F, 2.2634F);
			mob_tail.addChild(cube_r22);
			setRotationAngle(cube_r22, 2.6616F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(19, 19).addBox(0.5F, -1.5432F, 8.3325F, 2.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-1.5F, -14.8576F, 2.2634F);
			mob_tail.addChild(cube_r23);
			setRotationAngle(cube_r23, 2.6616F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(0, 31).addBox(1.0F, -4.5432F, 8.8325F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(-1.5F, -14.8576F, 2.2634F);
			mob_tail.addChild(cube_r24);
			setRotationAngle(cube_r24, 2.7053F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(25, 0).addBox(1.0F, -0.5432F, -0.6675F, 1.0F, 2.0F, 9.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.0F, 0.0F, 0.0F);
			mob_tail.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.7418F, 0.0F, 0.0F);
			cube_r25.setTextureOffset(0, 17).addBox(-2.0F, -1.875F, -1.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(3.0F, 19.75F, -4.5F);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(-1.0F, 0.0F, 0.0F);
			left_arm.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.0F, 0.48F, 0.0F);
			cube_r26.setTextureOffset(34, 27).addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(4.2069F, -0.025F, -7.0051F);
			left_arm.addChild(cube_r27);
			setRotationAngle(cube_r27, 2.4638F, 1.1725F, 2.4118F);
			cube_r27.setTextureOffset(14, 40).addBox(0.0703F, 0.05F, -0.5349F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r27.setTextureOffset(0, 10).addBox(1.0703F, -0.95F, -0.0349F, 5.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(4.2069F, -0.025F, -7.0051F);
			left_arm.addChild(cube_r28);
			setRotationAngle(cube_r28, -2.1484F, 0.9754F, -2.0427F);
			cube_r28.setTextureOffset(0, 12).addBox(1.9953F, 1.05F, -0.0349F, 4.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r28.setTextureOffset(34, 21).addBox(-0.0047F, -1.95F, -1.5349F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(5.6386F, -0.025F, -2.5164F);
			left_arm.addChild(cube_r29);
			setRotationAngle(cube_r29, -3.1416F, 1.2654F, 3.1416F);
			cube_r29.setTextureOffset(36, 4).addBox(0.0008F, -0.95F, -1.036F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			right_leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg4.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg3.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_tail.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_arm.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.left_leg2.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_leg3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg4.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.right_leg2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg3.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg4.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.mob_tail.rotateAngleY = f3 / (180F / (float) Math.PI);
		}
	}

}
