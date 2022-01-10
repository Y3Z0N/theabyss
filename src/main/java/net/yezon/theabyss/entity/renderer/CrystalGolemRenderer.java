package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.CrystalGolemEntity;

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
public class CrystalGolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CrystalGolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabyss_golem(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/golem.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/golem_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelabyss_golem extends EntityModel<Entity> {
		private final ModelRenderer ABYSSGOLEM;
		private final ModelRenderer HEAD;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer BODY;
		private final ModelRenderer LEFT_LEG;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer RIGHT_LEG;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer RIGHT_ARM;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer LEFT_ARM;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;

		public Modelabyss_golem() {
			textureWidth = 256;
			textureHeight = 256;
			ABYSSGOLEM = new ModelRenderer(this);
			ABYSSGOLEM.setRotationPoint(-3.0F, 15.0F, 0.5F);
			HEAD = new ModelRenderer(this);
			HEAD.setRotationPoint(3.0F, -32.9167F, 3.6667F);
			ABYSSGOLEM.addChild(HEAD);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(7.0F, 2.9167F, -9.1667F);
			HEAD.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.1745F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(47, 17).addBox(-14.0F, -3.0F, 0.0F, 14.0F, 3.0F, 4.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(6.0F, -6.3333F, -10.6667F);
			HEAD.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.1309F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(1, 92).addBox(-12.0F, -2.0F, 0.0F, 12.0F, 2.0F, 13.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(6.0F, 3.4167F, -7.6667F);
			HEAD.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.1309F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(47, 17).addBox(-12.0F, -10.0F, 0.0F, 12.0F, 10.0F, 11.0F, 0.0F, false);
			BODY = new ModelRenderer(this);
			BODY.setRotationPoint(9.5F, -19.5F, 0.5F);
			ABYSSGOLEM.addChild(BODY);
			BODY.setTextureOffset(12, 10).addBox(-14.5F, -3.5F, -0.5F, 16.0F, 8.0F, 6.0F, 0.0F, false);
			BODY.setTextureOffset(12, 10).addBox(-16.5F, -13.5F, -1.5F, 20.0F, 10.0F, 8.0F, 0.0F, false);
			LEFT_LEG = new ModelRenderer(this);
			LEFT_LEG.setRotationPoint(-2.75F, -17.25F, 3.0F);
			ABYSSGOLEM.addChild(LEFT_LEG);
			LEFT_LEG.setTextureOffset(57, 52).addBox(-4.25F, 22.25F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(3.25F, 15.25F, -3.0F);
			LEFT_LEG.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.0436F);
			cube_r4.setTextureOffset(57, 52).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(4.75F, 23.25F, -5.0F);
			LEFT_LEG.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.0436F);
			cube_r5.setTextureOffset(57, 52).addBox(-10.0F, -8.0F, 0.0F, 10.0F, 8.0F, 10.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(4.25F, 12.25F, -4.0F);
			LEFT_LEG.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, 0.0436F);
			cube_r6.setTextureOffset(57, 52).addBox(-8.0F, -12.0F, 0.0F, 8.0F, 12.0F, 8.0F, 0.0F, false);
			RIGHT_LEG = new ModelRenderer(this);
			RIGHT_LEG.setRotationPoint(8.75F, -17.25F, 3.0F);
			ABYSSGOLEM.addChild(RIGHT_LEG);
			RIGHT_LEG.setTextureOffset(55, 47).addBox(-3.75F, 22.25F, -4.0F, 8.0F, 4.0F, 8.0F, 0.0F, true);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-3.25F, 15.25F, -3.0F);
			RIGHT_LEG.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, -0.0436F);
			cube_r7.setTextureOffset(55, 47).addBox(0.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-4.75F, 23.25F, -5.0F);
			RIGHT_LEG.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, -0.0436F);
			cube_r8.setTextureOffset(55, 47).addBox(0.0F, -8.0F, 0.0F, 10.0F, 8.0F, 10.0F, 0.0F, true);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-4.25F, 12.25F, -4.0F);
			RIGHT_LEG.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, -0.0436F);
			cube_r9.setTextureOffset(55, 47).addBox(0.0F, -12.0F, 0.0F, 8.0F, 12.0F, 8.0F, 0.0F, true);
			RIGHT_ARM = new ModelRenderer(this);
			RIGHT_ARM.setRotationPoint(13.5006F, -31.7155F, 2.9787F);
			ABYSSGOLEM.addChild(RIGHT_ARM);
			setRotationAngle(RIGHT_ARM, 0.0F, 0.0F, -0.0436F);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(8.9994F, 25.7155F, -4.4787F);
			RIGHT_ARM.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.0873F, 0.0F, -0.0436F);
			cube_r10.setTextureOffset(61, 77).addBox(0.5168F, -0.455F, 0.4851F, 1.0F, 6.0F, 1.0F, 0.0F, true);
			cube_r10.setTextureOffset(61, 77).addBox(0.0F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-0.0006F, 25.7155F, -1.9787F);
			RIGHT_ARM.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -0.0436F);
			cube_r11.setTextureOffset(61, 77).addBox(0.5168F, -0.4338F, 1.0F, 1.0F, 6.0F, 2.0F, 0.0F, true);
			cube_r11.setTextureOffset(61, 77).addBox(0.0F, -6.0F, 0.0F, 2.0F, 6.0F, 4.0F, 0.0F, true);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(8.9994F, 28.7155F, -0.9787F);
			RIGHT_ARM.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, -0.0436F);
			cube_r12.setTextureOffset(61, 77).addBox(0.604F, -0.43F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, true);
			cube_r12.setTextureOffset(61, 77).addBox(0.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(8.9994F, 26.2155F, 2.5213F);
			RIGHT_ARM.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.2182F, 0.0F, -0.0436F);
			cube_r13.setTextureOffset(61, 77).addBox(0.5168F, -0.2411F, 0.2597F, 1.0F, 6.0F, 1.0F, 0.0F, true);
			cube_r13.setTextureOffset(61, 77).addBox(0.0F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.9994F, 22.7155F, -3.9787F);
			RIGHT_ARM.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, -0.0436F);
			cube_r14.setTextureOffset(61, 77).addBox(0.0F, -10.0F, 0.0F, 8.0F, 10.0F, 8.0F, 0.0F, true);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(1.9994F, 16.7155F, -2.9787F);
			RIGHT_ARM.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, -0.0436F);
			cube_r15.setTextureOffset(61, 77).addBox(5.8525F, -11.5262F, 1.0F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			cube_r15.setTextureOffset(61, 77).addBox(0.0F, -14.0F, 0.0F, 6.0F, 14.0F, 6.0F, 0.0F, true);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.4994F, 6.7155F, -3.4787F);
			RIGHT_ARM.addChild(cube_r16);
			setRotationAngle(cube_r16, -0.1309F, 0.0F, -0.2182F);
			cube_r16.setTextureOffset(61, 77).addBox(0.0F, -8.0F, 0.0F, 6.0F, 8.0F, 8.0F, 0.0F, true);
			LEFT_ARM = new ModelRenderer(this);
			LEFT_ARM.setRotationPoint(-7.0006F, -31.7155F, 2.9787F);
			ABYSSGOLEM.addChild(LEFT_ARM);
			setRotationAngle(LEFT_ARM, 0.0F, 0.0F, 0.0436F);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-9.4994F, 25.7155F, -4.4787F);
			LEFT_ARM.addChild(cube_r17);
			setRotationAngle(cube_r17, -0.0873F, 0.0F, 0.0436F);
			cube_r17.setTextureOffset(13, 87).addBox(-1.5168F, -0.455F, 0.4851F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r17.setTextureOffset(13, 87).addBox(-2.0F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(-0.4994F, 25.7155F, -1.9787F);
			LEFT_ARM.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, 0.0436F);
			cube_r18.setTextureOffset(13, 87).addBox(-1.5168F, -0.4338F, 1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r18.setTextureOffset(13, 87).addBox(-2.0F, -6.0F, 0.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-9.4994F, 28.7155F, -0.9787F);
			LEFT_ARM.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, 0.0436F);
			cube_r19.setTextureOffset(13, 87).addBox(-1.604F, -0.43F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			cube_r19.setTextureOffset(13, 87).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-9.4994F, 26.2155F, 2.5213F);
			LEFT_ARM.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.2182F, 0.0F, 0.0436F);
			cube_r20.setTextureOffset(13, 87).addBox(-1.5168F, -0.2411F, 0.2597F, 1.0F, 6.0F, 1.0F, 0.0F, false);
			cube_r20.setTextureOffset(13, 87).addBox(-2.0F, -6.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-1.4994F, 22.7155F, -3.9787F);
			LEFT_ARM.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.0F, 0.0436F);
			cube_r21.setTextureOffset(13, 87).addBox(-8.0F, -10.0F, 0.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-2.4994F, 16.7155F, -2.9787F);
			LEFT_ARM.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.0F, 0.0F, 0.0436F);
			cube_r22.setTextureOffset(13, 87).addBox(-6.8525F, -11.5262F, 1.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r22.setTextureOffset(13, 87).addBox(-6.0F, -14.0F, 0.0F, 6.0F, 14.0F, 6.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-0.9994F, 6.7155F, -3.4787F);
			LEFT_ARM.addChild(cube_r23);
			setRotationAngle(cube_r23, -0.1309F, 0.0F, 0.2182F);
			cube_r23.setTextureOffset(13, 87).addBox(-6.0F, -8.0F, 0.0F, 6.0F, 8.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			ABYSSGOLEM.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RIGHT_LEG.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LEFT_LEG.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RIGHT_ARM.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LEFT_ARM.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
