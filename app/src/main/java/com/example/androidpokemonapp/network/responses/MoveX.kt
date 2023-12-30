package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class MoveX(
    val name: String,
    val url: String
)