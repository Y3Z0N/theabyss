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
public class ModelPhantom<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "model_phantom"), "main");
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart mob_head;
	public final ModelPart body;

	public ModelPhantom(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.mob_head = root.getChild("mob_head");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_arm = partdefinition.addOrReplaceChild(
				"right_arm", CubeListBuilder.create().texOffs(16, 48).addBox(-4.025F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(0, 34).addBox(-4.55F, -1.5F, -1.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild(
				"left_arm", CubeListBuilder.create().texOffs(32, 49).addBox(0.05F, -1.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(36, 0).addBox(-0.45F, -1.5F, -1.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition mob_head = partdefinition
				.addOrReplaceChild(
						"mob_head", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
								.texOffs(0, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 1.0F, 1.0F));
		PartDefinition body = partdefinition.addOrReplaceChild(
				"body", CubeListBuilder.create().texOffs(28, 30).addBox(-5.0F, -23.0F, -1.0F, 10.0F, 15.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(63, 0).addBox(-4.5F, -22.975F, -0.25F, 9.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 6).addBox(0.1546F, -0.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.1546F, -6.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 3)
						.addBox(0.1546F, -3.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.8467F, -14.5F, -4.0188F, 0.0F, -1.789F, 0.0F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 18).addBox(-1.1546F, -0.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(0, 21).addBox(-1.1546F, -6.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 18)
						.addBox(-1.1546F, -3.475F, -2.8829F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.8467F, -14.5F, -4.0188F, 0.0F, 1.789F, 0.0F));
		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(48, 49).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 0)
						.addBox(-0.5F, -6.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(15, 34).addBox(-0.5F, -3.5F, -4.0F, 1.0F,
								1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5F, -14.5F, -0.5F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(51, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 52)
						.addBox(-0.5F, -6.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(6, 53).addBox(-0.5F, -3.5F, -4.0F, 1.0F,
								1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, -14.5F, -0.5F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(58, 32).addBox(-3.5F, 0.0F, -3.5F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 18)
						.addBox(-4.0F, 0.0F, -4.0F, 9.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -10.0F, 2.4641F, 0.5236F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		right_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_arm.render(poseStack, buffer, packedLight, packedOverlay);
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
