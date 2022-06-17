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
public class Modelabyss_raptor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelabyss_raptor"), "main");
	public final ModelPart mob_head;
	public final ModelPart mob_tail;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart body;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modelabyss_raptor(ModelPart root) {
		this.mob_head = root.getChild("mob_head");
		this.mob_tail = root.getChild("mob_tail");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.body = root.getChild("body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create(), PartPose.offset(0.0F, 9.675F, -7.0F));
		PartDefinition cube_r1 = mob_head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -0.625F, -6.925F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r2 = mob_head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.575F, -7.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r3 = mob_head.addOrReplaceChild(
				"cube_r3", CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(0.0F, -2.0301F, -3.6082F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -2.85F, -1.0F, 0.2618F, -0.0175F, 0.0436F));
		PartDefinition cube_r4 = mob_head.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0301F, -3.6082F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.85F, -1.0F, 0.2618F, 0.0087F, -0.0436F));
		PartDefinition cube_r5 = mob_head.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(18, 18).addBox(-1.5F, -2.3F, -3.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition mob_tail = partdefinition.addOrReplaceChild("mob_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 5.75F));
		PartDefinition cube_r6 = mob_tail.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.45F, -0.225F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.5722F, 6.7275F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r7 = mob_tail.addOrReplaceChild(
				"cube_r7", CubeListBuilder.create().texOffs(19, 0).mirror()
						.addBox(0.025F, -2.0178F, -2.204F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -1.2F, 1.9F, 0.1745F, 0.0F, 0.0087F));
		PartDefinition cube_r8 = mob_tail.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(19, 0).addBox(-0.025F, -2.0178F, -2.204F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.2F, 1.9F, 0.1745F, 0.0F, -0.0087F));
		PartDefinition cube_r9 = mob_tail.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.15F, -0.1F, 0.1745F, 0.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-2.0F, 16.55F, -2.5F));
		PartDefinition cube_r10 = right_arm.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(24, 26).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, 2.7552F, -0.9282F, -1.9635F, 0.0F, 0.0F));
		PartDefinition cube_r11 = right_arm.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(17, 18).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.05F, 0.0F, -0.3054F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(2.0F, 16.55F, -2.5F));
		PartDefinition cube_r12 = left_arm.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.025F, 2.7552F, -0.9282F, -1.9635F, 0.0F, 0.0F));
		PartDefinition cube_r13 = left_arm.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(19, 0).addBox(0.0F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.05F, 0.0F, -0.3054F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 17.675F, 0.0F));
		PartDefinition cube_r14 = body.addOrReplaceChild(
				"cube_r14", CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(0.0F, -4.0456F, -7.4791F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, -0.0436F));
		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0456F, -7.4791F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, 0.0436F));
		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(28, 10).addBox(-1.5F, 0.0F, -2.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -6.1049F, -5.6364F, -1.4399F, 0.0F, 0.0F));
		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(14, 26).addBox(-1.5F, -0.45F, -3.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0549F, -4.3078F, -0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.25F, 17.0F, 2.25F));
		PartDefinition cube_r19 = right_leg.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(0, 7).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.875F, 6.9868F, -0.0333F, 0.0F, 0.48F, 0.0F));
		PartDefinition cube_r20 = right_leg.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(4, 8).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.875F, 7.0118F, -0.0333F, 0.0F, -0.48F, 0.0F));
		PartDefinition cube_r21 = right_leg.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.475F, -1.5F, -1.45F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.9F, 5.7732F, 0.9564F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r22 = right_leg.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.9F, 3.447F, -0.2673F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r23 = right_leg.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(28, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.9F, -0.25F, -1.0F, -0.2182F, 0.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.25F, 17.0F, 2.25F));
		PartDefinition cube_r24 = left_leg.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.875F, 6.9868F, -0.0333F, 0.0F, -0.48F, 0.0F));
		PartDefinition cube_r25 = left_leg.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(11, 18).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.875F, 7.0118F, -0.0333F, 0.0F, 0.48F, 0.0F));
		PartDefinition cube_r26 = left_leg.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(0, 21).addBox(-0.525F, -1.5F, -1.45F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, 5.7732F, 0.9564F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r27 = left_leg.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(11, 21).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, 3.447F, -0.2673F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r28 = left_leg.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(29, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9F, -0.25F, -1.0F, -0.2182F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		mob_tail.render(poseStack, buffer, packedLight, packedOverlay);
		right_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_arm.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.mob_tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
