package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Type(
    val slot: Int,
    val type: TypeX
)