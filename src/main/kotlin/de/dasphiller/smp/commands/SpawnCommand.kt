package de.dasphiller.smp.commands

import de.dasphiller.smp.extensions.world
import kotlinx.coroutines.delay
import net.axay.fabrik.commands.command
import net.axay.fabrik.core.entity.changePos
import net.axay.fabrik.core.text.sendText

val spawnCommand = command("spawn") {
    suspend fun warp() = delay(5000)
    runsAsync {
        source.player?.sendText {
            text("Du wirst in 5 Sekunden teleportiert!") {
                color = 0x3ba55c
                italic = true
            }
        }
        warp()
        val world = world("overworld")
        source.player?.changePos(0, 80, 0, world)
    }
}