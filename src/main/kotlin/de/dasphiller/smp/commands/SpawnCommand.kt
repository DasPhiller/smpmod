package de.dasphiller.smp.commands

import de.dasphiller.smp.extensions.defaultWorld
import kotlinx.coroutines.delay
import net.axay.fabrik.commands.command
import net.axay.fabrik.core.entity.changePos
import net.axay.fabrik.core.text.sendText

val spawnCommand = command("spawn") {
    suspend fun warp() = delay(5000)
    runsAsync {
        source.player?.sendText {
            text("Bitte warte 5 sekunden!") {
                color = 0x3ba55c
                italic = true
            }
        }
        warp()
        source.player?.changePos(0, 80, 0, defaultWorld())
    }
}