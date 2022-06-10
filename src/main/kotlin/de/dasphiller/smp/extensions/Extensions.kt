package de.dasphiller.smp.extensions

import net.axay.fabrik.core.Fabrik
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.Level

fun defaultWorld(): ServerLevel {
    val resourceKey: ResourceKey<Level> = ResourceKey.create(Registry.DIMENSION_REGISTRY, ResourceLocation("overworld"))
    val defaultWorld: ServerLevel? = Fabrik.currentServer!!.getLevel(resourceKey)
    return defaultWorld!!
}