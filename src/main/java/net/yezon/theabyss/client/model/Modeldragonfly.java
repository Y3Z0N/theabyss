package net.yezon.theabyss.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modeldragonfly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modeldragonfly"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart wings;
	public final ModelPart right_wing;
	public final ModelPart left_wing;

	public Modeldragonfly(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.wings = root.getChild("wings");
		this.right_wing = root.getChild("right_wing");
		this.left_wing = root.getChild("left_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.6348F, -2.0793F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.001F)).texOffs(6, 10)
				.addBox(0.5F, -1.8087F, -2.4619F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 5).addBox(-1.5F, -1.8087F, -2.4619F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 23.0F, -4.5F, -0.3927F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-1.0F, -3.5F, -2.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition tail = body.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-1.5F, -1.5F, 3.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.0436F, 0.0F, 0.0F));
		PartDefinition wings = partdefinition.addOrReplaceChild("wings", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(-1.25F, 20.75F, 1.5F));
		PartDefinition wing_r_2 = right_wing.addOrReplaceChild("wing_r_2", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, -0.25F));
		PartDefinition cube_r1 = wing_r_2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 10).addBox(-19.0F, -3.0F, -1.0F, 18.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 3.0F, -1.0F, 0.0F, 0.2182F, 0.0F));
		PartDefinition wing_r_1 = right_wing.addOrReplaceChild("wing_r_1", CubeListBuilder.create().texOffs(18, 10).addBox(-18.0F, 0.0F, -2.0F, 18.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.25F, -2.25F, 0.0F, -0.2182F, 0.0F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(2.25F, 21.0F, -0.75F));
		PartDefinition wing_l_2 = left_wing.addOrReplaceChild("wing_l_2", CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, 0.0F, -2.25F, 18.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, -0.25F, 2.25F, 0.0F, -0.2182F, 0.0F));
		PartDefinition wing_l_1 = left_wing.addOrReplaceChild("wing_l_1", CubeListBuilder.create().texOffs(18, 14).addBox(0.0F, 0.0F, -2.0F, 18.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		wings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_wing.zRot = ageInTicks;
		this.left_wing.zRot = ageInTicks;
	}
}
