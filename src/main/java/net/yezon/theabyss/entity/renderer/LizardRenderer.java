package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.LizardEntity;

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
public class LizardRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LizardEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsoul_lizard(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/the_abyss_lizard.png");
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
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/the_abyss_lizard.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelsoul_lizard extends EntityModel<Entity> {
		private final ModelRenderer left_arm;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer right_arm;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r17;
		private final ModelRenderer mob_tail;
		private final ModelRenderer cube_r18;
		private final ModelRenderer body;

		public Modelsoul_lizard() {
			textureWidth = 32;
			textureHeight = 32;
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(2.0F, 22.5F, -4.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(3.1F, 0.3F, 0.35F);
			left_arm.addChild(cube_r1);
			setRotationAngle(cube_r1, 2.5976F, 1.208F, 2.5642F);
			cube_r1.setTextureOffset(6, 6).addBox(0.1331F, -0.0857F, -0.489F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(3.1F, 0.3F, 0.35F);
			left_arm.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.2544F, 0.9409F, 0.2891F);
			cube_r2.setTextureOffset(6, 8).addBox(0.2331F, -0.1607F, -0.414F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.3511F, 0.333F, 1.5638F);
			left_arm.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0436F, 0.5236F, 0.0F);
			cube_r3.setTextureOffset(20, 7).addBox(-0.4169F, -0.2107F, -0.689F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-0.025F, 0.0F, -0.675F);
			left_arm.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.1745F, -0.8126F, 0.2553F);
			cube_r4.setTextureOffset(20, 3).addBox(-1.0F, -0.4F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-2.0F, 22.5F, -4.0F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-3.1F, 0.3F, 0.35F);
			right_arm.addChild(cube_r5);
			setRotationAngle(cube_r5, 2.5976F, -1.208F, -2.5642F);
			cube_r5.setTextureOffset(10, 19).addBox(-2.1331F, -0.0857F, -0.489F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-3.1F, 0.3F, 0.35F);
			right_arm.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.2544F, -0.9409F, -0.2891F);
			cube_r6.setTextureOffset(15, 20).addBox(-2.2331F, -0.1607F, -0.414F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-1.3511F, 0.333F, 1.5638F);
			right_arm.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0436F, -0.5236F, 0.0F);
			cube_r7.setTextureOffset(20, 9).addBox(-2.5831F, -0.2107F, -0.689F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.025F, 0.0F, -0.675F);
			right_arm.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.1745F, 0.8126F, -0.2553F);
			cube_r8.setTextureOffset(20, 5).addBox(-3.0F, -0.4F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, 22.5F, 4.0F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-2.875F, 0.375F, 0.4F);
			right_leg.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0219F, -0.126F, -0.1965F);
			cube_r9.setTextureOffset(20, 21).addBox(-2.1331F, -0.0857F, -0.511F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-2.875F, 0.375F, 0.4F);
			right_leg.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.2639F, -1.0222F, -0.3279F);
			cube_r10.setTextureOffset(13, 22).addBox(-2.2331F, -0.1607F, -0.586F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-1.625F, 0.375F, 0.4F);
			right_leg.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, -0.0436F);
			cube_r11.setTextureOffset(0, 23).addBox(-1.8081F, -0.2107F, -0.511F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
			right_leg.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.3927F, -0.3054F);
			cube_r12.setTextureOffset(16, 17).addBox(-2.0F, -0.4F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, 22.5F, 4.0F);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(2.875F, 0.375F, 0.4F);
			left_leg.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0219F, 0.126F, 0.1965F);
			cube_r13.setTextureOffset(6, 23).addBox(0.1331F, -0.0857F, -0.511F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(2.875F, 0.375F, 0.4F);
			left_leg.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.2639F, 1.0222F, 0.3279F);
			cube_r14.setTextureOffset(18, 23).addBox(0.2331F, -0.1607F, -0.586F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(1.625F, 0.375F, 0.4F);
			left_leg.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, 0.0436F);
			cube_r15.setTextureOffset(11, 24).addBox(-0.1919F, -0.2107F, -0.511F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, -0.3927F, 0.3054F);
			cube_r16.setTextureOffset(20, 0).addBox(-1.0F, -0.4F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, 21.75F, -6.0F);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(0.0F, 0.0F, 0.0F);
			mob_head.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.1745F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(0, 17).addBox(-1.5F, -1.0F, -3.525F, 3.0F, 2.0F, 4.0F, 0.0F, false);
			mob_tail = new ModelRenderer(this);
			mob_tail.setRotationPoint(0.0F, 22.0F, 6.0F);
			mob_tail.setTextureOffset(0, 0).addBox(-1.0F, -0.975F, -0.25F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			mob_tail.setTextureOffset(10, 13).addBox(0.0F, -2.725F, -0.025F, 0.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.0F, -0.25F, 3.75F);
			mob_tail.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.1309F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(0, 6).addBox(-0.5F, -0.475F, -0.15F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.25F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 3.0F, 12.0F, 0.0F, false);
			body.setTextureOffset(0, 3).addBox(0.0F, -6.0F, -6.0F, 0.0F, 2.0F, 12.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
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

			this.right_arm.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.left_arm.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.mob_tail.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
