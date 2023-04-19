package net.yezon.theabyss.mixins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.stats.RecipeBookSettings;
import net.minecraft.world.inventory.RecipeBookType;
import net.yezon.theabyss.TheabyssMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(RecipeBookSettings.class)
public class PacketListenerMixin {
    @Inject(method = "write(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "HEAD"))
    private void writing(FriendlyByteBuf pBuffer, CallbackInfo ci) {
        TheabyssMod.LOGGER.info("Writing {} to network", PacketListenerMixin::getTypeArray);
    }
    @Inject(method = "read(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/minecraft/stats/RecipeBookSettings;", at = @At(value = "HEAD"))
    private static void reading(FriendlyByteBuf pBuffer, CallbackInfoReturnable<RecipeBookSettings> cir) {
        TheabyssMod.LOGGER.info("Reading {} from network", PacketListenerMixin::getTypeArray);
    }

    @Inject(method = "read(Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/stats/RecipeBookSettings;", at = @At(value = "HEAD"))
    private static void writingFromTag(CompoundTag pTag, CallbackInfoReturnable<RecipeBookSettings> cir) {
        TheabyssMod.LOGGER.info("Writing {} to network", PacketListenerMixin::getTypeArray);
    }
    @Inject(method = "read(Lnet/minecraft/nbt/CompoundTag;)Lnet/minecraft/stats/RecipeBookSettings;", at = @At(value = "HEAD"))
    private static void readingToTag(CompoundTag pTag, CallbackInfoReturnable<RecipeBookSettings> cir) {
        TheabyssMod.LOGGER.info("Reading {} from network", PacketListenerMixin::getTypeArray);
    }

    private static String[] getTypeArray() {
        return Arrays.stream(RecipeBookType.values()).map(Enum::name).toArray(String[]::new);
    }
}
