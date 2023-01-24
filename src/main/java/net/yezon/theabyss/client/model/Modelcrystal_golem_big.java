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
public class Modelcrystal_golem_big<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelcrystal_golem_big"), "main");
	public final ModelPart mob_head;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart body;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modelcrystal_golem_big(ModelPart root) {
		this.mob_head = root.getChild("mob_head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.body = root.getChild("body");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition mob_head = partdefinition.addOrReplaceChild("mob_head", CubeListBuilder.create().texOffs(145, 58).addBox(-5.0F, -6.5F, -4.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, -1.0F));
		PartDefinition cube_r14 = mob_head.addOrReplaceChild("cube_r14", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -4.25F, -4.0F, 0.0F, 0.0F, -0.2182F));
		PartDefinition cube_r14_r1 = cube_r14.addOrReplaceChild("cube_r14_r1", CubeListBuilder.create().texOffs(152, 64).addBox(-2.9145F, -0.7351F, -3.225F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9721F, -2.1038F, 2.45F));
		PartDefinition cube_r15 = mob_head.addOrReplaceChild("cube_r15", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -4.25F, -4.0F, 0.0F, 0.0F, 0.1745F));
		PartDefinition cube_r15_r1 = cube_r15.addOrReplaceChild("cube_r15_r1", CubeListBuilder.create().texOffs(149, 63).addBox(-2.8318F, -0.3721F, -2.5F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.5037F, -2.5684F, 2.0F, 0.0F, 0.0F, 0.0873F));
		PartDefinition cube_r16 = mob_head.addOrReplaceChild("cube_r16", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -2.75F, -3.75F, 0.0F, 0.0F, 0.0873F));
		PartDefinition cube_r16_r1 = cube_r16.addOrReplaceChild("cube_r16_r1", CubeListBuilder.create().texOffs(117, 59).addBox(-1.3647F, -0.5708F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.9648F, -0.9361F, 0.0F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r17 = mob_head.addOrReplaceChild("cube_r17", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -2.75F, -3.75F, 0.0F, 0.0F, -0.1309F));
		PartDefinition cube_r17_r1 = cube_r17.addOrReplaceChild("cube_r17_r1", CubeListBuilder.create().texOffs(131, 58).addBox(-1.6654F, -0.4755F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9032F, -0.9674F, 0.0F, 0.0F, 0.0F, -0.1745F));
		PartDefinition cube_r18 = mob_head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 205).addBox(0.5F, -1.875F, -0.825F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 1.0F, -3.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r19 = mob_head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(245, 247).addBox(-2.5F, -1.875F, -1.375F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, -3.0F, 0.48F, 0.0F, 0.0F));
		PartDefinition cube_r20 = mob_head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(60, 205).addBox(-3.5F, -2.075F, -0.85F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 1.0F, -3.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition crystal2 = mob_head.addOrReplaceChild("crystal2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.2F, -7.025F, -3.45F, 0.3357F, -0.3067F, 0.1992F));
		PartDefinition crystal_r1 = crystal2.addOrReplaceChild("crystal_r1", CubeListBuilder.create().texOffs(125, 159).addBox(-0.9547F, -3.606F, -0.1527F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, -0.675F, -0.0253F, -0.0284F, -0.0782F));
		PartDefinition cube_r2 = crystal2.addOrReplaceChild("cube_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3433F, 0.448F, 0.3523F));
		PartDefinition cube_r2_r1 = cube_r2.addOrReplaceChild("cube_r2_r1", CubeListBuilder.create().texOffs(0, 82).addBox(-0.773F, -2.5461F, 0.2375F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, -0.675F, 0.0026F, 0.0133F, -0.0862F));
		PartDefinition cube_r3 = crystal2.addOrReplaceChild("cube_r3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.225F, 0.0F, -0.3F, 0.5552F, 0.5576F, 0.1974F));
		PartDefinition cube_r22_r1 = cube_r3.addOrReplaceChild("cube_r22_r1", CubeListBuilder.create().texOffs(123, 159).addBox(-1.041F, -2.9135F, -0.3044F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.725F, 0.0F, -0.375F, 0.0169F, -0.0618F, -0.0598F));
		PartDefinition cube_r4 = crystal2.addOrReplaceChild("cube_r4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -0.175F, -0.4159F, -0.0194F, -0.4151F));
		PartDefinition cube_r23_r1 = cube_r4.addOrReplaceChild("cube_r23_r1", CubeListBuilder.create().texOffs(123, 162).addBox(-1.1204F, -2.8927F, 0.0155F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, -0.0145F, -0.0017F, -0.086F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(88, 37).addBox(-6.0F, -2.0F, -3.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(139, 119)
				.addBox(-5.25F, 4.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(148, 119).addBox(-5.75F, 11.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, -11.5F, 3.5F));
		PartDefinition cube_r1 = right_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 58).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 16.0F, -1.25F, -0.1309F, 0.0F, -0.3927F));
		PartDefinition cube_r8 = right_arm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(11, 57).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 16.0F, -0.25F, 0.3054F, 0.0F, 0.3054F));
		PartDefinition cube_r9 = right_arm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(11, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 16.0F, -1.25F, -0.1745F, 0.0F, 0.4363F));
		PartDefinition cube_r10 = right_arm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(10, 61).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 16.0F, -1.5F, 0.3054F, 0.0F, 0.0F));
		PartDefinition cube_r11 = right_arm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(10, 61).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 16.0F, -1.5F, -0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r12 = right_arm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(120, 157).addBox(-1.15F, -5.175F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.475F, -0.6F, 1.775F, 0.2163F, -0.2485F, -1.1831F));
		PartDefinition cube_r13 = right_arm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(10, 58).addBox(-1.0F, -6.125F, -0.8F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.475F, -0.6F, 1.775F, -1.0768F, 0.0181F, -0.2485F));
		PartDefinition cube_r21 = right_arm.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(12, 60).addBox(-1.0F, -5.675F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.475F, -0.6F, 1.775F, 0.2017F, 0.147F, -0.0708F));
		PartDefinition cube_r22 = right_arm.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(10, 60).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.475F, -0.6F, 1.775F, -0.3927F, 0.0F, -0.5236F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(106, 109).addBox(2.8469F, 10.2486F, -5.25F, 11.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -12.5F, 3.0F));
		PartDefinition cube_r23 = left_arm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(6, 54).addBox(-1.5F, -12.45F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.525F, -4.95F, 4.525F, -0.8828F, 0.0396F, -0.4276F));
		PartDefinition cube_r24 = left_arm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(6, 55).addBox(-1.5F, -11.45F, -3.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.525F, -4.95F, 3.525F, -0.4206F, -0.3308F, -0.2498F));
		PartDefinition cube_r25 = left_arm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(6, 55).addBox(-1.5F, -10.45F, -3.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.375F, -4.95F, 1.75F, 0.1708F, -0.2146F, -0.3964F));
		PartDefinition cube_r26 = left_arm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(7, 56).addBox(-1.5F, -11.45F, -3.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.675F, -4.25F, 4.55F, 0.251F, 0.803F, 1.4048F));
		PartDefinition cube_r27 = left_arm.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(6, 54).addBox(-1.5F, -12.45F, -3.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.675F, -4.25F, 4.55F, -0.9873F, 0.2268F, 0.7904F));
		PartDefinition cube_r28 = left_arm.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(6, 54).addBox(-1.5F, -11.45F, -3.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.675F, -6.275F, 1.75F, 0.3521F, -0.1776F, 0.4483F));
		PartDefinition cube_r29 = left_arm.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(1, 46).addBox(-6.0F, -17.0F, 0.0F, 6.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.0F, -3.4F, 1.0F, -0.3963F, -0.3753F, 0.544F));
		PartDefinition cube_r30 = left_arm.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(134, 116).addBox(-4.5F, 5.25F, -5.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(123, 109).addBox(-6.0F, -7.75F, -6.5F, 12.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 1.0F, 0.25F, 0.0F, 0.0F, -0.3491F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r31 = body.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(12, 60).addBox(-1.0F, -0.6F, -1.025F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -24.875F, 4.65F, 0.5236F, 0.2182F, -1.7453F));
		PartDefinition cube_r32 = body.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(10, 61).addBox(-1.0F, 0.05F, -1.025F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -24.875F, 4.65F, -0.5672F, 0.0F, -1.2654F));
		PartDefinition cube_r33 = body.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(13, 61).addBox(-1.0F, 0.05F, -1.025F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -24.875F, 4.65F, 0.0F, 0.0F, -2.3126F));
		PartDefinition cube_r34 = body.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(147, 116).addBox(-6.5F, 8.75F, -0.75F, 13.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -34.575F, 2.375F, 0.0436F, 0.0F, 0.0F));
		PartDefinition cube_r35 = body.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(132, 117).addBox(-6.0F, 3.0F, -2.25F, 12.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -36.0F, 2.875F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(115, 113).addBox(-11.0F, -3.5F, -3.0F, 22.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -34.95F, 1.0F, 0.4363F, 0.0F, -0.0436F));
		PartDefinition huge_ass_crystal2 = body.addOrReplaceChild("huge_ass_crystal2", CubeListBuilder.create().texOffs(9, 57).addBox(-1.5F, -9.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -38.0F, 5.5F, -0.9163F, 0.3054F, 0.0F));
		PartDefinition cube_r37 = huge_ass_crystal2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(83, 39).addBox(-0.5F, -7.75F, -1.25F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6751F, -0.8646F, 1.2334F));
		PartDefinition cube_r38 = huge_ass_crystal2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(10, 59).addBox(-1.75F, -7.75F, -0.775F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6257F, -0.4682F, -0.6944F));
		PartDefinition cube_r39 = huge_ass_crystal2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(12, 59).addBox(-1.0F, -8.25F, -2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.527F, -0.8769F, -0.1077F));
		PartDefinition cube_r40 = huge_ass_crystal2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(11, 59).addBox(-1.75F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6545F, 0.7854F, -0.9599F));
		PartDefinition huge_ass_crystal3 = body.addOrReplaceChild("huge_ass_crystal3", CubeListBuilder.create().texOffs(8, 56).addBox(-1.5F, -11.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.75F, -36.25F, 5.5F, -0.9163F, -0.48F, 0.0F));
		PartDefinition cube_r41 = huge_ass_crystal3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(11, 59).addBox(-0.5F, -7.75F, -1.25F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3021F, -0.785F, 1.306F));
		PartDefinition cube_r42 = huge_ass_crystal3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(12, 59).addBox(-1.75F, -7.75F, -0.775F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2585F, -0.2868F, -0.4554F));
		PartDefinition cube_r43 = huge_ass_crystal3.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(13, 59).addBox(-1.75F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7478F, 0.8323F, -0.9236F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-5.75F, 6.6F, 6.0F));
		PartDefinition cube_r44 = right_leg.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(38, 40).addBox(-2.25F, 7.725F, -9.375F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 5.3247F, -4.1777F, 0.3054F, 0.0436F, 0.0F));
		PartDefinition cube_r45 = right_leg.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(10, 62).addBox(0.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.625F, 11.35F, -5.7F, 1.9205F, -0.5606F, -1.6092F));
		PartDefinition cube_r46 = right_leg.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(13, 63).addBox(0.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.725F, 11.35F, -5.7F, 1.589F, 0.0217F, -1.7267F));
		PartDefinition cube_r47 = right_leg.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(124, 159).addBox(0.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.8F, 11.45F, -5.825F, 1.1396F, 0.564F, -0.4917F));
		PartDefinition cube_r48 = right_leg.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(13, 63).addBox(-1.0F, -5.0003F, -1.0027F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 11.275F, -4.7F, 0.8755F, 0.2898F, 0.0323F));
		PartDefinition cube_r49 = right_leg.addOrReplaceChild("cube_r49",
				CubeListBuilder.create().texOffs(141, 119).addBox(-3.25F, 7.725F, -5.375F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 82).addBox(-2.75F, -0.275F, -4.625F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 4.5747F, -1.9277F, 0.0F, 0.0436F, 0.0F));
		PartDefinition cube_r50 = right_leg.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(155, 117).addBox(-3.25F, -1.0F, -3.525F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.5236F, 0.0436F, 0.0F));
		PartDefinition crystal3 = right_leg.addOrReplaceChild("crystal3", CubeListBuilder.create().texOffs(124, 158).addBox(-0.5F, -4.0F, -0.675F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.3F, -0.875F, -1.7F, -0.057F, -0.394F, -0.5426F));
		PartDefinition cube_r5 = crystal3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(125, 160).addBox(-0.5F, -2.9F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3433F, 0.448F, 0.3523F));
		PartDefinition cube_r6 = crystal3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(15, 64).addBox(-0.5F, -3.2F, -0.425F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.225F, 0.0F, -0.3F, 0.5552F, 0.5576F, 0.1974F));
		PartDefinition cube_r7 = crystal3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(124, 160).addBox(-0.5F, -3.3F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -0.175F, -0.4159F, -0.0194F, -0.4151F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(5.75F, 6.6F, 6.0F));
		PartDefinition cube_r51 = left_leg.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(64, 40).addBox(-2.75F, 7.725F, -9.375F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 5.3247F, -4.1777F, 0.3054F, -0.0436F, 0.0F));
		PartDefinition cube_r52 = left_leg.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(13, 61).addBox(-1.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.625F, 15.35F, -8.7F, 1.5189F, 1.6581F, 1.1883F));
		PartDefinition cube_r53 = left_leg.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(17, 63).addBox(-1.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.725F, 15.35F, -8.7F, 1.868F, 1.0472F, 1.8865F));
		PartDefinition cube_r54 = left_leg.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(124, 161).addBox(-1.0F, -4.0003F, -0.0027F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.2F, 15.45F, -8.825F, 0.6067F, 0.4007F, 1.0655F));
		PartDefinition cube_r55 = left_leg.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(11, 61).addBox(-1.0F, -5.0003F, -1.0027F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 15.275F, -7.7F, -0.1413F, 0.1332F, 0.4059F));
		PartDefinition cube_r56 = left_leg.addOrReplaceChild("cube_r56",
				CubeListBuilder.create().texOffs(143, 119).addBox(-3.75F, 7.725F, -5.375F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(158, 116).addBox(-3.25F, -0.275F, -4.625F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 4.5747F, -1.9277F, 0.0F, -0.0436F, 0.0F));
		PartDefinition cube_r57 = left_leg.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(128, 116).addBox(-3.75F, -1.0F, -3.525F, 7.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.5236F, -0.0436F, 0.0F));
		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		mob_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.mob_head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.mob_head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
