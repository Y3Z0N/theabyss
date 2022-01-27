package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.AbyssalMothEntity;

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
public class AbyssalMothRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AbyssalMothEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelabyssal_moth_model(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/abyssal_moth_texture.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/abyssal_moth_texture_glow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelabyssal_moth_model extends EntityModel<Entity> {
		private final ModelRenderer Body;
		private final ModelRenderer Abdomen;
		private final ModelRenderer Tail;
		private final ModelRenderer Head;
		private final ModelRenderer RightAntenna;
		private final ModelRenderer LeftAntenna;
		private final ModelRenderer RightLeg1;
		private final ModelRenderer RightLeg2;
		private final ModelRenderer RightLeg3;
		private final ModelRenderer LeftLeg1;
		private final ModelRenderer LeftLeg2;
		private final ModelRenderer LeftLeg3;
		private final ModelRenderer RightWing;
		private final ModelRenderer LeftWing;

		public Modelabyssal_moth_model() {
			textureWidth = 128;
			textureHeight = 128;
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 17.5F, 3.75F);
			Body.setTextureOffset(69, 18).addBox(-5.5F, -3.5F, -3.75F, 11.0F, 7.0F, 8.0F, 0.0F, false);
			Body.setTextureOffset(0, 70).addBox(-7.5F, -4.5F, -8.75F, 15.0F, 9.0F, 5.0F, 0.0F, false);
			Abdomen = new ModelRenderer(this);
			Abdomen.setRotationPoint(0.0F, 0.0F, 4.25F);
			Body.addChild(Abdomen);
			Abdomen.setTextureOffset(50, 56).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F, 0.0F, false);
			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.0F, 0.0F, 12.0F);
			Abdomen.addChild(Tail);
			Tail.setTextureOffset(30, 46).addBox(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 0.0F, false);
			Tail.setTextureOffset(0, 58).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 12.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 1.0F, -8.75F);
			Body.addChild(Head);
			Head.setTextureOffset(81, 79).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 3.0F, 0.0F, false);
			RightAntenna = new ModelRenderer(this);
			RightAntenna.setRotationPoint(-1.5F, -2.5F, -3.0F);
			Head.addChild(RightAntenna);
			setRotationAngle(RightAntenna, 0.0F, 0.0F, -0.2182F);
			RightAntenna.setTextureOffset(46, 0).addBox(-7.5F, 0.0F, -10.0F, 9.0F, 0.0F, 13.0F, 0.0F, false);
			LeftAntenna = new ModelRenderer(this);
			LeftAntenna.setRotationPoint(1.5F, -2.5F, -3.0F);
			Head.addChild(LeftAntenna);
			setRotationAngle(LeftAntenna, 0.0F, 0.0F, 0.2182F);
			LeftAntenna.setTextureOffset(46, 13).addBox(-1.5F, 0.0F, -10.0F, 9.0F, 0.0F, 13.0F, 0.0F, false);
			RightLeg1 = new ModelRenderer(this);
			RightLeg1.setRotationPoint(-5.0F, 3.0F, -3.75F);
			Body.addChild(RightLeg1);
			setRotationAngle(RightLeg1, 0.0F, -0.2618F, 0.0F);
			RightLeg1.setTextureOffset(82, 33).addBox(-10.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			RightLeg2 = new ModelRenderer(this);
			RightLeg2.setRotationPoint(-5.0F, 3.0F, 0.25F);
			Body.addChild(RightLeg2);
			RightLeg2.setTextureOffset(76, 56).addBox(-10.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			RightLeg3 = new ModelRenderer(this);
			RightLeg3.setRotationPoint(-5.0F, 3.0F, 3.25F);
			Body.addChild(RightLeg3);
			setRotationAngle(RightLeg3, 0.0F, 0.2618F, 0.0F);
			RightLeg3.setTextureOffset(62, 75).addBox(-10.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			LeftLeg1 = new ModelRenderer(this);
			LeftLeg1.setRotationPoint(5.0F, 3.0F, -3.75F);
			Body.addChild(LeftLeg1);
			setRotationAngle(LeftLeg1, 0.0F, 0.2618F, 0.0F);
			LeftLeg1.setTextureOffset(77, 7).addBox(-0.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			LeftLeg2 = new ModelRenderer(this);
			LeftLeg2.setRotationPoint(5.0F, 3.0F, 0.25F);
			Body.addChild(LeftLeg2);
			LeftLeg2.setTextureOffset(77, 0).addBox(-0.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			LeftLeg3 = new ModelRenderer(this);
			LeftLeg3.setRotationPoint(5.0F, 3.0F, 3.25F);
			Body.addChild(LeftLeg3);
			setRotationAngle(LeftLeg3, 0.0F, -0.2618F, 0.0F);
			LeftLeg3.setTextureOffset(40, 75).addBox(-0.5F, -3.5F, 0.0F, 11.0F, 7.0F, 0.0F, 0.0F, false);
			RightWing = new ModelRenderer(this);
			RightWing.setRotationPoint(-5.5F, -3.1667F, -3.25F);
			Body.addChild(RightWing);
			RightWing.setTextureOffset(0, 46).addBox(-21.0F, -0.3333F, -1.5F, 21.0F, 2.0F, 10.0F, 0.0F, false);
			RightWing.setTextureOffset(0, 17).addBox(-21.0F, -0.3333F, 8.5F, 21.0F, 0.0F, 17.0F, 0.0F, false);
			RightWing.setTextureOffset(42, 34).addBox(-36.0F, -0.3333F, -1.5F, 15.0F, 0.0F, 10.0F, 0.0F, false);
			LeftWing = new ModelRenderer(this);
			LeftWing.setRotationPoint(5.5F, -3.1667F, -3.25F);
			Body.addChild(LeftWing);
			LeftWing.setTextureOffset(0, 34).addBox(0.0F, -0.3333F, -1.5F, 21.0F, 2.0F, 10.0F, 0.0F, false);
			LeftWing.setTextureOffset(42, 46).addBox(21.0F, -0.3333F, -1.5F, 15.0F, 0.0F, 10.0F, 0.0F, false);
			LeftWing.setTextureOffset(0, 0).addBox(0.0F, -0.3333F, 8.5F, 21.0F, 0.0F, 17.0F, 0.0F, false);
		}

@Override
public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
    float alpha) {
  Body.render(matrixStack, buffer, packedLight, packedOverlay);
}

public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
  modelRenderer.rotateAngleX = x;
  modelRenderer.rotateAngleY = y;
  modelRenderer.rotateAngleZ = z;
}

public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

  this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
  this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
  this.RightWing.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
  this.Tail.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
  this.LeftWing.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
}
}

}