package de.dasphiller.smp.mixins

import de.dasphiller.smp.broadcast
import net.minecraft.server.players.PlayerList

object PlayerMixinKt {
    fun onPlaceNewPlayer(instance: PlayerList) {
        broadcast("Willkommen ")

    }
}