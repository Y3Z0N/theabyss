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

// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelfrost_spider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelfrost_spider"), "main");
	public final ModelPart right_leg2;
	public final ModelPart left_leg2;
	public final ModelPart right_leg1;
	public final ModelPart left_leg1;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart mob_head;
	public final ModelPart body;

	public Modelfrost_spider(ModelPart root) {
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg2 = root.getChild("left_leg2");
		this.right_leg1 = root.getChild("right_leg1");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.mob_head = root.getChild("mob_head");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create().texOffs(0, 21).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 20.5F, 3.5F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r1 = right_leg2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r2 = right_leg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 47).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r3 = right_leg2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 26).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create().texOffs(27, 53).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 20.5F, 3.5F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r4 = left_leg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(21, 44).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r5 = left_leg2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(49, 48).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r6 = left_leg2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 33).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1", CubeListBuilder.create().texOffs(15, 53).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 20.5F, 1.75F, 0.0F, -0.3054F, 0.0F));
		PartDefinition cube_r7 = right_leg1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(11, 44).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r8 = right_leg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(48, 0).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r9 = right_leg1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(19, 26).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1", CubeListBuilder.create().texOffs(54, 14).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 20.5F, 1.75F, 0.0F, 0.3054F, 0.0F));
		PartDefinition cube_r10 = left_leg1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(44, 30).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r11 = left_leg1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(51, 7).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r12 = left_leg1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 44).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(21, 53).addBox(-6.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 20.5F, -1.5F, 0.0F, -0.3054F, 0.0F));
		PartDefinition cube_r13 = right_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(44, 12).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.48F));
		PartDefinition cube_r14 = right_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(41, 48).addBox(-0.75F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 1.5F, 0.0F, 0.0F, 0.0F, -0.2618F));
		PartDefinition cube_r15 = right_leg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(26, 33).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(54, 28).addBox(5.7067F, 0.4388F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 20.5F, -1.5F, 0.0F, 0.3054F, 0.0F));
		PartDefinition cube_r16 = left_leg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(31, 45).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -4.0F, 0.0F, 0.0F, 0.0F, -0.48F));
		PartDefinition cube_r17 = left_leg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(52, 19).addBox(-1.25F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.75F, 1.5F, 0.0F, 0.0F, 0.0F, 0.2618F));
		PartDefinition cube_r18 = left_leg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(52, 44).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create().texOffs(38, 40).addBox(-1.5F, -2.5F, -4.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -6.0F));
		PartDefinition cube_r19 = mob_head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(38, 31).addBox(-0.5374F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.625F, 1.5F, -4.1F, 0.215F, -0.1119F, -0.1769F));
		PartDefinition cube_r20 = mob_head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(48, 39).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.5F, -1.0F, 0.2618F, 0.6109F, 0.0F));
		PartDefinition cube_r21 = mob_head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(18, 44).addBox(-0.4626F, -0.4932F, -1.611F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.625F, 1.5F, -4.1F, 0.215F, 0.1119F, 0.1769F));
		PartDefinition cube_r22 = mob_head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(5, 53).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.5F, -1.0F, 0.2618F, -0.6109F, 0.0F));
		PartDefinition cube_r23 = mob_head.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -2.25F, 0.6109F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, 1.0F, 10.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(40, 22).addBox(-2.0F, -7.0F, -8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(26, 19).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -6.0F, 13.0F, 0.0F, 0.5236F, 0.0F));
		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(26, 19).mirror().addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, -6.0F, 13.0F, 0.0F, -0.5236F, 0.0F));
		PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(26, 6).mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.0F, 13.0F, 0.5236F, 0.0F, 0.0F));
		PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(26, 6).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.0F, 13.0F, -0.5236F, 0.0F, 0.0F));
		PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(19, 10).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -6.0F, 3.0F, 0.5977F, -0.2425F, 0.045F));
		PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(19, 10).mirror().addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.5F, -6.0F, 3.0F, 0.5977F, 0.2425F, -0.045F));
		PartDefinition cube_r30 = body.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(19, 10).addBox(0.0F, -5.0F, 1.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, 3.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(14, 33).mirror().addBox(-1.0F, -7.0F, -7.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, -7.5F, 4.5F, 0.7F, -0.1278F, -0.0285F));
		PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(14, 33).addBox(1.0F, -7.0F, -7.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -7.5F, 4.5F, 0.7F, 0.1278F, 0.0285F));
		PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 21).addBox(-3.0F, -3.0F, -7.0F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, 2.0F, 0.2182F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg1.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg1.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
