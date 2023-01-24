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
public class Modelwhale<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelwhale"), "main");
	public final ModelPart head;
	public final ModelPart torso;
	public final ModelPart tail;
	public final ModelPart bb_main;

	public Modelwhale(ModelPart root) {
		this.head = root.getChild("head");
		this.torso = root.getChild("torso");
		this.tail = root.getChild("tail");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition top_jaw = head.addOrReplaceChild("top_jaw",
				CubeListBuilder.create().texOffs(242, 54).addBox(-14.0F, -24.0F, -61.0F, 25.0F, 5.0F, 46.0F, new CubeDeformation(0.0F)).texOffs(162, 192).addBox(-14.0F, -19.0F, -61.0F, 25.0F, 11.0F, 46.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bottom_jaw = top_jaw.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(0, 223).addBox(-14.0F, -19.0F, -61.0F, 25.0F, 11.0F, 46.0F, new CubeDeformation(0.0F)).texOffs(233, 0)
				.addBox(-14.0F, -8.0F, -61.0F, 25.0F, 8.0F, 46.0F, new CubeDeformation(0.0F)).texOffs(96, 176).addBox(-1.5F, 0.0F, -55.0F, 0.0F, 12.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-29.0F, -11.0F, -15.0F, 55.0F, 0.0F, 73.0F, new CubeDeformation(0.0F)).texOffs(0, 123)
				.addBox(-17.0F, -24.0F, -15.0F, 31.0F, 27.0F, 73.0F, new CubeDeformation(0.0F)).texOffs(0, 24).addBox(-1.5F, -49.0F, -15.0F, 0.0F, 25.0F, 74.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(128, 18).addBox(-14.0F, -23.0F, 57.0F, 25.0F, 21.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tail_2 = tail.addOrReplaceChild("tail_2",
				CubeListBuilder.create().texOffs(164, 118).addBox(-10.0F, -23.0F, 112.0F, 17.0F, 17.0F, 57.0F, new CubeDeformation(0.0F)).texOffs(83, 123).addBox(-23.0F, -15.0F, 150.0F, 43.0F, 0.0F, 52.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_back_fin_r1 = bb_main.addOrReplaceChild("left_back_fin_r1",
				CubeListBuilder.create().texOffs(142, 234).addBox(-12.0F, 25.0F, 27.0F, 0.0F, 42.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-17.0F, 0.0F, -10.0F, 0.0F, 68.0F, 30.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, 0.0F, 0.7854F));
		PartDefinition right_back_fin_r1 = bb_main.addOrReplaceChild("right_back_fin_r1",
				CubeListBuilder.create().texOffs(0, 208).addBox(10.0F, 23.0F, 27.0F, 0.0F, 44.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 93).addBox(14.0F, -1.0F, -10.0F, 0.0F, 69.0F, 30.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		torso.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
