package de.dasphiller.smp.gui

import net.axay.fabrik.core.Fabrik
import net.axay.fabrik.core.item.itemStack
import net.axay.fabrik.core.item.setCustomName
import net.axay.fabrik.core.item.setLore
import net.axay.fabrik.core.text.literalText
import net.axay.fabrik.core.text.sendText
import net.axay.fabrik.igui.*
import net.axay.fabrik.igui.observable.toGuiList
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

val items = arrayListOf<ItemStack>(
    itemStack(Items.LIGHT) { count = 64 },
)

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
            changePageByKey((2 sl 5), itemStack(Items.STRUCTURE_VOID) {
                setCustomName("Items") {
                    bold = true
                    italic = false
                }
            }.guiIcon, 1)
        }
        page(3) {
            effectFrom = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            effectTo = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            placeholder(Slots.All, itemStack(Items.GRAY_STAINED_GLASS_PANE) {
                setCustomName("")
            }.guiIcon)
            goBack(this)
            button((3 sl 2), itemStack(Items.PAPER) {
                setCustomName {
                    text("Toggle Whitelist") {
                        val server = Fabrik.currentServer
                        color = if (server?.playerList!!.isUsingWhitelist) 0x19bb03 else 0xb30003
                        bold = true
                        italic = false
                    }
                    setLore(listOf(literalText("description") {
                        italic = false
                        color = 0xb30003
                    }))
                }
            }.guiIcon) {
                if (it.player.server!!.playerList.isUsingWhitelist) {
                    it.player.server!!.playerList.setUsingWhiteList(false)
                    it.player.sendText {
                        text("Die Whitelist wurde deaktiviert") {
                            color = 0xb30003//e64043
                            italic = true
                        }
                    }
                } else {
                    it.player.server!!.playerList.setUsingWhiteList(true)
                    it.player.sendText {
                        text("Die Whitelist wurde aktiviert") {
                            color = 0x19bb03
                            italic = true
                        }
                    }
                }
            }
            button((3 sl 4), itemStack(Items.RED_STAINED_GLASS_PANE) {
                setCustomName {
                    text("Stop Server") {
                        color = 0xb30003
                        italic = false
                        bold = true
                    }
                }
                setLore(listOf(literalText("description") {
                    italic = false
                    color = 0xb30003
                }))
            }.guiIcon) {
                val server = Fabrik.currentServer
                server?.playerList?.players?.forEach {
                    it.connection.disconnect(literalText {
                        text("Du wurdest gekickt! Grund:") {
                            color = 0xb30003
                        }
                        emptyLine()
                        text("Der Server stoppt nun") {
                            color = 0xb30003
                        }
                    })
                }
                server?.stopServer()
            }
        }
        page(1) {
            effectFrom = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            effectTo = GuiPage.ChangeEffect.SLIDE_VERTICALLY
            placeholder(Slots.Border, itemStack(Items.GRAY_STAINED_GLASS_PANE) {
                setCustomName("")
            }.guiIcon)
            val compound = compound(
                (4 sl 2) rectTo (2 sl 8), items.toGuiList(), iconGenerator = {
                    itemStack(it.item) {}
                }, onClick = { event, element ->
                    event.player.inventory.add(element)
                }
            )
            goBack(this)
        }
    }
}

fun goBack(builder: GuiBuilder.PageBuilder) {
    builder.changePageByKey((1 sl 1), itemStack(Items.DARK_OAK_DOOR) {
        setCustomName {
            text("Hauptmen??") {
                color = 0x6fa8dc
                bold = true
                italic = false
            }
            setLore(listOf(literalText("description") {
                italic = false
                color = 0xb30003
            }))
        }
    }.guiIcon, 2)
}