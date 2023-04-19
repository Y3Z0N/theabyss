package net.yezon.theabyss.mixins;

import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.yezon.theabyss.utils.DebugUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DisconnectedScreen.class)
public class DisconnectScreenMixin {
    @Inject(at = @At("RETURN"), method = "<init>")
    private void printDisconnectTrace(Screen pParent, Component pTitle, Component pReason, CallbackInfo ci) {
        DebugUtils.printStackTrace(Thread.currentThread().getStackTrace());
    }
}
