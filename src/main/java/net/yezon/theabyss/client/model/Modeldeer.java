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
public class Modeldeer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modeldeer"), "main");
	public final ModelPart mob_head;
	public final ModelPart right_leg1;
	public final ModelPart left_leg1;
	public final ModelPart right_leg2;
	public final ModelPart left_leg2;
	public final ModelPart mob_tail;
	public final ModelPart body;

	public Modeldeer(ModelPart root) {
		this.mob_head = root.getChild("mob_head");
		this.right_leg1 = root.getChild("right_leg1");
		this.left_leg1 = root.getChild("left_leg1");
		this.right_leg2 = root.getChild("right_leg2");
		this.left_leg2 = root.getChild("left_leg2");
		this.mob_tail = root.getChild("mob_tail");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create(), PartPose.offset(0.0F, 5.5F, -8.5F));
		PartDefinition cube_r1 = mob_head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(18, 31).addBox(-1.5F, -9.0F, -7.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 23)
						.addBox(-2.5F, -10.0F, -3.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.5F, 2.5F, 0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r2 = mob_head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(16, 25).addBox(-2.25F, -1.2093F, -0.6941F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -3.5F, 1.0F, 0.4363F, 0.0F, 0.5672F));
		PartDefinition cube_r3 = mob_head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(32, 23).addBox(-0.75F, -1.2093F, -0.6941F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.5F, -3.5F, 1.0F, 0.4363F, 0.0F, -0.5672F));
		PartDefinition horn_left = mob_head.addOrReplaceChild("horn_left", CubeListBuilder.create(), PartPose.offset(3.0244F, -7.5927F, -1.2413F));
		PartDefinition cube_r4 = horn_left.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(28, 38).addBox(-0.2236F, -5.1972F, -0.6244F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5523F, -0.1055F, 1.1188F));
		PartDefinition cube_r5 = horn_left.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 14).addBox(-3.8021F, -0.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0432F, -1.8554F, -2.1988F, 0.9511F, 0.0735F, 0.5188F));
		PartDefinition cube_r6 = horn_left.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(38, 26).addBox(-1.008F, -5.0117F, -0.992F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5962F, -1.0826F, -2.3115F, 0.974F, 0.1638F, 0.9501F));
		PartDefinition cube_r7 = horn_left.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(16, 23).addBox(-4.2521F, -2.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0432F, -1.8554F, -2.1988F, 0.954F, -0.2493F, 0.9422F));
		PartDefinition cube_r8 = horn_left.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(40, 32).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0244F, 4.0927F, 1.2413F, 0.3054F, 0.0F, 0.5236F));
		PartDefinition horn_right = mob_head.addOrReplaceChild("horn_right", CubeListBuilder.create(), PartPose.offset(-3.0244F, -7.5927F, -1.2413F));
		PartDefinition cube_r9 = horn_right.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(10, 10).addBox(-0.7764F, -5.1972F, -0.6244F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5523F, 0.1055F, -1.1188F));
		PartDefinition cube_r10 = horn_right.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 10).addBox(-0.1979F, -0.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0432F, -1.8554F, -2.1988F, 0.9511F, -0.0735F, -0.5188F));
		PartDefinition cube_r11 = horn_right.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 23).addBox(0.008F, -5.0117F, -0.992F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.5962F, -1.0826F, -2.3115F, 0.974F, -0.1638F, -0.9501F));
		PartDefinition cube_r12 = horn_right.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(0, 12).addBox(0.2521F, -2.9758F, -1.0421F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0432F, -1.8554F, -2.1988F, 0.954F, 0.2493F, -0.9422F));
		PartDefinition cube_r13 = horn_right.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(24, 38).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0244F, 4.0927F, 1.2413F, 0.3054F, 0.0F, -0.5236F));
		PartDefinition right_leg1 = partdefinition.addOrReplaceChild("right_leg1",
				CubeListBuilder.create().texOffs(32, 31).addBox(-2.0F, -1.25F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.25F, 15.25F, -6.5F));
		PartDefinition left_leg1 = partdefinition.addOrReplaceChild("left_leg1",
				CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -1.25F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.25F, 15.25F, -6.5F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild(
				"right_leg2", CubeListBuilder.create().texOffs(8, 33).addBox(-2.0F, 2.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(28, 0).addBox(-2.25F, -1.75F, -1.75F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.25F, 16.0F, 6.0F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild(
				"left_leg2", CubeListBuilder.create().texOffs(16, 38).addBox(0.0F, 2.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(28, 8).addBox(-0.75F, -1.75F, -1.75F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.25F, 16.0F, 6.0F));
		PartDefinition mob_tail = partdefinition.addOrReplaceChild("mob_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r14 = mob_tail.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(22, 23).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.0F, 7.0F, -0.7418F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -14.0F, -8.0F, 6.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.0F, -6.0F, 0.4363F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg1.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg1.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		mob_tail.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.mob_tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
