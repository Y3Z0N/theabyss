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
public class Modelzombie1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelzombie_1"), "main");
	public final ModelPart mob_head;
	public final ModelPart left_arm;
	public final ModelPart left_leg;
	public final ModelPart right_arm;
	public final ModelPart right_leg;
	public final ModelPart body;

	public Modelzombie1(ModelPart root) {
		this.mob_head = root.getChild("mob_head");
		this.left_arm = root.getChild("left_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(-3.5F, -7.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.3054F, 0.0F, -0.3054F));
		PartDefinition cube_r1 = mob_head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 1).addBox(-4.0F, -1.0F, -0.025F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, -0.215F, 0.0376F, 0.1705F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(44, 16).addBox(0.5F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
				.addBox(1.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(0.001F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 2.5F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(12, 42).addBox(-1.999F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 61)
				.addBox(-1.499F, 1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 30).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 2.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-4.001F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(44, 42)
				.addBox(-3.5F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 29).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 2.5F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 42).addBox(-2.001F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 46)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(17, 61).addBox(-1.499F, 0.025F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 2.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 2.0F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(31, 60).addBox(-3.5F, -11.0F, -1.5F, 7.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 26).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.6527F, 0.0304F, 0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		left_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
		right_arm.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_arm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
