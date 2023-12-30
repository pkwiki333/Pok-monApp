package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class Version(
    val name: String,
    val url: String
)