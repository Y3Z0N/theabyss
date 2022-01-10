package net.yezon.theabyss.entity.renderer;

import net.yezon.theabyss.entity.FrostSpiderEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FrostSpiderRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FrostSpiderEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelfrost_spider(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("theabyss:textures/frost_spider.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelfrost_spider extends EntityModel<Entity> {
		private final ModelRenderer main;
		private final ModelRenderer body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer mob_head;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer left_leg;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer right_leg;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer left_leg1;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer right_leg1;
		private final ModelRenderer cube_r25;
		private final ModelRenderer cube_r26;
		private final ModelRenderer cube_r27;
		private final ModelRenderer left_leg2;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer cube_r30;
		private final ModelRenderer right_leg2;
		private final ModelRenderer cube_r31;
		private final ModelRenderer cube_r32;
		private final ModelRenderer cube_r33;

		public Modelfrost_spider() {
			textureWidth = 64;
			textureHeight = 64;
			main = new ModelRenderer(this);
			main.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			main.addChild(body);
			body.setTextureOffset(0, 0).addBox(-5.0F, -11.0F, 1.0F, 10.0F, 9.0F, 12.0F, 0.0F, false);
			body.setTextureOffset(40, 22).addBox(-2.0F, -7.0F, -8.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-5.0F, -6.0F, 13.0F);
			body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.5236F, 0.0F);
			cube_r1.setTextureOffset(26, 19).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(5.0F, -6.0F, 13.0F);
			body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, -0.5236F, 0.0F);
			cube_r2.setTextureOffset(26, 19).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F, true);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -2.0F, 13.0F);
			body.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.5236F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(26, 6).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 6.0F, 0.0F, true);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -11.0F, 13.0F);
			body.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.5236F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(26, 6).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-2.5F, -6.0F, 3.0F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.5977F, -0.2425F, 0.045F);
			cube_r5.setTextureOffset(19, 10).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(2.5F, -6.0F, 3.0F);
			body.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.5977F, 0.2425F, -0.045F);
			cube_r6.setTextureOffset(19, 10).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, 0.0F, true);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, -6.0F, 3.0F);
			body.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.6109F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(19, 10).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-1.0F, -7.5F, 4.5F);
			body.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.7F, -0.1278F, -0.0285F);
			cube_r8.setTextureOffset(14, 33).addBox(-1.0F, -7.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, true);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.0F, -7.5F, 4.5F);
			body.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.7F, 0.1278F, 0.0285F);
			cube_r9.setTextureOffset(14, 33).addBox(1.0F, -7.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, -7.0F, 2.0F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.2182F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(0, 21).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 7.0F, 7.0F, 0.0F, false);
			mob_head = new ModelRenderer(this);
			mob_head.setRotationPoint(0.0F, -5.0F, -6.0F);
			main.addChild(mob_head);
			mob_head.setTextureOffset(38, 40).addBox(-1.5F, -2.5F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-2.625F, 1.5F, -4.1F);
			mob_head.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.215F, -0.1119F, -0.1769F);
			cube_r11.setTextureOffset(38, 31).addBox(-0.5374F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-0.5F, 0.5F, -1.0F);
			mob_head.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.2618F, 0.6109F, 0.0F);
			cube_r12.setTextureOffset(48, 39).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(2.625F, 1.5F, -4.1F);
			mob_head.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.215F, 0.1119F, 0.1769F);
			cube_r13.setTextureOffset(18, 44).addBox(-0.4626F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(0.5F, 0.5F, -1.0F);
			mob_head.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.2618F, -0.6109F, 0.0F);
			cube_r14.setTextureOffset(5, 53).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(0.0F, 0.0F, -2.25F);
			mob_head.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.6109F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 5).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(2.0F, -3.5F, -1.5F);
			main.addChild(left_leg);
			setRotationAngle(left_leg, 0.0F, 0.3054F, 0.0F);
			left_leg.setTextureOffset(54, 28).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(3.5F, -4.0F, 0.0F);
			left_leg.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, -0.48F);
			cube_r16.setTextureOffset(31, 45).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(2.75F, 1.5F, 0.0F);
			left_leg.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.0F, 0.2618F);
			cube_r17.setTextureOffset(52, 19).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.0F, 0.0F, 0.3054F);
			cube_r18.setTextureOffset(52, 44).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-2.0F, -3.5F, -1.5F);
			main.addChild(right_leg);
			setRotationAngle(right_leg, 0.0F, -0.3054F, 0.0F);
			right_leg.setTextureOffset(21, 53).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-3.5F, -4.0F, 0.0F);
			right_leg.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, 0.48F);
			cube_r19.setTextureOffset(44, 12).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-2.75F, 1.5F, 0.0F);
			right_leg.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, 0.0F, -0.2618F);
			cube_r20.setTextureOffset(41, 48).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(0.0F, 0.0F, 0.0F);
			right_leg.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.0F, -0.3054F);
			cube_r21.setTextureOffset(26, 33).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			left_leg1 = new ModelRenderer(this);
			left_leg1.setRotationPoint(4.0F, -3.5F, 1.75F);
			main.addChild(left_leg1);
			setRotationAngle(left_leg1, 0.0F, 0.3054F, 0.0F);
			left_leg1.setTextureOffset(54, 14).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(3.5F, -4.0F, 0.0F);
			left_leg1.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.0F, 0.0F, -0.48F);
			cube_r22.setTextureOffset(44, 30).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(2.75F, 1.5F, 0.0F);
			left_leg1.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.0F, 0.0F, 0.2618F);
			cube_r23.setTextureOffset(51, 7).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg1.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.0F, 0.0F, 0.3054F);
			cube_r24.setTextureOffset(28, 44).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg1 = new ModelRenderer(this);
			right_leg1.setRotationPoint(-4.0F, -3.5F, 1.75F);
			main.addChild(right_leg1);
			setRotationAngle(right_leg1, 0.0F, -0.3054F, 0.0F);
			right_leg1.setTextureOffset(15, 53).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(-3.5F, -4.0F, 0.0F);
			right_leg1.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.0F, 0.0F, 0.48F);
			cube_r25.setTextureOffset(11, 44).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(-2.75F, 1.5F, 0.0F);
			right_leg1.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.0F, 0.0F, -0.2618F);
			cube_r26.setTextureOffset(48, 0).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(0.0F, 0.0F, 0.0F);
			right_leg1.addChild(cube_r27);
			setRotationAngle(cube_r27, 0.0F, 0.0F, -0.3054F);
			cube_r27.setTextureOffset(19, 26).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			left_leg2 = new ModelRenderer(this);
			left_leg2.setRotationPoint(4.0F, -3.5F, 3.5F);
			main.addChild(left_leg2);
			setRotationAngle(left_leg2, 0.0F, -0.3927F, 0.0F);
			left_leg2.setTextureOffset(27, 53).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(3.5F, -4.0F, 0.0F);
			left_leg2.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.0F, 0.0F, -0.48F);
			cube_r28.setTextureOffset(21, 44).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(2.75F, 1.5F, 0.0F);
			left_leg2.addChild(cube_r29);
			setRotationAngle(cube_r29, 0.0F, 0.0F, 0.2618F);
			cube_r29.setTextureOffset(49, 48).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg2.addChild(cube_r30);
			setRotationAngle(cube_r30, 0.0F, 0.0F, 0.3054F);
			cube_r30.setTextureOffset(32, 33).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			right_leg2 = new ModelRenderer(this);
			right_leg2.setRotationPoint(-4.0F, -3.5F, 3.5F);
			main.addChild(right_leg2);
			setRotationAngle(right_leg2, 0.0F, 0.3927F, 0.0F);
			right_leg2.setTextureOffset(0, 21).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(-3.5F, -4.0F, 0.0F);
			right_leg2.addChild(cube_r31);
			setRotationAngle(cube_r31, 0.0F, 0.0F, 0.48F);
			cube_r31.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(-2.75F, 1.5F, 0.0F);
			right_leg2.addChild(cube_r32);
			setRotationAngle(cube_r32, 0.0F, 0.0F, -0.2618F);
			cube_r32.setTextureOffset(0, 47).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(0.0F, 0.0F, 0.0F);
			right_leg2.addChild(cube_r33);
			setRotationAngle(cube_r33, 0.0F, 0.0F, -0.3054F);
			cube_r33.setTextureOffset(0, 26).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
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

			this.left_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg1.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg2.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.left_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.mob_head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.mob_head.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
