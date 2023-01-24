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

// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsoul_lizard<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelsoul_lizard"), "main");
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart mob_head;
	public final ModelPart mob_tail;
	public final ModelPart body;

	public Modelsoul_lizard(ModelPart root) {
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.mob_head = root.getChild("mob_head");
		this.mob_tail = root.getChild("mob_tail");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(2.0F, 22.5F, -4.0F));
		PartDefinition cube_r1 = left_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 6).addBox(0.1331F, -0.0857F, -0.489F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1F, 0.3F, 0.35F, 2.5976F, 1.208F, 2.5642F));
		PartDefinition cube_r2 = left_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 8).addBox(0.2331F, -0.1607F, -0.414F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1F, 0.3F, 0.35F, 0.2544F, 0.9409F, 0.2891F));
		PartDefinition cube_r3 = left_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 7).addBox(-0.4169F, -0.2107F, -0.689F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.3511F, 0.333F, 1.5638F, 0.0436F, 0.5236F, 0.0F));
		PartDefinition cube_r4 = left_arm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 3).addBox(-1.0F, -0.4F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.025F, 0.0F, -0.675F, -0.1745F, -0.8126F, 0.2553F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-2.0F, 22.5F, -4.0F));
		PartDefinition cube_r5 = right_arm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 19).addBox(-2.1331F, -0.0857F, -0.489F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1F, 0.3F, 0.35F, 2.5976F, -1.208F, -2.5642F));
		PartDefinition cube_r6 = right_arm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(15, 20).addBox(-2.2331F, -0.1607F, -0.414F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1F, 0.3F, 0.35F, 0.2544F, -0.9409F, -0.2891F));
		PartDefinition cube_r7 = right_arm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(20, 9).addBox(-2.5831F, -0.2107F, -0.689F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.3511F, 0.333F, 1.5638F, 0.0436F, -0.5236F, 0.0F));
		PartDefinition cube_r8 = right_arm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 5).addBox(-3.0F, -0.4F, 0.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, 0.0F, -0.675F, -0.1745F, 0.8126F, -0.2553F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, 22.5F, 4.0F));
		PartDefinition cube_r9 = right_leg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 21).addBox(-2.1331F, -0.0857F, -0.511F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.875F, 0.375F, 0.4F, 0.0219F, -0.126F, -0.1965F));
		PartDefinition cube_r10 = right_leg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(13, 22).addBox(-2.2331F, -0.1607F, -0.586F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.875F, 0.375F, 0.4F, 0.2639F, -1.0222F, -0.3279F));
		PartDefinition cube_r11 = right_leg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 23).addBox(-1.8081F, -0.2107F, -0.511F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.625F, 0.375F, 0.4F, 0.0F, 0.0F, -0.0436F));
		PartDefinition cube_r12 = right_leg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 17).addBox(-2.0F, -0.4F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, -0.3054F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(2.0F, 22.5F, 4.0F));
		PartDefinition cube_r13 = left_leg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(6, 23).addBox(0.1331F, -0.0857F, -0.511F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.875F, 0.375F, 0.4F, 0.0219F, 0.126F, 0.1965F));
		PartDefinition cube_r14 = left_leg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(18, 23).addBox(0.2331F, -0.1607F, -0.586F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.875F, 0.375F, 0.4F, 0.2639F, 1.0222F, 0.3279F));
		PartDefinition cube_r15 = left_leg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(11, 24).addBox(-0.1919F, -0.2107F, -0.511F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.625F, 0.375F, 0.4F, 0.0F, 0.0F, 0.0436F));
		PartDefinition cube_r16 = left_leg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -0.4F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.3054F));
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create(), PartPose.offset(0.0F, 21.75F, -6.0F));
		PartDefinition cube_r17 = mob_head.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 17).addBox(-1.5F, -1.0F, -3.525F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition mob_tail = partdefinition.addOrReplaceChild("mob_tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.975F, -0.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 6.0F));
		PartDefinition cube_r18 = mob_tail.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -0.475F, -0.15F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.25F, 3.75F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r19 = mob_tail.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(10, 13).mirror().addBox(0.0F, -1.725F, -2.025F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.0F, 0.0F, 0.0349F));
		PartDefinition cube_r20 = mob_tail.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(10, 13).addBox(0.0F, -1.725F, -2.025F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.0349F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.25F, 0.0F));
		PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, -2.0F, -6.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0349F));
		PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -2.0F, -6.0F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.0349F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mob_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mob_tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.mob_tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
