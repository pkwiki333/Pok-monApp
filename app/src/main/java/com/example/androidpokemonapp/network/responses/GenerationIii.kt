package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de derde generatie Pokémon-spellen, Emerald, FireRed/LeafGreen, en Ruby/Sapphire, bevat.
 *
 * Deze klasse bevat geneste dataklassen voor elk van de derde generatie Pokémon-spellen: Emerald, FireRed/LeafGreen, en Ruby/Sapphire.
 * Deze geneste klassen bevatten specifieke gegevens uniek voor hun respectievelijke spelversies.
 *
 * @property emerald Een object van de klasse Emerald, bevat informatie specifiek voor de Emerald versie.
 * @property fireredleafgreen Een object van de klasse FireredLeafgreen, bevat informatie specifiek voor de FireRed en LeafGreen versies.
 * @property rubysapphire Een object van de klasse RubySapphire, bevat informatie specifiek voor de Ruby en Sapphire versies.
 */
data class GenerationIii(
    val emerald: Emerald,
    val fireredleafgreen: FireredLeafgreen,
    val rubysapphire: RubySapphire
)