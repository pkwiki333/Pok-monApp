package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die statistische gegevens van een Pokémon vertegenwoordigt, inclusief basisstatistieken en inspanning voor een specifieke statistiek.
 *
 * Deze klasse bevat informatie over de statistieken van een Pokémon, waaronder de basisstatistieken en de inspanning die de Pokémon levert voor een bepaalde statistiek.
 * Het omvat ook een verwijzing naar het type statistiek, dat de specifieke statistiek beschrijft, zoals aanval, verdediging, snelheid, enzovoort.
 *
 * @property baseStat De basiswaarde van de statistiek voor de Pokémon.
 * @property effort De inspanning van de Pokémon voor deze statistiek.
 * @property stat Een object van de klasse StatX, dat verwijst naar het type statistiek en extra informatie biedt.
 */
@Serializable
data class Stat(
    val baseStat: Int,
    val effort: Int,
    val stat: StatX
)