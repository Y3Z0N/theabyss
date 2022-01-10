package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.item.RingOfFireStrikeAttackItem;

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
public class RingOfFireStrikeAttackRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RingOfFireStrikeAttackItem.arrow, renderManager -> new CustomRender(renderManager));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class CustomRender extends EntityRenderer<RingOfFireStrikeAttackItem.ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("theabyss:textures/firefly_entity.png");

		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(RingOfFireStrikeAttackItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
				IRenderTypeBuffer bufferIn, int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelabyss_raptor();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(RingOfFireStrikeAttackItem.ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelabyss_raptor extends EntityModel<Entity> {
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer left_arm;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer body;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;

		public Modelabyss_raptor() {
			textureWidth = 64;
			textureHeight = 64;
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, 7.975F, -6.6062F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 1.2F, -1.3938F);
			mob_head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1309F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(19, 0).addBox(-0.5F, -0.625F, -6.925F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 1.2F, -1.3938F);
			mob_head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0436F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 27).addBox(-1.0F, -1.575F, -7.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 1.2F, -1.3938F);
			mob_head.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.2618F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(0.0F, -4.3F, -3.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);
			cube_r3.setTextureOffset(18, 18).addBox(-1.5F, -2.3F, -3.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 17.0F, 5.75F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -1.5722F, 6.7275F);
			mob_tail.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.3927F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(0, 0).addBox(-0.5F, -0.45F, -0.225F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.15F, -0.1F);
			mob_tail.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.1745F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(19, 0).addBox(-0.025F, -3.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 18).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-2.0F, 16.55F, -2.5F);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.025F, 2.7552F, -0.9282F);
			right_arm.addChild(cube_r6);
			setRotationAngle(cube_r6, -1.9635F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(24, 26).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, -0.05F, 0.0F);
			right_arm.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.3054F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(17, 18).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(2.0F, 16.55F, -2.5F);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-0.025F, 2.7552F, -0.9282F);
			left_arm.addChild(cube_r8);
			setRotationAngle(cube_r8, -1.9635F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(0, 27).addBox(0.0F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, -0.05F, 0.0F);
			left_arm.addChild(cube_r9);
			setRotationAngle(cube_r9, -0.3054F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(19, 0).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 17.675F, 0.0F);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, -0.1745F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(0, 0).addBox(0.0F, -7.0F, -8.0F, 0.0F, 4.0F, 14.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 11.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.5F, -6.1049F, -5.6364F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.4399F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(28, 10).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, -3.0549F, -4.3078F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, -0.8727F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(14, 26).addBox(-1.5F, -0.45F, -3.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-1.25F, 16.0F, 2.25F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-0.875F, 7.9868F, -0.0333F);
			right_leg.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.48F, 0.0F);
			cube_r13.setTextureOffset(0, 7).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-0.875F, 8.0118F, -0.0333F);
			right_leg.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, -0.48F, 0.0F);
			cube_r14.setTextureOffset(4, 8).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-0.9F, 6.7732F, 0.9564F);
			right_leg.addChild(cube_r15);
			setRotationAngle(cube_r15, -0.3927F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 0).addBox(-0.475F, -1.5F, -1.45F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-0.9F, 4.447F, -0.2673F);
			right_leg.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.7418F, 0.0F, 0.0F);
			cube_r16.setTextureOffset(6, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-0.9F, 0.75F, -1.0F);
			right_leg.addChild(cube_r17);
			setRotationAngle(cube_r17, -0.2182F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(28, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(1.25F, 16.0F, 2.25F);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.875F, 7.9868F, -0.0333F);
			left_leg.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, -0.48F, 0.0F);
			cube_r18.setTextureOffset(0, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(0.875F, 8.0118F, -0.0333F);
			left_leg.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.48F, 0.0F);
			cube_r19.setTextureOffset(11, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(0.9F, 6.7732F, 0.9564F);
			left_leg.addChild(cube_r20);
			setRotationAngle(cube_r20, -0.3927F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(0, 21).addBox(-0.525F, -1.5F, -1.45F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.9F, 4.447F, -0.2673F);
			left_leg.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.7418F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(11, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(0.9F, 0.75F, -1.0F);
			left_leg.addChild(cube_r22);
			setRotationAngle(cube_r22, -0.2182F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(29, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			mob_head.render(matrixStack, buffer, packedLight, packedOverlay);
			mob_tail.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
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
			this.mob_tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
