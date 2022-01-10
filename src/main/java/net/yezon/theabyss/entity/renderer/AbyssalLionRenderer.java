package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.AbyssalLionEntity;

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
public class AbyssalLionRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AbyssalLionEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabyssal_lion(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/abyssal_lion.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/abyssal_lion_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelabyssal_lion extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Body2;
		private final ModelRenderer RightLeg2;
		private final ModelRenderer LeftLeg2;
		private final ModelRenderer Tail1;
		private final ModelRenderer Tail2;
		private final ModelRenderer Tail3;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer Head;
		private final ModelRenderer RightEar;
		private final ModelRenderer LeftEar;
		private final ModelRenderer RightLowerJaw;
		private final ModelRenderer LeftLowerJaw;
		public Modelabyssal_lion() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 6.0F, -6.5F);
			Body.setTextureOffset(0, 0).addBox(-6.0F, -7.0F, -6.5F, 12.0F, 14.0F, 13.0F, 0.0F, false);
			Body2 = new ModelRenderer(this);
			Body2.setRotationPoint(0.0F, -4.25F, 6.5F);
			Body.addChild(Body2);
			Body2.setTextureOffset(0, 27).addBox(-4.5F, -2.75F, 0.0F, 9.0F, 11.0F, 15.0F, 0.0F, false);
			Body2.setTextureOffset(0, 36).addBox(0.0F, -10.75F, 6.0F, 0.0F, 8.0F, 17.0F, 0.0F, false);
			RightLeg2 = new ModelRenderer(this);
			RightLeg2.setRotationPoint(-4.6667F, 5.0833F, 12.8333F);
			Body2.addChild(RightLeg2);
			RightLeg2.setTextureOffset(85, 49).addBox(-3.3333F, 8.1667F, -2.8333F, 4.0F, 9.0F, 5.0F, 0.0F, false);
			RightLeg2.setTextureOffset(51, 63).addBox(-3.3333F, -2.8333F, -2.8333F, 4.0F, 11.0F, 9.0F, 0.0F, false);
			RightLeg2.setTextureOffset(0, 76).addBox(-3.3333F, -2.8333F, 6.1667F, 0.0F, 11.0F, 9.0F, 0.0F, false);
			LeftLeg2 = new ModelRenderer(this);
			LeftLeg2.setRotationPoint(4.6667F, 5.0833F, 12.8333F);
			Body2.addChild(LeftLeg2);
			LeftLeg2.setTextureOffset(64, 27).addBox(-0.6667F, -2.8333F, -2.8333F, 4.0F, 11.0F, 9.0F, 0.0F, false);
			LeftLeg2.setTextureOffset(82, 87).addBox(-0.6667F, 8.1667F, -2.8333F, 4.0F, 9.0F, 5.0F, 0.0F, false);
			LeftLeg2.setTextureOffset(64, 78).addBox(3.3333F, -2.8333F, 6.1667F, 0.0F, 11.0F, 9.0F, 0.0F, false);
			Tail1 = new ModelRenderer(this);
			Tail1.setRotationPoint(0.0F, -1.25F, 15.0F);
			Body2.addChild(Tail1);
			Tail1.setTextureOffset(0, 71).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, 0.0F, false);
			Tail2 = new ModelRenderer(this);
			Tail2.setRotationPoint(0.0F, 0.0F, 11.0F);
			Tail1.addChild(Tail2);
			Tail2.setTextureOffset(68, 52).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, 0.0F, false);
			Tail3 = new ModelRenderer(this);
			Tail3.setRotationPoint(0.0F, -0.3333F, 11.0F);
			Tail2.addChild(Tail3);
			Tail3.setTextureOffset(31, 27).addBox(1.5F, -0.1667F, 0.0F, 8.0F, 0.0F, 17.0F, 0.0F, false);
			Tail3.setTextureOffset(66, 0).addBox(-1.5F, -1.1667F, 0.0F, 3.0F, 3.0F, 11.0F, 0.0F, false);
			Tail3.setTextureOffset(33, 0).addBox(-9.5F, -0.1667F, 0.0F, 8.0F, 0.0F, 17.0F, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-6.0F, 5.0F, 1.5F);
			Body.addChild(RightLeg);
			RightLeg.setTextureOffset(77, 66).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, 0.0F, false);
			RightLeg.setTextureOffset(28, 67).addBox(-2.0F, 1.0F, 2.0F, 0.0F, 12.0F, 9.0F, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(6.0F, 5.0F, 1.5F);
			Body.addChild(LeftLeg);
			LeftLeg.setTextureOffset(81, 14).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, 0.0F, false);
			LeftLeg.setTextureOffset(46, 74).addBox(2.0F, 1.0F, 2.0F, 0.0F, 12.0F, 9.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-0.5F, -5.25F, -6.25F);
			Body.addChild(Head);
			Head.setTextureOffset(17, 63).addBox(-4.0F, -1.75F, -19.25F, 8.0F, 4.0F, 9.0F, 0.0F, false);
			Head.setTextureOffset(38, 44).addBox(-4.0F, -4.75F, -10.25F, 8.0F, 9.0F, 10.0F, 0.0F, false);
			RightEar = new ModelRenderer(this);
			RightEar.setRotationPoint(-4.0F, -1.75F, -3.25F);
			Head.addChild(RightEar);
			RightEar.setTextureOffset(0, 48).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 13.0F, 0.0F, false);
			LeftEar = new ModelRenderer(this);
			LeftEar.setRotationPoint(4.0F, -1.75F, -3.25F);
			Head.addChild(LeftEar);
			LeftEar.setTextureOffset(50, 4).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 13.0F, 0.0F, false);
			RightLowerJaw = new ModelRenderer(this);
			RightLowerJaw.setRotationPoint(-2.0F, 2.25F, -10.0F);
			Head.addChild(RightLowerJaw);
			RightLowerJaw.setTextureOffset(83, 0).addBox(-2.0F, 0.0F, -9.25F, 4.0F, 2.0F, 9.0F, 0.0F, false);
			LeftLowerJaw = new ModelRenderer(this);
			LeftLowerJaw.setRotationPoint(2.0F, 2.25F, -10.25F);
			Head.addChild(LeftLowerJaw);
			LeftLowerJaw.setTextureOffset(81, 38).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 2.0F, 9.0F, 0.0F, false);
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
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Tail1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Tail3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
