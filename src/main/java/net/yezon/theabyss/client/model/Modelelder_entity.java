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
public class Modelelder_entity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelelder_entity"), "main");
	public final ModelPart head;
	public final ModelPart neck;
	public final ModelPart torso;
	public final ModelPart tail;
	public final ModelPart leg_left;
	public final ModelPart arm_left;
	public final ModelPart leg_right;
	public final ModelPart arm_right;

	public Modelelder_entity(ModelPart root) {
		this.head = root.getChild("head");
		this.neck = root.getChild("neck");
		this.torso = root.getChild("torso");
		this.tail = root.getChild("tail");
		this.leg_left = root.getChild("leg_left");
		this.arm_left = root.getChild("arm_left");
		this.leg_right = root.getChild("leg_right");
		this.arm_right = root.getChild("arm_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.3664F, -46.2686F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 24).addBox(0.0F, -59.0F, -43.0F, 0.0F, 14.0F, 32.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 29.3664F, 46.2686F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(102, 87).addBox(-5.0F, -49.0F, -40.0F, 10.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 29.3664F, 46.2686F, 0.5236F, 0.0F, 0.0F));
		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(92, 53).addBox(-5.5F, -40.0F, -60.0F, 11.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 29.3664F, 46.2686F, 0.0436F, 0.0F, 0.0F));
		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r4 = neck.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(56, 80).addBox(0.0F, -45.0F, -34.0F, 0.0F, 18.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(62, 0).addBox(-5.0F, -45.0F, -34.0F, 10.0F, 10.0F, 23.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r5 = torso.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 75).addBox(0.5F, -50.0F, 32.0F, 0.0F, 12.0F, 28.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r6 = torso.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -39.0F, -27.0F, 12.0F, 18.0F, 38.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -7.4638F, 9.4709F));
		PartDefinition cube_r7 = tail.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(52, 70).addBox(-4.0F, -18.0F, 30.0F, 8.0F, 9.0F, 24.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 31.4638F, -9.4709F, 0.9163F, 0.0F, 0.0F));
		PartDefinition cube_r8 = tail.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 56).addBox(-3.5F, -50.0F, 25.0F, 7.0F, 7.0F, 31.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 31.4638F, -9.4709F, 0.1309F, 0.0F, 0.0F));
		PartDefinition leg_left = partdefinition.addOrReplaceChild("leg_left",
				CubeListBuilder.create().texOffs(32, 115).addBox(-2.5F, 14.8659F, -6.1854F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(100, 33).addBox(-2.5F, 29.8659F, -13.1854F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.5F, -8.8659F, 6.1854F));
		PartDefinition cube_r9 = leg_left.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -37.0F, -7.0F, 7.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.5F, 32.8659F, -6.1854F, -0.2618F, 0.0F, 0.0F));
		PartDefinition arm_left = partdefinition.addOrReplaceChild("arm_left", CubeListBuilder.create(), PartPose.offset(-8.9574F, -7.77F, -20.7237F));
		PartDefinition cube_r10 = arm_left.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(45, 59).addBox(-8.5F, -15.0F, -26.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(72, 121).addBox(-10.5F, -15.0F, -26.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.9574F, 31.77F, 20.7237F, -0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r11 = arm_left.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(100, 28).addBox(-9.0F, -5.0F, -26.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(128, 17).addBox(-10.0F, -6.0F, -26.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.9574F, 31.77F, 20.7237F, -0.2618F, 0.0F, -0.1309F));
		PartDefinition cube_r12 = arm_left.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 56).addBox(-11.0F, -38.0F, -18.0F, 5.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.9574F, 31.77F, 20.7237F, 0.1745F, 0.0F, 0.0F));
		PartDefinition leg_right = partdefinition.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(32, 115).mirror().addBox(-2.5F, 14.8659F, -6.1854F, 5.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(100, 33)
				.mirror().addBox(-2.5F, 29.8659F, -13.1854F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.5F, -8.8659F, 6.1854F));
		PartDefinition cube_r13 = leg_right.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(5.0F, -37.0F, -7.0F, 7.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-8.5F, 32.8659F, -6.1854F, -0.2618F, 0.0F, 0.0F));
		PartDefinition arm_right = partdefinition.addOrReplaceChild("arm_right", CubeListBuilder.create(), PartPose.offset(8.9574F, -7.77F, -20.7237F));
		PartDefinition cube_r14 = arm_right.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(45, 59).mirror().addBox(8.5F, -15.0F, -26.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(72, 121).mirror()
				.addBox(6.5F, -15.0F, -26.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.9574F, 31.77F, 20.7237F, -0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r15 = arm_right.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(100, 28).mirror().addBox(9.0F, -5.0F, -26.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(128, 17).mirror()
				.addBox(7.0F, -6.0F, -26.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.9574F, 31.77F, 20.7237F, -0.2618F, 0.0F, 0.1309F));
		PartDefinition cube_r16 = arm_right.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(6.0F, -38.0F, -18.0F, 5.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-8.9574F, 31.77F, 20.7237F, 0.1745F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg_right.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.arm_right.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leg_left.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.arm_left.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
