package net.yezon.theabyss.mixins;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.Connection;
import net.yezon.theabyss.utils.DebugUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class DisconnectionMixin {
    @Inject(at = @At("HEAD"), method = "exceptionCaught")
    private void printException(ChannelHandlerContext pContext, Throwable pException, CallbackInfo ci) {
        DebugUtils.printStackTraceToLog(pException);
    }
}
