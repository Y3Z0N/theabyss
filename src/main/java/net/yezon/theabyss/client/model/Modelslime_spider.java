package net.yezon.theabyss.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelslime_spider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelslime_spider"), "main");
	public final ModelPart mob_head;
	public final ModelPart right_leg;
	public final ModelPart left_leg1;
	public final ModelPart right_leg1;
	public final ModelPart left_leg2;
	public final ModelPart right_leg2;
	public final ModelPart left_leg;
	public final ModelPart body;

	public Modelslime_spider(ModelPart root) {
		this.mob_head = root.getChild("mob_head");
		this.right_leg = root.getChild("right_leg");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg1 = root.getChild("right_leg1");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg = root.getChild("left_leg");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, -2.5F, -4.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -6.0F));
		PartDefinition cube_r1 = mob_head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5374F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.625F, 1.5F, -4.1F, 0.215F, -0.1119F, -0.1769F));
		PartDefinition cube_r2 = mob_head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 13).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.5F, -1.0F, 0.2618F, 0.6109F, 0.0F));
		PartDefinition cube_r3 = mob_head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 9).addBox(-0.4626F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.625F, 1.5F, -4.1F, 0.215F, 0.1119F, 0.1769F));
		PartDefinition cube_r4 = mob_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.5F, -1.0F, 0.2618F, -0.6109F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(16, 49).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 20.5F, -1.5F, 0.0F, -0.3054F, 0.0F));
		PartDefinition cube_r5 = right_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r6 = right_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(38, 45).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r7 = right_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 10).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create().texOffs(22, 51).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 20.5F, 1.75F, 0.0F, 0.3054F, 0.0F));
		PartDefinition cube_r8 = left_leg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(42, 18).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r9 = left_leg1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 47).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r10 = left_leg1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(37, 9).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create().texOffs(48, 32).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 20.5F, 1.75F, 0.0F, -0.3054F, 0.0F));
		PartDefinition cube_r11 = right_leg1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r12 = right_leg1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 45).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r13 = right_leg1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(32, 8).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(51, 11).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 20.5F, 3.5F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r14 = left_leg2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(10, 38).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r15 = left_leg2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(46, 45).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r16 = left_leg2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(32, 29).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create().texOffs(48, 27).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 20.5F, 3.5F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r17 = right_leg2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r18 = right_leg2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(44, 6).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r19 = right_leg2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(26, 29).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 5).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 20.5F, -1.5F, 0.0F, 0.3054F, 0.0F));
		PartDefinition cube_r20 = left_leg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(20, 42).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r21 = left_leg.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(8, 47).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r22 = left_leg.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(7, 38).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, 1.0F, 10.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
				.addBox(-4.0F, -10.0F, 1.25F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(26, 21).addBox(-2.0F, -7.0F, -8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(29, 31).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, 2.0F, 0.2182F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mob_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
