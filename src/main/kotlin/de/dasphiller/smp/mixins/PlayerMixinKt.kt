package de.dasphiller.smp.mixins

import de.dasphiller.smp.broadcast
import net.minecraft.network.Connection
import net.minecraft.network.chat.ChatType
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.resources.ResourceKey
import net.minecraft.server.level.ServerPlayer
import net.minecraft.server.players.PlayerList
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

object PlayerMixinKt {
    fun onPlaceNewPlayer(instance: PlayerList) {
        broadcast("Willkommen ")
    }
}