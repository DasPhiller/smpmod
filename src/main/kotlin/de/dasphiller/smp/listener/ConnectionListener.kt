package de.dasphiller.smp.listener

import de.dasphiller.smp.broadcast
import net.axay.fabrik.core.text.sendText
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.minecraft.world.level.GameType

object ConnectionListener {
    fun register() {
        ServerPlayConnectionEvents.JOIN.register { serverGamePacketListenerImpl, _, _ ->
            serverGamePacketListenerImpl.player.sendText {
                text("Willkommen auf dem SMP") {
                    color = 0x8fce00
                }
            }
            serverGamePacketListenerImpl.player.setGameMode(GameType.SURVIVAL)
            broadcast(
                "${serverGamePacketListenerImpl.player.displayName.string} hat den Server betreten",
                0x8fce00,
                false,
                bold = true
            )
        }
        ServerPlayConnectionEvents.DISCONNECT.register { handler, _ ->
            broadcast(
                "${handler.player.displayName.string} hat den Server verlassen", 0xcc0000, false, bold = true
            )
        }
    }
}