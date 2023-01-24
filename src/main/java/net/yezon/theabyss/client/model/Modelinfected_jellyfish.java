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

// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelinfected_jellyfish<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("theabyss", "modelinfected_jellyfish"), "main");
	public final ModelPart SideHead;
	public final ModelPart Ranks;
	public final ModelPart MainRank;
	public final ModelPart bb_main;

	public Modelinfected_jellyfish(ModelPart root) {
		this.SideHead = root.getChild("SideHead");
		this.Ranks = root.getChild("Ranks");
		this.MainRank = root.getChild("MainRank");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition SideHead = partdefinition.addOrReplaceChild("SideHead",
				CubeListBuilder.create().texOffs(10, 5).addBox(-3.5F, -15.0F, -3.5F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.001F)).texOffs(10, 5).mirror().addBox(3.5F, -15.0F, -3.5F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.001F)).mirror(false)
						.texOffs(10, 12).mirror().addBox(-3.5F, -15.0F, -3.5F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.001F)).mirror(false).texOffs(10, 12).mirror().addBox(-3.5F, -15.0F, 3.5F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.001F))
						.mirror(false),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Ranks = partdefinition.addOrReplaceChild("Ranks", CubeListBuilder.create().texOffs(18, 12).addBox(-2.5F, -14.0F, -3.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition RankRR_r1 = Ranks.addOrReplaceChild("RankRR_r1", CubeListBuilder.create().texOffs(18, 12).mirror().addBox(5.0F, -6.5F, -4.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.001F)).mirror(false),
				PartPose.offsetAndRotation(0.5F, -7.5F, 7.5F, 0.0F, 1.5708F, 0.0F));
		PartDefinition RankR_r1 = Ranks.addOrReplaceChild("RankR_r1", CubeListBuilder.create().texOffs(18, 12).mirror().addBox(4.5F, -6.5F, -2.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.001F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -7.5F, -7.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition RankLL_r1 = Ranks.addOrReplaceChild("RankLL_r1", CubeListBuilder.create().texOffs(18, 12).mirror().addBox(-0.5F, -6.5F, -3.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.001F)).mirror(false),
				PartPose.offsetAndRotation(2.0F, -7.5F, 0.0F, 0.0F, 3.1416F, 0.0F));
		PartDefinition MainRank = partdefinition.addOrReplaceChild("MainRank", CubeListBuilder.create().texOffs(10, 11).addBox(0.0F, -14.0F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition MainRankR_r1 = MainRank.addOrReplaceChild("MainRankR_r1", CubeListBuilder.create().texOffs(10, 11).addBox(0.0F, -6.5F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.001F)),
				PartPose.offsetAndRotation(0.0F, -7.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		SideHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ranks.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MainRank.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
