package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de HeartGold en SoulSilver versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de HeartGold en SoulSilver versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, en voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in HeartGold/SoulSilver-stijl.
 * @property backFemale De vrouwelijke variant van de achterkant weergave in HeartGold/SoulSilver-stijl, indien aanwezig.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in HeartGold/SoulSilver-stijl.
 * @property backShinyFemale De vrouwelijke, glanzende versie van de achterkant weergave in HeartGold/SoulSilver-stijl, indien aanwezig.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in HeartGold/SoulSilver-stijl.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in HeartGold/SoulSilver-stijl, indien aanwezig.
 * @property frontShiny De glanzende versie van de voorkant weergave in HeartGold/SoulSilver-stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave in HeartGold/SoulSilver-stijl, indien aanwezig.
 */
data class HeartgoldSoulsilver(
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)