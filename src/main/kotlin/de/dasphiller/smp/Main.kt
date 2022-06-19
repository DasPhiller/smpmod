package de.dasphiller.smp

import de.dasphiller.smp.commands.adminCommand
import de.dasphiller.smp.commands.spawnCommand
import de.dasphiller.smp.commands.whitelistCommand
import de.dasphiller.smp.listener.ConnectionListener
import net.axay.fabrik.core.Fabrik
import net.axay.fabrik.core.text.sendText

fun init() {
    ConnectionListener.register()
    adminCommand
    spawnCommand
    whitelistCommand
}

fun broadcast(text: String, color: Int = 0xffffff, italic: Boolean = false, bold: Boolean = false) {
    Fabrik.currentServer?.playerList?.players?.forEach {
        it.sendText {
            text(text) {
                this.color = color
                this.italic = italic
                this.bold = bold
            }
        }
    }
}
