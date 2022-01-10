package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.MagicianEntity;

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
public class MagicianRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MagicianEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelmagician(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/magician.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/magician_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelmagician extends EntityModel<Entity> {
		private final ModelRenderer MODEL;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r1;
		private final ModelRenderer body_r1;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r2;
		private final ModelRenderer body_r2;
		private final ModelRenderer right_arm;
		private final ModelRenderer right_arm_r1;
		private final ModelRenderer staff;
		private final ModelRenderer magic_cube_r1;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer left_arm;
		private final ModelRenderer left_arm_r1;
		private final ModelRenderer body;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer head;

		public Modelmagician() {
			textureWidth = 128;
			textureHeight = 128;
			MODEL = new ModelRenderer(this);
			MODEL.setRotationPoint(0.0F, 24.0F, 0.0F);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-3.15F, -18.0F, 0.0F);
			MODEL.addChild(right_leg);
			right_leg.setTextureOffset(48, 41).addBox(-2.85F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-2.85F, 0.0F, 0.0F);
			right_leg.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0436F);
			cube_r1.setTextureOffset(64, 59).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 6.0F, 0.0F, false);
			body_r1 = new ModelRenderer(this);
			body_r1.setRotationPoint(3.15F, 0.0F, 3.0F);
			right_leg.addChild(body_r1);
			setRotationAngle(body_r1, 0.0436F, 0.0F, 0.0F);
			body_r1.setTextureOffset(76, 64).addBox(-6.0F, 0.0F, 0.0F, 6.0F, 16.0F, 0.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(3.15F, -18.0F, 0.0F);
			MODEL.addChild(left_leg);
			left_leg.setTextureOffset(0, 65).addBox(-3.15F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(2.85F, 0.0F, 0.0F);
			left_leg.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.0436F);
			cube_r2.setTextureOffset(68, 10).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 6.0F, 0.0F, false);
			body_r2 = new ModelRenderer(this);
			body_r2.setRotationPoint(-3.15F, 0.0F, 3.0F);
			left_leg.addChild(body_r2);
			setRotationAngle(body_r2, 0.0436F, 0.0F, 0.0F);
			body_r2.setTextureOffset(76, 80).addBox(0.0F, 0.0F, 0.0F, 6.0F, 16.0F, 0.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-5.5F, -33.0F, 0.0F);
			MODEL.addChild(right_arm);
			right_arm_r1 = new ModelRenderer(this);
			right_arm_r1.setRotationPoint(5.5F, 33.0F, 0.0F);
			right_arm.addChild(right_arm_r1);
			setRotationAngle(right_arm_r1, -0.4363F, 0.0F, 0.0873F);
			right_arm_r1.setTextureOffset(0, 24).addBox(-14.5F, -30.5F, -17.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			right_arm_r1.setTextureOffset(24, 65).addBox(-14.0F, -31.5F, -16.5F, 5.0F, 18.0F, 5.0F, 0.0F, false);
			staff = new ModelRenderer(this);
			staff.setRotationPoint(-3.875F, 12.375F, -6.375F);
			right_arm.addChild(staff);
			magic_cube_r1 = new ModelRenderer(this);
			magic_cube_r1.setRotationPoint(0.0F, -16.0F, -26.0F);
			staff.addChild(magic_cube_r1);
			setRotationAngle(magic_cube_r1, -0.2618F, 0.0F, 0.0F);
			magic_cube_r1.setTextureOffset(75, 27).addBox(-3.125F, -4.375F, -1.75F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-0.375F, -18.4168F, -24.7491F);
			staff.addChild(cube_r3);
			setRotationAngle(cube_r3, -1.2654F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(83, 0).addBox(-1.25F, 1.275F, 5.25F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-0.375F, -17.863F, -19.0028F);
			staff.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.8727F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(84, 37).addBox(-1.25F, 0.2923F, -0.7747F, 2.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.375F, -7.996F, -23.9293F);
			staff.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.4363F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(80, 16).addBox(-2.5F, -1.475F, -0.275F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(9.375F, 22.625F, 10.375F);
			staff.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.2182F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(72, 55).addBox(-12.5F, -35.625F, -23.25F, 5.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-0.375F, -16.1347F, -12.5119F);
			staff.addChild(cube_r7);
			setRotationAngle(cube_r7, -1.3963F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(58, 82).addBox(-1.5F, 3.5F, 1.75F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(9.375F, 22.625F, 10.375F);
			staff.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.3927F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(84, 45).addBox(-11.75F, -19.25F, -2.25F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r8.setTextureOffset(21, 88).addBox(-11.75F, -19.25F, -29.25F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r8.setTextureOffset(35, 88).addBox(-11.75F, -19.25F, -33.25F, 4.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r8.setTextureOffset(0, 0).addBox(-11.25F, -18.75F, -35.25F, 3.0F, 3.0F, 38.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(5.5F, -33.0F, 0.0F);
			MODEL.addChild(left_arm);
			left_arm_r1 = new ModelRenderer(this);
			left_arm_r1.setRotationPoint(-5.5F, 33.0F, 0.0F);
			left_arm.addChild(left_arm_r1);
			setRotationAngle(left_arm_r1, 0.0F, 0.0F, -0.0873F);
			left_arm_r1.setTextureOffset(44, 27).addBox(8.5F, -28.25F, -3.5F, 6.0F, 3.0F, 6.0F, 0.0F, false);
			left_arm_r1.setTextureOffset(44, 16).addBox(8.5F, -34.25F, -3.5F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			left_arm_r1.setTextureOffset(44, 65).addBox(9.0F, -35.25F, -3.0F, 5.0F, 18.0F, 5.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -36.0F, 0.0F);
			MODEL.addChild(body);
			body.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -3.0F, 12.0F, 18.0F, 6.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-6.0F, 18.0F, 0.0F);
			body.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.0567F);
			cube_r9.setTextureOffset(24, 18).addBox(0.0F, 0.0F, -3.0F, 0.0F, 14.0F, 6.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(6.0F, 18.0F, 0.0F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -0.0654F);
			cube_r10.setTextureOffset(72, 35).addBox(0.0F, 0.0F, -3.0F, 0.0F, 14.0F, 6.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -36.0F, 0.0F);
			MODEL.addChild(head);
			head.setTextureOffset(0, 41).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);
			head.setTextureOffset(44, 0).addBox(-6.5F, -11.0F, -6.5F, 13.0F, 3.0F, 13.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			MODEL.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.magic_cube_r1.rotateAngleX = f2 / 20.f;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
