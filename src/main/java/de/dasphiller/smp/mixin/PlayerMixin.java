package de.dasphiller.smp.mixin;

import de.dasphiller.smp.mixins.PlayerMixinKt;
import net.axay.fabrik.core.Fabrik;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(PlayerList.class)
public class PlayerMixin {

    @Redirect(
            method = "placeNewPlayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/players/PlayerList;broadcastSystemMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/resources/ResourceKey;)V"
            )
    )
    public void onPlace(PlayerList instance, Component message, ResourceKey<ChatType> messageType) {
        PlayerMixinKt.INSTANCE.onPlaceNewPlayer(Objects.requireNonNull(Fabrik.INSTANCE.getCurrentServer()).getPlayerList(), message, messageType);
    }
}

