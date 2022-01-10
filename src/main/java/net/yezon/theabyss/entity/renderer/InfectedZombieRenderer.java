package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.InfectedZombieEntity;

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
public class InfectedZombieRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(InfectedZombieEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelinfected_zombie(), 0.5f) {
					{
						this.addLayer(new GlowingLayer<>(this));
					}

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/infected_zombie_skeleton.png");
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
					.getBuffer(RenderType.getEyes(new ResourceLocation("theabyss:textures/infected_zombie_skeleton_glowing_layer.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelinfected_zombie extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer right_leg;
		private final ModelRenderer right_arm;
		private final ModelRenderer left_leg;
		private final ModelRenderer left_arm;
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r2;

		public Modelinfected_zombie() {
			textureWidth = 128;
			textureHeight = 128;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 2.0F);
			main.addChild(body);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -11.6527F, 0.0304F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.1745F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(31, 60).addBox(-3.5F, -11.0F, -1.5F, 7.0F, 10.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(24, 26).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, -12.0F, 2.0F);
			main.addChild(right_leg);
			right_leg.setTextureOffset(28, 42).addBox(-2.001F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_leg.setTextureOffset(0, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			right_leg.setTextureOffset(17, 61).addBox(-1.499F, 0.025F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, false);
			right_arm = new ModelRenderer(this);
			right_arm.setRotationPoint(-4.0F, -21.5F, 0.0F);
			main.addChild(right_arm);
			right_arm.setTextureOffset(32, 0).addBox(-4.001F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			right_arm.setTextureOffset(44, 42).addBox(-3.5F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			right_arm.setTextureOffset(48, 29).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, -12.0F, 2.0F);
			main.addChild(left_leg);
			left_leg.setTextureOffset(12, 42).addBox(-1.999F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			left_leg.setTextureOffset(0, 61).addBox(-1.499F, 1.0F, -1.5F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			left_leg.setTextureOffset(16, 30).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			left_arm = new ModelRenderer(this);
			left_arm.setRotationPoint(4.0F, -21.5F, 0.0F);
			main.addChild(left_arm);
			left_arm.setTextureOffset(44, 16).addBox(0.5F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			left_arm.setTextureOffset(48, 0).addBox(1.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, 0.0F, false);
			left_arm.setTextureOffset(0, 30).addBox(0.001F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, -22.0F, 0.0F);
			main.addChild(mob_head);
			setRotationAngle(mob_head, 0.3054F, 0.0F, -0.3054F);
			mob_head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			mob_head.setTextureOffset(0, 16).addBox(-3.5F, -7.5F, -3.5F, 7.0F, 7.0F, 7.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -1.0F, -4.0F);
			mob_head.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.215F, 0.0376F, 0.1705F);
			cube_r2.setTextureOffset(56, 1).addBox(-4.0F, -1.0F, -0.025F, 8.0F, 4.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
