package net.yezon.theabyss.mixins;

import net.minecraft.DefaultUncaughtExceptionHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientHandshakePacketListenerImpl;
import net.minecraft.client.multiplayer.resolver.ResolvedServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerNameResolver;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.handshake.ClientIntentionPacket;
import net.minecraft.network.protocol.login.ServerboundHelloPacket;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.yezon.theabyss.utils.DebugUtils;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.net.InetSocketAddress;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Mixin(ConnectScreen.class)
public abstract class DisconnectExceptionPrinter {

    @Shadow @Final static Logger LOGGER;
    @Shadow @Final private static AtomicInteger UNIQUE_THREAD_ID;
    @Shadow volatile boolean aborted;
    @Shadow volatile Connection connection;
    @Final @Shadow Screen parent;

    @SuppressWarnings("OverwriteAuthorRequired")
    @Overwrite
    private void connect(final Minecraft p_169265_, final ServerAddress p_169266_) {
        final CompletableFuture<Optional<ProfilePublicKey.Data>> completablefuture = p_169265_.getProfileKeyPairManager().preparePublicKey();
        LOGGER.info("Connecting to {}, {}", p_169266_.getHost(), p_169266_.getPort());
        Thread thread = new Thread("Server Connector #" + UNIQUE_THREAD_ID.incrementAndGet()) {
            public void run() {
                InetSocketAddress inetsocketaddress = null;

                try {
                    if (aborted) {
                        return;
                    }

                    Optional<InetSocketAddress> optional = ServerNameResolver.DEFAULT.resolveAddress(p_169266_).map(ResolvedServerAddress::asInetSocketAddress);
                    if (aborted) {
                        return;
                    }

                    if (optional.isEmpty()) {
                        p_169265_.execute(() -> p_169265_.setScreen(new DisconnectedScreen(parent, CommonComponents.CONNECT_FAILED, ConnectScreen.UNKNOWN_HOST_MESSAGE)));
                        return;
                    }

                    inetsocketaddress = optional.get();
                    connection = Connection.connectToServer(inetsocketaddress, p_169265_.options.useNativeTransport());
                    connection.setListener(new ClientHandshakePacketListenerImpl(connection, p_169265_, parent, component -> updateStatus(component)));
                    connection.send(new ClientIntentionPacket(inetsocketaddress.getHostName(), inetsocketaddress.getPort(), ConnectionProtocol.LOGIN));
                    connection.send(new ServerboundHelloPacket(p_169265_.getUser().getName(), completablefuture.join(), Optional.ofNullable(p_169265_.getUser().getProfileId())));
                } catch (Exception exception2) {
                    if (aborted) {
                        return;
                    }

                    Throwable throwable = exception2.getCause();
                    Exception exception;
                    if (throwable instanceof Exception exception1) {
                        exception = exception1;
                    } else {
                        exception = exception2;
                    }

                    LOGGER.error("Couldn't connect to server", exception2);
                    LOGGER.info("");
                    DebugUtils.printStackTraceToLog(exception);
                    String s = inetsocketaddress == null ? exception.getMessage() : exception.getMessage().replaceAll(inetsocketaddress.getHostName() + ":" + inetsocketaddress.getPort(), "").replaceAll(inetsocketaddress.toString(), "");
                    p_169265_.execute(() -> p_169265_.setScreen(new DisconnectedScreen(parent, CommonComponents.CONNECT_FAILED, Component.translatable("disconnect.genericReason", s))));
                }

            }
        };
        thread.setUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler(LOGGER));
        thread.start();
    }

    @Shadow
    protected abstract void updateStatus(Component pStatus);
}
