package de.dasphiller.smp.commands

import de.dasphiller.smp.gui.adminGui
import net.axay.fabrik.commands.command
import net.axay.fabrik.core.text.literal
import net.axay.fabrik.core.text.literalText
import net.axay.fabrik.game.sideboard.showSideboard
import net.axay.fabrik.game.sideboard.sideboard
import net.axay.fabrik.igui.openGui

val adminCommand = command("admin") {
    requiresPermissionLevel(4)
    literal("gui") {
        runs {
            source.player?.openGui(adminGui(), 2)
        }
    }
    literal("kickall") {
        runs {
            source.server.playerList.players.forEach {
                it.connection.disconnect(literalText {
                    text("Du wurdest gekickt!") {
                        color = 0xb30003
                        bold = true
                    }
                })
            }
        }
    }
}