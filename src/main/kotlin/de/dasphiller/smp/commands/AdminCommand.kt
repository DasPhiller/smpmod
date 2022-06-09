package de.dasphiller.smp.commands

import de.dasphiller.smp.gui.adminGui
import net.axay.fabrik.commands.command
import net.axay.fabrik.igui.openGui

val adminCommand = command("admin") {
    requiresPermissionLevel(4)
    literal("gui") {
        runs {
            source.player?.openGui(adminGui(), 2)
        }
    }
}