package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)