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
public class Modelmagician<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelmagician"), "main");
	public final ModelPart cube;
	public final ModelPart cube2;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart body;
	public final ModelPart head;

	public Modelmagician(ModelPart root) {
		this.cube = root.getChild("cube");
		this.cube2 = root.getChild("cube2");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition cube = partdefinition.addOrReplaceChild("cube", CubeListBuilder.create(), PartPose.offset(-9.375F, -12.625F, -32.375F));
		PartDefinition cube_r1 = cube.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(75, 27).addBox(-3.125F, -4.375F, -1.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition bone = cube.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube2 = partdefinition.addOrReplaceChild("cube2", CubeListBuilder.create(), PartPose.offset(-9.375F, -12.625F, -32.375F));
		PartDefinition cube_r2 = cube2.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(75, 27).addBox(-3.125F, -4.375F, -1.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition bone2 = cube2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(48, 41).addBox(-2.85F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.15F, 6.0F, 0.0F));
		PartDefinition cube_r3 = right_leg.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(64, 59).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.85F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
		PartDefinition body_r1 = right_leg.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(76, 64).addBox(-6.0F, 0.0F, 0.0F, 6.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.15F, 0.0F, 3.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 65).addBox(-3.15F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.15F, 6.0F, 0.0F));
		PartDefinition cube_r4 = left_leg.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(68, 10).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.85F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
		PartDefinition body_r2 = left_leg.addOrReplaceChild("body_r2",
				CubeListBuilder.create().texOffs(76, 80).addBox(0.0F, 0.0F, 0.0F, 6.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.15F, 0.0F, 3.0F, 0.0436F, 0.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.5F, -9.0F, 0.0F));
		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1",
				CubeListBuilder.create().texOffs(0, 24).addBox(-14.5F, -30.5F, -17.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 65)
						.addBox(-14.0F, -31.5F, -16.5F, 5.0F, 18.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, 33.0F, 0.0F, -0.4363F, 0.0F, 0.0873F));
		PartDefinition staff = right_arm.addOrReplaceChild("staff", CubeListBuilder.create(), PartPose.offset(-3.875F, 12.375F, -6.375F));
		PartDefinition cube_r5 = staff.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(83, 0).addBox(-1.25F, 1.275F, 5.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.375F, -18.4168F, -24.7491F, -1.2654F, 0.0F, 0.0F));
		PartDefinition cube_r6 = staff.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(84, 37).addBox(-1.25F, 0.2923F, -0.7747F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.375F, -17.863F, -19.0028F, -0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r7 = staff.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(80, 16).addBox(-2.5F, -1.475F, -0.275F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.375F, -7.996F, -23.9293F, -0.4363F, 0.0F, 0.0F));
		PartDefinition cube_r8 = staff.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(72, 55).addBox(-12.5F, -35.625F, -23.25F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.375F, 22.625F, 10.375F, 0.2182F, 0.0F, 0.0F));
		PartDefinition cube_r9 = staff.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(58, 82).addBox(-1.5F, 3.5F, 1.75F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.375F, -16.1347F, -12.5119F, -1.3963F, 0.0F, 0.0F));
		PartDefinition cube_r10 = staff.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(84, 45).addBox(-11.75F, -19.25F, -2.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 88)
						.addBox(-11.75F, -19.25F, -29.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(35, 88)
						.addBox(-11.75F, -19.25F, -33.25F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-11.25F, -18.75F, -35.25F, 3.0F, 3.0F, 38.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.375F, 22.625F, 10.375F, -0.3927F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.5F, -9.0F, 0.0F));
		PartDefinition left_arm_r1 = left_arm.addOrReplaceChild("left_arm_r1",
				CubeListBuilder.create().texOffs(44, 27).addBox(8.5F, -28.25F, -3.5F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(44, 16)
						.addBox(8.5F, -34.25F, -3.5F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(44, 65).addBox(9.0F, -35.25F, -3.0F, 5.0F,
								18.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.5F, 33.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, -3.0F, 12.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(24, 18).addBox(0.0F, 0.0F, -3.0F, 0.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.0F, 18.0F, 0.0F, 0.0F, 0.0F, 0.0567F));
		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(72, 35).addBox(0.0F, 0.0F, -3.0F, 0.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 18.0F, 0.0F, 0.0F, 0.0F, -0.0654F));
		PartDefinition head = partdefinition.addOrReplaceChild(
				"head", CubeListBuilder.create().texOffs(0, 41).addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
						.texOffs(44, 0).addBox(-6.5F, -11.0F, -6.5F, 13.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		cube.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		cube2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.cube2.zRot = ageInTicks / 20.f;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.cube.yRot = ageInTicks / 20.f;
	}
}
