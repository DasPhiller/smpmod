package de.dasphiller.smp.commands

import net.axay.fabrik.commands.command
import net.axay.fabrik.core.Fabrik
import net.axay.fabrik.core.text.sendText

val whitelistCommand = command("whitelist") {
    requiresPermissionLevel(4)
    literal("status") {
        runs {
            source.player?.sendText(if (Fabrik.currentServer?.playerList?.isUsingWhitelist!!) "true" else "false")
        }
    }
}