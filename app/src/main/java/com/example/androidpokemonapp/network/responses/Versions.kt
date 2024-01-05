package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie bevat over de verschillende generaties van Pokémon-games.
 *
 * Deze klasse bevat subklassen voor elke generatie, zoals GenerationI, GenerationII, enzovoort, die elk op hun beurt informatie bevatten over de visuele representaties van Pokémon in die generatie.
 * Het biedt een georganiseerde manier om toegang te krijgen tot de visuele gegevens van Pokémon in verschillende game-generaties.
 *
 * @property generationi Informatie over de visuele representaties van Pokémon in Generatie I van de Pokémon-games.
 * @property generationii Informatie over de visuele representaties van Pokémon in Generatie II van de Pokémon-games.
 * @property generationiii Informatie over de visuele representaties van Pokémon in Generatie III van de Pokémon-games.
 * @property generationiv Informatie over de visuele representaties van Pokémon in Generatie IV van de Pokémon-games.
 * @property generationv Informatie over de visuele representaties van Pokémon in Generatie V van de Pokémon-games.
 * @property generationvi Informatie over de visuele representaties van Pokémon in Generatie VI van de Pokémon-games.
 * @property generationvii Informatie over de visuele representaties van Pokémon in Generatie VII van de Pokémon-games.
 * @property generationviii Informatie over de visuele representaties van Pokémon in Generatie VIII van de Pokémon-games.
 */
data class Versions(
    val generationi: GenerationI,
    val generationii: GenerationIi,
    val generationiii: GenerationIii,
    val generationiv: GenerationIv,
    val generationv: GenerationV,
    val generationvi: GenerationVi,
    val generationvii: GenerationVii,
    val generationviii: GenerationViii
)