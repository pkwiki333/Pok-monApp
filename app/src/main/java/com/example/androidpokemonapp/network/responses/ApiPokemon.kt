package com.example.androidpokemonapp.network.responses

import com.example.androidpokemonapp.model.Pokemon
import kotlinx.serialization.Serializable

/**
 * Dataklasse die een Pokémon representeert zoals die door de externe API wordt geleverd.
 *
 * Deze klasse bevat gedetailleerde informatie over een specifieke Pokémon, inclusief
 * vaardigheden, ervaringspunten, vormen, spelindices, grootte, en meer.
 *
 * @property abilities Lijst van vaardigheden die de Pokémon heeft.
 * @property base_experience Het aantal basiservaringspunten dat de Pokémon heeft.
 * @property forms Lijst van verschillende vormen van de Pokémon.
 * @property game_indices Lijst van spelindices waarin de Pokémon voorkomt.
 * @property height De hoogte van de Pokémon, uitgedrukt in decimeters.
 * @property held_items Lijst van items die de Pokémon kan vasthouden.
 * @property id Uniek identificatienummer van de Pokémon.
 * @property is_default Geeft aan of dit de standaardvorm van de Pokémon is.
 * @property location_area_encounters URL waar locatie-ontmoetingsgegevens opgehaald kunnen worden.
 * @property moves Lijst van aanvallen die de Pokémon kan leren.
 * @property name De naam van de Pokémon.
 * @property order De volgorde waarin de Pokémon in de Pokédex verschijnt.
 * @property past_abilities Lijst van vroegere vaardigheden van de Pokémon.
 * @property past_types Lijst van vroegere types van de Pokémon.
 * @property species Link naar de soort waartoe de Pokémon behoort.
 * @property sprites Visuele representatie van de Pokémon in diverse media.
 * @property stats Lijst van statistieken van de Pokémon.
 * @property types Lijst van types waartoe de Pokémon behoort.
 * @property weight Het gewicht van de Pokémon, uitgedrukt in hectogram.
 */
@Serializable
data class ApiPokemon(
    val abilities: List<Ability>,
   // val base_experience: Int,
   // val forms: List<Form>,
   // val game_indices: List<GameIndice>,
    val height: Double,
    //val held_items: List<Any>,
    val id: Int,
    //val is_default: Boolean,
    //val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    /*val order: Int,//
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>, */
    val types: List<Type>,
    val weight: Double
)

/**
 * Converteert een [ApiPokemon] instantie naar een [Pokemon] instantie voor gebruik in de domeinlaag.
 * Dit omvat het transformeren van API-specifieke structuren naar meer algemene vormen.
 *
 * @return Een [Pokemon] object met overeenkomende velden van de [ApiPokemon].
 */
fun ApiPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = id,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name },
        moves = moves.map { it.move.name }
    )
}



