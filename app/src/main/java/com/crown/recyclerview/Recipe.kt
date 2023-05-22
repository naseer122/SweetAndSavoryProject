package com.crown.recyclerview

data class Recipe(val title: String, val description: String, val flavor: Flavor)
// Flavor enum
enum class Flavor {
    SWEET, SAVORY
}