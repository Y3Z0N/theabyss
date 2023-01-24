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
public class Modelscorpion<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelscorpion"), "main");
	public final ModelPart right_leg4;
	public final ModelPart right_leg3;
	public final ModelPart right_leg2;
	public final ModelPart right_leg;
	public final ModelPart left_leg4;
	public final ModelPart left_leg3;
	public final ModelPart left_leg2;
	public final ModelPart left_leg;
	public final ModelPart body;

	public Modelscorpion(ModelPart root) {
		this.right_leg4 = root.getChild("right_leg4");
		this.right_leg3 = root.getChild("right_leg3");
		this.right_leg2 = root.getChild("right_leg2");
		this.right_leg = root.getChild("right_leg");
		this.left_leg4 = root.getChild("left_leg4");
		this.left_leg3 = root.getChild("left_leg3");
		this.left_leg2 = root.getChild("left_leg2");
		this.left_leg = root.getChild("left_leg");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_leg4 = partdefinition.addOrReplaceChild("right_leg4", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 2.0F));
		PartDefinition cube_r1 = right_leg4.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(4, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(33, 34).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3834F, -0.5F, 2.974F, 0.1703F, 0.5218F, 0.3882F));
		PartDefinition right_leg3 = partdefinition.addOrReplaceChild("right_leg3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r2 = right_leg3.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 17).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3834F, -5.5F, 2.974F, 0.1027F, 0.2286F, 0.3676F));
		PartDefinition right_leg2 = partdefinition.addOrReplaceChild("right_leg2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r3 = right_leg2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(25, 0).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 36).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3834F, -5.5F, 0.974F, 0.0131F, -0.2114F, 0.2061F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition cube_r4 = right_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 17).addBox(-4.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3834F, -0.5F, -1.026F, -0.1916F, -0.5034F, 0.411F));
		PartDefinition cube_r5 = right_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(25, 11).addBox(-4.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.3834F, -0.5F, -1.026F, -0.0607F, -0.5296F, 0.158F));
		PartDefinition left_leg4 = partdefinition.addOrReplaceChild("left_leg4", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 2.0F));
		PartDefinition cube_r6 = left_leg4.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3834F, -0.5F, 2.974F, 0.1703F, -0.5218F, -0.3882F));
		PartDefinition left_leg3 = partdefinition.addOrReplaceChild("left_leg3", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition cube_r7 = left_leg3.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 17).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 14).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3834F, -0.5F, 2.974F, 0.1027F, -0.2286F, -0.3676F));
		PartDefinition left_leg2 = partdefinition.addOrReplaceChild("left_leg2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r8 = left_leg2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(29, 0).addBox(3.5F, 0.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 12).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3834F, -5.5F, 0.974F, 0.0131F, 0.2114F, -0.2061F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r9 = left_leg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(28, 40).addBox(3.5F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3834F, -5.5F, -1.026F, -0.1916F, 0.5034F, -0.411F));
		PartDefinition cube_r10 = left_leg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(36, 38).addBox(-1.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3834F, -5.5F, -1.026F, -0.0607F, 0.5296F, -0.158F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(19, 20).addBox(1.0F, -2.0682F, -1.1901F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -11.6112F, 14.7854F, 2.0071F, 0.0F, 0.0F));
		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(2, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -20.7781F, -0.8419F, 2.1817F, 0.0F, 0.0F));
		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 31).addBox(1.0F, -4.5432F, 8.8325F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -19.8576F, 10.2634F, 2.6616F, 0.0F, 0.0F));
		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(19, 19).addBox(0.5F, -1.5432F, 8.3325F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -19.8576F, 10.2634F, 2.6616F, 0.0F, 0.0F));
		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(25, 0).addBox(1.0F, -0.5432F, -0.6675F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -19.8576F, 10.2634F, 2.7053F, 0.0F, 0.0F));
		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 17).addBox(-2.0F, -1.875F, -1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, 8.0F, 0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(23, 24).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, -5.8123F, -6.964F, 0.48F, 0.3491F, 0.1745F));
		PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.25F, -5.8123F, -6.964F, 0.48F, -0.3491F, -0.1745F));
		PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(7, 24).addBox(0.0F, -1.175F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -3.8921F, -8.5834F, 0.3665F, 0.1309F, -0.3491F));
		PartDefinition cube_r20 = body.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(19, 24).addBox(-1.0F, -1.175F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -3.8921F, -8.5834F, 0.3665F, -0.1309F, 0.3491F));
		PartDefinition cube_r21 = body.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 31).addBox(-3.5F, -1.5F, -2.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -4.8488F, -6.2737F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r22 = body.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(36, 0).addBox(-5.0008F, -0.95F, -1.036F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.6386F, -4.275F, -7.0164F, -3.1416F, -1.2654F, -3.1416F));
		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(36, 4).addBox(0.0008F, -0.95F, -1.036F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.6386F, -4.275F, -7.0164F, -3.1416F, 1.2654F, 3.1416F));
		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(18, 34).addBox(-5.9953F, -1.95F, -1.5349F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 11).addBox(-5.9953F, 1.05F, -0.0349F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.2069F, -4.275F, -11.5051F, -2.1484F, -0.9754F, 2.0427F));
		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(34, 21).addBox(-0.0047F, -1.95F, -1.5349F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(1.9953F, 1.05F, -0.0349F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.2069F, -4.275F, -11.5051F, -2.1484F, 0.9754F, -2.0427F));
		PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(0, 9).addBox(-6.0703F, -0.95F, -0.0349F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 40).addBox(-6.0703F, 0.05F, -0.5349F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.2069F, -4.275F, -11.5051F, 2.4638F, -1.1725F, -2.4118F));
		PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(0, 10).addBox(1.0703F, -0.95F, -0.0349F, 5.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(14, 40).addBox(0.0703F, 0.05F, -0.5349F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.2069F, -4.275F, -11.5051F, 2.4638F, 1.1725F, 2.4118F));
		PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(34, 17).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -4.25F, -4.5F, 0.0F, -0.48F, 0.0F));
		PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(34, 27).addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -4.25F, -4.5F, 0.0F, 0.48F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_leg4.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg3.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg4.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg3.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg2.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_leg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_leg4.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_leg4.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
