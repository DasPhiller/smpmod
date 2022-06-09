package de.dasphiller.smp.gui

import net.axay.fabrik.core.item.itemStack
import net.axay.fabrik.core.item.setCustomName
import net.axay.fabrik.core.text.literalText
import net.axay.fabrik.core.text.sendText
import net.axay.fabrik.igui.*
import net.minecraft.world.item.Items

fun adminGui(): Gui {
    return igui(GuiType.NINE_BY_FIVE, literalText {
        text("Admin") {
            color = 0xf44336
        }
    }, 2) {
        page(2) {
            effectFrom = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            placeholder(Slots.All, itemStack(Items.GRAY_STAINED_GLASS_PANE) {
                setCustomName("")
            }.guiIcon)
            effectTo = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            changePageByKey((4 sl 5), itemStack(Items.ENDER_EYE) {
                setCustomName {
                    text("Allgemeine Einstellungen") {
                        color = 0xf6b26b
                        bold = true
                        italic = false
                    }
                }
            }.guiIcon, 3)
        }
        page(3) {
            effectFrom = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            effectTo = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            placeholder(Slots.All, itemStack(Items.GRAY_STAINED_GLASS_PANE) {
                setCustomName("")
            }.guiIcon)
            changePageByKey((1 sl 1), itemStack(Items.DARK_OAK_DOOR) {
                setCustomName {
                    text("Hauptmenü") {
                        color = 0x6fa8dc
                        bold = true
                        italic = false
                    }
                }
            }.guiIcon, 2)
            button((3 sl 2), itemStack(Items.PAPER) {
                setCustomName {
                    text("Toggle Whitelist") {
                        color = 0x5fdf5f
                        bold = true
                        italic = false
                    }
                }
            }.guiIcon) {
                if (it.player.server!!.playerList.isUsingWhitelist) {
                    it.player.server!!.playerList.setUsingWhiteList(false)
                    it.player.sendText {
                        text("Die Whitelist wurde deaktiviert") {
                            color = 0xe64043//e64043
                            italic = true
                        }
                    }
                } else {
                    it.player.server!!.playerList.setUsingWhiteList(true)
                    it.player.sendText {
                        text("Die Whitelist wurde aktiviert") {
                            color = 0x357836
                            italic = true
                        }
                    }
                }
            }
        }
    }
}