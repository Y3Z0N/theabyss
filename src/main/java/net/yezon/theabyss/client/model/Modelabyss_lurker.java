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
public class Modelabyss_lurker<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelabyss_lurker"), "main");
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;
	public final ModelPart mob_head;
	public final ModelPart mob_tail;
	public final ModelPart body;

	public Modelabyss_lurker(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
		this.mob_head = root.getChild("mob_head");
		this.mob_tail = root.getChild("mob_tail");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.5F, 3.925F, -1.25F, -0.0613F, -0.05F, 0.2846F));
		PartDefinition cube_r1 = right_arm.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(32, 47).addBox(-1.0F, -1.5F, -2.75F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 35)
						.addBox(0.0F, 3.5F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 45).addBox(-0.5F, 1.5F, -2.25F, 2.0F, 2.0F,
								2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 0.95F, 0.75F, -0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r2 = right_arm.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(3, 0).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, 6.2535F, -4.1324F, 0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r3 = right_arm.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.45F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.025F, 5.8754F, -5.4846F, -1.3963F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.5F, 3.925F, -1.25F, -0.0613F, 0.05F, -0.2846F));
		PartDefinition cube_r4 = left_arm.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(50, 24).addBox(-1.0F, -1.5F, -2.75F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(42, 0)
						.addBox(-1.0F, 3.5F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(52, 7).addBox(-1.5F, 1.5F, -2.25F, 2.0F,
								2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.95F, 0.75F, -0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r5 = left_arm.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(8, 10).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.025F, 6.2535F, -4.1324F, 0.8727F, 0.0F, 0.0F));
		PartDefinition cube_r6 = left_arm.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(50, 35).addBox(-0.55F, -0.5F, -1.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, 5.8754F, -5.4846F, -1.3963F, 0.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, 12.0F, 4.0F, 0.0F, 0.1745F, 0.0F));
		PartDefinition cube_r7 = right_leg.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(22, 23)
						.addBox(-1.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 10.6202F, -3.2607F, -1.1345F, 0.3054F, 0.0F));
		PartDefinition cube_r8 = right_leg.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 1).addBox(0.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(28, 0)
						.addBox(0.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 10.6202F, -3.2607F, -1.1345F, -0.3054F, 0.0F));
		PartDefinition cube_r9 = right_leg.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(38, 49).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.65F, 10.9772F, -0.0212F, -1.309F, 0.0F, -0.5236F));
		PartDefinition cube_r10 = right_leg.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(50, 30).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.6F, 10.9772F, -0.0212F, -1.309F, 0.0F, 0.5236F));
		PartDefinition cube_r11 = right_leg.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 35).addBox(-0.5F, 5.5F, 7.025F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(46, 42)
						.addBox(0.0F, 5.5F, 2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 45).addBox(-0.5F, -0.5F, -2.0F, 2.0F, 8.0F,
								4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -0.5F, 1.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r12 = right_leg.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.9889F, -4.0646F, -1.6483F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.3105F, 4.5781F, -6.7005F, -0.246F, -0.0664F, -0.0497F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, 12.0F, 4.0F, 0.0F, -0.1745F, 0.0F));
		PartDefinition cube_r13 = left_leg.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(0, 2).addBox(0.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 55)
						.addBox(0.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 10.6202F, -3.2607F, -1.1345F, -0.3054F, 0.0F));
		PartDefinition cube_r14 = left_leg.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(5, 2).addBox(-1.5F, 3.25F, -0.75F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(28, 55)
						.addBox(-1.5F, -2.75F, -0.75F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 10.6202F, -3.2607F, -1.1345F, 0.3054F, 0.0F));
		PartDefinition cube_r15 = left_leg.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(44, 50).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.65F, 10.9772F, -0.0212F, -1.309F, 0.0F, 0.5236F));
		PartDefinition cube_r16 = left_leg.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(50, 51).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, 10.9772F, -0.0212F, -1.309F, 0.0F, -0.5236F));
		PartDefinition cube_r17 = left_leg.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, 5.5F, 7.025F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 47)
						.addBox(-1.0F, 5.5F, 2.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(12, 47).addBox(-1.5F, -0.5F, -2.0F, 2.0F,
								8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -0.5F, 1.0F, -1.0472F, 0.0F, 0.0F));
		PartDefinition cube_r18 = left_leg.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 23).addBox(-0.9889F, -4.0646F, -1.6483F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.3105F, 4.5781F, -6.7005F, -0.246F, 0.0664F, 0.0497F));
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -4.0F, -4.0F, -0.1309F, 0.0F, 0.0F));
		PartDefinition cube_r19 = mob_head.addOrReplaceChild(
				"cube_r19", CubeListBuilder.create().texOffs(26, 29).mirror()
						.addBox(-0.6768F, -0.3495F, -4.2882F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-5.0F, -4.8745F, 4.8524F, 0.9163F, -0.4363F, -0.3491F));
		PartDefinition cube_r20 = mob_head.addOrReplaceChild(
				"cube_r20", CubeListBuilder.create().texOffs(23, 29).mirror()
						.addBox(-1.5F, 0.05F, -5.0F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.6268F, -5.8377F, 5.3417F, 0.9076F, -0.4363F, -0.3491F));
		PartDefinition cube_r21 = mob_head.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(26, 29).addBox(-2.3232F, -0.3495F, -4.2882F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -4.8745F, 4.8524F, 0.9163F, 0.4363F, 0.3491F));
		PartDefinition cube_r22 = mob_head.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(0, 23).addBox(-3.5F, -2.5952F, -4.0765F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.683F, 5.0131F, 0.6981F, 0.0F, 0.0F));
		PartDefinition cube_r23 = mob_head.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(0, 3).addBox(-2.0F, 1.4438F, -3.8232F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(26, 24)
						.addBox(-2.0F, 1.4438F, -3.8232F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(2.0F, 1.4438F, -3.8232F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 0)
						.addBox(-2.0F, 2.4438F, -3.8232F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.616F, -4.6292F, 1.4399F, 0.0F, 0.0F));
		PartDefinition cube_r24 = mob_head.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(33, 12).addBox(-2.0F, 0.5111F, -1.2393F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.4279F, -2.6206F, 1.7453F, 0.0F, 0.0F));
		PartDefinition cube_r25 = mob_head.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(52, 11).addBox(-2.8226F, -1.8219F, -2.627F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.75F, -1.5F, 0.5F, 0.5236F, -0.2618F, 0.0F));
		PartDefinition cube_r26 = mob_head.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(35, 54).addBox(1.8226F, -1.8219F, -2.627F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.75F, -1.5F, 0.5F, 0.5236F, 0.2618F, 0.0F));
		PartDefinition cube_r27 = mob_head.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(0, 35).addBox(-2.5F, -2.8266F, -3.6353F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(25, 23)
						.addBox(-2.0F, 1.1734F, -8.6353F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(1.975F, 1.1734F, -8.6353F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-1.975F, 1.1734F, -8.6353F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(42, 16)
						.addBox(-2.0F, -1.8266F, -8.6353F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, 0.5236F, 0.0F, 0.0F));
		PartDefinition mob_tail = partdefinition.addOrReplaceChild("mob_tail", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, 8.75F));
		PartDefinition cube_r28 = mob_tail.addOrReplaceChild(
				"cube_r28", CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(0.3521F, 0.0175F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.025F, -11.4395F, 13.8459F, 0.923F, 1.5778F, -0.644F));
		PartDefinition cube_r29 = mob_tail.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.3521F, -0.0075F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, -11.4395F, 13.8459F, 0.923F, -1.5778F, 0.6615F));
		PartDefinition cube_r30 = mob_tail.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(16, 0).addBox(-1.3521F, -0.0325F, -4.1467F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.4395F, 13.9041F, -1.7659F, -0.0707F, -0.1597F));
		PartDefinition cube_r31 = mob_tail.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(16, 0).addBox(-1.3521F, -0.0325F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.4395F, 13.8209F, 1.3698F, 0.003F, -0.1745F));
		PartDefinition cube_r32 = mob_tail.addOrReplaceChild(
				"cube_r32", CubeListBuilder.create().texOffs(2, 0).mirror()
						.addBox(-1.3521F, -0.0075F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-0.025F, -11.4395F, 13.8459F, 0.0146F, 1.1728F, -1.5683F));
		PartDefinition cube_r33 = mob_tail.addOrReplaceChild("cube_r33",
				CubeListBuilder.create().texOffs(2, 0).addBox(0.3521F, -0.0325F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.025F, -11.4395F, 13.8459F, 0.0146F, -1.1728F, 1.5683F));
		PartDefinition cube_r34 = mob_tail.addOrReplaceChild("cube_r34",
				CubeListBuilder.create().texOffs(18, 0).addBox(0.3521F, -0.0325F, -4.1467F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.4395F, 13.9041F, -1.7659F, 0.0707F, 0.1597F));
		PartDefinition cube_r35 = mob_tail.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(18, 0).addBox(0.3521F, -0.0325F, -3.8533F, 1.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.4395F, 13.8209F, 1.3698F, -0.003F, 0.1745F));
		PartDefinition cube_r36 = mob_tail.addOrReplaceChild("cube_r36",
				CubeListBuilder.create().texOffs(42, 7).addBox(-0.5F, -2.5F, -3.25F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.6199F, 14.7704F, 1.3526F, 0.0F, 0.0F));
		PartDefinition cube_r37 = mob_tail.addOrReplaceChild("cube_r37",
				CubeListBuilder.create().texOffs(36, 37).addBox(0.0F, -1.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(14, 37)
						.addBox(-1.5F, -3.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.6196F, 10.2361F, 0.6545F, 0.0F, 0.0F));
		PartDefinition cube_r38 = mob_tail.addOrReplaceChild("cube_r38",
				CubeListBuilder.create().texOffs(28, 34).addBox(0.0F, -0.25F, -3.75F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(34, 31)
						.addBox(-2.0F, -3.25F, -3.75F, 4.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.4558F, 2.8196F, 0.0436F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39",
				CubeListBuilder.create().texOffs(24, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -11.1781F, 5.2574F, -0.5236F, 0.0F, 0.0F));
		PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.5F, -6.0F, 0.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -2.5F, -6.0F, 6.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -18.5F, 0.0F, -1.0036F, 0.0F, 0.0F));
		PartDefinition cube_r41 = body.addOrReplaceChild("cube_r41",
				CubeListBuilder.create().texOffs(26, 17).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -28.0273F, -6.1603F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		right_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_arm.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
		mob_head.render(poseStack, buffer, packedLight, packedOverlay);
		mob_tail.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.mob_tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
