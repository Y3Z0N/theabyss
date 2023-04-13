package net.yezon.theabyss.mixins;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.yezon.theabyss.TheabyssMod;
import net.yezon.theabyss.utils.DebugUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.yezon.theabyss.utils.RecipeUtils;

import java.util.List;

@Mixin(ClientboundUpdateRecipesPacket.class)
public class RecipeIOChecker {
    @Shadow @Final private List<Recipe<?>> recipes;
    private static int uploadedRecipes = 0;
    private static int uploadedCraftingRecipes = 0;

    @Inject(at = @At("RETURN"), method = "write")
    private void getRecipeUploadCount(FriendlyByteBuf pBuffer, CallbackInfo ci) {
        TheabyssMod.LOGGER.info("[ABYSS] Uploaded {}/{} recipes from the mod", uploadedRecipes, recipes.stream().filter(r -> RecipeUtils.isModRecipe(r.getType())).count());
        TheabyssMod.LOGGER.info("[ABYSS] Uploaded {}/{} crafting recipes from vanilla", uploadedCraftingRecipes, recipes.stream().filter(r -> r.getId().getNamespace().equals("minecraft")).map(Recipe::getType).filter(RecipeType.CRAFTING::equals).count());
    }

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V")
    private void announceLoadFinish(FriendlyByteBuf pBuffer, CallbackInfo ci) {
        TheabyssMod.LOGGER.info("Finished loading {} recipes from network", recipes.size());
        DebugUtils.dumpRecipeInfo(recipes);
    }

    @Inject(at = @At("RETURN"), method = "toNetwork")
    private static void updateUploadCount(FriendlyByteBuf p_179470_, Recipe<?> p_179471_, CallbackInfo ci) {
        if (RecipeUtils.isModRecipe(p_179471_.getType())) uploadedRecipes ++;
        if (p_179471_.getId().getNamespace().equals("minecraft") && p_179471_.getType().equals(RecipeType.CRAFTING)) uploadedCraftingRecipes++;
    }

    @Inject(at = @At("RETURN"), method = "write")
    private void announceWriteFinished(FriendlyByteBuf pBuffer, CallbackInfo ci) {
        DebugUtils.dumpRecipeInfo(recipes);
    }
}
