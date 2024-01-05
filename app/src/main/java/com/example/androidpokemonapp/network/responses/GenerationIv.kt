package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de vierde generatie Pokémon-spellen, Diamond/Pearl, HeartGold/SoulSilver, en Platinum, bevat.
 *
 * Deze klasse bevat geneste dataklassen voor elk van de vierde generatie Pokémon-spellen: Diamond/Pearl, HeartGold/SoulSilver, en Platinum.
 * Deze geneste klassen bevatten specifieke gegevens uniek voor hun respectievelijke spelversies.
 *
 * @property diamondpearl Een object van de klasse DiamondPearl, bevat informatie specifiek voor de Diamond en Pearl versies.
 * @property heartgoldsoulsilver Een object van de klasse HeartgoldSoulsilver, bevat informatie specifiek voor de HeartGold en SoulSilver versies.
 * @property platinum Een object van de klasse Platinum, bevat informatie specifiek voor de Platinum versie.
 */
data class GenerationIv(
    val diamondpearl: DiamondPearl,
    val heartgoldsoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)