package de.dasphiller.smp.commands

import de.dasphiller.smp.extensions.world
import kotlinx.coroutines.time.delay
import net.axay.fabrik.commands.command
import net.axay.fabrik.core.entity.changePos
import net.axay.fabrik.core.text.sendText
import java.time.Duration

val spawnCommand = command("spawn") {
    suspend fun warp() = delay(Duration.ofSeconds(5))
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