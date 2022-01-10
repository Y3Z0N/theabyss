package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.BrainWalkerEntity;

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
public class BrainWalkerRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BrainWalkerEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelbrain_walker(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/firefly_entity.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/brain_walker.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelbrain_walker extends EntityModel<Entity> {
		private final ModelRenderer BODY;
		private final ModelRenderer RIGHT_LEG_BACK;
		private final ModelRenderer LEFT_LEG_BACK;
		private final ModelRenderer RIGHT_LEG;
		private final ModelRenderer LEFT_LEG;
		private final ModelRenderer HEAD;
		private final ModelRenderer cube_r1;

		public Modelbrain_walker() {
			textureWidth = 128;
			textureHeight = 128;
			BODY = new ModelRenderer(this);
			BODY.setRotationPoint(0.0F, 24.0F, 3.5F);
			BODY.setTextureOffset(0, 0).addBox(-7.0F, -25.0F, -13.0F, 13.0F, 16.0F, 19.0F, 0.0F, false);
			BODY.setTextureOffset(25, 23).addBox(0.0F, -13.0F, -1.0F, 0.0F, 6.0F, 12.0F, 0.0F, false);
			BODY.setTextureOffset(0, 42).addBox(0.0F, -16.5F, -14.0F, 0.0F, 2.0F, 10.0F, 0.0F, false);
			BODY.setTextureOffset(45, 0).addBox(-2.5F, -13.0F, -3.0F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			BODY.setTextureOffset(34, 41).addBox(-3.0F, -17.0F, -5.0F, 6.0F, 4.0F, 7.0F, 0.0F, false);
			RIGHT_LEG_BACK = new ModelRenderer(this);
			RIGHT_LEG_BACK.setRotationPoint(-3.5F, -10.0F, 3.5F);
			BODY.addChild(RIGHT_LEG_BACK);
			RIGHT_LEG_BACK.setTextureOffset(45, 7).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEFT_LEG_BACK = new ModelRenderer(this);
			LEFT_LEG_BACK.setRotationPoint(3.5F, -10.0F, 3.5F);
			BODY.addChild(LEFT_LEG_BACK);
			LEFT_LEG_BACK.setTextureOffset(0, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			RIGHT_LEG = new ModelRenderer(this);
			RIGHT_LEG.setRotationPoint(-3.5F, -10.0F, -10.5F);
			BODY.addChild(RIGHT_LEG);
			RIGHT_LEG.setTextureOffset(17, 52).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			LEFT_LEG = new ModelRenderer(this);
			LEFT_LEG.setRotationPoint(3.5F, -10.0F, -10.5F);
			BODY.addChild(LEFT_LEG);
			LEFT_LEG.setTextureOffset(29, 52).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, false);
			HEAD = new ModelRenderer(this);
			HEAD.setRotationPoint(0.0F, -15.8009F, -12.124F);
			BODY.addChild(HEAD);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 1.5F, -3.0F);
			HEAD.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1745F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 35).addBox(-4.0F, -5.5F, -4.5F, 8.0F, 8.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			BODY.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.LEFT_LEG.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.HEAD.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.HEAD.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LEFT_LEG_BACK.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RIGHT_LEG_BACK.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.RIGHT_LEG.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
