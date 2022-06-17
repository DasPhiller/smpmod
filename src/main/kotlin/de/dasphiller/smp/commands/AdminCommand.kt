package de.dasphiller.smp.commands

import de.dasphiller.smp.gui.adminGui
import kotlinx.coroutines.time.delay
import net.axay.fabrik.commands.command
import net.axay.fabrik.core.Fabrik
import net.axay.fabrik.core.text.literalText
import net.axay.fabrik.core.text.sendText
import net.axay.fabrik.game.sideboard.showSideboard
import net.axay.fabrik.game.sideboard.sideboard
import net.axay.fabrik.igui.openGui
import java.time.Duration

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
    /* literal("showstats") {
         suspend fun hide() = delay(Duration.ofSeconds(5))
         runsAsync {
             source.player?.sendText("${Fabrik.currentServer?.playerCount}")
             source.player?.showSideboard(statsBoard)
             hide()
             source.player?.showSideboard(statsBoard)
         }
     }
     */
}
/*
val statsBoard = sideboard(literalText("Stats"), "statsboard") {
    literalLine("Players: ${Fabrik.currentServer?.playerCount}")
}
 */