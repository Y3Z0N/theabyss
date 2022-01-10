package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.TheRokaEntity;

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
public class TheRokaRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TheRokaEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelRokaEntityModel(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/rokaentitytexture.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/rokaentitytexture_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelRokaEntityModel extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Stomach;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer LeftLeg2;
		private final ModelRenderer RightLeg;
		private final ModelRenderer RightLeg2;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightArm;
		private final ModelRenderer Head;
		private final ModelRenderer LeftEar;
		private final ModelRenderer RightEar;
		public ModelRokaEntityModel() {
			textureWidth = 256;
			textureHeight = 256;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -36.0F, 0.5F);
			Body.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -6.5F, 26.0F, 14.0F, 13.0F, 0.0F, false);
			Stomach = new ModelRenderer(this);
			Stomach.setRotationPoint(0.0F, 8.0F, 0.5F);
			Body.addChild(Stomach);
			Stomach.setTextureOffset(56, 48).addBox(-8.0F, 0.0F, -5.0F, 16.0F, 18.0F, 10.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(5.0F, 18.0F, 1.0F);
			Stomach.addChild(LeftLeg);
			LeftLeg.setTextureOffset(68, 17).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 17.0F, 10.0F, 0.0F, false);
			LeftLeg2 = new ModelRenderer(this);
			LeftLeg2.setRotationPoint(0.0F, 17.0F, 2.5F);
			LeftLeg.addChild(LeftLeg2);
			LeftLeg2.setTextureOffset(108, 38).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 17.0F, 5.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-5.0F, 18.25F, 1.0F);
			Stomach.addChild(RightLeg);
			RightLeg.setTextureOffset(0, 58).addBox(-4.0F, -0.25F, -5.0F, 8.0F, 17.0F, 10.0F, 0.0F, false);
			RightLeg2 = new ModelRenderer(this);
			RightLeg2.setRotationPoint(0.0F, 16.75F, 2.5F);
			RightLeg.addChild(RightLeg2);
			RightLeg2.setTextureOffset(104, 16).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 17.0F, 5.0F, 0.0F, false);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(12.8333F, -2.0F, -0.5F);
			Body.addChild(LeftArm);
			LeftArm.setTextureOffset(60, 76).addBox(0.1667F, -4.0F, -3.0F, 6.0F, 32.0F, 6.0F, 0.0F, false);
			LeftArm.setTextureOffset(0, 85).addBox(-0.8333F, 14.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
			LeftArm.setTextureOffset(78, 0).addBox(0.1667F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-13.0F, -2.5F, -0.5F);
			Body.addChild(RightArm);
			RightArm.setTextureOffset(36, 70).addBox(-6.0F, -3.5F, -3.0F, 6.0F, 32.0F, 6.0F, 0.0F, false);
			RightArm.setTextureOffset(84, 76).addBox(-7.0F, 14.5F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -5.9167F, -0.5833F);
			Body.addChild(Head);
			Head.setTextureOffset(0, 27).addBox(-9.0F, -16.0833F, -7.9167F, 18.0F, 16.0F, 15.0F, 0.0F, false);
			Head.setTextureOffset(51, 27).addBox(4.0F, -7.0833F, -9.9167F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(26, 58).addBox(-4.0F, -8.0833F, -9.9167F, 8.0F, 6.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(51, 34).addBox(-6.0F, -7.0833F, -9.9167F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			Head.setTextureOffset(0, 0).addBox(4.0F, -26.0833F, -5.9167F, 2.0F, 10.0F, 3.0F, 0.0F, false);
			Head.setTextureOffset(0, 27).addBox(-6.0F, -26.0833F, -5.9167F, 2.0F, 10.0F, 3.0F, 0.0F, false);
			LeftEar = new ModelRenderer(this);
			LeftEar.setRotationPoint(9.0F, -12.0833F, -0.4167F);
			Head.addChild(LeftEar);
			LeftEar.setTextureOffset(21, 97).addBox(0.0F, 0.0F, -5.5F, 2.0F, 10.0F, 11.0F, 0.0F, false);
			RightEar = new ModelRenderer(this);
			RightEar.setRotationPoint(-9.0F, -12.0833F, -0.4167F);
			Head.addChild(RightEar);
			RightEar.setTextureOffset(84, 94).addBox(-2.0F, 0.0F, -5.5F, 2.0F, 10.0F, 11.0F, 0.0F, false);
		}

        @Override
        public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
                float alpha) {
            matrixStack.push();
            matrixStack.translate(0f, 1.5f - 0.5 * 1.5f, 0f);
            matrixStack.scale(0.5f, 0.5f, 0.5f);
            Body.render(matrixStack, buffer, packedLight, packedOverlay);
            matrixStack.pop();


		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
