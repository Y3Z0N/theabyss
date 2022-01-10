package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.item.SpectralSpawnItem;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SpectralSpawnRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SpectralSpawnItem.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<SpectralSpawnItem.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("theabyss:textures/firefly_entity.png");

		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(SpectralSpawnItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelabyss_liz();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(SpectralSpawnItem.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelabyss_liz extends EntityModel<Entity> {
		private final ModelRenderer rightback;
		private final ModelRenderer FeetBackRight_r1;
		private final ModelRenderer FeetBackRight_r2;
		private final ModelRenderer FeetBackRight_r3;
		private final ModelRenderer Body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Body_r1;
		private final ModelRenderer Body_r2;
		private final ModelRenderer Body_r3;
		private final ModelRenderer Tall;
		private final ModelRenderer Start_r1;
		private final ModelRenderer Mid_r1;
		private final ModelRenderer End_r1;
		private final ModelRenderer TallStork;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer leftback;
		private final ModelRenderer FeetBackRight_r4;
		private final ModelRenderer FeetBackRight_r5;
		private final ModelRenderer FeetBackRight_r6;
		private final ModelRenderer leftfront;
		private final ModelRenderer FeetBackRight_r7;
		private final ModelRenderer FeetBackRight_r8;
		private final ModelRenderer leftfront_r1;
		private final ModelRenderer rightfront;
		private final ModelRenderer FeetBackRight_r9;
		private final ModelRenderer FeetBackRight_r10;
		private final ModelRenderer leftfront_r2;

		public Modelabyss_liz() {
			textureWidth = 48;
			textureHeight = 48;
			rightback = new ModelRenderer(this);
			rightback.setRotationPoint(0.0F, 24.0F, 0.0F);
			FeetBackRight_r1 = new ModelRenderer(this);
			FeetBackRight_r1.setRotationPoint(3.25F, 0.0F, 3.0F);
			rightback.addChild(FeetBackRight_r1);
			setRotationAngle(FeetBackRight_r1, 1.5708F, 0.0F, 0.0F);
			FeetBackRight_r1.setTextureOffset(20, 30).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r2 = new ModelRenderer(this);
			FeetBackRight_r2.setRotationPoint(3.25F, 0.0F, 3.0F);
			rightback.addChild(FeetBackRight_r2);
			setRotationAngle(FeetBackRight_r2, 0.3927F, 0.0F, 0.0F);
			FeetBackRight_r2.setTextureOffset(12, 22).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r3 = new ModelRenderer(this);
			FeetBackRight_r3.setRotationPoint(3.25F, -2.0F, 2.0F);
			rightback.addChild(FeetBackRight_r3);
			setRotationAngle(FeetBackRight_r3, 0.1745F, 0.0F, 0.0F);
			FeetBackRight_r3.setTextureOffset(30, 22).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(2.5F, 22.0F, -3.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-2.0F, -3.0F, 5.5F);
			Body.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.0873F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 11).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-2.0F, -3.5F, -1.5F);
			Body.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0436F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(18, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Body_r1 = new ModelRenderer(this);
			Body_r1.setRotationPoint(-1.0F, -1.0F, -2.0F);
			Body.addChild(Body_r1);
			setRotationAngle(Body_r1, -0.1309F, 0.0F, 0.0F);
			Body_r1.setTextureOffset(15, 17).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Body_r2 = new ModelRenderer(this);
			Body_r2.setRotationPoint(0.0F, -0.5F, 0.0F);
			Body.addChild(Body_r2);
			setRotationAngle(Body_r2, -0.0436F, 0.0F, 0.0F);
			Body_r2.setTextureOffset(0, 0).addBox(-5.0F, -3.0F, -2.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
			Body_r3 = new ModelRenderer(this);
			Body_r3.setRotationPoint(-0.5F, 0.5F, 7.5F);
			Body.addChild(Body_r3);
			setRotationAngle(Body_r3, -0.0873F, 0.0F, 0.0F);
			Body_r3.setTextureOffset(14, 23).addBox(-4.0F, -4.0F, -2.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			Tall = new ModelRenderer(this);
			Tall.setRotationPoint(-2.5F, 2.0F, 3.0F);
			Body.addChild(Tall);
			Start_r1 = new ModelRenderer(this);
			Start_r1.setRotationPoint(1.5F, -2.0F, 6.5F);
			Tall.addChild(Start_r1);
			setRotationAngle(Start_r1, -0.1745F, 0.0F, 0.0F);
			Start_r1.setTextureOffset(0, 11).addBox(-3.0F, -3.0F, -2.0F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			Mid_r1 = new ModelRenderer(this);
			Mid_r1.setRotationPoint(1.0F, -2.0F, 11.5F);
			Tall.addChild(Mid_r1);
			setRotationAngle(Mid_r1, -0.1745F, 0.0F, 0.0F);
			Mid_r1.setTextureOffset(25, 7).addBox(-2.0F, -2.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			End_r1 = new ModelRenderer(this);
			End_r1.setRotationPoint(0.5F, -2.0F, 15.5F);
			Tall.addChild(End_r1);
			setRotationAngle(End_r1, -0.0873F, 0.0F, 0.0F);
			End_r1.setTextureOffset(0, 20).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			TallStork = new ModelRenderer(this);
			TallStork.setRotationPoint(0.5F, -4.5F, 5.5F);
			Tall.addChild(TallStork);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 1.0F, 4.5F);
			TallStork.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.2182F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			TallStork.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.1745F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(23, 25).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(1.5F, 20.5F, -9.0F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.5F, 0.0F, -1.5F);
			Head.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.2182F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 27).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-1.0F, -1.5F, 1.0F);
			Head.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.3054F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 4).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-0.5F, 0.0F, 2.0F);
			Head.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.0873F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(26, 0).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 3.0F, 4.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.1309F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(26, 0).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			leftback = new ModelRenderer(this);
			leftback.setRotationPoint(-5.5F, 24.0F, 0.0F);
			FeetBackRight_r4 = new ModelRenderer(this);
			FeetBackRight_r4.setRotationPoint(3.25F, 0.0F, 3.0F);
			leftback.addChild(FeetBackRight_r4);
			setRotationAngle(FeetBackRight_r4, 1.5708F, 0.0F, 0.0F);
			FeetBackRight_r4.setTextureOffset(12, 30).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r5 = new ModelRenderer(this);
			FeetBackRight_r5.setRotationPoint(3.25F, 0.0F, 3.0F);
			leftback.addChild(FeetBackRight_r5);
			setRotationAngle(FeetBackRight_r5, 0.3927F, 0.0F, 0.0F);
			FeetBackRight_r5.setTextureOffset(8, 20).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r6 = new ModelRenderer(this);
			FeetBackRight_r6.setRotationPoint(3.25F, -2.0F, 2.0F);
			leftback.addChild(FeetBackRight_r6);
			setRotationAngle(FeetBackRight_r6, 0.1745F, 0.0F, 0.0F);
			FeetBackRight_r6.setTextureOffset(16, 30).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			leftfront = new ModelRenderer(this);
			leftfront.setRotationPoint(-5.5F, 24.0F, -6.0F);
			FeetBackRight_r7 = new ModelRenderer(this);
			FeetBackRight_r7.setRotationPoint(3.25F, 0.0F, 3.0F);
			leftfront.addChild(FeetBackRight_r7);
			setRotationAngle(FeetBackRight_r7, 1.5708F, 0.0F, 0.0F);
			FeetBackRight_r7.setTextureOffset(28, 13).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r8 = new ModelRenderer(this);
			FeetBackRight_r8.setRotationPoint(3.25F, 0.0F, 3.0F);
			leftfront.addChild(FeetBackRight_r8);
			setRotationAngle(FeetBackRight_r8, 0.3927F, 0.0F, 0.0F);
			FeetBackRight_r8.setTextureOffset(0, 20).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			leftfront_r1 = new ModelRenderer(this);
			leftfront_r1.setRotationPoint(3.25F, -2.0F, 2.0F);
			leftfront.addChild(leftfront_r1);
			setRotationAngle(leftfront_r1, 0.1745F, 0.0F, 0.0F);
			leftfront_r1.setTextureOffset(28, 16).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			rightfront = new ModelRenderer(this);
			rightfront.setRotationPoint(0.0F, 24.0F, -6.0F);
			FeetBackRight_r9 = new ModelRenderer(this);
			FeetBackRight_r9.setRotationPoint(3.25F, 0.0F, 3.0F);
			rightfront.addChild(FeetBackRight_r9);
			setRotationAngle(FeetBackRight_r9, 1.5708F, 0.0F, 0.0F);
			FeetBackRight_r9.setTextureOffset(0, 14).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			FeetBackRight_r10 = new ModelRenderer(this);
			FeetBackRight_r10.setRotationPoint(3.25F, 0.0F, 3.0F);
			rightfront.addChild(FeetBackRight_r10);
			setRotationAngle(FeetBackRight_r10, 0.3927F, 0.0F, 0.0F);
			FeetBackRight_r10.setTextureOffset(18, 0).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			leftfront_r2 = new ModelRenderer(this);
			leftfront_r2.setRotationPoint(3.25F, -2.0F, 2.0F);
			rightfront.addChild(leftfront_r2);
			setRotationAngle(leftfront_r2, 0.1745F, 0.0F, 0.0F);
			leftfront_r2.setTextureOffset(9, 27).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			rightback.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			leftback.render(matrixStack, buffer, packedLight, packedOverlay);
			leftfront.render(matrixStack, buffer, packedLight, packedOverlay);
			rightfront.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.leftback.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightfront.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftfront.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightback.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
