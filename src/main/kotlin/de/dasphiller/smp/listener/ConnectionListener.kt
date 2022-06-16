package de.dasphiller.smp.listener

import net.axay.fabrik.core.text.sendText
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.world.level.GameType

object ConnectionListener {
    init {
        ServerPlayConnectionEvents.JOIN.register { serverGamePacketListenerImpl, _, _ ->
            serverGamePacketListenerImpl.player.sendText {
                text("Willkommen auf dem SMP") {
                    color = 0x8fce00
                }
            }
            serverGamePacketListenerImpl.player.setGameMode(GameType.SURVIVAL)
        }
    }
}