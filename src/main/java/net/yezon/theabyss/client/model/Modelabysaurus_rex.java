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
public class Modelabysaurus_rex<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelabysaurus_rex"), "main");
	public final ModelPart entity_tail;
	public final ModelPart entity_leg_left;
	public final ModelPart entity_head;
	public final ModelPart entitiy_arm_left;
	public final ModelPart entitiy_arm_right;
	public final ModelPart body;
	public final ModelPart entity_leg_right;

	public Modelabysaurus_rex(ModelPart root) {
		this.entity_tail = root.getChild("entity_tail");
		this.entity_leg_left = root.getChild("entity_leg_left");
		this.entity_head = root.getChild("entity_head");
		this.entitiy_arm_left = root.getChild("entitiy_arm_left");
		this.entitiy_arm_right = root.getChild("entitiy_arm_right");
		this.body = root.getChild("body");
		this.entity_leg_right = root.getChild("entity_leg_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition entity_tail = partdefinition.addOrReplaceChild("entity_tail", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.4F, -2.2F, 12.75F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r1 = entity_tail.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(68, 27).addBox(-4.5F, -4.7882F, 0.2801F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, 2.8333F, 14.1937F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r2 = entity_tail.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(88, 89).addBox(-5.5F, -33.5F, 19.0F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(52, 76)
						.addBox(-6.5F, -35.0F, 10.5F, 13.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, 27.7F, -13.8F, -0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r3 = entity_tail.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(32, 99).addBox(-3.0F, -6.3006F, 0.3274F, 5.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1F, 4.8507F, 33.3459F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r4 = entity_tail.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(88, 64).addBox(-3.5F, -5.8348F, -2.0431F, 7.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, 4.3719F, 25.4912F, 0.1745F, 0.0F, 0.0F));
		PartDefinition entity_leg_left = partdefinition.addOrReplaceChild("entity_leg_left",
				CubeListBuilder.create().texOffs(55, 99).addBox(-1.75F, 21.7857F, -7.0714F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.5F, -0.7857F, 6.0714F));
		PartDefinition cube_r5 = entity_leg_left.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 71).addBox(-0.9519F, -1.9F, -3.1624F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.05F, 24.6857F, -6.3214F, 0.0436F, 0.2618F, 0.0F));
		PartDefinition cube_r6 = entity_leg_left.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(78, 48).addBox(-1.0F, -2.0F, -4.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.75F, 24.5357F, -6.0714F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r7 = entity_leg_left.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(78, 54).addBox(-0.9876F, -2.0F, -3.9079F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, 24.7857F, -6.0714F, 0.0436F, -0.3054F, 0.0F));
		PartDefinition cube_r8 = entity_leg_left.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(98, 10).addBox(10.0F, -29.5F, -8.5F, 5.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-11.5F, 24.7857F, -6.0714F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r9 = entity_leg_left.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(32, 116).addBox(10.0F, -15.0F, -1.25F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.75F, 24.7857F, -6.0714F, -0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r10 = entity_leg_left.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(104, 110).addBox(9.5F, -9.0F, 13.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-10.75F, 24.7857F, -6.0714F, 0.7854F, 0.0F, 0.0F));
		PartDefinition entity_head = partdefinition.addOrReplaceChild("entity_head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -8.3333F, -28.5F));
		PartDefinition cube_r11 = entity_head.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 18).addBox(-4.5F, -2.8942F, -12.8346F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
						.texOffs(41, 31).addBox(4.5F, -2.8942F, -12.8346F, 0.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(41, 30)
						.addBox(-4.5F, -2.8942F, -12.8346F, 0.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(78, 48)
						.addBox(-4.5F, -1.8942F, -12.8346F, 9.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.5833F, -10.5F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r12 = entity_head.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(41, 28).addBox(5.0F, 4.0F, -6.5F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(41, 26)
						.addBox(-5.0F, 4.0F, -6.5F, 0.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-5.0F, 4.0F, -6.5F, 10.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(58, 0).addBox(-5.0F, -4.0F, -6.5F, 10.0F,
								8.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.5192F, -18.1464F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r13 = entity_head.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(0, 39).addBox(-7.0F, -43.5F, -37.5F, 14.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 34.5833F, 28.5F, 0.0873F, 0.0F, 0.0F));
		PartDefinition entitiy_arm_left = partdefinition.addOrReplaceChild("entitiy_arm_left", CubeListBuilder.create(),
				PartPose.offset(7.5F, -0.3333F, -18.5417F));
		PartDefinition cube_r14 = entitiy_arm_left.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(8, 19).addBox(1.4F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.975F, 10.5237F, -2.8439F, 1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r15 = entitiy_arm_left.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(12, 19).addBox(-0.625F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.775F, 10.6714F, -2.7875F, 1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r16 = entitiy_arm_left.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(18, 0).addBox(6.125F, -14.15F, -22.975F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(17, 18)
						.addBox(7.9F, -14.3F, -23.025F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.5F, 21.8333F, 20.0417F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r17 = entitiy_arm_left.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(14, 115).addBox(5.5F, -32.0F, -4.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.5F, 21.8333F, 20.0417F, 0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r18 = entitiy_arm_left.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(58, 0).addBox(6.0F, -5.0F, -27.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.5F, 21.8333F, 20.0417F, -0.6109F, 0.0F, 0.0F));
		PartDefinition entitiy_arm_right = partdefinition.addOrReplaceChild("entitiy_arm_right", CubeListBuilder.create(),
				PartPose.offset(-7.5F, -0.8333F, -19.0417F));
		PartDefinition cube_r19 = entitiy_arm_right.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(14, 0).addBox(-8.9F, -14.3F, -23.025F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.125F, -14.15F, -22.975F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.5F, 22.3333F, 20.5417F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r20 = entitiy_arm_right.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(4, 19).addBox(-2.4F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.975F, 11.0237F, -2.3439F, 1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r21 = entitiy_arm_right.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(0, 19).addBox(-0.375F, 0.0358F, -1.1922F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.775F, 11.1714F, -2.2875F, 1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r22 = entitiy_arm_right.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(91, 0).addBox(-9.5F, -32.0F, -4.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.5F, 21.8333F, 20.0417F, 0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r23 = entitiy_arm_right.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(0, 39).addBox(-9.0F, -5.0F, -27.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.5F, 21.8333F, 20.0417F, -0.6109F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.6167F, 12.5F, -0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(40, 51).addBox(-6.0F, -25.8071F, -41.713F, 12.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 25.0516F, -12.1556F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(0, 65).addBox(-7.0F, -35.0F, -24.5F, 14.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(110, 35)
						.addBox(-8.0F, -35.275F, -13.5F, 16.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(68, 110)
						.addBox(-8.0F, -35.0F, 10.5F, 16.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -37.0F, -11.5F, 18.0F, 17.0F, 22.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 25.0516F, -12.1556F, -0.0436F, 0.0F, 0.0F));
		PartDefinition entity_leg_right = partdefinition.addOrReplaceChild("entity_leg_right",
				CubeListBuilder.create().texOffs(21, 90).addBox(-3.25F, 21.7857F, -7.0714F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.5F, -0.7857F, 6.0714F));
		PartDefinition cube_r26 = entity_leg_right.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(41, 45).addBox(-1.0481F, -1.9F, -3.1624F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.05F, 24.6857F, -6.3214F, 0.0436F, -0.2618F, 0.0F));
		PartDefinition cube_r27 = entity_leg_right.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(53, 45).addBox(-1.0F, -2.0F, -4.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.75F, 24.5357F, -6.0714F, 0.0873F, 0.0F, 0.0F));
		PartDefinition cube_r28 = entity_leg_right.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(0, 65).addBox(-1.0124F, -2.0F, -3.9079F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.25F, 24.7857F, -6.0714F, 0.0436F, 0.3054F, 0.0F));
		PartDefinition cube_r29 = entity_leg_right.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(0, 90).addBox(-15.0F, -29.5F, -8.5F, 5.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(11.5F, 24.7857F, -6.0714F, -0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r30 = entity_leg_right.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(0, 115).addBox(-13.0F, -15.0F, -1.25F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.75F, 24.7857F, -6.0714F, -0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r31 = entity_leg_right.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(0, 0).addBox(-13.5F, -9.0F, 13.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.75F, 24.7857F, -6.0714F, 0.7854F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		entity_tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		entity_leg_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		entity_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		entitiy_arm_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		entitiy_arm_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		entity_leg_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.entity_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.entity_head.xRot = headPitch / (180F / (float) Math.PI);
		this.entity_tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.entitiy_arm_right.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.entity_leg_right.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.entitiy_arm_left.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.entity_leg_left.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
