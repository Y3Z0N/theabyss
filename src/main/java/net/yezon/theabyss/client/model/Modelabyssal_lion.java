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
public class Modelabyssal_lion<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelabyssal_lion"), "main");
	public final ModelPart Head;
	public final ModelPart LeftLeg;
	public final ModelPart RightLeg;
	public final ModelPart Tail1;
	public final ModelPart LeftLeg2;
	public final ModelPart RightLeg2;
	public final ModelPart bb_main;

	public Modelabyssal_lion(ModelPart root) {
		this.Head = root.getChild("Head");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.Tail1 = root.getChild("Tail1");
		this.LeftLeg2 = root.getChild("LeftLeg2");
		this.RightLeg2 = root.getChild("RightLeg2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(17, 63).addBox(-4.0F, -1.75F, -19.25F, 8.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(38, 44).addBox(-4.0F, -4.75F, -10.25F, 8.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 0.75F, -12.75F));
		PartDefinition RightEar = Head.addOrReplaceChild("RightEar", CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -1.75F, -3.25F));
		PartDefinition LeftEar = Head.addOrReplaceChild("LeftEar", CubeListBuilder.create().texOffs(50, 4).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -1.75F, -3.25F));
		PartDefinition RightLowerJaw = Head.addOrReplaceChild("RightLowerJaw", CubeListBuilder.create().texOffs(83, 0).addBox(-2.0F, 0.0F, -9.25F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.25F, -10.0F));
		PartDefinition LeftLowerJaw = Head.addOrReplaceChild("LeftLowerJaw", CubeListBuilder.create().texOffs(81, 38).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.25F, -10.25F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(81, 14).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(46, 74).addBox(2.0F, 1.0F, 2.0F, 0.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 11.0F, -5.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(77, 66).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 67).addBox(-2.0F, 1.0F, 2.0F, 0.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, 11.0F, -5.0F));
		PartDefinition Tail1 = partdefinition.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 71).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 15.0F));
		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(68, 52).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));
		PartDefinition Tail3 = Tail2.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(31, 27).addBox(1.5F, -0.1667F, 0.0F, 8.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(66, 0)
				.addBox(-1.5F, -1.1667F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(33, 0).addBox(-9.5F, -0.1667F, 0.0F, 8.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3333F, 11.0F));
		PartDefinition LeftLeg2 = partdefinition.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(64, 27).addBox(-0.6667F, -2.8333F, -2.8333F, 4.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(82, 87)
				.addBox(-0.6667F, 8.1667F, -2.8333F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(64, 78).addBox(3.3333F, -2.8333F, 6.1667F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.6667F, 6.8333F, 12.8333F));
		PartDefinition RightLeg2 = partdefinition.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(85, 49).addBox(-3.3333F, 8.1667F, -2.8333F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(51, 63)
				.addBox(-3.3333F, -2.8333F, -2.8333F, 4.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 76).addBox(-3.3333F, -2.8333F, 6.1667F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.6667F, 6.8333F, 12.8333F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -25.0F, -13.0F, 12.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
				.addBox(-4.5F, -25.0F, 0.0F, 9.0F, 11.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 36).addBox(0.0F, -33.0F, 6.0F, 0.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		Tail1.render(poseStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		RightLeg2.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.RightLeg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.LeftLeg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.Tail1.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
